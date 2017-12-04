import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

class SBPrinter extends IRVisitor {
    public static final String headerString = ".intel_syntax";

    PrintWriter _writer; 
    int _level;
    boolean _lineStart;
    List<String> _rodatas;
    SymbolTable _symTab;
    RegisterAllocator _regAllocator;
    FunDef _owner;
    
    SBPrinter(PrintWriter writer, SymbolTable symTab) {
	_writer = writer;
	_level = 0;
	_rodatas = new ArrayList<String>();
	_symTab = symTab;
	_lineStart = true;
	_regAllocator = new RegisterAllocator();
	_owner = null;
    }
    
    SBPrinter p(Address ir) {
	ir.accept(this);
	return this;
    }

    // Helper functions
    void printLeadingSpacesIfNeeded() {
	if (!_lineStart) return;
	_lineStart = false;
	for (int i = 0; i < _level; i++) _writer.print("    ");
    }
    SBPrinter p(String s) {
	printLeadingSpacesIfNeeded();
	_writer.print(s);
	return this;
    }
    SBPrinter p(int i) {
	printLeadingSpacesIfNeeded();
	_writer.print(i);
	return this;
    }
    SBPrinter pln() {
	_writer.println();
	_lineStart = true;
	return this;
    }
    
    SBPrinter indent() {
	_level++;
	return this;
    }
    SBPrinter dedent() {
	_level--;
	return this;
    }

    // Common class for Address, String, and Integer.
    class Printable {
        Address _a;
        String _b;
        Integer _c;

        Printable(Address a) { _a = a; _b = null; _c = null; }
        Printable(String b) { _a = null; _b = b; _c = null; }
        Printable(Integer c) { _a = null; _b = null; _c = c; }

        void print() {
            if (_a != null) p(_a);
            if (_b != null) p(_b);
            if (_c != null) p(_c);
        }
    }

    SBPrinter printOp(String op, Printable a, Printable b) {
        p(op + " ");
        a.print();
        p(", ");
        b.print();
        pln();
        return this;
    }
    
    SBPrinter printUnaryOp(String op, Printable a) {
        p(op + " ");
        a.print();
        pln();
        return this;
    }

    int getRecordOffset(Type t, String name) {
        int num = 0;
	if (t instanceof RecordType) {
	    RecordType rt = (RecordType)t;
	    for ( FieldType f : rt._fields) {
                if (f._field._id.equals(name)) break;
		--num;
	    }
        }
        return (num * ProgramStack.WIDTH);
    }
    // top-level
    Object visit(Program ir) {
        // Print header
	p(headerString);
        pln();

        // Print functions separated by newline.
	for (int i = 0; i < ir._functions.size(); i++) {
	    ir._functions.get(i).accept(this);
	    if (i < (ir._functions.size() - 1)) pln();
	}
	return null;
    }
    
    Object visit(FunDef ir) {
	_symTab.push(ir._heldScope);
	_owner = ir;

        // read only data section
	if (!_symTab._current._rodatas.isEmpty()) {
	    p(".section .rodata");
            pln();
        }
	for (ConstantAddr address : _symTab._current._rodatas) {
            indent();
            p(address._label);
            p(":");
            pln();
                indent();
                p(".string\t");
                p(address._literal.toString());
                pln();
                dedent();
            dedent();
	}
	
        // text section
	p(".text");
        pln();

	indent();
                indent();
                p(".global\t");
                p(ir._name._id);
                pln();
                p(".type\t");
                p(ir._name._id);
                p(",\t@function");
                pln();
                dedent();
	
	p(ir._name._id);
        p(":");
        pln();
	
	        indent();
                printUnaryOp("push", new Printable("%rbp"));
                printOp("mov", new Printable("%rbp"), new Printable("%rsp"));
                dedent();

	if (ir._stack.getFrameSize() > 0) {
	    indent();
            printOp("sub", new Printable("%rsp"), new Printable(ir._stack.getFrameSize()));
            dedent();
	}

	// function paramateres
        int count = 0;
	for (FieldType ft : ir._type._formals._fields) {
	    String param = ft._field._id;
	    if (count < RegisterAllocator.ParamReg.length) {
                // use register.
		indent();
                printOp("mov", new Printable("[%rbp" + ir._stack.getOffset(param) + "]"), new Printable(_regAllocator.getParamReg(count)));
                dedent();
		_regAllocator.initialize();
	    }
	    else {
		// use memory.
		indent();
                printOp("mov", new Printable("[%rbp" + ir._stack.getOffset(param) + "]"), new Printable("[%rbp+" + ProgramStack.WIDTH * (count - 4) + "]"));
                dedent();
	    }
            ++count;
	}
	
	// Instructions
	for (Instruction instr : ir._sym._instructions) {
	    for (Label label : instr._labels) {
		p(label);
                p(":");
            }
	    if (!instr._labels.isEmpty()) pln();
	    indent();
	    instr.accept(this);
	    dedent();
	}
	
	dedent();
	_owner = null;
	_symTab.pop(ir._heldScope);
	_regAllocator.initialize();
	return null;
    }
    
