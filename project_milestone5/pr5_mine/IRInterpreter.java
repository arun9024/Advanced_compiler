import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

class IRInterpreter extends IRVisitor {
  public static void main(final String[] args) throws IOException {
    String printIR = null, fileName = null;
    boolean trace = false;
    for (int i=0, n=args.length; i<n; i++) {
      if ("--printIR".equals(args[i])) {
        i++;
        assert null == printIR : "spurious --printIR " + args[i];
        printIR = args[i];
      } else if ("--trace".equals(args[i])) {
        assert !trace : "spurious --trace";
        trace = true;
      } else {
        assert null == fileName : "spurious file name " + args[i];
        fileName = args[i];
      }
    }
    final TackLexer lexer = new TackLexer(new ANTLRFileStream(fileName));
    final TackParser parser = new TackParser(new CommonTokenStream(lexer));
    parser.removeErrorListeners();
    parser.addErrorListener(new ErrorPrinter());
    final Program ast = parser.irProgram().v;
    if (0 < ErrorPrinter._count)
      ErrorPrinter.exit();
    if (null != printIR) {
      PrintWriter writer = new PrintWriter(new FileWriter(printIR), true);
      IRPrinter visitor = new IRPrinter(writer);
      ast.accept(visitor);
    }
    PrintWriter out = new PrintWriter(System.out, true);
    PrintWriter trc = trace ? new PrintWriter(System.out, true) : null;
    IRInterpreter intp = new IRInterpreter(out, trc);
    ast.accept(intp);
  }

  // ---------------- interpreter state ----------------
  private static final class ActivationRecord {
    final FunDef _fun;
    final int _ra;
    Map<String, Object> _slots;
    Map<String, Integer> _labels;
    ActivationRecord(FunDef fun, int ra) {
      _fun = fun;
      _ra = ra;
      _slots = new TreeMap<String, Object>();
      _labels = new TreeMap<String, Integer>();
      for (int i=0, n=fun._sym._instructions.size(); i<n; i++) {
        Instruction instr = fun._sym._instructions.get(i);
        for (Label label : instr._labels) {
          if (_labels.containsKey(label._name)) {
            ErrorPrinter.print(instr._loc,
                               "Duplicate label '" + label._name
                               + "' in function '" + _fun._name._id + "'");
          } else {
            _labels.put(label._name, Integer.valueOf(i));
          }
        }
      }
    }
  }

  PrintWriter _out;
  PrintWriter _trace;
  Map<String, FunDef> _functions;
  Stack<ActivationRecord> _stack;
  List<Object> _params;
  int _ip;

  IRInterpreter(PrintWriter out, PrintWriter trace) {
    _out = out;
    _trace = trace;
  }

