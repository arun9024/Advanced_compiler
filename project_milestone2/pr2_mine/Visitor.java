abstract class Visitor {
  Object defaultVisit(AstNode ast) {
    assert false : "not implemented";
    return null;
  }
  Object visit(Program ast) { return defaultVisit(ast); }
  Object visit(FunDef ast) { return defaultVisit(ast); }

  Object visit(FunDefListHead ast) { return defaultVisit(ast); }
  Object visit(FunDefListTail ast) { return defaultVisit(ast); }

  Object visit(FunId ast) { return defaultVisit(ast); }
  Object visit(FieldId ast) { return defaultVisit(ast); }
  Object visit(VarId ast) { return defaultVisit(ast); }

  Object visit(StringLit ast) { return defaultVisit(ast); }
  Object visit(IntLit ast) { return defaultVisit(ast); }
  Object visit(BoolLit ast) { return defaultVisit(ast); }
  Object visit(NullLit ast) { return defaultVisit(ast); }
  Object visit(ArrayLit ast) { return defaultVisit(ast); }
  Object visit(RecordLit ast) { return defaultVisit(ast); }
  Object visit(ParenExpr ast) { return defaultVisit(ast); }
  Object visit(FieldLit ast) { return defaultVisit(ast); }
  Object visit(FieldLitList ast) { return defaultVisit(ast); }
  Object visit(FieldLitListTail ast) { return defaultVisit(ast); }

  Object visit(IntType ast) { return defaultVisit(ast); }
  Object visit(BoolType ast) { return defaultVisit(ast); }
  Object visit(StringType ast) { return defaultVisit(ast); }
  Object visit(VoidType ast) { return defaultVisit(ast); }
  Object visit(PrimitiveType ast) { return defaultVisit(ast); }

  Object visit(Type ast) { return defaultVisit(ast); }
  Object visit(ArrayType ast) { return defaultVisit(ast); }
  Object visit(RecordType ast) { return defaultVisit(ast); }
  Object visit(FieldType ast) { return defaultVisit(ast); }
  Object visit(FieldTypeList ast) { return defaultVisit(ast); }
  Object visit(FieldTypeListTail ast) { return defaultVisit(ast); }
  Object visit(FunType ast) { return defaultVisit(ast); }
  Object visit(ReturnType ast) { return defaultVisit(ast); }

  Object visit(SumOp ast) { return defaultVisit(ast); }
  Object visit(SubOp ast) { return defaultVisit(ast); }
  Object visit(ProductOp ast) { return defaultVisit(ast); }
  Object visit(DivOp ast) { return defaultVisit(ast); }
  Object visit(ModOp ast) { return defaultVisit(ast); }
  Object visit(EqualOp ast) { return defaultVisit(ast); }
  Object visit(NotEqualOp ast) { return defaultVisit(ast); }
  Object visit(LessEqualOp ast) { return defaultVisit(ast); }
  Object visit(LessOp ast) { return defaultVisit(ast); }
  Object visit(GreatEqualOp ast) { return defaultVisit(ast); }
  Object visit(GreatOp ast) { return defaultVisit(ast); }
  Object visit(NotOp ast) { return defaultVisit(ast); }
  Object visit(MinusOp ast) { return defaultVisit(ast); }
  Object visit(OrOp ast) { return defaultVisit(ast); }
  Object visit(AndOp ast) { return defaultVisit(ast); }
  Object visit(EqOp ast) { return defaultVisit(ast); }
  Object visit(RelOp ast) { return defaultVisit(ast); }
  Object visit(AddOp ast) { return defaultVisit(ast); }
  Object visit(MultOp ast) { return defaultVisit(ast); }
  Object visit(PrefixOp ast) { return defaultVisit(ast); }
  Object visit(InfixOp ast) { return defaultVisit(ast); }

  // Expr
  Object visit(Expr ast) { return defaultVisit(ast); }
  Object visit(LogicOrExpr ast) { return defaultVisit(ast); }
  Object visit(LogicOrExprTail ast) { return defaultVisit(ast); }
  Object visit(LogicAndExpr ast) { return defaultVisit(ast); }
  Object visit(LogicAndExprTail ast) { return defaultVisit(ast); }
  Object visit(EqExpr ast) { return defaultVisit(ast); }
  Object visit(EqExprTail ast) { return defaultVisit(ast); }
  Object visit(RelExpr ast) { return defaultVisit(ast); }
  Object visit(RelExprTail ast) { return defaultVisit(ast); }
  Object visit(AddExpr ast) { return defaultVisit(ast); }
  Object visit(AddExprTail ast) { return defaultVisit(ast); }
  Object visit(MultExpr ast) { return defaultVisit(ast); }
  Object visit(MultExprTail ast) { return defaultVisit(ast); }
  Object visit(CallActuals ast) { return defaultVisit(ast); }
  Object visit(CallExpr ast) { return defaultVisit(ast); }
  Object visit(PrefixExpr ast) { return defaultVisit(ast); }
  Object visit(PrimExpr ast) {return defaultVisit(ast); } 
  Object visit(PostfixExpr ast) {return defaultVisit(ast); } 
  Object visit(PostfixExprTail ast) {return defaultVisit(ast); } 
 
  Object visit(ExprList ast) { return defaultVisit(ast); }
  Object visit(ExprListTail ast) { return defaultVisit(ast); }
 
  // Stmt
  Object visit(VarDef ast) { return defaultVisit(ast); }
  Object visit(AssignStmt ast) { return defaultVisit(ast); }
  Object visit(CallStmt ast) { return defaultVisit(ast); }
  Object visit(StmtList ast) { return defaultVisit(ast); }
  Object visit(StmtListTail ast) { return defaultVisit(ast); }
  Object visit(BlockStmt ast) { return defaultVisit(ast); }
  Object visit(ForStmt ast) { return defaultVisit(ast); }
  Object visit(WhileStmt ast) { return defaultVisit(ast); }
  Object visit(IfStmt ast) { return defaultVisit(ast); }
  Object visit(ReturnStmt ast) { return defaultVisit(ast); }
  Object visit(Stmt ast) { return defaultVisit(ast); }
 
  Object visit(Tester ast) { return defaultVisit(ast); }
}
