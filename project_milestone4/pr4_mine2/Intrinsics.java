import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;


import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

class Intrinsics {
  private static void defIntrinsic(SymbolTable symTab, String name, String typeString) {
    if (symTab.contains(name)) {
      ErrorPrinter.print(symTab.get(name).loc(),
                         "Redefinition of intrinsic '" + name + "'");
      return;
    }
    TackLexer lexer = null;
    try {
      lexer = new TackLexer(new ANTLRFileStream(typeString));
    } catch (final IOException e) {
      assert false;
    }

    TackParser parser = new TackParser(new CommonTokenStream(lexer));

    final Tester tester = (Tester)parser.tester().v;
    final FunType rawTypeAst = tester._raw;
    final TreeNormalizer normalizer = new TreeNormalizer();
    final FunType typeAst = (FunType)rawTypeAst.accept(normalizer);
    final FunId id = new FunId(null, name);
    final FunDef fun = new FunDef(null, id, typeAst, (BlockStmt)null);
    final FunSym sym = new FunSym(symTab._current, fun);
    symTab.def(sym);
  }

  static void defIntrinsics(SymbolTable symTab) {
    defIntrinsic(symTab, "append", "append.g4");
    defIntrinsic(symTab, "bool2int", "bool2int.g4");
    defIntrinsic(symTab, "bool2string", "bool2string.g4");
    defIntrinsic(symTab, "int2bool", "int2bool.g4");
    defIntrinsic(symTab, "int2string", "int2string.g4");    
    defIntrinsic(symTab, "length", "length.g4");
    defIntrinsic(symTab, "newArray", "newArray.g4");
    defIntrinsic(symTab, "newRecord", "newRecord.g4");
    defIntrinsic(symTab, "print", "print.g4");
    defIntrinsic(symTab, "range", "range.g4");
    defIntrinsic(symTab, "size", "size.g4");
    defIntrinsic(symTab, "string2bool", "string2bool.g4");
    defIntrinsic(symTab, "string2int", "string2int.g4");    
    defIntrinsic(symTab, "stringEqual", "stringEqual.g4");    
  }

  static FunSym get(SymbolTable symTab, String name) {
    FunSym result = (FunSym)symTab._topLevel.get(name);
    assert null != result : name;
    return result;
  }
}