  private Object call(String name) {
    if (_functions.containsKey(name)) {
      FunDef fun = _functions.get(name);
      Object res = fun.accept(this);
      return res;
    } else if ("append".equals(name)) {
      Object lhs = getParam("lhs", 0), rhs = getParam("rhs", 1);
      _params.clear();
      if (null != lhs && checkType("string", lhs, "parameter 'lhs'") &&
          null != rhs && checkType("string", rhs, "parameter 'rhs'"))
        return ((String)lhs) + ((String)rhs);
    } else if ("bool2int".equals(name)) {
      Object b = getParam("b", 0);
      _params.clear();
      if (null != b && checkType("bool", b, "parameter 'b'"))
        return Long.valueOf(((Boolean)b).booleanValue() ? 1 : 0);
    } else if ("bool2string".equals(name)) {
      Object b = getParam("b", 0);
      _params.clear();
      if (null != b && checkType("bool", b, "parameter 'b'"))
        return ((Boolean)b).booleanValue() ? "true" : "false";
    } else if ("int2bool".equals(name)) {
      Object i = getParam("i", 0);
      _params.clear();
      if (null != i && checkType("int", i, "parameter 'i'"))
        return Boolean.valueOf(0 != ((Long)i).longValue());
    } else if ("int2string".equals(name)) {
      Object i = getParam("i", 0);
      _params.clear();
      if (null != i && checkType("int", i, "parameter 'i'"))
        return i.toString();
    } else if ("length".equals(name)) {
      Object s = getParam("s", 0);
      _params.clear();
      if (null != s && checkType("string", s, "parameter 's'"))
        return Long.valueOf(((String)s).length());
    } else if ("newArray".equals(name)) {
      Object aSize = getParam("aSize", 1);
      _params.clear();
      if (null != aSize && checkType("int", aSize, "parameter 'aSize'"))
        return new Object[((Long)aSize).intValue()];
    } else if ("newRecord".equals(name)) {
      _params.clear();
      return new TreeMap<String, Object>();
    } else if ("print".equals(name)) {
      _out.print(getParam("s", 0));
      _out.flush();
      _params.clear();
      return null;
    } else if ("range".equals(name)) {
      Object start = getParam("start", 0), end = getParam("end", 1);
      _params.clear();
      if (null != start && checkType("int", start, "parameter 'start'") &&
          null != end && checkType("int", end, "parameter 'end'")) {
        int s = ((Long)start).intValue(), e = ((Long)end).intValue();
        Object[] res = new Object[e - s];
        for (int i=s; i<e; i++)
          res[i - s] = Long.valueOf(i);
        return res;
      }
    } else if ("size".equals(name)) {
      Object a = getParam("size", 0);
      _params.clear();
      if (null != a && checkType("array", a, "parameter 'a'"))
        return Long.valueOf(((Object[])a).length);
    } else if ("string2bool".equals(name)) {
      Object s = getParam("s", 0);
      _params.clear();
      if (null != s && checkType("string", s, "parameter 's'"))
        return Boolean.valueOf(!("".equals(s) || "0".equals(s)));
    } else if ("string2int".equals(name)) {
      Object s = getParam("s", 0);
      _params.clear();
      if (null != s && checkType("string", s, "parameter 's'"))
        return Long.valueOf((String)s);
    } else if ("stringEqual".equals(name)) {
      Object lhs = getParam("lhs", 0), rhs = getParam("rhs", 1);
      _params.clear();
      if (null != lhs && checkType("string", lhs, "parameter 'start'") &&
          null != rhs && checkType("string", rhs, "parameter 'end'"))
        return lhs.equals(rhs);
    } else {
      ErrorPrinter.print(loc(), "Unknown function '" + name + "'");
    }
    return null;
  }

  private boolean checkType(String expectedType, Object actualValue,
                            String description) {
    String actualType = getType(actualValue);
    if (actualType.equals(expectedType))
      return true;
    if ("null".equals(actualType) && "record".equals(expectedType))
      return true;
    ErrorPrinter.print(loc(), "Expected " + expectedType + ", but found "
                       + actualType + " for " + description);
    return false;
  }

  private boolean equals(Object lhs, Object rhs) {
    if (lhs instanceof Boolean)
      return lhs.equals(rhs);
    else if (lhs instanceof Long)
      return lhs.equals(rhs);
    else if (lhs instanceof Map)
      return lhs == rhs;
    else if (lhs instanceof NullLit)
      return rhs instanceof NullLit;
    else if (lhs instanceof Object[])
      return lhs == rhs;
    else if (lhs instanceof String)
      return lhs == rhs;
    return false;
  }

  private Object getParam(String name, int idx) {
    Object res = null;
    if (0 <= idx && idx < _params.size())
      res = _params.get(idx);
    if (null == res)
      ErrorPrinter.print(loc(), "Missing parameter " + idx + " '" + name +"'");
    return res;
  }

  private String getType(Object value) {
    if (value instanceof Boolean)
      return "bool";
    else if (value instanceof Long)
      return "int";
    else if (value instanceof Map)
      return "record";
    else if (value instanceof NullLit)
      return "null";
    else if (value instanceof Object[])
      return "array";
    else if (value instanceof String)
      return "string";
    return value.getClass().getSimpleName();
  }

