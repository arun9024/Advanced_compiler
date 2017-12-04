grammar Tack;

// ---------------- syntactic --------------------------------------
program returns [AstNode v] :
        f=funDefList EOF
                {$v = new Program(new Location($ctx), $f.v);};

funDef returns [FunDef v] :
	f=funId EQ FUN g=funType h=blockStmt
		{$v=new FunDef(new Location($ctx), $f.v, $g.v, $h.v);};

funDefList returns [FunDefListHead v] :
        f=funDef t=funDefListTail
                {$v=new FunDefListHead(new Location($ctx), $f.v, $t.v);};

funDefListTail returns [FunDefListTail v] :
    f=funDef t=funDefListTail {$v=new FunDefListTail(
             new Location($ctx), $f.v, $t.v);}
  | /*empty*/ {$v=new FunDefListTail(new Location($ctx));};

funId returns [FunId v] :
    ID {$v=new FunId(new Location($ctx), $ID.text);};

fieldId returns [FieldId v] :
    ID {$v=new FieldId(new Location($ctx), $ID.text);};

varId returns [VarId v] :
    ID {$v=new VarId(new Location($ctx), $ID.text);};



// Type ------------------------------------------------------------
type returns [Type v] :
        ab=arrayType
                {$v=new Type(new Location($ctx), $ab.v);} |
        bc=recordType
                {$v=new Type(new Location($ctx), $bc.v);} |
        ef=primitiveType
                {$v=new Type(new Location($ctx), $ef.v);};

arrayType returns [ArrayType v] :
        LBRACKET fg=type RBRACKET
                {$v=new ArrayType(new Location($ctx), $fg.v);};

recordType returns [RecordType v] :
        LPAREN gh=fieldTypeList RPAREN
                {$v=new RecordType(new Location($ctx), $gh.v);};

fieldTypeList returns [FieldTypeList v] :
        hi=fieldType ij=fieldTypeListTail
                {$v=new FieldTypeList(new Location($ctx), $hi.v, $ij.v);} |
                /*empty*/ {$v=new FieldTypeList(new Location($ctx));};

fieldTypeListTail returns [FieldTypeListTail v] :
        COMMA ij=fieldType jk=fieldTypeListTail
                {$v=new FieldTypeListTail(new Location ($ctx), $ij.v, $jk.v);} |
                /*empty*/ {$v=new FieldTypeListTail(new Location($ctx));};

fieldType returns [FieldType v] :
        kl=fieldId COLON lm=type
                {$v=new FieldType(new Location($ctx), $kl.v, $lm.v);};

funType returns [FunType v] :
        mn=recordType ARROW no=returnType
                {$v=new FunType(new Location($ctx), $mn.v, $no.v);};

returnType returns [ReturnType v] :
        op=type
                {$v=new ReturnType(new Location($ctx), $op.v);} |
        pq=voidType
                {$v=new ReturnType(new Location($ctx), $pq.v);};




// Literals -------------------------------------------------------
intLit returns [IntLit v] :
        INT_LIT
                {$v=new IntLit(new Location($ctx), $INT_LIT.text);};

stringLit returns [StringLit v] :
        STRING_LIT
                {$v=new StringLit(new Location($ctx), $STRING_LIT.text);};

boolLit returns [BoolLit v] :
        BOOL_LIT
                {$v=new BoolLit(new Location($ctx), $BOOL_LIT.text);};

nullLit returns [NullLit v] :
        NULL_LIT
                {$v=new NullLit(new Location($ctx));};

arrayLit returns [ArrayLit v] :
        LBRACKET f=exprList RBRACKET
                {$v=new ArrayLit(new Location($ctx), $f.v);};

recordLit returns [RecordLit v] :
        LPAREN f=fieldLitList RPAREN
                {$v=new RecordLit(new Location($ctx), $f.v);};

parenExpr returns [ParenExpr v] :
        LPAREN f=expr RPAREN
                {$v=new ParenExpr(new Location($ctx), $f.v);};

fieldLit returns [FieldLit v] :
	f=fieldId EQ g=expr
		{$v=new FieldLit(new Location($ctx), $f.v, $g.v);};

fieldLitList returns [FieldLitList v] :
	f=fieldLit g= fieldLitListTail
		{$v=new FieldLitList(new Location($ctx), $f.v, $g.v);}
	| /*empty*/ {$v=new FieldLitList(new Location($ctx));};

fieldLitListTail returns [FieldLitListTail v] :
	COMMA f=fieldLit g=fieldLitListTail
		{$v=new FieldLitListTail(new Location($ctx), $f.v, $g.v);}
	| /*empty*/ {$v=new FieldLitListTail(new Location($ctx));};