    Object visit(Type ir) {
	return null;
    }
    
    Object visit(Label ir) {
	p(ir._name);
	return null;
    }
    
    // addresses
    Object visit(NameAddr ir) {
	p(_owner._stack.getMemory(ir._name));
	return null;
    }
    
    Object visit(ConstantAddr ir) {
	if (ir._literal instanceof StringLit) {
	    p("OFFSET FLAT:");
            p(ir._label);
	}
	else if (ir._literal instanceof BoolLit) {
	    BoolLit boolLit = (BoolLit)ir._literal;
	    if (boolLit._value) 
                p("1");
	    else 
                p("0");
	}
	else if (ir._literal instanceof NullLit) {
	    p(0);
	}
	else {
	    p(ir._literal.toString());
	}
	return null;
    }
    
    Object visit(TempAddr ir) {
	p(_owner._stack.getMemory(ir._name));
	return null;
    }
    
    int getElemType(Type tgt) {
	if (tgt instanceof ArrayType) {
	    ArrayType arrtype = (ArrayType)tgt;
	    return getElemType(arrtype._elem);
	}
	else if (tgt instanceof FieldType) {
	    FieldType fdtype = (FieldType)tgt;
	    fdtype._sym.type();
	}
        return ProgramStack.WIDTH;
    }
    
    Object visit(SizeofAddr ir) {
	p(getElemType(ir._ofType));
	return null;
    }
    
    // instructions for computing values
    Object visit(CopyInstr ir) {
	String reg = _regAllocator.getFreeReg(); 
        printOp("mov", new Printable(reg), new Printable(ir._in));
        printOp("mov", new Printable(ir._out), new Printable(reg));
	_regAllocator.freeRegister(reg);
	return null;
    }
    
    Object visit(InfixInstr ir) {
	if (ir._op.equals("+")) {
	    String reg1 = _regAllocator.getFreeReg();
	    String reg2 = _regAllocator.getFreeReg();
            printOp("mov", new Printable(reg1), new Printable(ir._lhs));
            printOp("mov", new Printable(reg2), new Printable(ir._rhs));
	    printOp("add", new Printable(reg1), new Printable(reg2));
            printOp("mov", new Printable(ir._out), new Printable(reg1));
	    _regAllocator.freeRegister(reg1);
	    _regAllocator.freeRegister(reg2);
	}
	else if (ir._op.equals("-")) {
	    String reg1 = _regAllocator.getFreeReg();
	    String reg2 = _regAllocator.getFreeReg();
            printOp("mov", new Printable(reg1), new Printable(ir._lhs));
            printOp("mov", new Printable(reg2), new Printable(ir._rhs));
	    printOp("sub", new Printable(reg1), new Printable(reg2));
            printOp("mov", new Printable(ir._out), new Printable(reg1));
	    _regAllocator.freeRegister(reg1);
	    _regAllocator.freeRegister(reg2);
	}
	else if (ir._op.equals("*")) {
	    String reg1 = _regAllocator.getFreeReg();
	    String reg2 = _regAllocator.getFreeReg();
            printOp("mov", new Printable(reg1), new Printable(ir._lhs));
            printOp("mov", new Printable(reg2), new Printable(ir._rhs));
	    printOp("imul", new Printable(reg1), new Printable(reg2));
            printOp("mov", new Printable(ir._out), new Printable(reg1));
	    
	    _regAllocator.freeRegister(reg1);
	    _regAllocator.freeRegister(reg2);
	}
	else if (ir._op.equals("/")) {
	    String rax = _regAllocator.acquireIfFree("%rax");
	    String rdx = _regAllocator.acquireIfFree("%rdx");
	    String freereg = _regAllocator.getFreeReg();
	    
            printOp("mov", new Printable(rax), new Printable(ir._lhs));
            printOp("mov", new Printable(freereg), new Printable(ir._rhs));
            printOp("mov", new Printable(rdx), new Printable(rax));
            printOp("sar", new Printable("%rdx"), new Printable(63));
	    printUnaryOp("idiv", new Printable(freereg));
            printOp("mov", new Printable(ir._out), new Printable(rax));
	    
	    _regAllocator.freeRegister(rax);
	    _regAllocator.freeRegister(rdx);
	    _regAllocator.freeRegister(freereg);
	}
	else if (ir._op.equals("%")) {
	    String rax = _regAllocator.acquireIfFree("%rax");
	    String rdx = _regAllocator.acquireIfFree("%rdx");
	    String freereg = _regAllocator.getFreeReg();
	    
            printOp("mov", new Printable(rax), new Printable(ir._lhs));
            printOp("mov", new Printable(freereg), new Printable(ir._rhs));
            printOp("mov", new Printable(rdx), new Printable(rax));
            printOp("sar", new Printable("%rdx"), new Printable(63));
	    printUnaryOp("idiv", new Printable(freereg));
            printOp("mov", new Printable(ir._out), new Printable(rdx));
	    
	    _regAllocator.freeRegister(rax);
	    _regAllocator.freeRegister(rdx);
	    _regAllocator.freeRegister(freereg);
	}
	return null;
    }
    