  private Location loc() {
    return _stack.peek()._fun._sym._instructions.get(_ip)._loc;
  }

  private Object rvalue(Address addr) {
    Object res = addr.accept(this);
    if (null == res)
      ErrorPrinter.print(loc(), "Could not compute rvalue");
    return res;
  }

  private Map<String, Object> slots() {
    return _stack.peek()._slots;
  }

  // ---------------- top-level ----------------
  Object visit(Program ir) {
    assert null == _functions && null == _stack && null == _params;
    _functions = new TreeMap<String, FunDef>();
    _stack = new Stack<ActivationRecord>();
    _params = new ArrayList<Object>();
    for (FunDef fun : ir._functions)
      _functions.put(fun._name._id, fun);
    Object res = call("main");
    assert 0 == _stack.size();
    _params = null;
    _stack = null;
    _functions = null;
    if (null != res && res instanceof Long)
      System.exit(((Long)res).intValue());
    return null;
  }

  Object visit(FunDef ir) {
    IRPrinter printer = null == _trace ? null : new IRPrinter(_trace);
    _stack.push(new ActivationRecord(ir, _ip));
    List<FieldType> formals = ir._type._formals._fields;
    for (int i=0, n=formals.size(); i<n; i++) {
      String formal = formals.get(i)._field._id;
      Object actual = getParam(formal, i);
      if (null != actual)
        slots().put(formal, actual);
    }
    _params.clear();
    _ip = 0;
    while (true) {
      if (_ip >= ir._sym._instructions.size()) {
        ErrorPrinter.print(ir._loc, "Control reached end of function");
        ActivationRecord popped = _stack.pop();
        _ip = popped._ra;
        return null;
      }
      Instruction instr = ir._sym._instructions.get(_ip);
      if (null != _trace) {
        _trace.print(instr._loc + ": ");
        instr.accept(printer);
        _trace.println();
      }
      Object res = instr.accept(this);
      if (instr instanceof ReturnInstr) {
        ActivationRecord popped = _stack.pop();
        _ip = popped._ra;
        return res;
      }
      if (null == res) {
        _ip++;
      } else {
        String tgtName = ((Label)res)._name;
        if (_stack.peek()._labels.containsKey(tgtName)) {
          _ip = _stack.peek()._labels.get(tgtName).intValue();
        } else {
          ErrorPrinter.print(instr._loc, "Unknown label '" + tgtName + "'");
          _ip++;
        }
      }
    }
  }

  Object visit(Type ir) {
    assert false : "Should never be called";
    return null;
  }

  Object visit(Label ir) {
    assert false : "Should never be called";
    return null;
  }

  // ---------------- addresses ----------------
  Object visit(NameAddr ir) {
    if (slots().containsKey(ir._name))
      return slots().get(ir._name);
    ErrorPrinter.print(loc(), "Undefined name '" + ir._name + "'");
    return null;
  }

  Object visit(ConstantAddr ir) {
    Expr lit = ((ConstantAddr)ir)._literal;
    if (lit instanceof BoolLit) {
      return Boolean.valueOf(((BoolLit)lit)._value);
    } else if (lit instanceof IntLit) {
      return Long.valueOf(((IntLit)lit)._value);
    } else if (lit instanceof NullLit) {
      return lit;
    } else if (lit instanceof StringLit) {
      String tok = ((StringLit)lit)._token;
      assert '"' == tok.charAt(0) && '"' == tok.charAt(tok.length() - 1);
      StringBuilder bld = new StringBuilder();
      for (int i=1, n=tok.length()-1; i<n; i++) {
        switch (tok.charAt(i)) {
          case '\\': {
            i++;
            switch (tok.charAt(i)) {
              case 'n': bld.append('\n'); break;
              default: bld.append(tok.charAt(i));
            }
            break;
          }
          default: {
            bld.append(tok.charAt(i));
          }
        }
      }
      return bld.toString();
    } else {
      assert false : "Unexpected literal type "+lit.getClass().getSimpleName();
    }
    return null;
  }

