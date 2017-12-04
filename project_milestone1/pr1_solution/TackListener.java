// Generated from Tack.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TackParser}.
 */
public interface TackListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TackParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(TackParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(TackParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#funDef}.
	 * @param ctx the parse tree
	 */
	void enterFunDef(TackParser.FunDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#funDef}.
	 * @param ctx the parse tree
	 */
	void exitFunDef(TackParser.FunDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#funDefList}.
	 * @param ctx the parse tree
	 */
	void enterFunDefList(TackParser.FunDefListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#funDefList}.
	 * @param ctx the parse tree
	 */
	void exitFunDefList(TackParser.FunDefListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#funDefListTail}.
	 * @param ctx the parse tree
	 */
	void enterFunDefListTail(TackParser.FunDefListTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#funDefListTail}.
	 * @param ctx the parse tree
	 */
	void exitFunDefListTail(TackParser.FunDefListTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(TackParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(TackParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(TackParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(TackParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#recordType}.
	 * @param ctx the parse tree
	 */
	void enterRecordType(TackParser.RecordTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#recordType}.
	 * @param ctx the parse tree
	 */
	void exitRecordType(TackParser.RecordTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#fieldTypeList}.
	 * @param ctx the parse tree
	 */
	void enterFieldTypeList(TackParser.FieldTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#fieldTypeList}.
	 * @param ctx the parse tree
	 */
	void exitFieldTypeList(TackParser.FieldTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#fieldTypeListTail}.
	 * @param ctx the parse tree
	 */
	void enterFieldTypeListTail(TackParser.FieldTypeListTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#fieldTypeListTail}.
	 * @param ctx the parse tree
	 */
	void exitFieldTypeListTail(TackParser.FieldTypeListTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void enterFieldType(TackParser.FieldTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#fieldType}.
	 * @param ctx the parse tree
	 */
	void exitFieldType(TackParser.FieldTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#boolType}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(TackParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#boolType}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(TackParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#intType}.
	 * @param ctx the parse tree
	 */
	void enterIntType(TackParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#intType}.
	 * @param ctx the parse tree
	 */
	void exitIntType(TackParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#stringType}.
	 * @param ctx the parse tree
	 */
	void enterStringType(TackParser.StringTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#stringType}.
	 * @param ctx the parse tree
	 */
	void exitStringType(TackParser.StringTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#funType}.
	 * @param ctx the parse tree
	 */
	void enterFunType(TackParser.FunTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#funType}.
	 * @param ctx the parse tree
	 */
	void exitFunType(TackParser.FunTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(TackParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(TackParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#voidType}.
	 * @param ctx the parse tree
	 */
	void enterVoidType(TackParser.VoidTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#voidType}.
	 * @param ctx the parse tree
	 */
	void exitVoidType(TackParser.VoidTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(TackParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(TackParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(TackParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(TackParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(TackParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(TackParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#blockStmt}.
	 * @param ctx the parse tree
	 */
	void enterBlockStmt(TackParser.BlockStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#blockStmt}.
	 * @param ctx the parse tree
	 */
	void exitBlockStmt(TackParser.BlockStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#callStmt}.
	 * @param ctx the parse tree
	 */
	void enterCallStmt(TackParser.CallStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#callStmt}.
	 * @param ctx the parse tree
	 */
	void exitCallStmt(TackParser.CallStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(TackParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(TackParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(TackParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(TackParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(TackParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(TackParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(TackParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(TackParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void enterStmtList(TackParser.StmtListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#stmtList}.
	 * @param ctx the parse tree
	 */
	void exitStmtList(TackParser.StmtListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#stmtListTail}.
	 * @param ctx the parse tree
	 */
	void enterStmtListTail(TackParser.StmtListTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#stmtListTail}.
	 * @param ctx the parse tree
	 */
	void exitStmtListTail(TackParser.StmtListTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(TackParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(TackParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#logicOrExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicOrExpr(TackParser.LogicOrExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#logicOrExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicOrExpr(TackParser.LogicOrExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#logicOrExprTail}.
	 * @param ctx the parse tree
	 */
	void enterLogicOrExprTail(TackParser.LogicOrExprTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#logicOrExprTail}.
	 * @param ctx the parse tree
	 */
	void exitLogicOrExprTail(TackParser.LogicOrExprTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#logicAndExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicAndExpr(TackParser.LogicAndExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#logicAndExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicAndExpr(TackParser.LogicAndExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#logicAndExprTail}.
	 * @param ctx the parse tree
	 */
	void enterLogicAndExprTail(TackParser.LogicAndExprTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#logicAndExprTail}.
	 * @param ctx the parse tree
	 */
	void exitLogicAndExprTail(TackParser.LogicAndExprTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#eqExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqExpr(TackParser.EqExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#eqExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqExpr(TackParser.EqExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#eqExprTail}.
	 * @param ctx the parse tree
	 */
	void enterEqExprTail(TackParser.EqExprTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#eqExprTail}.
	 * @param ctx the parse tree
	 */
	void exitEqExprTail(TackParser.EqExprTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#relExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelExpr(TackParser.RelExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#relExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelExpr(TackParser.RelExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#relExprTail}.
	 * @param ctx the parse tree
	 */
	void enterRelExprTail(TackParser.RelExprTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#relExprTail}.
	 * @param ctx the parse tree
	 */
	void exitRelExprTail(TackParser.RelExprTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddExpr(TackParser.AddExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#addExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddExpr(TackParser.AddExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#addExprTail}.
	 * @param ctx the parse tree
	 */
	void enterAddExprTail(TackParser.AddExprTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#addExprTail}.
	 * @param ctx the parse tree
	 */
	void exitAddExprTail(TackParser.AddExprTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#multExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultExpr(TackParser.MultExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#multExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultExpr(TackParser.MultExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#multExprTail}.
	 * @param ctx the parse tree
	 */
	void enterMultExprTail(TackParser.MultExprTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#multExprTail}.
	 * @param ctx the parse tree
	 */
	void exitMultExprTail(TackParser.MultExprTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#prefixExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpr(TackParser.PrefixExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#prefixExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpr(TackParser.PrefixExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#postfixExpr}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpr(TackParser.PostfixExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#postfixExpr}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpr(TackParser.PostfixExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#postfixExprTail}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExprTail(TackParser.PostfixExprTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#postfixExprTail}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExprTail(TackParser.PostfixExprTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#emptyPostfixTail}.
	 * @param ctx the parse tree
	 */
	void enterEmptyPostfixTail(TackParser.EmptyPostfixTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#emptyPostfixTail}.
	 * @param ctx the parse tree
	 */
	void exitEmptyPostfixTail(TackParser.EmptyPostfixTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#callExpr}.
	 * @param ctx the parse tree
	 */
	void enterCallExpr(TackParser.CallExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#callExpr}.
	 * @param ctx the parse tree
	 */
	void exitCallExpr(TackParser.CallExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#callActuals}.
	 * @param ctx the parse tree
	 */
	void enterCallActuals(TackParser.CallActualsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#callActuals}.
	 * @param ctx the parse tree
	 */
	void exitCallActuals(TackParser.CallActualsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#callExprTail}.
	 * @param ctx the parse tree
	 */
	void enterCallExprTail(TackParser.CallExprTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#callExprTail}.
	 * @param ctx the parse tree
	 */
	void exitCallExprTail(TackParser.CallExprTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#castExprTail}.
	 * @param ctx the parse tree
	 */
	void enterCastExprTail(TackParser.CastExprTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#castExprTail}.
	 * @param ctx the parse tree
	 */
	void exitCastExprTail(TackParser.CastExprTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#fieldExprTail}.
	 * @param ctx the parse tree
	 */
	void enterFieldExprTail(TackParser.FieldExprTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#fieldExprTail}.
	 * @param ctx the parse tree
	 */
	void exitFieldExprTail(TackParser.FieldExprTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#subscriptExprTail}.
	 * @param ctx the parse tree
	 */
	void enterSubscriptExprTail(TackParser.SubscriptExprTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#subscriptExprTail}.
	 * @param ctx the parse tree
	 */
	void exitSubscriptExprTail(TackParser.SubscriptExprTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(TackParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(TackParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#exprListTail}.
	 * @param ctx the parse tree
	 */
	void enterExprListTail(TackParser.ExprListTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#exprListTail}.
	 * @param ctx the parse tree
	 */
	void exitExprListTail(TackParser.ExprListTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#primExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrimExpr(TackParser.PrimExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#primExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrimExpr(TackParser.PrimExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#parenExpr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(TackParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#parenExpr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(TackParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#arrayLit}.
	 * @param ctx the parse tree
	 */
	void enterArrayLit(TackParser.ArrayLitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#arrayLit}.
	 * @param ctx the parse tree
	 */
	void exitArrayLit(TackParser.ArrayLitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#recordLit}.
	 * @param ctx the parse tree
	 */
	void enterRecordLit(TackParser.RecordLitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#recordLit}.
	 * @param ctx the parse tree
	 */
	void exitRecordLit(TackParser.RecordLitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#fieldLitList}.
	 * @param ctx the parse tree
	 */
	void enterFieldLitList(TackParser.FieldLitListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#fieldLitList}.
	 * @param ctx the parse tree
	 */
	void exitFieldLitList(TackParser.FieldLitListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#fieldLitListTail}.
	 * @param ctx the parse tree
	 */
	void enterFieldLitListTail(TackParser.FieldLitListTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#fieldLitListTail}.
	 * @param ctx the parse tree
	 */
	void exitFieldLitListTail(TackParser.FieldLitListTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#fieldLit}.
	 * @param ctx the parse tree
	 */
	void enterFieldLit(TackParser.FieldLitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#fieldLit}.
	 * @param ctx the parse tree
	 */
	void exitFieldLit(TackParser.FieldLitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#boolLit}.
	 * @param ctx the parse tree
	 */
	void enterBoolLit(TackParser.BoolLitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#boolLit}.
	 * @param ctx the parse tree
	 */
	void exitBoolLit(TackParser.BoolLitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#intLit}.
	 * @param ctx the parse tree
	 */
	void enterIntLit(TackParser.IntLitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#intLit}.
	 * @param ctx the parse tree
	 */
	void exitIntLit(TackParser.IntLitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#nullLit}.
	 * @param ctx the parse tree
	 */
	void enterNullLit(TackParser.NullLitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#nullLit}.
	 * @param ctx the parse tree
	 */
	void exitNullLit(TackParser.NullLitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#stringLit}.
	 * @param ctx the parse tree
	 */
	void enterStringLit(TackParser.StringLitContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#stringLit}.
	 * @param ctx the parse tree
	 */
	void exitStringLit(TackParser.StringLitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#fieldId}.
	 * @param ctx the parse tree
	 */
	void enterFieldId(TackParser.FieldIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#fieldId}.
	 * @param ctx the parse tree
	 */
	void exitFieldId(TackParser.FieldIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#funId}.
	 * @param ctx the parse tree
	 */
	void enterFunId(TackParser.FunIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#funId}.
	 * @param ctx the parse tree
	 */
	void exitFunId(TackParser.FunIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#varId}.
	 * @param ctx the parse tree
	 */
	void enterVarId(TackParser.VarIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#varId}.
	 * @param ctx the parse tree
	 */
	void exitVarId(TackParser.VarIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#eqOp}.
	 * @param ctx the parse tree
	 */
	void enterEqOp(TackParser.EqOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#eqOp}.
	 * @param ctx the parse tree
	 */
	void exitEqOp(TackParser.EqOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#relOp}.
	 * @param ctx the parse tree
	 */
	void enterRelOp(TackParser.RelOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#relOp}.
	 * @param ctx the parse tree
	 */
	void exitRelOp(TackParser.RelOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#addOp}.
	 * @param ctx the parse tree
	 */
	void enterAddOp(TackParser.AddOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#addOp}.
	 * @param ctx the parse tree
	 */
	void exitAddOp(TackParser.AddOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#multOp}.
	 * @param ctx the parse tree
	 */
	void enterMultOp(TackParser.MultOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#multOp}.
	 * @param ctx the parse tree
	 */
	void exitMultOp(TackParser.MultOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TackParser#prefixOp}.
	 * @param ctx the parse tree
	 */
	void enterPrefixOp(TackParser.PrefixOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TackParser#prefixOp}.
	 * @param ctx the parse tree
	 */
	void exitPrefixOp(TackParser.PrefixOpContext ctx);
}