    Object visit(PrefixInstr ir) {
        String reg = _regAllocator.getFreeReg();
        printOp("mov", new Printable(reg), new Printable(ir._in));
	printUnaryOp("neg", new Printable(reg));
        printOp("mov", new Printable(ir._out), new Printable(reg));
	_regAllocator.freeRegister(reg);
	return null;
    }
    
    Object visit(CastInstr ir) {
	String outType = ir._type.toString();
	String inType = ir._in.type().toString();
	String rdi = _regAllocator.acquireIfFree("%rdi");
	if (!outType.equals(inType) && (inType.equals("int") || inType.equals("bool") || inType.equals("string"))) {
            printOp("mov", new Printable(rdi), new Printable(ir._in));
	    printUnaryOp("call", new Printable(inType + "2" + outType));
            printOp("mov", new Printable(ir._out), new Printable("%rax"));
	}
	else {
            printOp("mov", new Printable(rdi), new Printable(ir._in));
            printOp("mov", new Printable(ir._out), new Printable(rdi));
	}
	_regAllocator.freeRegister(rdi);
	return null;
    }
    
    // instructions for jumping
    Object visit(UncondJumpInstr ir) {
	printUnaryOp("jmp", new Printable(ir._tgt));
	return null;
    }
    
    Object visit(TrueJumpInstr ir) {
	String reg = _regAllocator.getFreeReg();
        printOp("mov", new Printable(reg), new Printable(ir._cond));
	printOp("cmp", new Printable(reg), new Printable("1"));
	printUnaryOp("je", new Printable(ir._tgt));
	_regAllocator.freeRegister(reg);
	return null;
    }
    
    Object visit(FalseJumpInstr ir) {
	String reg = _regAllocator.getFreeReg();
        printOp("mov", new Printable(reg), new Printable(ir._cond));
	printOp("cmp", new Printable(reg), new Printable("1"));
	printUnaryOp("jne", new Printable(ir._tgt));
	_regAllocator.freeRegister(reg);
	return null;
    }

    Object visit(RelopJumpInstr ir) {
	String reg1 = _regAllocator.getFreeReg();
	String reg2 = _regAllocator.getFreeReg();
        printOp("mov", new Printable(reg1), new Printable(ir._lhs));
        printOp("mov", new Printable(reg2), new Printable(ir._rhs));
	printOp("cmp", new Printable(reg1), new Printable(reg2));

        String jumpOp = "";
        if ("==".equals(ir._op)) 
	    jumpOp = "je";
        else if ("!=".equals(ir._op)) 
	    jumpOp = "jne";
	else if (">".equals(ir._op)) 
	    jumpOp = "jg";
	else if (">=".equals(ir._op)) 
	    jumpOp = "jge";
	else if ("<".equals(ir._op)) 
	    jumpOp = "jl";
	else if ("<=".equals(ir._op)) 
	    jumpOp = "jle";

	printUnaryOp(jumpOp, new Printable(ir._tgt));
	_regAllocator.freeRegister(reg1);
	_regAllocator.freeRegister(reg2);
	return null;
    }
    
