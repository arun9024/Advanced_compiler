import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

class Main {
  public static void main(String[] args) throws IOException {
    String printSource = null, printSymTab = null,
      printIR = null, printAsm = null;
    TackLexer lexer = new TackLexer(new ANTLRFileStream(args[0]));
    TackParser parser = new TackParser(new CommonTokenStream(lexer));
    parser.removeErrorListeners();
    parser.addErrorListener(new ErrorPrinter());
    AstNode rawAst= parser.program().v;
    if (0 < ErrorPrinter._count)
      ErrorPrinter.exit();
    TreeNormalizer normalizer = new TreeNormalizer();
    AstNode ast = (AstNode)rawAst.accept(normalizer);
    ScopeAnalyzer scopeAnalyzer = new ScopeAnalyzer();
    ast.accept(scopeAnalyzer);
    Intrinsics.defIntrinsics(scopeAnalyzer._symTab);
    SemanticAnalyzer semanticAnalyzer =
      new SemanticAnalyzer(scopeAnalyzer._symTab);
    ast.accept(semanticAnalyzer);
    if (0 < ErrorPrinter._count)
      ErrorPrinter.exit();
    PrintWriter writer = new PrintWriter(System.out, true);
    scopeAnalyzer._symTab.print(writer);
  }
}