  Object visit(TempAddr ir) {
    if (slots().containsKey(ir._name))
      return slots().get(ir._name);
    ErrorPrinter.print(loc(), "Undefined name '" + ir._name + "'");
    return null;
  }

  Object visit(SizeofAddr ir) {
    return Long.valueOf(1);
  }

  // ---------------- instructions for computing values ----------------
  Object visit(CopyInstr ir) {
    Object in = rvalue(ir._in);
    String out = ir._out._name;
    slots().put(out, in);
    return null;
  }

  Object visit(InfixInstr ir) {
    Object lhs = rvalue(ir._lhs);
    Object rhs = rvalue(ir._rhs);
    if (checkType("int", lhs, "left operand of '" + ir._op + "'") &&
        checkType("int", rhs, "right operand of '" + ir._op + "'"))
    {
      long l = ((Long)lhs).longValue(), r = ((Long)rhs).longValue();
      String out = ir._out._name;
      if ("+".equals(ir._op))
        slots().put(out, Long.valueOf(l + r));
      else if ("-".equals(ir._op))
        slots().put(out, Long.valueOf(l - r));
      else if ("*".equals(ir._op))
        slots().put(out, Long.valueOf(l * r));
      else if ("/".equals(ir._op))
        slots().put(out, Long.valueOf(l / r));
      else if ("%".equals(ir._op))
        slots().put(out, Long.valueOf(l % r));
      else
        ErrorPrinter.print(ir._loc, "Unexpected operator '" + ir._op + "'");
    }
    return null;
  }

  Object visit(PrefixInstr ir) {
    Object in = rvalue(ir._in);
    if ("-".equals(ir._op)) {
      if (checkType("int", in, "operand of prefix '" + ir._op + "'")) {
        Long i = ((Long)in).longValue();
        String out = ir._out._name;
        slots().put(out, Long.valueOf(-i));
      }
    } else {
      ErrorPrinter.print(ir._loc, "Unexpected operator '" + ir._op + "'");
    }
    return null;
  }

  Object visit(CastInstr ir) {
    Object in = rvalue(ir._in);
    Type type = ir._type;
    if (type.equals(PrimitiveType.BOOLT)) {
      if (in instanceof Long)
        in = Boolean.valueOf(0 != ((Long)in).longValue());
      else if (in instanceof String)
        in = Boolean.valueOf(!("".equals(in) || "0".equals(in)));
    } else if (type.equals(PrimitiveType.INTT)) {
      if (in instanceof Boolean)
        in = Long.valueOf(((Boolean)in).booleanValue() ? 1 : 0);
      else if (in instanceof String)
        in = Long.valueOf((String)in);
    } else if (type.equals(PrimitiveType.STRINGT)) {
      if (in instanceof Boolean || in instanceof Long)
        in = in.toString();
    }
    String out = ir._out._name;
    slots().put(out, in);
    return null;
  }

  // ---------------- instructions for jumping ----------------
  Object visit(UncondJumpInstr ir) {
    return ir._tgt;
  }

  Object visit(TrueJumpInstr ir) {
    Object cond = rvalue(ir._cond);
    if (checkType("bool", cond, "condition"))
      return ((Boolean)cond).booleanValue() ? ir._tgt : null;
    return null;
  }

  Object visit(FalseJumpInstr ir) {
    Object cond = rvalue(ir._cond);
    if (checkType("bool", cond, "condition"))
      return ((Boolean)cond).booleanValue() ? null : ir._tgt;
    return null;
  }