    // instructions for functions
    Object visit(ParamInstr ir) {
	if(ir._index < RegisterAllocator.ParamReg.length) {
	    String paramReg = _regAllocator.getParamReg(ir._index);
            printOp("mov", new Printable(paramReg), new Printable(ir._in));
	    _regAllocator.freeRegister(paramReg);
	}
	return null;
    }
    
    Object visit(CallInstr ir) {
	printUnaryOp("call", new Printable(ir._fun.name()));
	if (null != ir._out) {
            printOp("mov", new Printable(ir._out), new Printable("%rax"));
	}
	return null;
    }
    
    Object visit(ReturnInstr ir) {
	if (null != ir._val) {
	    printOp("mov", new Printable("%rax"), new Printable(ir._val));
	}
	printOp("mov", new Printable("%rsp"), new Printable("%rbp"));
        printUnaryOp("pop", new Printable("%rbp"));
        p("ret");
        pln();
	return null;
    }
    
    // instructions for memory access
    Object visit(ArrReadInstr ir) {
	String reg1 = _regAllocator.getFreeReg();
	String reg2 = _regAllocator.getFreeReg();
        printOp("mov", new Printable(reg1), new Printable(ir._base));
        printOp("mov", new Printable(reg1), new Printable("[" + reg1 + "+" + ProgramStack.WIDTH + "]"));
        printOp("mov", new Printable(reg2), new Printable(ir._subscript));
	printOp("sal", new Printable(reg2), new Printable("3"));
	printOp("add", new Printable(reg2), new Printable(reg1));
        printOp("mov", new Printable(reg2), new Printable("[" + reg2 + "]"));
        printOp("mov", new Printable(ir._out), new Printable(reg2));
	_regAllocator.freeRegister(reg1);
	_regAllocator.freeRegister(reg2);
	return null;
    }
    
    Object visit(ArrWriteInstr ir) {
	String reg1 = _regAllocator.getFreeReg();
	String reg2 = _regAllocator.getFreeReg();
	String reg3 = _regAllocator.getFreeReg();
        printOp("mov", new Printable(reg1), new Printable(ir._base));
        printOp("mov", new Printable(reg1), new Printable("[" + reg1 + "+" + ProgramStack.WIDTH + "]"));
        printOp("mov", new Printable(reg2), new Printable(ir._subscript));
	printOp("sal", new Printable(reg2), new Printable("3"));
	printOp("add", new Printable(reg2), new Printable(reg1));
        printOp("mov", new Printable(reg3), new Printable(ir._in));
        printOp("mov", new Printable("[" + reg2 + "]"), new Printable(reg3));
	_regAllocator.freeRegister(reg1);
	_regAllocator.freeRegister(reg2);
	_regAllocator.freeRegister(reg3);
	return null;
    }
    
    Object visit(RecReadInstr ir) {
	String reg1 = _regAllocator.getFreeReg();
	String reg2 = _regAllocator.getFreeReg();
	int offset = getRecordOffset(ir._base.type(), ir._field.name());
        printOp("mov", new Printable(reg1), new Printable(ir._base));
	printOp("add", new Printable(reg1), new Printable(offset));
        printOp("mov", new Printable(reg2), new Printable("[" + reg1 + "]"));
        printOp("mov", new Printable(ir._out), new Printable(reg2));
	_regAllocator.freeRegister(reg1);
	_regAllocator.freeRegister(reg2);
	return null;
    }
    
    Object visit(RecWriteInstr ir) {
	String reg1 = _regAllocator.getFreeReg();
	String reg2 = _regAllocator.getFreeReg();
	int offset = getRecordOffset(ir._base.type(), ir._field.name());
        printOp("mov", new Printable(reg1), new Printable(ir._base));
        printOp("mov", new Printable(reg2), new Printable(ir._in));
	printOp("add", new Printable(reg1), new Printable(offset));
        printOp("mov", new Printable("[" + reg1 + "]"), new Printable(reg2));
	_regAllocator.freeRegister(reg1);
	_regAllocator.freeRegister(reg2);
	return null;
    }
}
