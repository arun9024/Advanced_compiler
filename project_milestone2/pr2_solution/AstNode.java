import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

abstract class AstNode {
  Location _loc;
  AstNode(Location loc) { _loc = loc; }
  abstract Object accept(Visitor visitor);
}

// ---------------- top-level ----------------
class Program extends AstNode {
  FunDefListHead _raw;
  List<FunDef> _functions;
  Program(Location loc, FunDefListHead raw) {
    super(loc); _raw = raw; _functions = null;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class FunDef extends AstNode {
  FunId _name;
  FunType _type;
  BlockStmt _body;
  FunDef(Location loc, FunId name, FunType type, BlockStmt body) {
    super(loc); _name = name; _type = type; _body = body;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class FunDefListHead extends AstNode {
  FunDef _first;
  FunDefListTail _tail;
  FunDefListHead(Location loc) { super(loc); _first = null; _tail = null; }
  FunDefListHead(Location loc, FunDef first, FunDefListTail tail) {
    super(loc); _first = first; _tail = tail;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}
class FunDefListTail extends AstNode {
  List<FunDef> _inh;
  FunDef _next;
  FunDefListTail _tail;
  FunDefListTail(Location loc) { super(loc); _next = null; _tail = null; }
  FunDefListTail(Location loc,FunDef next,FunDefListTail tail) {
    super(loc); _next = next; _tail = tail;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

// ---------------- types ----------------
abstract class Type extends AstNode {
  Type(Location loc) { super(loc); }
}

class ArrayType extends Type {
  Type _elem;
  ArrayType(Location loc, Type elem) { super(loc); _elem = elem; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class RecordType extends Type {
  FieldTypeListHead _raw;
  List<FieldType> _fields;
  RecordType(Location loc, FieldTypeListHead raw) {
    super(loc); _raw = raw; _fields = null;
  }
  RecordType(Location loc, List<FieldType> fields) {
    super(loc); _raw = null; _fields = fields;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class FieldTypeListHead extends AstNode {
  FieldType _first;
  FieldTypeListTail _tail;
  FieldTypeListHead(Location loc) { super(loc); _first = null; _tail = null; }
  FieldTypeListHead(Location loc, FieldType first, FieldTypeListTail tail) {
    super(loc); _first = first; _tail = tail;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}
class FieldTypeListTail extends AstNode {
  List<FieldType> _inh;
  FieldType _next;
  FieldTypeListTail _tail;
  FieldTypeListTail(Location loc) { super(loc); _next = null; _tail = null; }
  FieldTypeListTail(Location loc, FieldType next, FieldTypeListTail tail) {
    super(loc); _next = next; _tail = tail;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}  

class FieldType extends Type  {
  FieldId _field;
  Type _type;
  FieldType(Location loc, FieldId field, Type type) {
    super(loc); _field = field; _type = type;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class PrimitiveType extends Type {
  static final String BOOL = "bool".intern();
  static final String INT = "int".intern();
  static final String STRING = "string".intern();
  static final String VOID = "void".intern();
  String _name;
  PrimitiveType(Location loc, String name) {
    super(loc);
    assert BOOL == name || INT == name || STRING == name || VOID == name;
    _name = name;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class FunType extends Type {
  RecordType _formals;
  Type _returnType;
  FunType(Location loc, RecordType formals, Type returnType) {
    super(loc); _formals = formals; _returnType = returnType;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

// ---------------- statements ----------------
abstract class Stmt extends AstNode {
  Stmt(Location loc) { super(loc); }
}

class VarDef extends Stmt {
  VarId _var;
  Expr _rhs;
  VarDef(Location loc, VarId var, Expr rhs) {
    super(loc); _var = var; _rhs = rhs;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class AssignStmt extends Stmt {
  Expr _lhs;
  Expr _rhs;
  AssignStmt(Location loc, Expr lhs, Expr rhs) {
    super(loc); _lhs = lhs; _rhs = rhs;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class BlockStmt extends Stmt {
  StmtListHead _raw;
  List<Stmt> _stmts;
  BlockStmt(Location loc, StmtListHead raw) {
    super(loc); _raw=raw; _stmts=null;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class CallStmt extends Stmt {
  Expr _expr;
  CallStmt(Location loc, Expr expr) { super(loc); _expr = expr; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class ForStmt extends Stmt {
  VarId _var;
  Expr _expr;
  BlockStmt _body;
  ForStmt(Location loc, VarId var, Expr expr, BlockStmt body) {
    super(loc); _var = var; _expr = expr; _body = body;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class IfStmt extends Stmt {
  Expr _cond;
  BlockStmt _thenBranch;
  BlockStmt _elseBranch;
  IfStmt(Location loc, Expr cond, BlockStmt thenBranch, BlockStmt elseBranch) {
    super(loc); _cond=cond; _thenBranch=thenBranch; _elseBranch=elseBranch;
  }
  IfStmt(Location loc, Expr cond, BlockStmt thenBranch) {
    super(loc); _cond=cond; _thenBranch=thenBranch; _elseBranch=null;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class ReturnStmt extends Stmt {
  Expr _expr;
  ReturnStmt(Location loc, Expr expr) { super(loc); _expr = expr; }
  ReturnStmt(Location loc) { super(loc); _expr = null; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class WhileStmt extends Stmt {
  Expr _cond;
  BlockStmt _body;
  WhileStmt(Location loc, Expr cond, BlockStmt body) {
    super(loc); _cond = cond; _body = body;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class StmtListHead extends AstNode {
  Stmt _first;
  StmtListTail _tail;
  StmtListHead(Location loc) { super(loc); _first = null; _tail = null; }
  StmtListHead(Location loc, Stmt first, StmtListTail tail) {
    super(loc); _first = first; _tail = tail;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}
class StmtListTail extends AstNode {
  List<Stmt> _inh;
  Stmt _next;
  StmtListTail _tail;
  StmtListTail(Location loc) { super(loc); _next = null; _tail = null; }
  StmtListTail(Location loc, Stmt next, StmtListTail tail) {
    super(loc); _next = next; _tail = tail;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

// ---------------- expressions ----------------
abstract class Expr extends AstNode {
  Expr(Location loc) { super(loc); }
}

class InfixExpr extends Expr {
  String _op;
  Expr _lhs;
  Expr _rhs;
  InfixExpr(Location loc, String op, Expr lhs, Expr rhs) {
    super(loc); _op = op; _lhs = lhs; _rhs = rhs;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}
class InfixExprHead extends Expr {
  Expr _lhs;
  InfixExprTail _tail;
  InfixExprHead(Location loc, Expr lhs, InfixExprTail tail) {
    super(loc); _lhs = lhs; _tail = tail;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}
class InfixExprTail extends AstNode {
  Expr _inh;
  String _op;
  Expr _rhs;
  InfixExprTail _tail;
  InfixExprTail(Location loc) {
    super(loc); _inh = null; _op = null; _rhs = null; _tail = null;
  }
  InfixExprTail(Location loc, String op, Expr rhs, InfixExprTail tail) {
    super(loc); _inh = null; _op = op; _rhs = rhs; _tail = tail;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class PrefixExpr extends Expr {
  String _op;
  Expr _base;
  PrefixExpr(Location loc, String op, Expr base) {
    super(loc); _op = op; _base = base;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class PostfixExprHead extends Expr {
  Expr _base;
  PostfixExprTail _tail;
  PostfixExprHead(Location loc, Expr base, PostfixExprTail tail) {
    super(loc); _base = base; _tail = tail;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}
class PostfixExprTail extends AstNode {
  Expr _inh;
  PostfixExprTail(Location loc) { super(loc); _inh = null; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class CallExpr extends Expr {
  Expr _base;
  List<Expr> _actuals;
  CallExpr(Location loc, Expr base, List<Expr> actuals) {
    super(loc); _base = base; _actuals = actuals;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}
class CallExprTail extends PostfixExprTail {
  ExprListHead _actuals;
  PostfixExprTail _tail;
  CallExprTail(Location loc, ExprListHead actuals, PostfixExprTail tail) {
    super(loc); _actuals = actuals; _tail = tail;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class CastExpr extends Expr {
  Expr _base;
  Type _targetType;
  CastExpr(Location loc, Expr base, Type type) {
    super(loc); _base = base; _targetType = type;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}
class CastExprTail extends PostfixExprTail {
  Type _targetType;
  PostfixExprTail _tail;
  CastExprTail(Location loc, Type type, PostfixExprTail tail) {
    super(loc); _targetType = type; _tail = tail;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class FieldExpr extends Expr {
  Expr _base;
  FieldId _field;
  FieldExpr(Location loc, Expr base, FieldId field) {
    super(loc); _base = base; _field = field;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}
class FieldExprTail extends PostfixExprTail {
  FieldId _field;
  PostfixExprTail _tail;
  FieldExprTail(Location loc, FieldId field, PostfixExprTail tail) {
    super(loc); _field = field; _tail = tail;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class SubscriptExpr extends Expr {
  Expr _base;
  Expr _subscript;
  SubscriptExpr(Location loc, Expr base, Expr subscript) {
    super(loc); _base = base; _subscript = subscript;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}
class SubscriptExprTail extends PostfixExprTail {
  Expr _subscript;
  PostfixExprTail _tail;
  SubscriptExprTail(Location loc, Expr subscript, PostfixExprTail tail) {
    super(loc); _subscript = subscript; _tail = tail;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class ExprListHead extends AstNode {
  Expr _first;
  ExprListTail _tail;
  ExprListHead(Location loc) { super(loc); _first = null; _tail = null; }
  ExprListHead(Location loc, Expr first, ExprListTail tail) {
    super(loc); _first = first; _tail = tail;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}
class ExprListTail extends AstNode {
  List<Expr> _inh;
  Expr _next;
  ExprListTail _tail;
  ExprListTail(Location loc) { super(loc); _next = null; _tail = null; }
  ExprListTail(Location loc, Expr next, ExprListTail tail) {
    super(loc); _next = next; _tail = tail;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
} 

class ParenExpr extends Expr {
  Expr _base;
  ParenExpr(Location loc, Expr base) { super(loc); _base = base; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
} 

// ---------------- identifiers ----------------
class FieldId extends AstNode {
  String _id;
  FieldId(Location loc, String id) { super(loc); _id = id; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class FunId extends Expr {
  String _id;
  FunId(Location loc, String id) { super(loc); _id = id; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class VarId extends Expr {
  String _id;
  VarId(Location loc, String id) { super(loc); _id = id; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

// ---------------- literals ----------------
class ArrayLit extends Expr {
  ExprListHead _raw;
  List<Expr> _elems;
  ArrayLit(Location loc, ExprListHead raw) {
    super(loc); _raw = raw; _elems = null;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class RecordLit extends Expr {
  FieldLitListHead _raw;
  List<FieldLit> _fields;
  RecordLit(Location loc, FieldLitListHead raw) {
    super(loc); _raw = raw; _fields = null;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class FieldLitListHead extends AstNode {
  FieldLit _first;
  FieldLitListTail _tail;
  FieldLitListHead(Location loc) { super(loc); _first = null; _tail = null; }
  FieldLitListHead(Location loc, FieldLit first, FieldLitListTail tail) {
    super(loc); _first = first; _tail = tail;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}
class FieldLitListTail extends AstNode {
  List<FieldLit> _inh;
  FieldLit _next;
  FieldLitListTail _tail;
  FieldLitListTail(Location loc) { super(loc);  _next = null; _tail = null; }
  FieldLitListTail(Location loc, FieldLit next, FieldLitListTail tail) {
    super(loc); _next = next; _tail = tail;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class FieldLit extends AstNode {
  FieldId _field;
  Expr _expr;
  FieldType _type;
  FieldLit(Location loc, FieldId field, Expr expr) {
    super(loc); _field = field; _expr = expr; _type = null;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class BoolLit extends Expr {
  boolean _value;
  BoolLit(Location loc, String token) {
    super(loc); _value = "true".equals(token);
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class IntLit extends Expr {
  int _value;
  IntLit(Location loc, String token) {
    super(loc); _value = Integer.parseInt(token);
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class NullLit extends Expr {
  NullLit(Location loc) { super(loc); }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class StringLit extends Expr {
  String _token;
  StringLit(Location loc, String token) {
    super(loc); _token = token;
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}
