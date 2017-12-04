// Generated from Tack.g4 by ANTLR 4.5
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TackParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, BOOL=13, ELSE=14, FOR=15, FUN=16, IF=17, 
		IN=18, INT=19, STRING=20, VOID=21, WHILE=22, ARROW=23, DOT=24, COLON=25, 
		COLONEQ=26, COMMA=27, EQ=28, SEMI=29, LBRACKET=30, RBRACKET=31, LCURLY=32, 
		RCURLY=33, LPAREN=34, RPAREN=35, LOGIC_OR_OP=36, LOGIC_AND_OP=37, BOOL_LIT=38, 
		NULL_LIT=39, ID=40, INT_LIT=41, STRING_LIT=42, WS=43, NEWLINE=44, COMMENT=45;
	public static final int
		RULE_program = 0, RULE_funDef = 1, RULE_funDefList = 2, RULE_funDefListTail = 3, 
		RULE_type = 4, RULE_arrayType = 5, RULE_recordType = 6, RULE_fieldTypeList = 7, 
		RULE_fieldTypeListTail = 8, RULE_fieldType = 9, RULE_boolType = 10, RULE_intType = 11, 
		RULE_stringType = 12, RULE_funType = 13, RULE_returnType = 14, RULE_voidType = 15, 
		RULE_stmt = 16, RULE_varDef = 17, RULE_assignStmt = 18, RULE_blockStmt = 19, 
		RULE_callStmt = 20, RULE_forStmt = 21, RULE_ifStmt = 22, RULE_returnStmt = 23, 
		RULE_whileStmt = 24, RULE_stmtList = 25, RULE_stmtListTail = 26, RULE_expr = 27, 
		RULE_logicOrExpr = 28, RULE_logicOrExprTail = 29, RULE_logicAndExpr = 30, 
		RULE_logicAndExprTail = 31, RULE_eqExpr = 32, RULE_eqExprTail = 33, RULE_relExpr = 34, 
		RULE_relExprTail = 35, RULE_addExpr = 36, RULE_addExprTail = 37, RULE_multExpr = 38, 
		RULE_multExprTail = 39, RULE_prefixExpr = 40, RULE_postfixExpr = 41, RULE_postfixExprTail = 42, 
		RULE_emptyPostfixTail = 43, RULE_callExpr = 44, RULE_callActuals = 45, 
		RULE_callExprTail = 46, RULE_castExprTail = 47, RULE_fieldExprTail = 48, 
		RULE_subscriptExprTail = 49, RULE_exprList = 50, RULE_exprListTail = 51, 
		RULE_primExpr = 52, RULE_parenExpr = 53, RULE_arrayLit = 54, RULE_recordLit = 55, 
		RULE_fieldLitList = 56, RULE_fieldLitListTail = 57, RULE_fieldLit = 58, 
		RULE_boolLit = 59, RULE_intLit = 60, RULE_nullLit = 61, RULE_stringLit = 62, 
		RULE_fieldId = 63, RULE_funId = 64, RULE_varId = 65, RULE_eqOp = 66, RULE_relOp = 67, 
		RULE_addOp = 68, RULE_multOp = 69, RULE_prefixOp = 70;
	public static final String[] ruleNames = {
		"program", "funDef", "funDefList", "funDefListTail", "type", "arrayType", 
		"recordType", "fieldTypeList", "fieldTypeListTail", "fieldType", "boolType", 
		"intType", "stringType", "funType", "returnType", "voidType", "stmt", 
		"varDef", "assignStmt", "blockStmt", "callStmt", "forStmt", "ifStmt", 
		"returnStmt", "whileStmt", "stmtList", "stmtListTail", "expr", "logicOrExpr", 
		"logicOrExprTail", "logicAndExpr", "logicAndExprTail", "eqExpr", "eqExprTail", 
		"relExpr", "relExprTail", "addExpr", "addExprTail", "multExpr", "multExprTail", 
		"prefixExpr", "postfixExpr", "postfixExprTail", "emptyPostfixTail", "callExpr", 
		"callActuals", "callExprTail", "castExprTail", "fieldExprTail", "subscriptExprTail", 
		"exprList", "exprListTail", "primExpr", "parenExpr", "arrayLit", "recordLit", 
		"fieldLitList", "fieldLitListTail", "fieldLit", "boolLit", "intLit", "nullLit", 
		"stringLit", "fieldId", "funId", "varId", "eqOp", "relOp", "addOp", "multOp", 
		"prefixOp"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'=='", "'!='", "'<='", "'<'", "'>='", "'>'", "'+'", "'-'", "'*'", 
		"'/'", "'%'", "'!'", "'bool'", "'else'", "'for'", "'fun'", "'if'", "'in'", 
		"'int'", "'string'", "'void'", "'while'", "'->'", "'.'", "':'", "':='", 
		"','", "'='", "';'", "'['", "']'", "'{'", "'}'", "'('", "')'", "'||'", 
		"'&&'", null, "'null'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "BOOL", "ELSE", "FOR", "FUN", "IF", "IN", "INT", "STRING", "VOID", 
		"WHILE", "ARROW", "DOT", "COLON", "COLONEQ", "COMMA", "EQ", "SEMI", "LBRACKET", 
		"RBRACKET", "LCURLY", "RCURLY", "LPAREN", "RPAREN", "LOGIC_OR_OP", "LOGIC_AND_OP", 
		"BOOL_LIT", "NULL_LIT", "ID", "INT_LIT", "STRING_LIT", "WS", "NEWLINE", 
		"COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Tack.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TackParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public FunDefListContext funDefList() {
			return getRuleContext(FunDefListContext.class,0);
		}
		public TerminalNode EOF() { return getToken(TackParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			funDefList();
			setState(143);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunDefContext extends ParserRuleContext {
		public FunIdContext funId() {
			return getRuleContext(FunIdContext.class,0);
		}
		public TerminalNode EQ() { return getToken(TackParser.EQ, 0); }
		public TerminalNode FUN() { return getToken(TackParser.FUN, 0); }
		public FunTypeContext funType() {
			return getRuleContext(FunTypeContext.class,0);
		}
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public FunDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterFunDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitFunDef(this);
		}
	}

	public final FunDefContext funDef() throws RecognitionException {
		FunDefContext _localctx = new FunDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_funDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			funId();
			setState(146);
			match(EQ);
			setState(147);
			match(FUN);
			setState(148);
			funType();
			setState(149);
			blockStmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunDefListContext extends ParserRuleContext {
		public FunDefContext funDef() {
			return getRuleContext(FunDefContext.class,0);
		}
		public FunDefListTailContext funDefListTail() {
			return getRuleContext(FunDefListTailContext.class,0);
		}
		public FunDefListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDefList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterFunDefList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitFunDefList(this);
		}
	}

	public final FunDefListContext funDefList() throws RecognitionException {
		FunDefListContext _localctx = new FunDefListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funDefList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			funDef();
			setState(152);
			funDefListTail();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunDefListTailContext extends ParserRuleContext {
		public FunDefContext funDef() {
			return getRuleContext(FunDefContext.class,0);
		}
		public FunDefListTailContext funDefListTail() {
			return getRuleContext(FunDefListTailContext.class,0);
		}
		public FunDefListTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDefListTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterFunDefListTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitFunDefListTail(this);
		}
	}

	public final FunDefListTailContext funDefListTail() throws RecognitionException {
		FunDefListTailContext _localctx = new FunDefListTailContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_funDefListTail);
		try {
			setState(158);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				funDef();
				setState(155);
				funDefListTail();
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public RecordTypeContext recordType() {
			return getRuleContext(RecordTypeContext.class,0);
		}
		public BoolTypeContext boolType() {
			return getRuleContext(BoolTypeContext.class,0);
		}
		public IntTypeContext intType() {
			return getRuleContext(IntTypeContext.class,0);
		}
		public StringTypeContext stringType() {
			return getRuleContext(StringTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		try {
			setState(165);
			switch (_input.LA(1)) {
			case LBRACKET:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				arrayType();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				recordType();
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 3);
				{
				setState(162);
				boolType();
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 4);
				{
				setState(163);
				intType();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(164);
				stringType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayTypeContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(TackParser.LBRACKET, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(TackParser.RBRACKET, 0); }
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitArrayType(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arrayType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(LBRACKET);
			setState(168);
			type();
			setState(169);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RecordTypeContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(TackParser.LPAREN, 0); }
		public FieldTypeListContext fieldTypeList() {
			return getRuleContext(FieldTypeListContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(TackParser.RPAREN, 0); }
		public RecordTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterRecordType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitRecordType(this);
		}
	}

	public final RecordTypeContext recordType() throws RecognitionException {
		RecordTypeContext _localctx = new RecordTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_recordType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(LPAREN);
			setState(172);
			fieldTypeList();
			setState(173);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldTypeListContext extends ParserRuleContext {
		public FieldTypeContext fieldType() {
			return getRuleContext(FieldTypeContext.class,0);
		}
		public FieldTypeListTailContext fieldTypeListTail() {
			return getRuleContext(FieldTypeListTailContext.class,0);
		}
		public FieldTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldTypeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterFieldTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitFieldTypeList(this);
		}
	}

	public final FieldTypeListContext fieldTypeList() throws RecognitionException {
		FieldTypeListContext _localctx = new FieldTypeListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fieldTypeList);
		try {
			setState(179);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				fieldType();
				setState(176);
				fieldTypeListTail();
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldTypeListTailContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(TackParser.COMMA, 0); }
		public FieldTypeContext fieldType() {
			return getRuleContext(FieldTypeContext.class,0);
		}
		public FieldTypeListTailContext fieldTypeListTail() {
			return getRuleContext(FieldTypeListTailContext.class,0);
		}
		public FieldTypeListTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldTypeListTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterFieldTypeListTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitFieldTypeListTail(this);
		}
	}

	public final FieldTypeListTailContext fieldTypeListTail() throws RecognitionException {
		FieldTypeListTailContext _localctx = new FieldTypeListTailContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_fieldTypeListTail);
		try {
			setState(186);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				match(COMMA);
				setState(182);
				fieldType();
				setState(183);
				fieldTypeListTail();
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldTypeContext extends ParserRuleContext {
		public FieldIdContext fieldId() {
			return getRuleContext(FieldIdContext.class,0);
		}
		public TerminalNode COLON() { return getToken(TackParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public FieldTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterFieldType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitFieldType(this);
		}
	}

	public final FieldTypeContext fieldType() throws RecognitionException {
		FieldTypeContext _localctx = new FieldTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_fieldType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			fieldId();
			setState(189);
			match(COLON);
			setState(190);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolTypeContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(TackParser.BOOL, 0); }
		public BoolTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterBoolType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitBoolType(this);
		}
	}

	public final BoolTypeContext boolType() throws RecognitionException {
		BoolTypeContext _localctx = new BoolTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_boolType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(BOOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntTypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(TackParser.INT, 0); }
		public IntTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitIntType(this);
		}
	}

	public final IntTypeContext intType() throws RecognitionException {
		IntTypeContext _localctx = new IntTypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_intType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringTypeContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(TackParser.STRING, 0); }
		public StringTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterStringType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitStringType(this);
		}
	}

	public final StringTypeContext stringType() throws RecognitionException {
		StringTypeContext _localctx = new StringTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stringType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunTypeContext extends ParserRuleContext {
		public RecordTypeContext recordType() {
			return getRuleContext(RecordTypeContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(TackParser.ARROW, 0); }
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public FunTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterFunType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitFunType(this);
		}
	}

	public final FunTypeContext funType() throws RecognitionException {
		FunTypeContext _localctx = new FunTypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_funType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			recordType();
			setState(199);
			match(ARROW);
			setState(200);
			returnType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnTypeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VoidTypeContext voidType() {
			return getRuleContext(VoidTypeContext.class,0);
		}
		public ReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterReturnType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitReturnType(this);
		}
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_returnType);
		try {
			setState(204);
			switch (_input.LA(1)) {
			case BOOL:
			case INT:
			case STRING:
			case LBRACKET:
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				type();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				voidType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VoidTypeContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(TackParser.VOID, 0); }
		public VoidTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voidType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterVoidType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitVoidType(this);
		}
	}

	public final VoidTypeContext voidType() throws RecognitionException {
		VoidTypeContext _localctx = new VoidTypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_voidType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(VOID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public AssignStmtContext assignStmt() {
			return getRuleContext(AssignStmtContext.class,0);
		}
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public CallStmtContext callStmt() {
			return getRuleContext(CallStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_stmt);
		try {
			setState(216);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				varDef();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				assignStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(210);
				blockStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(211);
				callStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(212);
				forStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(213);
				ifStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(214);
				returnStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(215);
				whileStmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDefContext extends ParserRuleContext {
		public VarIdContext varId() {
			return getRuleContext(VarIdContext.class,0);
		}
		public TerminalNode EQ() { return getToken(TackParser.EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(TackParser.SEMI, 0); }
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitVarDef(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_varDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			varId();
			setState(219);
			match(EQ);
			setState(220);
			expr();
			setState(221);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignStmtContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COLONEQ() { return getToken(TackParser.COLONEQ, 0); }
		public TerminalNode SEMI() { return getToken(TackParser.SEMI, 0); }
		public AssignStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterAssignStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitAssignStmt(this);
		}
	}

	public final AssignStmtContext assignStmt() throws RecognitionException {
		AssignStmtContext _localctx = new AssignStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_assignStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			expr();
			setState(224);
			match(COLONEQ);
			setState(225);
			expr();
			setState(226);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStmtContext extends ParserRuleContext {
		public TerminalNode LCURLY() { return getToken(TackParser.LCURLY, 0); }
		public StmtListContext stmtList() {
			return getRuleContext(StmtListContext.class,0);
		}
		public TerminalNode RCURLY() { return getToken(TackParser.RCURLY, 0); }
		public BlockStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterBlockStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitBlockStmt(this);
		}
	}

	public final BlockStmtContext blockStmt() throws RecognitionException {
		BlockStmtContext _localctx = new BlockStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_blockStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(LCURLY);
			setState(229);
			stmtList();
			setState(230);
			match(RCURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CallStmtContext extends ParserRuleContext {
		public CallExprContext callExpr() {
			return getRuleContext(CallExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(TackParser.SEMI, 0); }
		public CallStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterCallStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitCallStmt(this);
		}
	}

	public final CallStmtContext callStmt() throws RecognitionException {
		CallStmtContext _localctx = new CallStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_callStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			callExpr();
			setState(233);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(TackParser.FOR, 0); }
		public VarIdContext varId() {
			return getRuleContext(VarIdContext.class,0);
		}
		public TerminalNode IN() { return getToken(TackParser.IN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitForStmt(this);
		}
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_forStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(FOR);
			setState(236);
			varId();
			setState(237);
			match(IN);
			setState(238);
			expr();
			setState(239);
			blockStmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(TackParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<BlockStmtContext> blockStmt() {
			return getRuleContexts(BlockStmtContext.class);
		}
		public BlockStmtContext blockStmt(int i) {
			return getRuleContext(BlockStmtContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(TackParser.ELSE, 0); }
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitIfStmt(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_ifStmt);
		try {
			setState(251);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(241);
				match(IF);
				setState(242);
				expr();
				setState(243);
				blockStmt();
				setState(244);
				match(ELSE);
				setState(245);
				blockStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(247);
				match(IF);
				setState(248);
				expr();
				setState(249);
				blockStmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode ARROW() { return getToken(TackParser.ARROW, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(TackParser.SEMI, 0); }
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitReturnStmt(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_returnStmt);
		try {
			setState(259);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(253);
				match(ARROW);
				setState(254);
				expr();
				setState(255);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(257);
				match(ARROW);
				setState(258);
				match(SEMI);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(TackParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockStmtContext blockStmt() {
			return getRuleContext(BlockStmtContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitWhileStmt(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(WHILE);
			setState(262);
			expr();
			setState(263);
			blockStmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtListContext extends ParserRuleContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public StmtListTailContext stmtListTail() {
			return getRuleContext(StmtListTailContext.class,0);
		}
		public StmtListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterStmtList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitStmtList(this);
		}
	}

	public final StmtListContext stmtList() throws RecognitionException {
		StmtListContext _localctx = new StmtListContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_stmtList);
		try {
			setState(269);
			switch (_input.LA(1)) {
			case T__7:
			case T__11:
			case FOR:
			case IF:
			case WHILE:
			case ARROW:
			case LBRACKET:
			case LCURLY:
			case LPAREN:
			case BOOL_LIT:
			case NULL_LIT:
			case ID:
			case INT_LIT:
			case STRING_LIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(265);
				stmt();
				setState(266);
				stmtListTail();
				}
				break;
			case RCURLY:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtListTailContext extends ParserRuleContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public StmtListTailContext stmtListTail() {
			return getRuleContext(StmtListTailContext.class,0);
		}
		public StmtListTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtListTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterStmtListTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitStmtListTail(this);
		}
	}

	public final StmtListTailContext stmtListTail() throws RecognitionException {
		StmtListTailContext _localctx = new StmtListTailContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_stmtListTail);
		try {
			setState(275);
			switch (_input.LA(1)) {
			case T__7:
			case T__11:
			case FOR:
			case IF:
			case WHILE:
			case ARROW:
			case LBRACKET:
			case LCURLY:
			case LPAREN:
			case BOOL_LIT:
			case NULL_LIT:
			case ID:
			case INT_LIT:
			case STRING_LIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(271);
				stmt();
				setState(272);
				stmtListTail();
				}
				break;
			case RCURLY:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public LogicOrExprContext logicOrExpr() {
			return getRuleContext(LogicOrExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			logicOrExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicOrExprContext extends ParserRuleContext {
		public LogicAndExprContext logicAndExpr() {
			return getRuleContext(LogicAndExprContext.class,0);
		}
		public LogicOrExprTailContext logicOrExprTail() {
			return getRuleContext(LogicOrExprTailContext.class,0);
		}
		public LogicOrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicOrExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterLogicOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitLogicOrExpr(this);
		}
	}

	public final LogicOrExprContext logicOrExpr() throws RecognitionException {
		LogicOrExprContext _localctx = new LogicOrExprContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_logicOrExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			logicAndExpr();
			setState(280);
			logicOrExprTail();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicOrExprTailContext extends ParserRuleContext {
		public TerminalNode LOGIC_OR_OP() { return getToken(TackParser.LOGIC_OR_OP, 0); }
		public LogicAndExprContext logicAndExpr() {
			return getRuleContext(LogicAndExprContext.class,0);
		}
		public LogicOrExprTailContext logicOrExprTail() {
			return getRuleContext(LogicOrExprTailContext.class,0);
		}
		public LogicOrExprTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicOrExprTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterLogicOrExprTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitLogicOrExprTail(this);
		}
	}

	public final LogicOrExprTailContext logicOrExprTail() throws RecognitionException {
		LogicOrExprTailContext _localctx = new LogicOrExprTailContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_logicOrExprTail);
		try {
			setState(287);
			switch (_input.LA(1)) {
			case LOGIC_OR_OP:
				enterOuterAlt(_localctx, 1);
				{
				setState(282);
				match(LOGIC_OR_OP);
				setState(283);
				logicAndExpr();
				setState(284);
				logicOrExprTail();
				}
				break;
			case COLONEQ:
			case COMMA:
			case SEMI:
			case RBRACKET:
			case LCURLY:
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicAndExprContext extends ParserRuleContext {
		public EqExprContext eqExpr() {
			return getRuleContext(EqExprContext.class,0);
		}
		public LogicAndExprTailContext logicAndExprTail() {
			return getRuleContext(LogicAndExprTailContext.class,0);
		}
		public LogicAndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicAndExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterLogicAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitLogicAndExpr(this);
		}
	}

	public final LogicAndExprContext logicAndExpr() throws RecognitionException {
		LogicAndExprContext _localctx = new LogicAndExprContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_logicAndExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			eqExpr();
			setState(290);
			logicAndExprTail();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicAndExprTailContext extends ParserRuleContext {
		public TerminalNode LOGIC_AND_OP() { return getToken(TackParser.LOGIC_AND_OP, 0); }
		public EqExprContext eqExpr() {
			return getRuleContext(EqExprContext.class,0);
		}
		public LogicAndExprTailContext logicAndExprTail() {
			return getRuleContext(LogicAndExprTailContext.class,0);
		}
		public LogicAndExprTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicAndExprTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterLogicAndExprTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitLogicAndExprTail(this);
		}
	}

	public final LogicAndExprTailContext logicAndExprTail() throws RecognitionException {
		LogicAndExprTailContext _localctx = new LogicAndExprTailContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_logicAndExprTail);
		try {
			setState(297);
			switch (_input.LA(1)) {
			case LOGIC_AND_OP:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				match(LOGIC_AND_OP);
				setState(293);
				eqExpr();
				setState(294);
				logicAndExprTail();
				}
				break;
			case COLONEQ:
			case COMMA:
			case SEMI:
			case RBRACKET:
			case LCURLY:
			case RPAREN:
			case LOGIC_OR_OP:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqExprContext extends ParserRuleContext {
		public RelExprContext relExpr() {
			return getRuleContext(RelExprContext.class,0);
		}
		public EqExprTailContext eqExprTail() {
			return getRuleContext(EqExprTailContext.class,0);
		}
		public EqExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterEqExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitEqExpr(this);
		}
	}

	public final EqExprContext eqExpr() throws RecognitionException {
		EqExprContext _localctx = new EqExprContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_eqExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			relExpr();
			setState(300);
			eqExprTail();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqExprTailContext extends ParserRuleContext {
		public EqOpContext eqOp() {
			return getRuleContext(EqOpContext.class,0);
		}
		public RelExprContext relExpr() {
			return getRuleContext(RelExprContext.class,0);
		}
		public EqExprTailContext eqExprTail() {
			return getRuleContext(EqExprTailContext.class,0);
		}
		public EqExprTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqExprTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterEqExprTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitEqExprTail(this);
		}
	}

	public final EqExprTailContext eqExprTail() throws RecognitionException {
		EqExprTailContext _localctx = new EqExprTailContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_eqExprTail);
		try {
			setState(307);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(302);
				eqOp();
				setState(303);
				relExpr();
				setState(304);
				eqExprTail();
				}
				break;
			case COLONEQ:
			case COMMA:
			case SEMI:
			case RBRACKET:
			case LCURLY:
			case RPAREN:
			case LOGIC_OR_OP:
			case LOGIC_AND_OP:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelExprContext extends ParserRuleContext {
		public AddExprContext addExpr() {
			return getRuleContext(AddExprContext.class,0);
		}
		public RelExprTailContext relExprTail() {
			return getRuleContext(RelExprTailContext.class,0);
		}
		public RelExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterRelExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitRelExpr(this);
		}
	}

	public final RelExprContext relExpr() throws RecognitionException {
		RelExprContext _localctx = new RelExprContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_relExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			addExpr();
			setState(310);
			relExprTail();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelExprTailContext extends ParserRuleContext {
		public RelOpContext relOp() {
			return getRuleContext(RelOpContext.class,0);
		}
		public AddExprContext addExpr() {
			return getRuleContext(AddExprContext.class,0);
		}
		public RelExprTailContext relExprTail() {
			return getRuleContext(RelExprTailContext.class,0);
		}
		public RelExprTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relExprTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterRelExprTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitRelExprTail(this);
		}
	}

	public final RelExprTailContext relExprTail() throws RecognitionException {
		RelExprTailContext _localctx = new RelExprTailContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_relExprTail);
		try {
			setState(317);
			switch (_input.LA(1)) {
			case T__2:
			case T__3:
			case T__4:
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(312);
				relOp();
				setState(313);
				addExpr();
				setState(314);
				relExprTail();
				}
				break;
			case T__0:
			case T__1:
			case COLONEQ:
			case COMMA:
			case SEMI:
			case RBRACKET:
			case LCURLY:
			case RPAREN:
			case LOGIC_OR_OP:
			case LOGIC_AND_OP:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddExprContext extends ParserRuleContext {
		public MultExprContext multExpr() {
			return getRuleContext(MultExprContext.class,0);
		}
		public AddExprTailContext addExprTail() {
			return getRuleContext(AddExprTailContext.class,0);
		}
		public AddExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitAddExpr(this);
		}
	}

	public final AddExprContext addExpr() throws RecognitionException {
		AddExprContext _localctx = new AddExprContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_addExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			multExpr();
			setState(320);
			addExprTail();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddExprTailContext extends ParserRuleContext {
		public AddOpContext addOp() {
			return getRuleContext(AddOpContext.class,0);
		}
		public MultExprContext multExpr() {
			return getRuleContext(MultExprContext.class,0);
		}
		public AddExprTailContext addExprTail() {
			return getRuleContext(AddExprTailContext.class,0);
		}
		public AddExprTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExprTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterAddExprTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitAddExprTail(this);
		}
	}

	public final AddExprTailContext addExprTail() throws RecognitionException {
		AddExprTailContext _localctx = new AddExprTailContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_addExprTail);
		try {
			setState(327);
			switch (_input.LA(1)) {
			case T__6:
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(322);
				addOp();
				setState(323);
				multExpr();
				setState(324);
				addExprTail();
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case COLONEQ:
			case COMMA:
			case SEMI:
			case RBRACKET:
			case LCURLY:
			case RPAREN:
			case LOGIC_OR_OP:
			case LOGIC_AND_OP:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultExprContext extends ParserRuleContext {
		public PrefixExprContext prefixExpr() {
			return getRuleContext(PrefixExprContext.class,0);
		}
		public MultExprTailContext multExprTail() {
			return getRuleContext(MultExprTailContext.class,0);
		}
		public MultExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterMultExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitMultExpr(this);
		}
	}

	public final MultExprContext multExpr() throws RecognitionException {
		MultExprContext _localctx = new MultExprContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_multExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			prefixExpr();
			setState(330);
			multExprTail();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultExprTailContext extends ParserRuleContext {
		public MultOpContext multOp() {
			return getRuleContext(MultOpContext.class,0);
		}
		public PrefixExprContext prefixExpr() {
			return getRuleContext(PrefixExprContext.class,0);
		}
		public MultExprTailContext multExprTail() {
			return getRuleContext(MultExprTailContext.class,0);
		}
		public MultExprTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multExprTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterMultExprTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitMultExprTail(this);
		}
	}

	public final MultExprTailContext multExprTail() throws RecognitionException {
		MultExprTailContext _localctx = new MultExprTailContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_multExprTail);
		try {
			setState(337);
			switch (_input.LA(1)) {
			case T__8:
			case T__9:
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(332);
				multOp();
				setState(333);
				prefixExpr();
				setState(334);
				multExprTail();
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case COLONEQ:
			case COMMA:
			case SEMI:
			case RBRACKET:
			case LCURLY:
			case RPAREN:
			case LOGIC_OR_OP:
			case LOGIC_AND_OP:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixExprContext extends ParserRuleContext {
		public PrefixOpContext prefixOp() {
			return getRuleContext(PrefixOpContext.class,0);
		}
		public PrefixExprContext prefixExpr() {
			return getRuleContext(PrefixExprContext.class,0);
		}
		public PostfixExprContext postfixExpr() {
			return getRuleContext(PostfixExprContext.class,0);
		}
		public PrefixExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterPrefixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitPrefixExpr(this);
		}
	}

	public final PrefixExprContext prefixExpr() throws RecognitionException {
		PrefixExprContext _localctx = new PrefixExprContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_prefixExpr);
		try {
			setState(343);
			switch (_input.LA(1)) {
			case T__7:
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(339);
				prefixOp();
				setState(340);
				prefixExpr();
				}
				break;
			case LBRACKET:
			case LPAREN:
			case BOOL_LIT:
			case NULL_LIT:
			case ID:
			case INT_LIT:
			case STRING_LIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(342);
				postfixExpr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixExprContext extends ParserRuleContext {
		public PrimExprContext primExpr() {
			return getRuleContext(PrimExprContext.class,0);
		}
		public PostfixExprTailContext postfixExprTail() {
			return getRuleContext(PostfixExprTailContext.class,0);
		}
		public PostfixExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterPostfixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitPostfixExpr(this);
		}
	}

	public final PostfixExprContext postfixExpr() throws RecognitionException {
		PostfixExprContext _localctx = new PostfixExprContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_postfixExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			primExpr();
			setState(346);
			postfixExprTail();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixExprTailContext extends ParserRuleContext {
		public CallExprTailContext callExprTail() {
			return getRuleContext(CallExprTailContext.class,0);
		}
		public CastExprTailContext castExprTail() {
			return getRuleContext(CastExprTailContext.class,0);
		}
		public FieldExprTailContext fieldExprTail() {
			return getRuleContext(FieldExprTailContext.class,0);
		}
		public SubscriptExprTailContext subscriptExprTail() {
			return getRuleContext(SubscriptExprTailContext.class,0);
		}
		public EmptyPostfixTailContext emptyPostfixTail() {
			return getRuleContext(EmptyPostfixTailContext.class,0);
		}
		public PostfixExprTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExprTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterPostfixExprTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitPostfixExprTail(this);
		}
	}

	public final PostfixExprTailContext postfixExprTail() throws RecognitionException {
		PostfixExprTailContext _localctx = new PostfixExprTailContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_postfixExprTail);
		try {
			setState(353);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(348);
				callExprTail();
				}
				break;
			case COLON:
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
				castExprTail();
				}
				break;
			case DOT:
				enterOuterAlt(_localctx, 3);
				{
				setState(350);
				fieldExprTail();
				}
				break;
			case LBRACKET:
				enterOuterAlt(_localctx, 4);
				{
				setState(351);
				subscriptExprTail();
				}
				break;
			case T__0:
			case T__1:
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case COLONEQ:
			case COMMA:
			case SEMI:
			case RBRACKET:
			case LCURLY:
			case RPAREN:
			case LOGIC_OR_OP:
			case LOGIC_AND_OP:
				enterOuterAlt(_localctx, 5);
				{
				setState(352);
				emptyPostfixTail();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmptyPostfixTailContext extends ParserRuleContext {
		public EmptyPostfixTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyPostfixTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterEmptyPostfixTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitEmptyPostfixTail(this);
		}
	}

	public final EmptyPostfixTailContext emptyPostfixTail() throws RecognitionException {
		EmptyPostfixTailContext _localctx = new EmptyPostfixTailContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_emptyPostfixTail);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CallExprContext extends ParserRuleContext {
		public FunIdContext funId() {
			return getRuleContext(FunIdContext.class,0);
		}
		public CallActualsContext callActuals() {
			return getRuleContext(CallActualsContext.class,0);
		}
		public CallExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitCallExpr(this);
		}
	}

	public final CallExprContext callExpr() throws RecognitionException {
		CallExprContext _localctx = new CallExprContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_callExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			funId();
			setState(358);
			callActuals();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CallActualsContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(TackParser.LPAREN, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(TackParser.RPAREN, 0); }
		public EmptyPostfixTailContext emptyPostfixTail() {
			return getRuleContext(EmptyPostfixTailContext.class,0);
		}
		public CallActualsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callActuals; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterCallActuals(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitCallActuals(this);
		}
	}

	public final CallActualsContext callActuals() throws RecognitionException {
		CallActualsContext _localctx = new CallActualsContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_callActuals);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			match(LPAREN);
			setState(361);
			exprList();
			setState(362);
			match(RPAREN);
			setState(363);
			emptyPostfixTail();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CallExprTailContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(TackParser.LPAREN, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(TackParser.RPAREN, 0); }
		public PostfixExprTailContext postfixExprTail() {
			return getRuleContext(PostfixExprTailContext.class,0);
		}
		public CallExprTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callExprTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterCallExprTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitCallExprTail(this);
		}
	}

	public final CallExprTailContext callExprTail() throws RecognitionException {
		CallExprTailContext _localctx = new CallExprTailContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_callExprTail);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			match(LPAREN);
			setState(366);
			exprList();
			setState(367);
			match(RPAREN);
			setState(368);
			postfixExprTail();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CastExprTailContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(TackParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public PostfixExprTailContext postfixExprTail() {
			return getRuleContext(PostfixExprTailContext.class,0);
		}
		public CastExprTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castExprTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterCastExprTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitCastExprTail(this);
		}
	}

	public final CastExprTailContext castExprTail() throws RecognitionException {
		CastExprTailContext _localctx = new CastExprTailContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_castExprTail);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			match(COLON);
			setState(371);
			type();
			setState(372);
			postfixExprTail();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldExprTailContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(TackParser.DOT, 0); }
		public FieldIdContext fieldId() {
			return getRuleContext(FieldIdContext.class,0);
		}
		public PostfixExprTailContext postfixExprTail() {
			return getRuleContext(PostfixExprTailContext.class,0);
		}
		public FieldExprTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldExprTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterFieldExprTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitFieldExprTail(this);
		}
	}

	public final FieldExprTailContext fieldExprTail() throws RecognitionException {
		FieldExprTailContext _localctx = new FieldExprTailContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_fieldExprTail);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			match(DOT);
			setState(375);
			fieldId();
			setState(376);
			postfixExprTail();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubscriptExprTailContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(TackParser.LBRACKET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(TackParser.RBRACKET, 0); }
		public PostfixExprTailContext postfixExprTail() {
			return getRuleContext(PostfixExprTailContext.class,0);
		}
		public SubscriptExprTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subscriptExprTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterSubscriptExprTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitSubscriptExprTail(this);
		}
	}

	public final SubscriptExprTailContext subscriptExprTail() throws RecognitionException {
		SubscriptExprTailContext _localctx = new SubscriptExprTailContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_subscriptExprTail);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			match(LBRACKET);
			setState(379);
			expr();
			setState(380);
			match(RBRACKET);
			setState(381);
			postfixExprTail();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprListContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprListTailContext exprListTail() {
			return getRuleContext(ExprListTailContext.class,0);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitExprList(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_exprList);
		try {
			setState(387);
			switch (_input.LA(1)) {
			case T__7:
			case T__11:
			case LBRACKET:
			case LPAREN:
			case BOOL_LIT:
			case NULL_LIT:
			case ID:
			case INT_LIT:
			case STRING_LIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(383);
				expr();
				setState(384);
				exprListTail();
				}
				break;
			case RBRACKET:
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprListTailContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(TackParser.COMMA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprListTailContext exprListTail() {
			return getRuleContext(ExprListTailContext.class,0);
		}
		public ExprListTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprListTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterExprListTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitExprListTail(this);
		}
	}

	public final ExprListTailContext exprListTail() throws RecognitionException {
		ExprListTailContext _localctx = new ExprListTailContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_exprListTail);
		try {
			setState(394);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(389);
				match(COMMA);
				setState(390);
				expr();
				setState(391);
				exprListTail();
				}
				break;
			case RBRACKET:
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimExprContext extends ParserRuleContext {
		public VarIdContext varId() {
			return getRuleContext(VarIdContext.class,0);
		}
		public ArrayLitContext arrayLit() {
			return getRuleContext(ArrayLitContext.class,0);
		}
		public RecordLitContext recordLit() {
			return getRuleContext(RecordLitContext.class,0);
		}
		public ParenExprContext parenExpr() {
			return getRuleContext(ParenExprContext.class,0);
		}
		public BoolLitContext boolLit() {
			return getRuleContext(BoolLitContext.class,0);
		}
		public IntLitContext intLit() {
			return getRuleContext(IntLitContext.class,0);
		}
		public NullLitContext nullLit() {
			return getRuleContext(NullLitContext.class,0);
		}
		public StringLitContext stringLit() {
			return getRuleContext(StringLitContext.class,0);
		}
		public PrimExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterPrimExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitPrimExpr(this);
		}
	}

	public final PrimExprContext primExpr() throws RecognitionException {
		PrimExprContext _localctx = new PrimExprContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_primExpr);
		try {
			setState(404);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(396);
				varId();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(397);
				arrayLit();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(398);
				recordLit();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(399);
				parenExpr();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(400);
				boolLit();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(401);
				intLit();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(402);
				nullLit();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(403);
				stringLit();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParenExprContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(TackParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(TackParser.RPAREN, 0); }
		public ParenExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitParenExpr(this);
		}
	}

	public final ParenExprContext parenExpr() throws RecognitionException {
		ParenExprContext _localctx = new ParenExprContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_parenExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			match(LPAREN);
			setState(407);
			expr();
			setState(408);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayLitContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(TackParser.LBRACKET, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(TackParser.RBRACKET, 0); }
		public ArrayLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayLit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterArrayLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitArrayLit(this);
		}
	}

	public final ArrayLitContext arrayLit() throws RecognitionException {
		ArrayLitContext _localctx = new ArrayLitContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_arrayLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			match(LBRACKET);
			setState(411);
			exprList();
			setState(412);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RecordLitContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(TackParser.LPAREN, 0); }
		public FieldLitListContext fieldLitList() {
			return getRuleContext(FieldLitListContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(TackParser.RPAREN, 0); }
		public RecordLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordLit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterRecordLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitRecordLit(this);
		}
	}

	public final RecordLitContext recordLit() throws RecognitionException {
		RecordLitContext _localctx = new RecordLitContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_recordLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
			match(LPAREN);
			setState(415);
			fieldLitList();
			setState(416);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldLitListContext extends ParserRuleContext {
		public FieldLitContext fieldLit() {
			return getRuleContext(FieldLitContext.class,0);
		}
		public FieldLitListTailContext fieldLitListTail() {
			return getRuleContext(FieldLitListTailContext.class,0);
		}
		public FieldLitListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldLitList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterFieldLitList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitFieldLitList(this);
		}
	}

	public final FieldLitListContext fieldLitList() throws RecognitionException {
		FieldLitListContext _localctx = new FieldLitListContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_fieldLitList);
		try {
			setState(422);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(418);
				fieldLit();
				setState(419);
				fieldLitListTail();
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldLitListTailContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(TackParser.COMMA, 0); }
		public FieldLitContext fieldLit() {
			return getRuleContext(FieldLitContext.class,0);
		}
		public FieldLitListTailContext fieldLitListTail() {
			return getRuleContext(FieldLitListTailContext.class,0);
		}
		public FieldLitListTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldLitListTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterFieldLitListTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitFieldLitListTail(this);
		}
	}

	public final FieldLitListTailContext fieldLitListTail() throws RecognitionException {
		FieldLitListTailContext _localctx = new FieldLitListTailContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_fieldLitListTail);
		try {
			setState(429);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(424);
				match(COMMA);
				setState(425);
				fieldLit();
				setState(426);
				fieldLitListTail();
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldLitContext extends ParserRuleContext {
		public FieldIdContext fieldId() {
			return getRuleContext(FieldIdContext.class,0);
		}
		public TerminalNode EQ() { return getToken(TackParser.EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FieldLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldLit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterFieldLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitFieldLit(this);
		}
	}

	public final FieldLitContext fieldLit() throws RecognitionException {
		FieldLitContext _localctx = new FieldLitContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_fieldLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
			fieldId();
			setState(432);
			match(EQ);
			setState(433);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BoolLitContext extends ParserRuleContext {
		public TerminalNode BOOL_LIT() { return getToken(TackParser.BOOL_LIT, 0); }
		public BoolLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolLit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterBoolLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitBoolLit(this);
		}
	}

	public final BoolLitContext boolLit() throws RecognitionException {
		BoolLitContext _localctx = new BoolLitContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_boolLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			match(BOOL_LIT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntLitContext extends ParserRuleContext {
		public TerminalNode INT_LIT() { return getToken(TackParser.INT_LIT, 0); }
		public IntLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intLit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterIntLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitIntLit(this);
		}
	}

	public final IntLitContext intLit() throws RecognitionException {
		IntLitContext _localctx = new IntLitContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_intLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
			match(INT_LIT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NullLitContext extends ParserRuleContext {
		public TerminalNode NULL_LIT() { return getToken(TackParser.NULL_LIT, 0); }
		public NullLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullLit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterNullLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitNullLit(this);
		}
	}

	public final NullLitContext nullLit() throws RecognitionException {
		NullLitContext _localctx = new NullLitContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_nullLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			match(NULL_LIT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringLitContext extends ParserRuleContext {
		public TerminalNode STRING_LIT() { return getToken(TackParser.STRING_LIT, 0); }
		public StringLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterStringLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitStringLit(this);
		}
	}

	public final StringLitContext stringLit() throws RecognitionException {
		StringLitContext _localctx = new StringLitContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_stringLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(441);
			match(STRING_LIT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldIdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TackParser.ID, 0); }
		public FieldIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterFieldId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitFieldId(this);
		}
	}

	public final FieldIdContext fieldId() throws RecognitionException {
		FieldIdContext _localctx = new FieldIdContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_fieldId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunIdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TackParser.ID, 0); }
		public FunIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterFunId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitFunId(this);
		}
	}

	public final FunIdContext funId() throws RecognitionException {
		FunIdContext _localctx = new FunIdContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_funId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarIdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TackParser.ID, 0); }
		public VarIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterVarId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitVarId(this);
		}
	}

	public final VarIdContext varId() throws RecognitionException {
		VarIdContext _localctx = new VarIdContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_varId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(447);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqOpContext extends ParserRuleContext {
		public EqOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterEqOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitEqOp(this);
		}
	}

	public final EqOpContext eqOp() throws RecognitionException {
		EqOpContext _localctx = new EqOpContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_eqOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__1) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelOpContext extends ParserRuleContext {
		public RelOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterRelOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitRelOp(this);
		}
	}

	public final RelOpContext relOp() throws RecognitionException {
		RelOpContext _localctx = new RelOpContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_relOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddOpContext extends ParserRuleContext {
		public AddOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterAddOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitAddOp(this);
		}
	}

	public final AddOpContext addOp() throws RecognitionException {
		AddOpContext _localctx = new AddOpContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			_la = _input.LA(1);
			if ( !(_la==T__6 || _la==T__7) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultOpContext extends ParserRuleContext {
		public MultOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterMultOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitMultOp(this);
		}
	}

	public final MultOpContext multOp() throws RecognitionException {
		MultOpContext _localctx = new MultOpContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_multOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixOpContext extends ParserRuleContext {
		public PrefixOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).enterPrefixOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TackListener ) ((TackListener)listener).exitPrefixOp(this);
		}
	}

	public final PrefixOpContext prefixOp() throws RecognitionException {
		PrefixOpContext _localctx = new PrefixOpContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_prefixOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			_la = _input.LA(1);
			if ( !(_la==T__7 || _la==T__11) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3/\u01ce\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5\u00a1"+
		"\n\5\3\6\3\6\3\6\3\6\3\6\5\6\u00a8\n\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\5\t\u00b6\n\t\3\n\3\n\3\n\3\n\3\n\5\n\u00bd\n\n\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\5\20\u00cf\n\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22"+
		"\u00db\n\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00fe\n\30\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\5\31\u0106\n\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\5\33"+
		"\u0110\n\33\3\34\3\34\3\34\3\34\5\34\u0116\n\34\3\35\3\35\3\36\3\36\3"+
		"\36\3\37\3\37\3\37\3\37\3\37\5\37\u0122\n\37\3 \3 \3 \3!\3!\3!\3!\3!\5"+
		"!\u012c\n!\3\"\3\"\3\"\3#\3#\3#\3#\3#\5#\u0136\n#\3$\3$\3$\3%\3%\3%\3"+
		"%\3%\5%\u0140\n%\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\5\'\u014a\n\'\3(\3(\3(\3"+
		")\3)\3)\3)\3)\5)\u0154\n)\3*\3*\3*\3*\5*\u015a\n*\3+\3+\3+\3,\3,\3,\3"+
		",\3,\5,\u0164\n,\3-\3-\3.\3.\3.\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60"+
		"\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\64"+
		"\3\64\3\64\3\64\5\64\u0186\n\64\3\65\3\65\3\65\3\65\3\65\5\65\u018d\n"+
		"\65\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u0197\n\66\3\67\3\67"+
		"\3\67\3\67\38\38\38\38\39\39\39\39\3:\3:\3:\3:\5:\u01a9\n:\3;\3;\3;\3"+
		";\3;\5;\u01b0\n;\3<\3<\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3"+
		"C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3H\2\2I\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080"+
		"\u0082\u0084\u0086\u0088\u008a\u008c\u008e\2\7\3\2\3\4\3\2\5\b\3\2\t\n"+
		"\3\2\13\r\4\2\n\n\16\16\u01af\2\u0090\3\2\2\2\4\u0093\3\2\2\2\6\u0099"+
		"\3\2\2\2\b\u00a0\3\2\2\2\n\u00a7\3\2\2\2\f\u00a9\3\2\2\2\16\u00ad\3\2"+
		"\2\2\20\u00b5\3\2\2\2\22\u00bc\3\2\2\2\24\u00be\3\2\2\2\26\u00c2\3\2\2"+
		"\2\30\u00c4\3\2\2\2\32\u00c6\3\2\2\2\34\u00c8\3\2\2\2\36\u00ce\3\2\2\2"+
		" \u00d0\3\2\2\2\"\u00da\3\2\2\2$\u00dc\3\2\2\2&\u00e1\3\2\2\2(\u00e6\3"+
		"\2\2\2*\u00ea\3\2\2\2,\u00ed\3\2\2\2.\u00fd\3\2\2\2\60\u0105\3\2\2\2\62"+
		"\u0107\3\2\2\2\64\u010f\3\2\2\2\66\u0115\3\2\2\28\u0117\3\2\2\2:\u0119"+
		"\3\2\2\2<\u0121\3\2\2\2>\u0123\3\2\2\2@\u012b\3\2\2\2B\u012d\3\2\2\2D"+
		"\u0135\3\2\2\2F\u0137\3\2\2\2H\u013f\3\2\2\2J\u0141\3\2\2\2L\u0149\3\2"+
		"\2\2N\u014b\3\2\2\2P\u0153\3\2\2\2R\u0159\3\2\2\2T\u015b\3\2\2\2V\u0163"+
		"\3\2\2\2X\u0165\3\2\2\2Z\u0167\3\2\2\2\\\u016a\3\2\2\2^\u016f\3\2\2\2"+
		"`\u0174\3\2\2\2b\u0178\3\2\2\2d\u017c\3\2\2\2f\u0185\3\2\2\2h\u018c\3"+
		"\2\2\2j\u0196\3\2\2\2l\u0198\3\2\2\2n\u019c\3\2\2\2p\u01a0\3\2\2\2r\u01a8"+
		"\3\2\2\2t\u01af\3\2\2\2v\u01b1\3\2\2\2x\u01b5\3\2\2\2z\u01b7\3\2\2\2|"+
		"\u01b9\3\2\2\2~\u01bb\3\2\2\2\u0080\u01bd\3\2\2\2\u0082\u01bf\3\2\2\2"+
		"\u0084\u01c1\3\2\2\2\u0086\u01c3\3\2\2\2\u0088\u01c5\3\2\2\2\u008a\u01c7"+
		"\3\2\2\2\u008c\u01c9\3\2\2\2\u008e\u01cb\3\2\2\2\u0090\u0091\5\6\4\2\u0091"+
		"\u0092\7\2\2\3\u0092\3\3\2\2\2\u0093\u0094\5\u0082B\2\u0094\u0095\7\36"+
		"\2\2\u0095\u0096\7\22\2\2\u0096\u0097\5\34\17\2\u0097\u0098\5(\25\2\u0098"+
		"\5\3\2\2\2\u0099\u009a\5\4\3\2\u009a\u009b\5\b\5\2\u009b\7\3\2\2\2\u009c"+
		"\u009d\5\4\3\2\u009d\u009e\5\b\5\2\u009e\u00a1\3\2\2\2\u009f\u00a1\3\2"+
		"\2\2\u00a0\u009c\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1\t\3\2\2\2\u00a2\u00a8"+
		"\5\f\7\2\u00a3\u00a8\5\16\b\2\u00a4\u00a8\5\26\f\2\u00a5\u00a8\5\30\r"+
		"\2\u00a6\u00a8\5\32\16\2\u00a7\u00a2\3\2\2\2\u00a7\u00a3\3\2\2\2\u00a7"+
		"\u00a4\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\13\3\2\2"+
		"\2\u00a9\u00aa\7 \2\2\u00aa\u00ab\5\n\6\2\u00ab\u00ac\7!\2\2\u00ac\r\3"+
		"\2\2\2\u00ad\u00ae\7$\2\2\u00ae\u00af\5\20\t\2\u00af\u00b0\7%\2\2\u00b0"+
		"\17\3\2\2\2\u00b1\u00b2\5\24\13\2\u00b2\u00b3\5\22\n\2\u00b3\u00b6\3\2"+
		"\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00b1\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6"+
		"\21\3\2\2\2\u00b7\u00b8\7\35\2\2\u00b8\u00b9\5\24\13\2\u00b9\u00ba\5\22"+
		"\n\2\u00ba\u00bd\3\2\2\2\u00bb\u00bd\3\2\2\2\u00bc\u00b7\3\2\2\2\u00bc"+
		"\u00bb\3\2\2\2\u00bd\23\3\2\2\2\u00be\u00bf\5\u0080A\2\u00bf\u00c0\7\33"+
		"\2\2\u00c0\u00c1\5\n\6\2\u00c1\25\3\2\2\2\u00c2\u00c3\7\17\2\2\u00c3\27"+
		"\3\2\2\2\u00c4\u00c5\7\25\2\2\u00c5\31\3\2\2\2\u00c6\u00c7\7\26\2\2\u00c7"+
		"\33\3\2\2\2\u00c8\u00c9\5\16\b\2\u00c9\u00ca\7\31\2\2\u00ca\u00cb\5\36"+
		"\20\2\u00cb\35\3\2\2\2\u00cc\u00cf\5\n\6\2\u00cd\u00cf\5 \21\2\u00ce\u00cc"+
		"\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf\37\3\2\2\2\u00d0\u00d1\7\27\2\2\u00d1"+
		"!\3\2\2\2\u00d2\u00db\5$\23\2\u00d3\u00db\5&\24\2\u00d4\u00db\5(\25\2"+
		"\u00d5\u00db\5*\26\2\u00d6\u00db\5,\27\2\u00d7\u00db\5.\30\2\u00d8\u00db"+
		"\5\60\31\2\u00d9\u00db\5\62\32\2\u00da\u00d2\3\2\2\2\u00da\u00d3\3\2\2"+
		"\2\u00da\u00d4\3\2\2\2\u00da\u00d5\3\2\2\2\u00da\u00d6\3\2\2\2\u00da\u00d7"+
		"\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00d9\3\2\2\2\u00db#\3\2\2\2\u00dc"+
		"\u00dd\5\u0084C\2\u00dd\u00de\7\36\2\2\u00de\u00df\58\35\2\u00df\u00e0"+
		"\7\37\2\2\u00e0%\3\2\2\2\u00e1\u00e2\58\35\2\u00e2\u00e3\7\34\2\2\u00e3"+
		"\u00e4\58\35\2\u00e4\u00e5\7\37\2\2\u00e5\'\3\2\2\2\u00e6\u00e7\7\"\2"+
		"\2\u00e7\u00e8\5\64\33\2\u00e8\u00e9\7#\2\2\u00e9)\3\2\2\2\u00ea\u00eb"+
		"\5Z.\2\u00eb\u00ec\7\37\2\2\u00ec+\3\2\2\2\u00ed\u00ee\7\21\2\2\u00ee"+
		"\u00ef\5\u0084C\2\u00ef\u00f0\7\24\2\2\u00f0\u00f1\58\35\2\u00f1\u00f2"+
		"\5(\25\2\u00f2-\3\2\2\2\u00f3\u00f4\7\23\2\2\u00f4\u00f5\58\35\2\u00f5"+
		"\u00f6\5(\25\2\u00f6\u00f7\7\20\2\2\u00f7\u00f8\5(\25\2\u00f8\u00fe\3"+
		"\2\2\2\u00f9\u00fa\7\23\2\2\u00fa\u00fb\58\35\2\u00fb\u00fc\5(\25\2\u00fc"+
		"\u00fe\3\2\2\2\u00fd\u00f3\3\2\2\2\u00fd\u00f9\3\2\2\2\u00fe/\3\2\2\2"+
		"\u00ff\u0100\7\31\2\2\u0100\u0101\58\35\2\u0101\u0102\7\37\2\2\u0102\u0106"+
		"\3\2\2\2\u0103\u0104\7\31\2\2\u0104\u0106\7\37\2\2\u0105\u00ff\3\2\2\2"+
		"\u0105\u0103\3\2\2\2\u0106\61\3\2\2\2\u0107\u0108\7\30\2\2\u0108\u0109"+
		"\58\35\2\u0109\u010a\5(\25\2\u010a\63\3\2\2\2\u010b\u010c\5\"\22\2\u010c"+
		"\u010d\5\66\34\2\u010d\u0110\3\2\2\2\u010e\u0110\3\2\2\2\u010f\u010b\3"+
		"\2\2\2\u010f\u010e\3\2\2\2\u0110\65\3\2\2\2\u0111\u0112\5\"\22\2\u0112"+
		"\u0113\5\66\34\2\u0113\u0116\3\2\2\2\u0114\u0116\3\2\2\2\u0115\u0111\3"+
		"\2\2\2\u0115\u0114\3\2\2\2\u0116\67\3\2\2\2\u0117\u0118\5:\36\2\u0118"+
		"9\3\2\2\2\u0119\u011a\5> \2\u011a\u011b\5<\37\2\u011b;\3\2\2\2\u011c\u011d"+
		"\7&\2\2\u011d\u011e\5> \2\u011e\u011f\5<\37\2\u011f\u0122\3\2\2\2\u0120"+
		"\u0122\3\2\2\2\u0121\u011c\3\2\2\2\u0121\u0120\3\2\2\2\u0122=\3\2\2\2"+
		"\u0123\u0124\5B\"\2\u0124\u0125\5@!\2\u0125?\3\2\2\2\u0126\u0127\7\'\2"+
		"\2\u0127\u0128\5B\"\2\u0128\u0129\5@!\2\u0129\u012c\3\2\2\2\u012a\u012c"+
		"\3\2\2\2\u012b\u0126\3\2\2\2\u012b\u012a\3\2\2\2\u012cA\3\2\2\2\u012d"+
		"\u012e\5F$\2\u012e\u012f\5D#\2\u012fC\3\2\2\2\u0130\u0131\5\u0086D\2\u0131"+
		"\u0132\5F$\2\u0132\u0133\5D#\2\u0133\u0136\3\2\2\2\u0134\u0136\3\2\2\2"+
		"\u0135\u0130\3\2\2\2\u0135\u0134\3\2\2\2\u0136E\3\2\2\2\u0137\u0138\5"+
		"J&\2\u0138\u0139\5H%\2\u0139G\3\2\2\2\u013a\u013b\5\u0088E\2\u013b\u013c"+
		"\5J&\2\u013c\u013d\5H%\2\u013d\u0140\3\2\2\2\u013e\u0140\3\2\2\2\u013f"+
		"\u013a\3\2\2\2\u013f\u013e\3\2\2\2\u0140I\3\2\2\2\u0141\u0142\5N(\2\u0142"+
		"\u0143\5L\'\2\u0143K\3\2\2\2\u0144\u0145\5\u008aF\2\u0145\u0146\5N(\2"+
		"\u0146\u0147\5L\'\2\u0147\u014a\3\2\2\2\u0148\u014a\3\2\2\2\u0149\u0144"+
		"\3\2\2\2\u0149\u0148\3\2\2\2\u014aM\3\2\2\2\u014b\u014c\5R*\2\u014c\u014d"+
		"\5P)\2\u014dO\3\2\2\2\u014e\u014f\5\u008cG\2\u014f\u0150\5R*\2\u0150\u0151"+
		"\5P)\2\u0151\u0154\3\2\2\2\u0152\u0154\3\2\2\2\u0153\u014e\3\2\2\2\u0153"+
		"\u0152\3\2\2\2\u0154Q\3\2\2\2\u0155\u0156\5\u008eH\2\u0156\u0157\5R*\2"+
		"\u0157\u015a\3\2\2\2\u0158\u015a\5T+\2\u0159\u0155\3\2\2\2\u0159\u0158"+
		"\3\2\2\2\u015aS\3\2\2\2\u015b\u015c\5j\66\2\u015c\u015d\5V,\2\u015dU\3"+
		"\2\2\2\u015e\u0164\5^\60\2\u015f\u0164\5`\61\2\u0160\u0164\5b\62\2\u0161"+
		"\u0164\5d\63\2\u0162\u0164\5X-\2\u0163\u015e\3\2\2\2\u0163\u015f\3\2\2"+
		"\2\u0163\u0160\3\2\2\2\u0163\u0161\3\2\2\2\u0163\u0162\3\2\2\2\u0164W"+
		"\3\2\2\2\u0165\u0166\3\2\2\2\u0166Y\3\2\2\2\u0167\u0168\5\u0082B\2\u0168"+
		"\u0169\5\\/\2\u0169[\3\2\2\2\u016a\u016b\7$\2\2\u016b\u016c\5f\64\2\u016c"+
		"\u016d\7%\2\2\u016d\u016e\5X-\2\u016e]\3\2\2\2\u016f\u0170\7$\2\2\u0170"+
		"\u0171\5f\64\2\u0171\u0172\7%\2\2\u0172\u0173\5V,\2\u0173_\3\2\2\2\u0174"+
		"\u0175\7\33\2\2\u0175\u0176\5\n\6\2\u0176\u0177\5V,\2\u0177a\3\2\2\2\u0178"+
		"\u0179\7\32\2\2\u0179\u017a\5\u0080A\2\u017a\u017b\5V,\2\u017bc\3\2\2"+
		"\2\u017c\u017d\7 \2\2\u017d\u017e\58\35\2\u017e\u017f\7!\2\2\u017f\u0180"+
		"\5V,\2\u0180e\3\2\2\2\u0181\u0182\58\35\2\u0182\u0183\5h\65\2\u0183\u0186"+
		"\3\2\2\2\u0184\u0186\3\2\2\2\u0185\u0181\3\2\2\2\u0185\u0184\3\2\2\2\u0186"+
		"g\3\2\2\2\u0187\u0188\7\35\2\2\u0188\u0189\58\35\2\u0189\u018a\5h\65\2"+
		"\u018a\u018d\3\2\2\2\u018b\u018d\3\2\2\2\u018c\u0187\3\2\2\2\u018c\u018b"+
		"\3\2\2\2\u018di\3\2\2\2\u018e\u0197\5\u0084C\2\u018f\u0197\5n8\2\u0190"+
		"\u0197\5p9\2\u0191\u0197\5l\67\2\u0192\u0197\5x=\2\u0193\u0197\5z>\2\u0194"+
		"\u0197\5|?\2\u0195\u0197\5~@\2\u0196\u018e\3\2\2\2\u0196\u018f\3\2\2\2"+
		"\u0196\u0190\3\2\2\2\u0196\u0191\3\2\2\2\u0196\u0192\3\2\2\2\u0196\u0193"+
		"\3\2\2\2\u0196\u0194\3\2\2\2\u0196\u0195\3\2\2\2\u0197k\3\2\2\2\u0198"+
		"\u0199\7$\2\2\u0199\u019a\58\35\2\u019a\u019b\7%\2\2\u019bm\3\2\2\2\u019c"+
		"\u019d\7 \2\2\u019d\u019e\5f\64\2\u019e\u019f\7!\2\2\u019fo\3\2\2\2\u01a0"+
		"\u01a1\7$\2\2\u01a1\u01a2\5r:\2\u01a2\u01a3\7%\2\2\u01a3q\3\2\2\2\u01a4"+
		"\u01a5\5v<\2\u01a5\u01a6\5t;\2\u01a6\u01a9\3\2\2\2\u01a7\u01a9\3\2\2\2"+
		"\u01a8\u01a4\3\2\2\2\u01a8\u01a7\3\2\2\2\u01a9s\3\2\2\2\u01aa\u01ab\7"+
		"\35\2\2\u01ab\u01ac\5v<\2\u01ac\u01ad\5t;\2\u01ad\u01b0\3\2\2\2\u01ae"+
		"\u01b0\3\2\2\2\u01af\u01aa\3\2\2\2\u01af\u01ae\3\2\2\2\u01b0u\3\2\2\2"+
		"\u01b1\u01b2\5\u0080A\2\u01b2\u01b3\7\36\2\2\u01b3\u01b4\58\35\2\u01b4"+
		"w\3\2\2\2\u01b5\u01b6\7(\2\2\u01b6y\3\2\2\2\u01b7\u01b8\7+\2\2\u01b8{"+
		"\3\2\2\2\u01b9\u01ba\7)\2\2\u01ba}\3\2\2\2\u01bb\u01bc\7,\2\2\u01bc\177"+
		"\3\2\2\2\u01bd\u01be\7*\2\2\u01be\u0081\3\2\2\2\u01bf\u01c0\7*\2\2\u01c0"+
		"\u0083\3\2\2\2\u01c1\u01c2\7*\2\2\u01c2\u0085\3\2\2\2\u01c3\u01c4\t\2"+
		"\2\2\u01c4\u0087\3\2\2\2\u01c5\u01c6\t\3\2\2\u01c6\u0089\3\2\2\2\u01c7"+
		"\u01c8\t\4\2\2\u01c8\u008b\3\2\2\2\u01c9\u01ca\t\5\2\2\u01ca\u008d\3\2"+
		"\2\2\u01cb\u01cc\t\6\2\2\u01cc\u008f\3\2\2\2\31\u00a0\u00a7\u00b5\u00bc"+
		"\u00ce\u00da\u00fd\u0105\u010f\u0115\u0121\u012b\u0135\u013f\u0149\u0153"+
		"\u0159\u0163\u0185\u018c\u0196\u01a8\u01af";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}