import java.io.PrintWriter;

class IRPrinter extends IRVisitor {
  PrintWriter _writer; 
  int _lcount;
  int _ocount;
  SymbolTable _symTab;

  IRPrinter(PrintWriter writer, SymbolTable symTab) {
    _writer = writer;
    _lcount = 0;
    _ocount = -1;
    _symTab = symTab;
  }

  IRPrinter p(Address ir) {
    ir.accept(this);
    return this;
  }
  IRPrinter p(String s) {
    _writer.print(s);
    return this;
  }
  IRPrinter p(int i) {
    _writer.print(i);
    return this;
  }
  IRPrinter pln() {
    _writer.println();
    return this;
  }
  String getNewLabel() {
	  return "S_" + _lcount++;
  }
  
  // ---------------- top-level ----------------
  Object visit(Program ir) {
    for (int i=0, n=ir._functions.size(); i<n; i++) {
      FunDef fun = ir._functions.get(i);
      fun.accept(this);
      if (i != n - 1)
	pln();
    }
    return null;
  }

  Object visit(FunDef ir) {
	  _symTab.push(ir._heldScope);
    p(ir._name._id).p(" = fun ").p(ir._type.toString()).pln();

    for (Instruction instr : ir._sym._instructions) {
      p("  ");
      instr.accept(this);
      p(";").pln();
    }
    
    _symTab.pop(ir._heldScope);
    return null;
  }

  Object visit(Type ir) {
    assert false : "use 'p(Type t)' instead";
    return null;
  }

  Object visit(Label ir) {
    p(ir._name);
    return null;
  }

  // ---------------- addresses ----------------
  Object visit(NameAddr ir) {
    p(ir._name);
    return null;
  }

  Object visit(ConstantAddr ir) {
    if (ir._literal instanceof StringLit) {
	  assert _symTab._current._owner instanceof FunDef;
	  FunDef owner = (FunDef)_symTab._current._owner;
	  ir._label = owner._name._id + "." + getNewLabel();
	  _symTab._current._rodatas.add(ir);
    }
    p(ir._literal.toString());
    return ir._literal.toString();
  }

  Object visit(TempAddr ir) {
    p(ir._name);
    return null;
  }

  Object visit(SizeofAddr ir) {
    p("sizeof(").p(ir._ofType.toString()).p(")");
    return null;
  }

  // ---------------- instructions for computing values ----------------
  Object visit(CopyInstr ir) {
    p(ir._out).p(" = ").p(ir._in);
    return null;
  }

  Object visit(InfixInstr ir) {
    p(ir._out).p(" = ").p(ir._lhs).p(" ").p(ir._op).p(" ").p(ir._rhs);
    return null;
  }

  Object visit(PrefixInstr ir) {
    p(ir._out).p(" = ").p(ir._op).p(" ").p(ir._in);
    return null;
  }

  Object visit(CastInstr ir) {
    p(ir._out).p(" = ").p(ir._in).p(" : ").p(ir._type.toString());
    return null;
  }

  // ---------------- instructions for jumping ----------------
  Object visit(UncondJumpInstr ir) {
    p("goto ").p(ir._tgt);
    return null;
  }

  Object visit(TrueJumpInstr ir) {
    p("if ").p(ir._cond).p(" goto ").p(ir._tgt);
    return null;
  }

  Object visit(FalseJumpInstr ir) {
    p("ifFalse ").p(ir._cond).p(" goto ").p(ir._tgt);
    return null;
  }

  Object visit(RelopJumpInstr ir) {
    p("if ").p(ir._lhs).p(" ").p(ir._op).p(" ").p(ir._rhs)
      .p(" goto ").p(ir._tgt);
    return null;
  }

  // ---------------- instructions for functions ----------------
  Object visit(ParamInstr ir) {
    p("param[").p(ir._index).p(" : ").p(ir._arity).p("] = ").p(ir._in);
    return null;
  }

  Object visit(CallInstr ir) {
    if (null != ir._out)
      p(ir._out).p(" = ");
    p("call ").p(ir._fun.name()).p(" : ").p(ir._arity);
    return null;
  }

  Object visit(ReturnInstr ir) {
    p("return");
	  
    if (null != ir._val) {
      p(" ").p(ir._val);
    }
    return null;
  }

  // ---------------- instructions for memory access ----------------
  Object visit(ArrReadInstr ir) {
    p(ir._out).p(" = ").p(ir._base).p("[").p(ir._subscript).p("]");
    return null;
  }

  Object visit(ArrWriteInstr ir) {	  
    p(ir._base).p("[").p(ir._subscript).p("] = ").p(ir._in);
    return null;
  }

  Object visit(RecReadInstr ir) {
    p(ir._out).p(" = ").p(ir._base).p(".").p(ir._field.name());
    return null;
  }

  Object visit(RecWriteInstr ir) {
    p(ir._base).p(".").p(ir._field.name());
    p(" = ").p(ir._in);
    return null;
  }
}
