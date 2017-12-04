grammar Tack;

// ---------------- top-level ----------------

program returns [Program v] : fs=funDefList EOF {$v = new Program(new Location($ctx), $fs.v);} ;

funDef returns [FunDef v] : i=funId EQ FUN t=funType b=blockStmt
                            {$v = new FunDef(new Location($ctx), $i.v, $t.v, $b.v);} ;

funDefList returns [FunDefListHead v] : h=funDef t=funDefListTail
  {$v = new FunDefListHead(new Location($ctx), $h.v, $t.v);} ;

funDefListTail returns [FunDefListTail v]
 : h=funDef t=funDefListTail {$v = new FunDefListTail(new Location($ctx), $h.v, $t.v);}
 | {$v = new FunDefListTail(new Location($ctx));}
 ;

// ---------------- types ----------------
type returns [Type v] :
    at=arrayType {$v = $at.v;}
  | rt=recordType {$v = $rt.v;}
  | bt=boolType {$v = $bt.v;}
  | it=intType {$v = $it.v;}
  | st=stringType {$v = $st.v;}
  ;

arrayType returns [ArrayType v] : LBRACKET typ=type RBRACKET {$v = new ArrayType(new Location($ctx), $typ.v);} ;

recordType returns [RecordType v] : LPAREN fs=fieldTypeList RPAREN {$v = new RecordType(new Location($ctx), $fs.v);} ;

fieldTypeList returns [List<FieldType> v] :
    h=fieldType t=fieldTypeListTail {$v = $t.v; $v.add(0, $h.v);}
  | /*empty*/ {$v = new ArrayList<FieldType>();} ;
fieldTypeListTail returns [List<FieldType> v] :
    COMMA h=fieldType t=fieldTypeListTail {$v = $t.v; $v.add(0, $h.v);} 
  | /*empty*/ {$v = new ArrayList<FieldType>();} ;

fieldType returns [FieldType v] : name=fieldId COLON typ=type {$v = new FieldType(new Location($ctx), $name.v, $typ.v);} ;

boolType returns [PrimitiveType v] : BOOL {$v = new PrimitiveType(new Location($ctx), PrimitiveType.BOOL);} ;
intType returns [PrimitiveType v] : INT {$v = new PrimitiveType(new Location($ctx), PrimitiveType.INT);} ;
stringType returns [PrimitiveType v]: STRING {$v = new PrimitiveType(new Location($ctx), PrimitiveType.STRING);} ;

funType returns [FunType v] : a=recordType ARROW r=returnType {$v = new FunType(new Location($ctx), $a.v, $r.v);} ;

returnType returns [Type v] : typ=type {$v = $typ.v;} | vt=voidType {$v = $vt.v;} ;

voidType returns [PrimitiveType v] : VOID {$v = new PrimitiveType(new Location($ctx), PrimitiveType.VOID);} ;

// ---------------- statements ----------------
stmt returns [Stmt v] :
    vd=varDef {$v = $vd.v;}
  | as=assignStmt {$v = $as.v;}
  | bs=blockStmt {$v = $bs.v;}
  | cs=callStmt {$v = $cs.v;}
  | fs=forStmt {$v = $fs.v;}
  | is=ifStmt {$v = $is.v;}
  | rs=returnStmt {$v = $rs.v;}
  | ws=whileStmt {$v = $ws.v;} ;

varDef returns [VarDef v] : i=varId EQ e=expr SEMI {$v = new VarDef(new Location($ctx), $i.v, $e.v);} ;
assignStmt returns [AssignStmt v] : l=expr COLONEQ r=expr SEMI {$v = new AssignStmt(new Location($ctx), $l.v, $r.v);} ;
blockStmt returns [BlockStmt v] : LCURLY ss=stmtList RCURLY {$v = new BlockStmt(new Location($ctx), $ss.v);} ;
callStmt returns [CallStmt v] : e=callExpr SEMI {$v = new CallStmt(new Location($ctx), $e.v);} ;
forStmt returns [ForStmt v] : FOR i=varId IN e=expr b=blockStmt {$v = new ForStmt(new Location($ctx), $i.v, $e.v, $b.v);} ;

ifStmt returns [IfStmt v] :
    IF c=expr t=blockStmt ELSE e=blockStmt {$v = new IfStmt(new Location($ctx), $c.v, $t.v, $e.v);}
  | IF c=expr t=blockStmt {$v = new IfStmt(new Location($ctx), $c.v, $t.v, null);} ;