// primitive types -----------------------------------------------
primitiveType returns [PrimitiveType v] :
        i=intType
                {$v=new PrimitiveType(new Location($ctx), $i.v);}
        | b=boolType
                {$v=new PrimitiveType(new Location($ctx), $b.v);}
        | s=stringType
                {$v=new PrimitiveType(new Location($ctx), $s.v);};

intType returns [IntType v] :
        INT_TYPE
                {$v=new IntType(new Location($ctx));};

boolType returns [BoolType v] :
        BOOL_TYPE
                {$v=new BoolType(new Location($ctx));};

stringType returns [StringType v] :
        STRING_TYPE
                {$v=new StringType(new Location($ctx));};

voidType returns [VoidType v] :
        VOID_TYPE
                {$v=new VoidType(new Location($ctx));};

// Infix type
eqOp returns [EqOp v] :
        a=equalOp
                {$v=new EqOp(new Location($ctx), $a.v);}
        | s=notEqualOp
                {$v=new EqOp(new Location($ctx), $s.v);};

relOp returns [RelOp v] :
        a=lessEqualOp
                {$v=new RelOp(new Location($ctx), $a.v);}
        | s=lessOp
                {$v=new RelOp(new Location($ctx), $s.v);}
        | mu=greatEqualOp
                {$v=new RelOp(new Location($ctx), $mu.v);}
        | d=greatOp
                {$v=new RelOp(new Location($ctx), $d.v);};

addOp returns [AddOp v] :
        a=sumOp
                {$v=new AddOp(new Location($ctx), $a.v);}
        | s=subOp
                {$v=new AddOp(new Location($ctx), $s.v);};

multOp returns [MultOp v] :
        a=productOp
                {$v=new MultOp(new Location($ctx), $a.v);}
        | s=divOp
                {$v=new MultOp(new Location($ctx), $s.v);}
        | mu=modOp
                {$v=new MultOp(new Location($ctx), $mu.v);};

prefixOp returns [PrefixOp v] :
        a=notOp
                {$v=new PrefixOp(new Location($ctx), $a.v);}
        | s=minusOp
                {$v=new PrefixOp(new Location($ctx), $s.v);};

sumOp returns [SumOp v] :
        ADD_OP
                {$v=new SumOp(new Location($ctx));};

subOp returns [SubOp v] :
        SUB_OP
                {$v=new SubOp(new Location($ctx));};

productOp returns [ProductOp v] :
        MULT_OP
                {$v=new ProductOp(new Location($ctx));};

divOp returns [DivOp v] :
        DIV_OP
                {$v=new DivOp(new Location($ctx));};

modOp returns [ModOp v] :
        MOD_OP
                {$v=new ModOp(new Location($ctx));};

equalOp returns [EqualOp v] :
        EQUAL_OP
                {$v=new EqualOp(new Location($ctx));};

notEqualOp returns [NotEqualOp v] :
        NOTEQUAL_OP
                {$v=new NotEqualOp(new Location($ctx));};

lessEqualOp returns [LessEqualOp v] :
        LESSEQUAL_OP
                {$v=new LessEqualOp(new Location($ctx));};

lessOp returns [LessOp v] :
        LESS_OP
                {$v=new LessOp(new Location($ctx));};

greatEqualOp returns [GreatEqualOp v] :
        GREATEQUAL_OP
                {$v=new GreatEqualOp(new Location($ctx));};

greatOp returns [GreatOp v] :
        GREAT_OP
                {$v=new GreatOp(new Location($ctx));};

notOp returns [NotOp v] :
        NOT_OP
                {$v=new NotOp(new Location($ctx));};

minusOp returns [MinusOp v] :
        SUB_OP
                {$v=new MinusOp(new Location($ctx));};

orOp returns [OrOp v] :
        LOGIC_OR_OP
                        {$v=new OrOp(new Location($ctx));};

andOp returns [AndOp v] :
        LOGIC_AND_OP
                        {$v=new AndOp(new Location($ctx));};

// Expr -------------------------------------------------------------------

expr returns [Expr v] :
 	f=logicOrExpr
			{$v=new Expr(new Location($ctx), $f.v);};

logicOrExpr returns [LogicOrExpr v] :
	f=logicAndExpr g=logicOrExprTail
			{$v=new LogicOrExpr(new Location($ctx), $f.v, $g.v);};

logicOrExprTail returns [LogicOrExprTail v] :
	f=orOp g=logicAndExpr h=logicOrExprTail
			{$v=new LogicOrExprTail(new Location($ctx), $f.v, $g.v, $h.v);}
  	                | /*empty*/ {$v=new LogicOrExprTail(new Location($ctx));};

logicAndExpr returns [LogicAndExpr v] :
	f=eqExpr g=logicAndExprTail
			{$v=new LogicAndExpr(new Location($ctx), $f.v, $g.v);};

