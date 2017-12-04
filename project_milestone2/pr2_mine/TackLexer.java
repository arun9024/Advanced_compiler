// Generated from Tack.g4 by ANTLR 4.5
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TackLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NULL_LIT=1, BOOL_LIT=2, EQ=3, FUN=4, IF=5, IN=6, ELSE=7, FOR=8, WHILE=9, 
		INT_TYPE=10, BOOL_TYPE=11, STRING_TYPE=12, VOID_TYPE=13, LBRACKET=14, 
		RBRACKET=15, LCURLY=16, RCURLY=17, LPAREN=18, RPAREN=19, ARROW=20, DOT=21, 
		COLON=22, COLONEQ=23, SEMI=24, COMMA=25, ADD_OP=26, MULT_OP=27, SUB_OP=28, 
		DIV_OP=29, MOD_OP=30, EQUAL_OP=31, NOTEQUAL_OP=32, LESSEQUAL_OP=33, LESS_OP=34, 
		GREATEQUAL_OP=35, GREAT_OP=36, NOT_OP=37, LOGIC_OR_OP=38, LOGIC_AND_OP=39, 
		ID=40, STRING_LIT=41, INT_LIT=42, WS=43, NEWLINE=44, COMMENT=45;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"NULL_LIT", "BOOL_LIT", "EQ", "FUN", "IF", "IN", "ELSE", "FOR", "WHILE", 
		"INT_TYPE", "BOOL_TYPE", "STRING_TYPE", "VOID_TYPE", "LBRACKET", "RBRACKET", 
		"LCURLY", "RCURLY", "LPAREN", "RPAREN", "ARROW", "DOT", "COLON", "COLONEQ", 
		"SEMI", "COMMA", "ADD_OP", "MULT_OP", "SUB_OP", "DIV_OP", "MOD_OP", "EQUAL_OP", 
		"NOTEQUAL_OP", "LESSEQUAL_OP", "LESS_OP", "GREATEQUAL_OP", "GREAT_OP", 
		"NOT_OP", "LOGIC_OR_OP", "LOGIC_AND_OP", "ID", "ESCAPED_QUOTE", "STRING_LIT", 
		"INT_LIT", "WS", "NEWLINE", "COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'null'", null, "'='", "'fun'", "'if'", "'in'", "'else'", "'for'", 
		"'while'", "'int'", "'bool'", "'string'", "'void'", "'['", "']'", "'{'", 
		"'}'", "'('", "')'", "'->'", "'.'", "':'", "':='", "';'", "','", "'+'", 
		"'*'", "'-'", "'/'", "'%'", "'=='", "'!='", "'<='", "'<'", "'>='", "'>'", 
		"'!'", "'||'", "'&&'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "NULL_LIT", "BOOL_LIT", "EQ", "FUN", "IF", "IN", "ELSE", "FOR", 
		"WHILE", "INT_TYPE", "BOOL_TYPE", "STRING_TYPE", "VOID_TYPE", "LBRACKET", 
		"RBRACKET", "LCURLY", "RCURLY", "LPAREN", "RPAREN", "ARROW", "DOT", "COLON", 
		"COLONEQ", "SEMI", "COMMA", "ADD_OP", "MULT_OP", "SUB_OP", "DIV_OP", "MOD_OP", 
		"EQUAL_OP", "NOTEQUAL_OP", "LESSEQUAL_OP", "LESS_OP", "GREATEQUAL_OP", 
		"GREAT_OP", "NOT_OP", "LOGIC_OR_OP", "LOGIC_AND_OP", "ID", "STRING_LIT", 
		"INT_LIT", "WS", "NEWLINE", "COMMENT"
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


	public TackLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Tack.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2/\u0117\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\5\3n\n\3\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3"+
		"\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3"+
		"\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3!\3!\3\""+
		"\3\"\3\"\3#\3#\3$\3$\3$\3%\3%\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\7)\u00de"+
		"\n)\f)\16)\u00e1\13)\3*\3*\3*\3+\3+\3+\7+\u00e9\n+\f+\16+\u00ec\13+\3"+
		"+\3+\3,\3,\3,\7,\u00f3\n,\f,\16,\u00f6\13,\5,\u00f8\n,\3-\3-\3-\6-\u00fd"+
		"\n-\r-\16-\u00fe\3-\3-\3.\3.\3.\5.\u0106\n.\3/\3/\7/\u010a\n/\f/\16/\u010d"+
		"\13/\3/\5/\u0110\n/\3/\3/\5/\u0114\n/\3/\3/\3\u00ea\2\60\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S\2U+W,Y-[.]/\3\2\b\4\2C\\c|\5\2\62;C\\c|\4\2\f\f\17\17\3"+
		"\2\63;\3\2\62;\5\2\13\f\17\17\"\"\u0122\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2"+
		"\2\2]\3\2\2\2\3_\3\2\2\2\5m\3\2\2\2\7o\3\2\2\2\tq\3\2\2\2\13u\3\2\2\2"+
		"\rx\3\2\2\2\17{\3\2\2\2\21\u0080\3\2\2\2\23\u0084\3\2\2\2\25\u008a\3\2"+
		"\2\2\27\u008e\3\2\2\2\31\u0093\3\2\2\2\33\u009a\3\2\2\2\35\u009f\3\2\2"+
		"\2\37\u00a1\3\2\2\2!\u00a3\3\2\2\2#\u00a5\3\2\2\2%\u00a7\3\2\2\2\'\u00a9"+
		"\3\2\2\2)\u00ab\3\2\2\2+\u00ae\3\2\2\2-\u00b0\3\2\2\2/\u00b2\3\2\2\2\61"+
		"\u00b5\3\2\2\2\63\u00b7\3\2\2\2\65\u00b9\3\2\2\2\67\u00bb\3\2\2\29\u00bd"+
		"\3\2\2\2;\u00bf\3\2\2\2=\u00c1\3\2\2\2?\u00c3\3\2\2\2A\u00c6\3\2\2\2C"+
		"\u00c9\3\2\2\2E\u00cc\3\2\2\2G\u00ce\3\2\2\2I\u00d1\3\2\2\2K\u00d3\3\2"+
		"\2\2M\u00d5\3\2\2\2O\u00d8\3\2\2\2Q\u00db\3\2\2\2S\u00e2\3\2\2\2U\u00e5"+
		"\3\2\2\2W\u00f7\3\2\2\2Y\u00fc\3\2\2\2[\u0105\3\2\2\2]\u0107\3\2\2\2_"+
		"`\7p\2\2`a\7w\2\2ab\7n\2\2bc\7n\2\2c\4\3\2\2\2de\7v\2\2ef\7t\2\2fg\7w"+
		"\2\2gn\7g\2\2hi\7h\2\2ij\7c\2\2jk\7n\2\2kl\7u\2\2ln\7g\2\2md\3\2\2\2m"+
		"h\3\2\2\2n\6\3\2\2\2op\7?\2\2p\b\3\2\2\2qr\7h\2\2rs\7w\2\2st\7p\2\2t\n"+
		"\3\2\2\2uv\7k\2\2vw\7h\2\2w\f\3\2\2\2xy\7k\2\2yz\7p\2\2z\16\3\2\2\2{|"+
		"\7g\2\2|}\7n\2\2}~\7u\2\2~\177\7g\2\2\177\20\3\2\2\2\u0080\u0081\7h\2"+
		"\2\u0081\u0082\7q\2\2\u0082\u0083\7t\2\2\u0083\22\3\2\2\2\u0084\u0085"+
		"\7y\2\2\u0085\u0086\7j\2\2\u0086\u0087\7k\2\2\u0087\u0088\7n\2\2\u0088"+
		"\u0089\7g\2\2\u0089\24\3\2\2\2\u008a\u008b\7k\2\2\u008b\u008c\7p\2\2\u008c"+
		"\u008d\7v\2\2\u008d\26\3\2\2\2\u008e\u008f\7d\2\2\u008f\u0090\7q\2\2\u0090"+
		"\u0091\7q\2\2\u0091\u0092\7n\2\2\u0092\30\3\2\2\2\u0093\u0094\7u\2\2\u0094"+
		"\u0095\7v\2\2\u0095\u0096\7t\2\2\u0096\u0097\7k\2\2\u0097\u0098\7p\2\2"+
		"\u0098\u0099\7i\2\2\u0099\32\3\2\2\2\u009a\u009b\7x\2\2\u009b\u009c\7"+
		"q\2\2\u009c\u009d\7k\2\2\u009d\u009e\7f\2\2\u009e\34\3\2\2\2\u009f\u00a0"+
		"\7]\2\2\u00a0\36\3\2\2\2\u00a1\u00a2\7_\2\2\u00a2 \3\2\2\2\u00a3\u00a4"+
		"\7}\2\2\u00a4\"\3\2\2\2\u00a5\u00a6\7\177\2\2\u00a6$\3\2\2\2\u00a7\u00a8"+
		"\7*\2\2\u00a8&\3\2\2\2\u00a9\u00aa\7+\2\2\u00aa(\3\2\2\2\u00ab\u00ac\7"+
		"/\2\2\u00ac\u00ad\7@\2\2\u00ad*\3\2\2\2\u00ae\u00af\7\60\2\2\u00af,\3"+
		"\2\2\2\u00b0\u00b1\7<\2\2\u00b1.\3\2\2\2\u00b2\u00b3\7<\2\2\u00b3\u00b4"+
		"\7?\2\2\u00b4\60\3\2\2\2\u00b5\u00b6\7=\2\2\u00b6\62\3\2\2\2\u00b7\u00b8"+
		"\7.\2\2\u00b8\64\3\2\2\2\u00b9\u00ba\7-\2\2\u00ba\66\3\2\2\2\u00bb\u00bc"+
		"\7,\2\2\u00bc8\3\2\2\2\u00bd\u00be\7/\2\2\u00be:\3\2\2\2\u00bf\u00c0\7"+
		"\61\2\2\u00c0<\3\2\2\2\u00c1\u00c2\7\'\2\2\u00c2>\3\2\2\2\u00c3\u00c4"+
		"\7?\2\2\u00c4\u00c5\7?\2\2\u00c5@\3\2\2\2\u00c6\u00c7\7#\2\2\u00c7\u00c8"+
		"\7?\2\2\u00c8B\3\2\2\2\u00c9\u00ca\7>\2\2\u00ca\u00cb\7?\2\2\u00cbD\3"+
		"\2\2\2\u00cc\u00cd\7>\2\2\u00cdF\3\2\2\2\u00ce\u00cf\7@\2\2\u00cf\u00d0"+
		"\7?\2\2\u00d0H\3\2\2\2\u00d1\u00d2\7@\2\2\u00d2J\3\2\2\2\u00d3\u00d4\7"+
		"#\2\2\u00d4L\3\2\2\2\u00d5\u00d6\7~\2\2\u00d6\u00d7\7~\2\2\u00d7N\3\2"+
		"\2\2\u00d8\u00d9\7(\2\2\u00d9\u00da\7(\2\2\u00daP\3\2\2\2\u00db\u00df"+
		"\t\2\2\2\u00dc\u00de\t\3\2\2\u00dd\u00dc\3\2\2\2\u00de\u00e1\3\2\2\2\u00df"+
		"\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0R\3\2\2\2\u00e1\u00df\3\2\2\2"+
		"\u00e2\u00e3\7^\2\2\u00e3\u00e4\7$\2\2\u00e4T\3\2\2\2\u00e5\u00ea\7$\2"+
		"\2\u00e6\u00e9\5S*\2\u00e7\u00e9\n\4\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e7"+
		"\3\2\2\2\u00e9\u00ec\3\2\2\2\u00ea\u00eb\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb"+
		"\u00ed\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ed\u00ee\7$\2\2\u00eeV\3\2\2\2\u00ef"+
		"\u00f8\7\62\2\2\u00f0\u00f4\t\5\2\2\u00f1\u00f3\t\6\2\2\u00f2\u00f1\3"+
		"\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5"+
		"\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00ef\3\2\2\2\u00f7\u00f0\3\2"+
		"\2\2\u00f8X\3\2\2\2\u00f9\u00fd\t\7\2\2\u00fa\u00fd\5[.\2\u00fb\u00fd"+
		"\5]/\2\u00fc\u00f9\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fb\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\3\2"+
		"\2\2\u0100\u0101\b-\2\2\u0101Z\3\2\2\2\u0102\u0103\7\17\2\2\u0103\u0106"+
		"\7\f\2\2\u0104\u0106\t\4\2\2\u0105\u0102\3\2\2\2\u0105\u0104\3\2\2\2\u0106"+
		"\\\3\2\2\2\u0107\u010b\7%\2\2\u0108\u010a\n\4\2\2\u0109\u0108\3\2\2\2"+
		"\u010a\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010f"+
		"\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u0110\7\17\2\2\u010f\u010e\3\2\2\2"+
		"\u010f\u0110\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u0114\5[.\2\u0112\u0114"+
		"\7\2\2\3\u0113\u0111\3\2\2\2\u0113\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115"+
		"\u0116\b/\2\2\u0116^\3\2\2\2\17\2m\u00df\u00e8\u00ea\u00f4\u00f7\u00fc"+
		"\u00fe\u0105\u010b\u010f\u0113\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}