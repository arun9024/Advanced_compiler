grammar Tack;

// ---------------- top-level ----------------

program : funDefList EOF ;

funDef : funId EQ FUN funType blockStmt ;

funDefList : funDef funDefListTail ;

funDefListTail
 : funDef funDefListTail
 |
 ;

// ---------------- types ----------------
type : arrayType | recordType | boolType | intType | stringType;

arrayType : LBRACKET type RBRACKET;

recordType : LPAREN fieldTypeList RPAREN;

fieldTypeList :
    fieldType fieldTypeListTail
  | /*empty*/;
fieldTypeListTail :
    COMMA fieldType fieldTypeListTail
  | /*empty*/;

fieldType : fieldId COLON type;

boolType : BOOL;
intType : INT;
stringType : STRING;

funType : recordType ARROW returnType;

returnType : type | voidType;

voidType : VOID;

// ---------------- statements ----------------
stmt :
    varDef | assignStmt | blockStmt | callStmt | forStmt
  | ifStmt | returnStmt | whileStmt;

varDef : varId EQ expr SEMI;
assignStmt : expr COLONEQ expr SEMI;
blockStmt : LCURLY stmtList RCURLY;
callStmt : callExpr SEMI;
forStmt : FOR varId IN expr blockStmt;

ifStmt :
    IF expr blockStmt ELSE blockStmt
  | IF expr blockStmt;

returnStmt :
    ARROW expr SEMI
  | ARROW SEMI;

whileStmt : WHILE expr blockStmt;

stmtList :
    stmt stmtListTail
  | /*empty*/;
stmtListTail :
    stmt stmtListTail
  | /*empty*/;

// ---------------- expressions ----------------
expr : logicOrExpr;

logicOrExpr : logicAndExpr logicOrExprTail;
logicOrExprTail :
    LOGIC_OR_OP logicAndExpr logicOrExprTail
  | /*empty*/;

logicAndExpr : eqExpr logicAndExprTail;
logicAndExprTail :
    LOGIC_AND_OP eqExpr logicAndExprTail
  | /*empty*/;

eqExpr : relExpr eqExprTail;
eqExprTail :
    eqOp relExpr eqExprTail
  | /*empty*/;

relExpr : addExpr relExprTail;
relExprTail :
    relOp addExpr relExprTail
  | /*empty*/;

addExpr :
    multExpr addExprTail ;
addExprTail :
    addOp multExpr addExprTail
  | /*empty*/;

multExpr :
    prefixExpr multExprTail ;
multExprTail :
    multOp prefixExpr multExprTail    
  | /*empty*/;

prefixExpr :
    prefixOp prefixExpr
  | postfixExpr;

postfixExpr : primExpr postfixExprTail;

postfixExprTail :
    callExprTail
  | castExprTail
  | fieldExprTail
  | subscriptExprTail
  | emptyPostfixTail;

emptyPostfixTail : /*empty*/;

callExpr : funId callActuals;
callActuals : LPAREN exprList RPAREN emptyPostfixTail;

callExprTail : LPAREN exprList RPAREN postfixExprTail;
castExprTail : COLON type postfixExprTail;
fieldExprTail : DOT fieldId postfixExprTail;
subscriptExprTail : LBRACKET expr RBRACKET postfixExprTail;

exprList :
    expr exprListTail 
  | /*empty*/;
exprListTail :
    COMMA expr exprListTail 
  | /*empty*/;

primExpr :
    varId | arrayLit | recordLit | parenExpr
  | boolLit | intLit | nullLit | stringLit;

parenExpr : LPAREN expr RPAREN;

// ---------------- literals ----------------
arrayLit : LBRACKET exprList RBRACKET;

recordLit : LPAREN fieldLitList RPAREN;

fieldLitList :
    fieldLit fieldLitListTail
  | /*empty*/;
fieldLitListTail :
    COMMA fieldLit fieldLitListTail
  | /*empty*/;

fieldLit : fieldId EQ expr;

boolLit : BOOL_LIT ;
intLit : INT_LIT ;
nullLit : NULL_LIT ;
stringLit : STRING_LIT ;

// ---------------- identifiers ----------------

fieldId : ID;
funId : ID;
varId : ID;

eqOp : '=='  | '!=' ;
relOp : '<='  | '<'  | '>='  | '>' ;
addOp : '+'  | '-' ;
multOp : '*'  | '/'  | '%' ;
prefixOp : '!' | '-' ;

// ---------------- lexical ----------------

BOOL : 'bool' ;
ELSE : 'else' ;
FOR : 'for' ;
FUN : 'fun' ;
IF : 'if' ;
IN : 'in' ;
INT : 'int' ;
STRING : 'string' ;
VOID : 'void' ;
WHILE : 'while' ;

ARROW : '->' ;
DOT : '.' ;
COLON : ':' ;
COLONEQ : ':=' ;
COMMA : ',' ;
EQ : '=' ;
SEMI : ';' ;
LBRACKET : '[' ;
RBRACKET : ']' ;
LCURLY : '{' ;
RCURLY : '}' ;
LPAREN : '(' ;
RPAREN : ')' ;


LOGIC_OR_OP : '||' ;
LOGIC_AND_OP : '&&' ;

BOOL_LIT : 'true' | 'false';
NULL_LIT : 'null';
ID : [a-zA-Z] [a-zA-Z0-9]* ;
INT_LIT : '0' | [1-9] [0-9]*;
fragment ESCAPED_QUOTE : '\\"';
STRING_LIT :   '"' ( ESCAPED_QUOTE | ~('\n'|'\r') )*? '"';

WS : ( [ \r\t\n] | NEWLINE | COMMENT )+ -> skip ;

NEWLINE : '\r' '\n' | '\r' | '\n';
COMMENT : '#' ~[\r\n]* '\r'?  (NEWLINE | EOF) -> skip ;