returnStmt returns [ReturnStmt v] :
    ARROW e=expr SEMI {$v = new ReturnStmt(new Location($ctx), $e.v);}
  | ARROW SEMI {$v = new ReturnStmt(new Location($ctx), null);} ;

whileStmt returns [WhileStmt v] : WHILE c=expr b=blockStmt {$v = new WhileStmt(new Location($ctx), $c.v, $b.v);} ;

stmtList returns [StmtListHead v] :
    h=stmt t=stmtListTail {$v = new StmtListHead(new Location($ctx), $h.v, $t.v);}
  | /*empty*/ {$v = new StmtListHead(new Location($ctx));} ;

stmtListTail returns [StmtListTail v] :
    h=stmt t=stmtListTail {$v = new StmtListTail(new Location($ctx), $h.v, $t.v);}
  | /*empty*/ {$v = new StmtListTail(new Location($ctx));} ;

// ---------------- expressions ----------------
expr returns [Expr v] : e=logicOrExpr {$v = $e.v;} ;

logicOrExpr returns [Expr v] : x=logicAndExpr y=logicOrExprTail
  {$v = new InfixExprHead(new Location($ctx), $x.v, $y.v);} ;
logicOrExprTail returns [InfixExprTail v] :
    o=LOGIC_OR_OP x=logicAndExpr y=logicOrExprTail
    {$v = new InfixExprTail(new Location($ctx), $o.text, $x.v, $y.v);}
  | /*empty*/ {$v = new InfixExprTail(new Location($ctx));} ;

logicAndExpr returns [Expr v] : x=eqExpr y=logicAndExprTail
  {$v = new InfixExprHead(new Location($ctx), $x.v, $y.v);} ;
logicAndExprTail returns [InfixExprTail v] :
    o=LOGIC_AND_OP x=eqExpr y=logicAndExprTail
    {$v = new InfixExprTail(new Location($ctx), $o.text, $x.v, $y.v);}
  | /*empty*/ {$v = new InfixExprTail(new Location($ctx));} ;

eqExpr returns [Expr v] : x=relExpr y=eqExprTail
  {$v = new InfixExprHead(new Location($ctx), $x.v, $y.v);} ;
eqExprTail returns [InfixExprTail v] :
    o=eqOp x=relExpr y=eqExprTail
    {$v = new InfixExprTail(new Location($ctx), $o.text, $x.v, $y.v);}
  | /*empty*/ {$v = new InfixExprTail(new Location($ctx));} ;

relExpr returns [Expr v] : x=addExpr y=relExprTail
  {$v = new InfixExprHead(new Location($ctx), $x.v, $y.v);} ;
relExprTail returns [InfixExprTail v] :
    o=relOp x=addExpr y=relExprTail
    {$v = new InfixExprTail(new Location($ctx), $o.text, $x.v, $y.v);}
  | /*empty*/ {$v = new InfixExprTail(new Location($ctx));} ;

addExpr returns [Expr v] :
    x=multExpr y=addExprTail
    {$v = new InfixExprHead(new Location($ctx), $x.v, $y.v);} ;
addExprTail returns [InfixExprTail v] :
    o=addOp x=multExpr y=addExprTail
    {$v = new InfixExprTail(new Location($ctx), $o.text, $x.v, $y.v);}
  | /*empty*/ {$v = new InfixExprTail(new Location($ctx));} ;

multExpr returns [Expr v] :
    x=prefixExpr y=multExprTail
    {$v = new InfixExprHead(new Location($ctx), $x.v, $y.v);} ;
multExprTail returns [InfixExprTail v] :
    o=multOp x=prefixExpr y=multExprTail    
    {$v = new InfixExprTail(new Location($ctx), $o.text, $x.v, $y.v);}
  | /*empty*/ {$v = new InfixExprTail(new Location($ctx));} ;

prefixExpr returns [Expr v] :
    o=prefixOp x=prefixExpr {$v = new PrefixExpr(new Location($ctx), $o.text, $x.v);}
  | t=postfixExpr {$v = $t.v;} ;

postfixExpr returns [Expr v] : x=primExpr y=postfixExprTail
  {$v = new PostfixExprHead(new Location($ctx), $x.v, $y.v);} ;

postfixExprTail returns [PostfixExprTail v] :
    callet=callExprTail {$v = $callet.v;}
  | castet=castExprTail {$v = $castet.v;}
  | fet=fieldExprTail {$v = $fet.v;}
  | set=subscriptExprTail {$v = $set.v;}
  | et=emptyPostfixTail {$v = $et.v;} ;