logicAndExprTail returns [LogicAndExprTail v] :
	f=andOp g=eqExpr h=logicAndExprTail
			{$v=new LogicAndExprTail(new Location($ctx), $f.v, $g.v, $h.v);}
                	| /*empty*/ {$v=new LogicAndExprTail(new Location($ctx));};

eqExpr returns [EqExpr v] :
        f=relExpr g=eqExprTail
                        {$v=new EqExpr(new Location($ctx), $f.v, $g.v);};

eqExprTail returns [EqExprTail v] :
        f=eqOp g=relExpr h=eqExprTail
                        {$v=new EqExprTail(new Location($ctx), $f.v, $g.v, $h.v);} |
                        /*empty*/ {$v=new EqExprTail(new Location($ctx));};

relExpr returns [RelExpr v] :
        f=addExpr g=relExprTail
                        {$v=new RelExpr(new Location($ctx), $f.v, $g.v);};

relExprTail returns [RelExprTail v] :
        f=relOp g=addExpr h=relExprTail
                        {$v=new RelExprTail(new Location($ctx), $f.v, $g.v, $h.v);} |
                        /*empty*/ {$v=new RelExprTail(new Location($ctx));};

addExpr returns [AddExpr v] :
        f=multExpr g=addExprTail
                        {$v=new AddExpr(new Location($ctx), $f.v, $g.v);};

addExprTail returns [AddExprTail v] :
        f=addOp g=multExpr h=addExprTail
                        {$v=new AddExprTail(new Location($ctx), $f.v, $g.v, $h.v);} |
                        /*empty*/ {$v=new AddExprTail(new Location($ctx));};

multExpr returns [MultExpr v] :
        f=prefixExpr g=multExprTail
                        {$v=new MultExpr(new Location($ctx), $f.v, $g.v);};

multExprTail returns [MultExprTail v] :
        f=multOp g=prefixExpr h=multExprTail
                        {$v=new MultExprTail(new Location($ctx), $f.v, $g.v, $h.v);} |
                        /*empty*/ {$v=new MultExprTail(new Location($ctx));};

prefixExpr returns [PrefixExpr v] :
	f=prefixOp g=prefixExpr
		{$v=new PrefixExpr(new Location($ctx), $f.v, $g.v);}
	| h=postfixExpr
		{$v=new PrefixExpr(new Location($ctx), $h.v);};

postfixExpr returns [PostfixExpr v] :
	f=primExpr g=postfixExprTail
		{$v=new PostfixExpr(new Location($ctx), $f.v, $g.v);};

postfixExprTail returns [PostfixExprTail v] :
	LPAREN a=exprList RPAREN b=postfixExprTail
		{$v=new PostfixExprTail(new Location($ctx), $a.v, $b.v, "CallExpr");} |
	COLON c=type d=postfixExprTail
		{$v=new PostfixExprTail(new Location($ctx), $c.v, $d.v, "CastExpr");} |
	DOT e=fieldId f=postfixExprTail
		{$v=new PostfixExprTail(new Location($ctx), $e.v, $f.v, "FieldExpr");} |
	LBRACKET g=expr RBRACKET h=postfixExprTail
		{$v=new PostfixExprTail(new Location($ctx), $g.v, $h.v, "SubscriptExpr");} |
	/*empty*/ {$v=new PostfixExprTail(new Location($ctx));};

primExpr returns [PrimExpr v] :
	a=varId
		{$v=new PrimExpr(new Location($ctx), $a.v);}
	| b=arrayLit
		{$v=new PrimExpr(new Location($ctx), $b.v);}
	| c=recordLit
		{$v=new PrimExpr(new Location($ctx), $c.v);}
	| d=parenExpr
		{$v=new PrimExpr(new Location($ctx), $d.v);}
	| e=boolLit
		{$v=new PrimExpr(new Location($ctx), $e.v);}
	| f=intLit
		{$v=new PrimExpr(new Location($ctx), $f.v);}
	| g=nullLit
		{$v=new PrimExpr(new Location($ctx), $g.v);}
	| h=stringLit
		{$v=new PrimExpr(new Location($ctx), $h.v);};

callExpr returns [CallExpr v] :
        f=funId g=callActuals
                {$v=new CallExpr(new Location($ctx), $f.v, $g.v);};

callActuals returns [CallActuals v] :
        LPAREN f=exprList RPAREN
                {$v=new CallActuals(new Location($ctx), $f.v);};

exprList returns [ExprList v] :
	f=expr g=exprListTail
		{$v=new ExprList(new Location($ctx), $f.v, $g.v);};

exprListTail returns [ExprListTail v] :
	COMMA f=expr g=exprListTail
		{$v=new ExprListTail(new Location($ctx), $f.v, $g.v);} |
	/*empty*/ {$v=new ExprListTail(new Location($ctx));};

// Statements --------------------------------------------------------------
varDef returns [VarDef v] :
        f=varId EQ g=expr SEMI
                {$v=new VarDef(new Location($ctx), $f.v, $g.v);};

