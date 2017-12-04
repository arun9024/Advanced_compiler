class SBGenerator extends IRVisitor {
    LabelCounter _labelCounter;
    SymbolTable _symTab;
    
    SBGenerator(SymbolTable symTab) {
        _labelCounter = new LabelCounter();
        _symTab = symTab;
    }
    
    SBGenerator p(Address ir) {
	ir.accept(this);
	return this;
    }
    
    // top-level
    Object visit(Program ir) {
        for (FunDef fun : ir._functions) fun.accept(this);
        return null;
    }
    
    Object visit(FunDef ir) {
	_symTab.push(ir._heldScope);
	ir._stack = new ProgramStack();
	for (FieldType fieldType :ir._type._formals._fields) ir._stack.push(fieldType._field._id);
        for (Instruction instr : ir._sym._instructions) instr.accept(this);
        _symTab.pop(ir._heldScope);
        return null;
    }
    
    Object visit(Type ir) {
        return null;
    }
    
    Object visit(Label ir) {
        return null;
    }
    
    // addresses 
    Object visit(NameAddr ir) {
	FunDef owner = (FunDef)_symTab._current._owner;
	owner._stack.push(ir._name);
        return null;
    }
    
    Object visit(ConstantAddr ir) {
        if (ir._literal instanceof StringLit) {
	    FunDef owner = (FunDef)_symTab._current._owner;
	    ir._label = owner._name._id + "." + _labelCounter.getNewLabel();
	    _symTab._current._rodatas.add(ir);
        }
        return null;
    }
    
    Object visit(TempAddr ir) {
	FunDef owner = (FunDef)_symTab._current._owner;
	owner._stack.push(ir._name);
        return null;
    }
    
    Object visit(SizeofAddr ir) {
        return null;
    }
    
    // instructions for computing values 
    Object visit(CopyInstr ir) {
        p(ir._out);
        p(ir._in);
        return null;
    }
    
    Object visit(InfixInstr ir) {
        p(ir._out);
        p(ir._lhs);
        p(ir._rhs);
        return null;
    }
    
    Object visit(PrefixInstr ir) {
        p(ir._out);
        p(ir._in);
        return null;
    }
    
    Object visit(CastInstr ir) {
        p(ir._out);
        p(ir._in);
        return null;
    }
    
    // instructions for jumping
    Object visit(UncondJumpInstr ir) {
        return null;
    }
    
    Object visit(TrueJumpInstr ir) {
        p(ir._cond);
        return null;
    }
    
    Object visit(FalseJumpInstr ir) {
        p(ir._cond);
        return null;
    }
    
    Object visit(RelopJumpInstr ir) {
        p(ir._lhs);
        p(ir._rhs);
        return null;
    }
    
    // instructions for functions
    Object visit(ParamInstr ir) {
        p(ir._in);
        return null;
    }
    
    Object visit(CallInstr ir) {
	if (null != ir._out) p(ir._out);
        return null;
    }
    
    Object visit(ReturnInstr ir) {
        if (null != ir._val) p(ir._val);
        return null;
    }
    
    // instructions for memory access
    Object visit(ArrReadInstr ir) {
        p(ir._out);
        p(ir._base);
        p(ir._subscript);
        return null;
    }
    
    Object visit(ArrWriteInstr ir) {	  
        p(ir._base);
        p(ir._subscript);
        p(ir._in);
        return null;
    }
    
    Object visit(RecReadInstr ir) {
        p(ir._out);
        p(ir._base);
        return null;
    }
    
    Object visit(RecWriteInstr ir) {
        p(ir._base);
        p(ir._in);
        return null;
    }
}
