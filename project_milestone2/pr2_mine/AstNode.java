import java.util.List;

abstract class AstNode {
  Location _loc;
  AstNode(Location loc) { _loc = loc; }
  abstract Object accept(Visitor visitor);
}

abstract class InfixOp extends AstNode {
  InfixOp(Location loc) { super(loc); }

  abstract String op();
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

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
  BlockStmt _stmt;

  FunDef(Location loc, FunId name, FunType type, BlockStmt stmt) { super(loc); _name = name; _type = type; _stmt = stmt;}
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

class FunId extends AstNode {
  String _id;
  FunId(Location loc, String id) { super(loc); _id = id; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class FieldId extends AstNode {
  String _id;
  FieldId(Location loc, String id) { super(loc); _id = id; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class VarId extends AstNode {
  String _id;
  VarId(Location loc, String id) { super(loc); _id = id; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

// Literals -----------------------------------------------------------------------------------
class StringLit extends AstNode {
  String _lit;
  StringLit(Location loc, String lit) { super(loc); _lit = lit; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class IntLit extends AstNode {
  String _lit;
  IntLit(Location loc, String lit) { super(loc); _lit = lit; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class BoolLit extends AstNode {
  String _lit;
  BoolLit(Location loc, String lit) { super(loc); _lit = lit; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class NullLit extends AstNode {
  NullLit(Location loc) { super(loc); }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class ArrayLit extends AstNode {
        ExprList _exprList;

        ArrayLit(Location loc, ExprList exprList) {
                super(loc);

                _exprList = exprList;
        }

        Object accept(Visitor visitor) { return visitor.visit(this); }
}

class RecordLit extends AstNode {
        FieldLitList _fieldLitList;

        RecordLit(Location loc, FieldLitList fieldLitList) {
                super(loc);

                _fieldLitList = fieldLitList;
        }

        Object accept(Visitor visitor) { return visitor.visit(this); }
}

class ParenExpr extends AstNode {
        Expr _expr;

        ParenExpr(Location loc, Expr expr) {
                super(loc);

                _expr = expr;
        }

        Object accept(Visitor visitor) { return visitor.visit(this); }
}

class FieldLit extends AstNode {
	FieldId _id;
	Expr _expr;

	FieldLit(Location loc, FieldId id, Expr expr) {
		super(loc);

		_id = id;
		_expr = expr;
	}
	
  	Object accept(Visitor visitor) { return visitor.visit(this); }
}

class FieldLitList extends AstNode {
	FieldLit _lit;
	FieldLitListTail _tail;

	List<FieldLit> _inh;

	FieldLitList(Location loc, FieldLit lit, FieldLitListTail tail) {
		super(loc);

		_lit = lit;
		_tail = tail;

		_inh = null;
	}

	FieldLitList(Location loc) {
		super(loc);

		_lit = null;
		_tail = null;

		_inh = null;
	}
	
  	Object accept(Visitor visitor) { return visitor.visit(this); }
}

class FieldLitListTail extends AstNode {
	FieldLit _lit;
	FieldLitListTail _tail;

	List<FieldLit> _inh;
	
	FieldLitListTail(Location loc, FieldLit lit, FieldLitListTail tail) {
		super(loc);

		_lit = lit;
		_tail = tail;

		_inh = null;
	}

	FieldLitListTail(Location loc) {
		super(loc);

		_lit = null;
		_tail = null;

		_inh = null;
	}
	
  	Object accept(Visitor visitor) { return visitor.visit(this); }
}

// Primitives ---------------------------------------------------------------------------------
class IntType extends AstNode {
  IntType(Location loc) { super(loc); }
  String attr() { return "int"; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class BoolType extends AstNode {
  BoolType(Location loc) { super(loc); }
  String attr() { return "bool"; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class StringType extends AstNode {
  StringType(Location loc) { super(loc); }
  String attr() { return "string"; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class VoidType extends AstNode {
  VoidType(Location loc) { super(loc); }
  String attr() { return "void"; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class PrimitiveType extends AstNode {
  IntType _i;
  BoolType _b;
  StringType _s;

  PrimitiveType(Location loc, IntType i) { super(loc); _i = i; _b = null; _s = null; }
  PrimitiveType(Location loc, BoolType b) { super(loc); _i = null; _b = b; _s = null; }
  PrimitiveType(Location loc, StringType s) { super(loc); _i = null; _b = null; _s = s; }
  String attr() {
      if (_i != null) return _i.attr();
      if (_b != null) return _b.attr();
      if (_s != null) return _s.attr();
      return ""; // unreachable
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

// InfixOp
class SumOp extends InfixOp {
  SumOp(Location loc) { super(loc); }
  String op() { return "+"; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class SubOp extends InfixOp {
  SubOp(Location loc) { super(loc); }
  String op() { return "-"; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class ProductOp extends InfixOp {
  ProductOp(Location loc) { super(loc); }
  String op() { return "*"; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class DivOp extends InfixOp {
  DivOp(Location loc) { super(loc); }
  String op() { return "/"; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class ModOp extends InfixOp {
  ModOp(Location loc) { super(loc); }
  String op() { return "%"; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class EqualOp extends InfixOp {
  EqualOp(Location loc) { super(loc); }
  String op() { return "=="; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class NotEqualOp extends InfixOp {
  NotEqualOp(Location loc) { super(loc); }
  String op() { return "!="; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class LessEqualOp extends InfixOp {
  LessEqualOp(Location loc) { super(loc); }
  String op() { return "<="; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class LessOp extends InfixOp {
  LessOp(Location loc) { super(loc); }
  String op() { return "<"; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class GreatEqualOp extends InfixOp {
  GreatEqualOp(Location loc) { super(loc); }
  String op() { return ">="; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class GreatOp extends InfixOp {
  GreatOp(Location loc) { super(loc); }
  String op() { return ">"; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class NotOp extends AstNode {
  NotOp(Location loc) { super(loc); }
  String op() { return "!"; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class MinusOp extends AstNode {
  MinusOp(Location loc) { super(loc); }
  String op() { return "-"; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class OrOp extends InfixOp {
  OrOp(Location loc) { super(loc); }
  String op() { return "||"; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class AndOp extends InfixOp {
  AndOp(Location loc) { super(loc); }
  String op() { return "&&"; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class EqOp extends InfixOp {
  EqualOp _a;
  NotEqualOp _s;

  EqOp(Location loc, EqualOp a) { super(loc); _a = a; _s = null; }
  EqOp(Location loc, NotEqualOp s) { super(loc); _a = null; _s = s; }

  String op() {
      if (_a != null) return _a.op();
      if (_s != null) return _s.op();
      return ""; // unreachable
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class RelOp extends InfixOp {
  LessEqualOp _a;
  LessOp _s;
  GreatEqualOp _mu;
  GreatOp _d;

  RelOp(Location loc, LessEqualOp a) { super(loc); _a = a; _s = null; _mu = null; _d = null; }
  RelOp(Location loc, LessOp s) { super(loc); _a = null; _s = s; _mu = null; _d = null; }
  RelOp(Location loc, GreatEqualOp mu) { super(loc); _a = null; _s = null; _mu = mu; _d = null; }
  RelOp(Location loc, GreatOp d) { super(loc); _a = null; _s = null; _mu = null; _d = d; }

  String op() {
      if (_a != null) return _a.op();
      if (_s != null) return _s.op();
      if (_mu != null) return _mu.op();
      if (_d != null) return _d.op();
      return ""; // unreachable
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class AddOp extends InfixOp {
  SumOp _a;
  SubOp _s;

  AddOp(Location loc, SumOp a) { super(loc); _a = a; _s = null; }
  AddOp(Location loc, SubOp s) { super(loc); _a = null; _s = s; }

  String op() {
      if (_a != null) return _a.op();
      if (_s != null) return _s.op();
      return ""; // unreachable
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}


class MultOp extends InfixOp {
  ProductOp _a;
  DivOp _s;
  ModOp _mu;

  MultOp(Location loc, ProductOp a) { super(loc); _a = a; _s = null; _mu = null; }
  MultOp(Location loc, DivOp s) { super(loc); _a = null; _s = s; _mu = null; }
  MultOp(Location loc, ModOp mu) { super(loc); _a = null; _s = null; _mu = mu; }

  String op() {
      if (_a != null) return _a.op();
      if (_s != null) return _s.op();
      if (_mu != null) return _mu.op();
      return ""; // unreachable
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class PrefixOp extends AstNode {
  NotOp _a;
  MinusOp _s;

  PrefixOp(Location loc, NotOp a) { super(loc); _a = a; _s = null; }
  PrefixOp(Location loc, MinusOp s) { super(loc); _a = null; _s = s; }

  String op() {
      if (_a != null) return _a.op();
      if (_s != null) return _s.op();
      return ""; // unreachable
  }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

// Types ---------------------------------------------------------------------------------------
class ArrayType extends AstNode {
  Type _type;
  ArrayType(Location loc, Type type) { super(loc); _type = type; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class RecordType extends AstNode {
  FieldTypeList _raw;
  List<FieldType> _fields;
  RecordType(Location loc, FieldTypeList raw) { super(loc); _raw = raw; _fields = null; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class FieldTypeList extends AstNode {
  FieldType _type;
  FieldTypeListTail _tail;
  FieldTypeList(Location loc, FieldType type, FieldTypeListTail tail) { super(loc); _type = type; _tail = tail; }
  FieldTypeList(Location loc) { super(loc); _type = null; _tail = null; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class FieldTypeListTail extends AstNode {
  List<FieldType> _inh;
  FieldType _next;
  FieldTypeListTail _tail;
  FieldTypeListTail(Location loc) { super(loc); _inh = null; _next = null; _tail = null; }
  FieldTypeListTail(Location loc, FieldType next, FieldTypeListTail tail) { super(loc); _inh = null; _next = next; _tail = tail; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class FieldType extends AstNode {
  FieldId _id;
  Type _type;
  FieldType(Location loc, FieldId id, Type type) { super(loc); _id = id; _type = type; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class FunType extends AstNode {
  RecordType _rec;
  ReturnType _type;
  FunType(Location loc, RecordType rec, ReturnType type) { super(loc); _rec = rec; _type = type; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class ReturnType extends AstNode {
  Type _type;
  VoidType _voidType;
  ReturnType(Location loc, Type type) { super(loc); _type = type; _voidType = null; }
  ReturnType(Location loc, VoidType voidType) { super(loc); _type = null; _voidType = voidType; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

class Type extends AstNode {
      ArrayType _arr;
      RecordType _rec;
      PrimitiveType _prim;

      Type(Location loc, ArrayType arr) { super(loc); _arr = arr; _rec = null; _prim = null; }
      Type(Location loc, RecordType rec) { super(loc); _arr = null; _rec = rec; _prim = null; }
      Type(Location loc, PrimitiveType prim) { super(loc); _arr = null; _rec = null; _prim = prim; }
      Object accept(Visitor visitor) { return visitor.visit(this); }
}

// Expr ----------------------------------------------------------------------------

class Expr extends AstNode {
      	// members containing pointers to children
	LogicOrExpr _raw;

      	// member containing information extracted from children.
	List<LogicAndExpr> _inh;
	List<OrOp> _infixOp;

	// Constructors (corresponding to rules in Tack.g4)
	Expr(Location loc, LogicOrExpr raw) { 
		super(loc); 

		_raw = raw;

		// make sure that inherited information from children point to null at this point.
		_inh = null;
		_infixOp = null;
	}      
      	
	// abstract class function
	Object accept(Visitor visitor) { return visitor.visit(this); }
}

class LogicOrExpr extends AstNode {
	LogicAndExpr _andExpr;
	LogicOrExprTail _tail;

	List<LogicAndExpr> _inh;
	List<OrOp> _infixOp;

	LogicOrExpr(Location loc, LogicAndExpr andExpr, LogicOrExprTail tail) {
		super(loc); 
		
		_andExpr = andExpr;
		_tail = tail;

		_inh = null;
		_infixOp = null;
	}

	Object accept(Visitor visitor) { return visitor.visit(this); }
}

class LogicOrExprTail extends AstNode {
	OrOp _orOp;
	LogicAndExpr _andExpr;
	LogicOrExprTail _tail;

	List<LogicAndExpr> _inh;
	List<OrOp> _infixOp;

	LogicOrExprTail(Location loc, OrOp orOp, LogicAndExpr andExpr, LogicOrExprTail tail) {
		super(loc); 
		
		_orOp = orOp;
		_andExpr = andExpr;
		_tail = tail;

		_inh = null;
		_infixOp = null;
	}

	LogicOrExprTail(Location loc) {
		super(loc); 
		
		_orOp = null;
		_andExpr = null;
		_tail = null;

		_inh = null;
		_infixOp = null;
	}

	Object accept(Visitor visitor) { return visitor.visit(this); }
}

class LogicAndExpr extends AstNode {
	EqExpr _eqExpr;
	LogicAndExprTail _tail;

	List<EqExpr> _inh;
	List<AndOp> _infixOp;

	LogicAndExpr(Location loc, EqExpr eqExpr, LogicAndExprTail tail) {
		super(loc); 
		
		_eqExpr = eqExpr;
		_tail = tail;

		_inh = null;
		_infixOp = null;
	}

	Object accept(Visitor visitor) { return visitor.visit(this); }
}

class LogicAndExprTail extends AstNode {
	AndOp _andOp;
	EqExpr _eqExpr;
	LogicAndExprTail _tail;

	List<EqExpr> _inh;
	List<AndOp> _infixOp;

	LogicAndExprTail(Location loc, AndOp andOp, EqExpr eqExpr, LogicAndExprTail tail) {
		super(loc); 
		
		_andOp = andOp;
		_eqExpr = eqExpr;
		_tail = tail;

		_inh = null;
		_infixOp = null;
	}

	LogicAndExprTail(Location loc) {
		super(loc); 
		
		_andOp = null;
		_eqExpr = null;
		_tail = null;

		_inh = null;
		_infixOp = null;
	}

	Object accept(Visitor visitor) { return visitor.visit(this); }
}

class EqExpr extends AstNode {
	RelExpr _relExpr;
	EqExprTail _tail;

	List<RelExpr> _inh;
	List<EqOp> _infixOp;

	EqExpr(Location loc, RelExpr relExpr, EqExprTail tail) {
		super(loc); 
		
		_relExpr = relExpr;
		_tail = tail;

		_inh = null;
		_infixOp = null;
	}

	Object accept(Visitor visitor) { return visitor.visit(this); }
}

class EqExprTail extends AstNode {
	EqOp _eqOp;
	RelExpr _relExpr;
	EqExprTail _tail;

	List<RelExpr> _inh;
	List<EqOp> _infixOp;

	EqExprTail(Location loc, EqOp eqOp, RelExpr relExpr, EqExprTail tail) {
		super(loc); 
		
		_eqOp = eqOp;
		_relExpr = relExpr;
		_tail = tail;

		_inh = null;
		_infixOp = null;
	}

	EqExprTail(Location loc) {
		super(loc); 
		
		_eqOp = null;
		_relExpr = null;
		_tail = null;

		_inh = null;
		_infixOp = null;
	}

	Object accept(Visitor visitor) { return visitor.visit(this); }
}

class RelExpr extends AstNode {
	AddExpr _addExpr;
	RelExprTail _tail;

	List<AddExpr> _inh;
	List<RelOp> _infixOp;

	RelExpr(Location loc, AddExpr addExpr, RelExprTail tail) {
		super(loc); 
		
		_addExpr = addExpr;
		_tail = tail;

		_inh = null;
		_infixOp = null;
	}

	Object accept(Visitor visitor) { return visitor.visit(this); }
}

class RelExprTail extends AstNode {
	RelOp _relOp;
	AddExpr _addExpr;
	RelExprTail _tail;

	List<AddExpr> _inh;
	List<RelOp> _infixOp;

	RelExprTail(Location loc, RelOp relOp, AddExpr addExpr, RelExprTail tail) {
		super(loc); 
		
		_relOp = relOp;
		_addExpr = addExpr;
		_tail = tail;

		_inh = null;
		_infixOp = null;
	}

	RelExprTail(Location loc) {
		super(loc); 
		
		_relOp = null;
		_addExpr = null;
		_tail = null;

		_inh = null;
		_infixOp = null;
	}

	Object accept(Visitor visitor) { return visitor.visit(this); }
}

class AddExpr extends AstNode {
	MultExpr _multExpr;
	AddExprTail _tail;

	List<MultExpr> _inh;
	List<AddOp> _infixOp;

	AddExpr(Location loc, MultExpr multExpr, AddExprTail tail) {
		super(loc); 
		
		_multExpr = multExpr;
		_tail = tail;

		_inh = null;
		_infixOp = null;
	}

	Object accept(Visitor visitor) { return visitor.visit(this); }
}

class AddExprTail extends AstNode {
	AddOp _addOp;
	MultExpr _multExpr;
	AddExprTail _tail;

	List<MultExpr> _inh;
	List<AddOp> _infixOp;

	AddExprTail(Location loc, AddOp addOp, MultExpr multExpr, AddExprTail tail) {
		super(loc); 
		
		_addOp = addOp;
		_multExpr = multExpr;
		_tail = tail;

		_inh = null;
		_infixOp = null;
	}

	AddExprTail(Location loc) {
		super(loc); 
		
		_addOp = null;
		_multExpr = null;
		_tail = null;

		_inh = null;
		_infixOp = null;
	}

	Object accept(Visitor visitor) { return visitor.visit(this); }
}

class MultExpr extends AstNode {
	PrefixExpr _prefixExpr;
	MultExprTail _tail;

	List<PrefixExpr> _inh;
	List<MultOp> _infixOp;

	MultExpr(Location loc, PrefixExpr prefixExpr, MultExprTail tail) {
		super(loc); 
		
		_prefixExpr = prefixExpr;
		_tail = tail;

		_inh = null;
		_infixOp = null;
	}

	Object accept(Visitor visitor) { return visitor.visit(this); }
}

class MultExprTail extends AstNode {
	MultOp _multOp;
	PrefixExpr _prefixExpr;
	MultExprTail _tail;

	List<PrefixExpr> _inh;
	List<MultOp> _infixOp;

	MultExprTail(Location loc, MultOp multOp, PrefixExpr prefixExpr, MultExprTail tail) {
		super(loc); 
		
		_multOp = multOp;
		_prefixExpr = prefixExpr;
		_tail = tail;

		_inh = null;
		_infixOp = null;
	}

	MultExprTail(Location loc) {
		super(loc); 
		
		_multOp = null;
		_prefixExpr = null;
		_tail = null;

		_inh = null;
		_infixOp = null;
	}

	Object accept(Visitor visitor) { return visitor.visit(this); }
}

class PrefixExpr extends AstNode {
	PrefixOp _prefixOp;
	PrefixExpr _tail;
	
	PostfixExpr _postfixExpr;

	List<PrefixOp> _inh;
	PostfixExpr _actPostfixExpr;
		
	PrefixExpr(Location loc, PrefixOp prefixOp, PrefixExpr tail) {
		super(loc);

		_prefixOp = prefixOp;
		_tail = tail;

		_postfixExpr = null;
		_inh = null;
		_actPostfixExpr = null;
	}

	PrefixExpr(Location loc, PostfixExpr postfixExpr) {
		super(loc);

		_prefixOp = null;
		_tail = null;

		_postfixExpr = postfixExpr;
		_inh = null;
		_actPostfixExpr = postfixExpr;
	}

	Object accept(Visitor visitor) { return visitor.visit(this); }
}

class CallExpr extends AstNode {
        FunId _id;
        CallActuals _callActuals;

        CallExpr(Location loc, FunId id, CallActuals callActuals) {
                super(loc);

                _id = id;
                _callActuals = callActuals;
        }

        Object accept(Visitor visitor) { return visitor.visit(this); }
}

class CallActuals extends AstNode {
        ExprList _exprList;

        CallActuals(Location loc, ExprList exprList) {
                super(loc);

                _exprList = exprList;
        }

        Object accept(Visitor visitor) { return visitor.visit(this); }
}

class PrimExpr extends AstNode {
	VarId _varId;
	ArrayLit _arrayLit;
	RecordLit _recordLit;
	ParenExpr _parenExpr;
	BoolLit _boolLit;
	IntLit _intLit;
	NullLit _nullLit;
	StringLit _stringLit;

	PrimExpr(Location loc, VarId varId) { super(loc); _varId = varId; _arrayLit = null; _recordLit = null; _parenExpr = null; _boolLit = null; _intLit = null; _nullLit = null; _stringLit = null;}	
	PrimExpr(Location loc, ArrayLit arrayLit) { super(loc); _varId = null; _arrayLit = arrayLit; _recordLit = null; _parenExpr = null; _boolLit = null; _intLit = null; _nullLit = null; _stringLit = null;}	
	PrimExpr(Location loc, RecordLit recordLit) { super(loc); _varId = null; _arrayLit = null; _recordLit = recordLit; _parenExpr = null; _boolLit = null; _intLit = null; _nullLit = null; _stringLit = null;}	
	PrimExpr(Location loc, ParenExpr parenExpr) { super(loc); _varId = null; _arrayLit = null; _recordLit = null; _parenExpr = parenExpr; _boolLit = null; _intLit = null; _nullLit = null; _stringLit = null;}	
	PrimExpr(Location loc, BoolLit boolLit) { super(loc); _varId = null; _arrayLit = null; _recordLit = null; _parenExpr = null; _boolLit = boolLit; _intLit = null; _nullLit = null; _stringLit = null;}	
	PrimExpr(Location loc, IntLit intLit) { super(loc); _varId = null; _arrayLit = null; _recordLit = null; _parenExpr = null; _boolLit = null; _intLit = intLit; _nullLit = null; _stringLit = null;}	
	PrimExpr(Location loc, NullLit nullLit) { super(loc); _varId = null; _arrayLit = null; _recordLit = null; _parenExpr = null; _boolLit = null; _intLit = null; _nullLit = nullLit; _stringLit = null;}	
	PrimExpr(Location loc, StringLit stringLit) { super(loc); _varId = null; _arrayLit = null; _recordLit = null; _parenExpr = null; _boolLit = null; _intLit = null; _nullLit = null; _stringLit = stringLit;}	

        Object accept(Visitor visitor) { return visitor.visit(this); }
}

class CommonPostfix {
	String _name;

	ExprList _exprList;
	Type _type;
	FieldId _fieldId;
	Expr _expr;

	CommonPostfix(String name, ExprList exprList) { _name = name; _exprList = exprList; _type = null; _fieldId = null; _expr = null; }	
	CommonPostfix(String name, Type type) { _name = name; _exprList = null; _type = type; _fieldId = null; _expr = null; }	
	CommonPostfix(String name, FieldId fieldId) { _name = name; _exprList = null; _type = null; _fieldId = fieldId; _expr = null; }	
	CommonPostfix(String name, Expr expr) { _name = name; _exprList = null; _type = null; _fieldId = null; _expr = expr; }	
}

class PostfixExpr extends AstNode {
	PrimExpr _primExpr;
	PostfixExprTail _tail;

	List<CommonPostfix> _inh;	

	PostfixExpr(Location loc, PrimExpr primExpr, PostfixExprTail tail) {
		super(loc);

		_primExpr = primExpr;
		_tail = tail;
		_inh = null;
	}

        Object accept(Visitor visitor) { return visitor.visit(this); }
}

class PostfixExprTail extends AstNode {
	CommonPostfix _next;
	PostfixExprTail _tail;

	List<CommonPostfix> _inh;

	PostfixExprTail(Location loc, ExprList exprList, PostfixExprTail tail, String name) 
	{
		super(loc);
		
		_next = new CommonPostfix(name, exprList);
		_tail = tail;
		_inh = null;
	}

	PostfixExprTail(Location loc, Type type, PostfixExprTail tail, String name) 
	{
		super(loc);
		
		_next = new CommonPostfix(name, type);
		_tail = tail;
		_inh = null;
	}

	PostfixExprTail(Location loc, FieldId fieldId, PostfixExprTail tail, String name) 
	{
		super(loc);
		
		_next = new CommonPostfix(name, fieldId);
		_tail = tail;
		_inh = null;
	}

	PostfixExprTail(Location loc, Expr expr, PostfixExprTail tail, String name) 
	{
		super(loc);
		
		_next = new CommonPostfix(name, expr);
		_tail = tail;
		_inh = null;
	}

	PostfixExprTail(Location loc) 
	{
		super(loc);
		
		_next = null;
		_tail = null;
		_inh = null;
	}

        Object accept(Visitor visitor) { return visitor.visit(this); }
}

class ExprList extends AstNode {
	Expr _expr;
	ExprListTail _tail;

	List<Expr> _inh;

	ExprList(Location loc, Expr expr, ExprListTail tail) {
		super(loc);

		_expr = expr;
		_tail = tail;

		_inh = null;
	}

	Object accept(Visitor visitor) { return visitor.visit(this); }
}

class ExprListTail extends AstNode {
	Expr _expr;
	ExprListTail _tail;

	List<Expr> _inh;
	
	ExprListTail(Location loc, Expr expr, ExprListTail tail) {
		super(loc);

		_expr = expr;
		_tail = tail;

		_inh = null;
	}

	ExprListTail(Location loc) {
		super(loc);

		_expr = null;
		_tail = null;

		_inh = null;
	}

	Object accept(Visitor visitor) { return visitor.visit(this); }
}

// Statements ------------------------------------------------------------------------

class VarDef extends AstNode {
    VarId _id;
    Expr _expr;

    VarDef(Location loc, VarId id, Expr expr) {
        super(loc);

        _id = id;
        _expr = expr;
    }

    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class AssignStmt extends AstNode {
    Expr _expr1;
    Expr _expr2;

    AssignStmt(Location loc, Expr expr1, Expr expr2) {
        super(loc);

        _expr1 = expr1;
        _expr2 = expr2;
    }

    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class CallStmt extends AstNode {
    CallExpr _callExpr;

    CallStmt(Location loc, CallExpr callExpr) {
        super(loc);

        _callExpr = callExpr;
    }

    Object accept(Visitor visitor) { return visitor.visit(this); }
}

class StmtList extends AstNode {
        Stmt _stmt;
        StmtListTail _tail;

        List<Stmt> _inh;

        StmtList(Location loc, Stmt stmt, StmtListTail tail) {
                super(loc);

                _stmt = stmt;
                _tail = tail;

                _inh = null;
        }

        StmtList(Location loc) {
                super(loc);

                _stmt = null;
                _tail = null;

                _inh = null;
        }

        Object accept(Visitor visitor) { return visitor.visit(this); }
}

class StmtListTail extends AstNode {
        Stmt _stmt;
        StmtListTail _tail;

        List<Stmt> _inh;

        StmtListTail(Location loc, Stmt stmt, StmtListTail tail) {
                super(loc);

                _stmt = stmt;
                _tail = tail;

                _inh = null;
        }

        StmtListTail(Location loc) {
                super(loc);

                _stmt = null;
                _tail = null;

                _inh = null;
        }

        Object accept(Visitor visitor) { return visitor.visit(this); }
}

class BlockStmt extends AstNode {
        StmtList _stmtList;

        BlockStmt(Location loc, StmtList stmtList) {
                super(loc);

                _stmtList = stmtList;
        }

        Object accept(Visitor visitor) { return visitor.visit(this); }
}

class ForStmt extends AstNode {
        VarId _id;
        Expr _expr;
        BlockStmt _blockStmt;

        ForStmt(Location loc, VarId id, Expr expr, BlockStmt blockStmt) {
                super(loc);

                _id = id;
                _expr = expr;
                _blockStmt = blockStmt;
        }

        Object accept(Visitor visitor) { return visitor.visit(this); }
}

class WhileStmt extends AstNode {
        Expr _expr;
        BlockStmt _blockStmt;

        WhileStmt(Location loc, Expr expr, BlockStmt blockStmt) {
                super(loc);

                _expr = expr;
                _blockStmt = blockStmt;
        }

        Object accept(Visitor visitor) { return visitor.visit(this); }
}

class IfStmt extends AstNode {
        Expr _expr1;
        BlockStmt _blockStmt1;
        BlockStmt _blockStmt2;
        Expr _expr2;
        BlockStmt _blockStmt3;

        IfStmt(Location loc, Expr expr1, BlockStmt blockStmt1, BlockStmt blockStmt2) {
                super(loc);

                _expr1 = expr1;
                _blockStmt1 = blockStmt1;
                _blockStmt2 = blockStmt2;
                _expr2 = null;
                _blockStmt3 = null;
        }

        IfStmt(Location loc, Expr expr2, BlockStmt blockStmt3) {
                super(loc);

                _expr1 = null;
                _blockStmt1 = null;
                _blockStmt2 = null;
                _expr2 = expr2;
                _blockStmt3 = blockStmt3;
        }

        Object accept(Visitor visitor) { return visitor.visit(this); }
}

class ReturnStmt extends AstNode {
        Expr _expr;

        ReturnStmt(Location loc, Expr expr) {
                super(loc);

                _expr = expr;
        }

        ReturnStmt(Location loc) {
                super(loc);

                _expr = null;
        }

        Object accept(Visitor visitor) { return visitor.visit(this); }
}

class Stmt extends AstNode {
        VarDef _varDef;
        AssignStmt _assignStmt;
        BlockStmt _blockStmt;
        CallStmt _callStmt;
        ForStmt _forStmt;
        IfStmt _ifStmt;
        ReturnStmt _returnStmt;
        WhileStmt _whileStmt;

        Stmt(Location loc, VarDef varDef) { super(loc); _varDef = varDef; _assignStmt = null; _blockStmt = null; _callStmt = null; _forStmt = null; _ifStmt = null; _returnStmt = null; _whileStmt = null;}  
        Stmt(Location loc, AssignStmt assignStmt) { super(loc); _varDef = null; _assignStmt = assignStmt; _blockStmt = null; _callStmt = null; _forStmt = null; _ifStmt = null; _returnStmt = null; _whileStmt = null;}
        Stmt(Location loc, BlockStmt blockStmt) { super(loc); _varDef = null; _assignStmt = null; _blockStmt = blockStmt; _callStmt = null; _forStmt = null; _ifStmt = null; _returnStmt = null; _whileStmt = null;}
        Stmt(Location loc, CallStmt callStmt) { super(loc); _varDef = null; _assignStmt = null; _blockStmt = null; _callStmt = callStmt; _forStmt = null; _ifStmt = null; _returnStmt = null; _whileStmt = null;}
        Stmt(Location loc, ForStmt forStmt) { super(loc); _varDef = null; _assignStmt = null; _blockStmt = null; _callStmt = null; _forStmt = forStmt; _ifStmt = null; _returnStmt = null; _whileStmt = null;}
        Stmt(Location loc, IfStmt ifStmt) { super(loc); _varDef = null; _assignStmt = null; _blockStmt = null; _callStmt = null; _forStmt = null; _ifStmt = ifStmt; _returnStmt = null; _whileStmt = null;}  
        Stmt(Location loc, ReturnStmt returnStmt) { super(loc); _varDef = null; _assignStmt = null; _blockStmt = null; _callStmt = null; _forStmt = null; _ifStmt = null; _returnStmt = returnStmt; _whileStmt = null;}
        Stmt(Location loc, WhileStmt whileStmt) { super(loc); _varDef = null; _assignStmt = null; _blockStmt = null; _callStmt = null; _forStmt = null; _ifStmt = null; _returnStmt = null; _whileStmt = whileStmt;}

        Object accept(Visitor visitor) { return visitor.visit(this); }
}

// Tester ----------------------------------------------------------------------------
class Tester extends AstNode {
  Expr _raw;
  Tester(Location loc, Expr raw) { super(loc); _raw = raw; }
  Object accept(Visitor visitor) { return visitor.visit(this); }
}