assignStmt returns [AssignStmt v] :
        f=expr COLONEQ g=expr SEMI
                {$v=new AssignStmt(new Location($ctx), $f.v, $g.v);};

callStmt returns [CallStmt v] :
        f=callExpr SEMI
                {$v=new CallStmt(new Location($ctx), $f.v);};

//-------------------------

stmtList returns [StmtList v] :
        f=stmt g= stmtListTail
                {$v=new StmtList(new Location($ctx), $f.v, $g.v);}
        | /*empty*/ {$v=new StmtList(new Location($ctx));};

stmtListTail returns [StmtListTail v] :
        f=stmt g=stmtListTail
                {$v=new StmtListTail(new Location($ctx), $f.v, $g.v);}
        | /*empty*/ {$v=new StmtListTail(new Location($ctx));};

blockStmt returns [BlockStmt v] :
        LCURLY f=stmtList RCURLY
                {$v=new BlockStmt(new Location($ctx), $f.v);};


forStmt returns [ForStmt v] :
        FOR f=varId IN g=expr h=blockStmt
                {$v=new ForStmt(new Location($ctx), $f.v, $g.v, $h.v);};

whileStmt returns [WhileStmt v] :
        WHILE f=expr g=blockStmt
                {$v=new WhileStmt(new Location($ctx), $f.v, $g.v);};

ifStmt returns [IfStmt v] :
        IF f=expr g=blockStmt ELSE h=blockStmt
                {$v=new IfStmt(new Location($ctx), $f.v, $g.v, $h.v);}
      | IF a=expr b=blockStmt
                {$v=new IfStmt(new Location($ctx), $a.v, $b.v);};

returnStmt returns [ReturnStmt v] :
        ARROW f=expr SEMI
                {$v=new ReturnStmt(new Location($ctx), $f.v);}
      | ARROW SEMI
                {$v=new ReturnStmt(new Location($ctx));};

stmt returns [Stmt v] :
        a=varDef
                {$v=new Stmt(new Location($ctx), $a.v);}
        | b=assignStmt
                {$v=new Stmt(new Location($ctx), $b.v);}
        | c=blockStmt
                {$v=new Stmt(new Location($ctx), $c.v);}
        | d=callStmt
                {$v=new Stmt(new Location($ctx), $d.v);}
        | e=forStmt
                {$v=new Stmt(new Location($ctx), $e.v);}
        | f=ifStmt
                {$v=new Stmt(new Location($ctx), $f.v);}
        | g=returnStmt
                {$v=new Stmt(new Location($ctx), $g.v);}
        | h=whileStmt
                {$v=new Stmt(new Location($ctx), $h.v);};



// Tester -------------------------------------------------------------------
tester returns [Tester v] :
    f=expr EOF
                {$v= new Tester(new Location($ctx), $f.v);};

// Blockstmt
// Callstmt
// CallExpr
// ReturnStmt



// Lexical -----------------------------------------------------------------

NULL_LIT : 'null';
BOOL_LIT : 'true' | 'false';

EQ : '=' ;
FUN : 'fun' ;
IF : 'if' ;
IN : 'in' ;
ELSE : 'else' ;
FOR : 'for' ;
WHILE : 'while' ;

INT_TYPE : 'int';
BOOL_TYPE : 'bool';
STRING_TYPE : 'string';
VOID_TYPE : 'void';

LBRACKET : '[' ;
RBRACKET : ']' ;
LCURLY : '{' ;
RCURLY : '}' ;
LPAREN : '(' ;
RPAREN : ')' ;
ARROW : '->' ;
DOT : '.' ;
COLON : ':' ;
COLONEQ : ':=' ;
SEMI : ';' ;
COMMA : ',';

ADD_OP : '+';
MULT_OP : '*';
SUB_OP : '-';
DIV_OP : '/';
MOD_OP : '%';
EQUAL_OP : '==';
NOTEQUAL_OP : '!=';
LESSEQUAL_OP : '<=';
LESS_OP : '<';
GREATEQUAL_OP : '>=';
GREAT_OP : '>';
NOT_OP : '!';
LOGIC_OR_OP : '||' ;
LOGIC_AND_OP : '&&' ;

ID : [a-zA-Z] [a-zA-Z0-9]* ;

fragment ESCAPED_QUOTE : '\\"';
STRING_LIT :   '"' ( ESCAPED_QUOTE | ~('\n'|'\r') )*? '"';
INT_LIT : '0' | [1-9] [0-9]*;

WS : ( [ \r\t\n] | NEWLINE | COMMENT )+ -> skip ;

NEWLINE : '\r' '\n' | '\r' | '\n';
COMMENT : '#' ~[\r\n]* '\r'?  (NEWLINE | EOF) -> skip ;