  Object visit(RelopJumpInstr ir) {
    Object lhs = rvalue(ir._lhs);
    Object rhs = rvalue(ir._rhs);
    if ("==".equals(ir._op)) {
      return equals(lhs, rhs) ? ir._tgt : null;
    } else if ("!=".equals(ir._op)) {
      return equals(lhs, rhs) ? null : ir._tgt;
    } else {
      if (checkType("int", lhs, "left operand of '" + ir._op + "'") &&
          checkType("int", rhs, "right operand of '" + ir._op + "'")) {
        long l = ((Long)lhs).longValue(), r = ((Long)rhs).longValue();
        if ("<=".equals(ir._op))
          return l <= r ? ir._tgt : null;
        else if ("<".equals(ir._op))
          return l < r ? ir._tgt : null;
        else if (">=".equals(ir._op))
          return l >= r ? ir._tgt : null;
        else if (">".equals(ir._op))
          return l > r ? ir._tgt : null;
        else
          ErrorPrinter.print(ir._loc, "Unexpected operator '" + ir._op + "'");
      }
    }
    return null;
  }

  // ---------------- instructions for functions ----------------
  Object visit(ParamInstr ir) {
    while (_params.size() <= ir._arity)
      _params.add(null);
    if (null == _params.get(ir._index)) {
      _params.add(ir._index, rvalue(ir._in));
    } else {
      ErrorPrinter.print(ir._loc, "Duplicate param index '" + ir._index + "'");
    }
    return null;
  }

  Object visit(CallInstr ir) {
    Object res = call(ir._fun.name());
    if (null != ir._out) {
      String out = ir._out._name;
      if (null == res)
        ErrorPrinter.print(ir._loc, "Missing return value");
      else
        slots().put(out, res);
    }
    return null;
  }

  Object visit(ReturnInstr ir) {
    if (null != ir._val)
      return rvalue(ir._val);
    return null;
  }

  // ---------------- instructions for memory access ----------------
  Object visit(ArrReadInstr ir) {
    Object base = rvalue(ir._base);
    Object subscript = rvalue(ir._subscript);
    if (checkType("array", base, "base of '[]'") &&
        checkType("int", subscript, "subscript of '[]'")) {
      Object[] b = (Object[])base;
      int s = ((Long)subscript).intValue();
      if (0 <= s && s < b.length) {
        String out = ir._out._name;
        slots().put(out, b[s]);
      } else {
        ErrorPrinter.print(ir._loc, "Subscript '" + s
                           + "' is out of bounds for array of size '"
                           + b.length + "'");
      }
    }
    return null;
  }

  Object visit(ArrWriteInstr ir) {
    Object base = rvalue(ir._base);
    Object subscript = rvalue(ir._subscript);
    Object in = rvalue(ir._in);
    if (checkType("array", base, "base of '[]'") &&
        checkType("int", subscript, "subscript of '[]'")) {
      Object[] b = (Object[])base;
      int s = ((Long)subscript).intValue();
      if (0 <= s && s < b.length)
        b[s] = in;
      else
        ErrorPrinter.print(ir._loc, "Subscript '" + s
                           + "' is out of bounds for array of size '"
                           + b.length + "'");
    }
    return null;
  }

  Object visit(RecReadInstr ir) {
    Object base = rvalue(ir._base);
    String field = ir._field.name();
    if (checkType("record", base, "base of '.'")) {
      if (base instanceof NullLit) {
        ErrorPrinter.print(ir._loc, "The base of '.' is null");
      } else {
        @SuppressWarnings("unchecked")
          Map<String, Object> b = (Map<String, Object>)base;
        if (b.containsKey(field)) {
          String out = ir._out._name;
          slots().put(out, b.get(field));
        } else {
          ErrorPrinter.print(ir._loc, "Field '" + field + "' does not exist");
        }
      }
    }
    return null;
  }

  Object visit(RecWriteInstr ir) {
    Object base = rvalue(ir._base);
    String field = ir._field.name();
    Object in = rvalue(ir._in);
    if (checkType("record", base, "base of '.'")) {
      if (base instanceof NullLit) {
        ErrorPrinter.print(ir._loc, "The base of '.' is null");
      } else {
        @SuppressWarnings("unchecked")
          Map<String, Object> b = (Map<String, Object>)base;
        b.put(field, in);
      }
    }
    return null;
  }
}