emptyPostfixTail returns [PostfixExprTail v] : /*empty*/ {$v = new PostfixExprTail(new Location($ctx));} ;

callExpr returns [Expr v] : f=funId t=callActuals
  {$v = new PostfixExprHead(new Location($ctx), $f.v, $t.v);} ;
callActuals returns [PostfixExprTail v] : LPAREN a=exprList RPAREN t=emptyPostfixTail
  {$v = new CallExprTail(new Location($ctx), $a.v, $t.v);} ;

callExprTail returns [PostfixExprTail v] : LPAREN a=exprList RPAREN t=postfixExprTail
  {$v = new CallExprTail(new Location($ctx), $a.v, $t.v);} ;
castExprTail returns [PostfixExprTail v] : COLON t=type tl=postfixExprTail
  {$v = new CastExprTail(new Location($ctx), $t.v, $tl.v);} ;
fieldExprTail returns [PostfixExprTail v] : DOT f=fieldId t=postfixExprTail
  {$v = new FieldExprTail(new Location($ctx), $f.v, $t.v);} ;
subscriptExprTail returns [PostfixExprTail v] : LBRACKET s=expr RBRACKET t=postfixExprTail
  {$v = new SubscriptExprTail(new Location($ctx), $s.v, $t.v);} ;

exprList returns [ExprListHead v] :
    h=expr t=exprListTail {$v = new ExprListHead(new Location($ctx), $h.v, $t.v);}
  | /*empty*/ {$v = new ExprListHead(new Location($ctx));} ;
exprListTail returns [ExprListTail v] :
    COMMA h=expr t=exprListTail {$v = new ExprListTail(new Location($ctx), $h.v, $t.v);}
  | /*empty*/ {$v = new ExprListTail(new Location($ctx));} ;

primExpr returns [Expr v] :
    vi=varId {$v = $vi.v;}
  | al=arrayLit {$v = $al.v;}
  | rl=recordLit {$v = $rl.v;}
  | pe=parenExpr {$v = $pe.v;}
  | bl=boolLit {$v = $bl.v;}
  | il=intLit {$v = $il.v;}
  | nl=nullLit {$v = $nl.v;}
  | sl=stringLit {$v = $sl.v;} ;

parenExpr returns [Expr v] : LPAREN e=expr RPAREN {$v = new ParenExpr(new Location($ctx), $e.v);} ;

// ---------------- literals ----------------
arrayLit returns [Expr v] : LBRACKET e=exprList RBRACKET
  {$v = new ArrayLit(new Location($ctx), $e.v);} ;

recordLit returns [Expr v] : LPAREN f=fieldLitList RPAREN
  {$v = new RecordLit(new Location($ctx), $f.v);} ;

fieldLitList returns [FieldLitListHead v] :
    h=fieldLit t=fieldLitListTail {$v = new FieldLitListHead(new Location($ctx), $h.v, $t.v);}
  | /*empty*/ {$v = new FieldLitListHead(new Location($ctx));} ;
fieldLitListTail returns [FieldLitListTail v] :
    COMMA h=fieldLit t=fieldLitListTail {$v = new FieldLitListTail(new Location($ctx), $h.v, $t.v);}
  | /*empty*/ {$v = new FieldLitListTail(new Location($ctx));} ;

fieldLit returns [FieldLit v] : f=fieldId EQ e=expr
  {$v = new FieldLit(new Location($ctx), $f.v, $e.v);} ;

boolLit returns [BoolLit v] : BOOL_LIT {$v = new BoolLit(new Location($ctx), $BOOL_LIT.text);} ;
intLit returns [IntLit v] : INT_LIT {$v = new IntLit(new Location($ctx), $INT_LIT.text);} ;
nullLit returns [NullLit v] : NULL_LIT {$v = new NullLit(new Location($ctx));} ;
stringLit returns [StringLit v] : STRING_LIT {$v = new StringLit(new Location($ctx), $STRING_LIT.text);} ;

// ---------------- identifiers ----------------

fieldId returns [FieldId v] : ID {$v = new FieldId(new Location($ctx), $ID.text);} ;
funId returns [FunId v] : ID {$v = new FunId(new Location($ctx), $ID.text);};
varId returns [VarId v] : ID {$v = new VarId(new Location($ctx), $ID.text);} ;

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



