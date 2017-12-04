import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

class Main {
  static PrintWriter pfw(String fileName) throws IOException {
    return new PrintWriter(new FileWriter(fileName), true);
  }

  public static void main(final String[] args) throws IOException {
    String fileName = args[0];
    final TackLexer lexer = new TackLexer(new ANTLRFileStream(fileName));
    final TackParser parser = new TackParser(new CommonTokenStream(lexer));
    parser.removeErrorListeners();
    parser.addErrorListener(new ErrorPrinter());
    final AstNode rawAst = parser.program().v;
    if (0 < ErrorPrinter._count)
      ErrorPrinter.exit();
    final TreeNormalizer normalizer = new TreeNormalizer();
    final Program ast = (Program)rawAst.accept(normalizer);
    ScopeAnalyzer scopeAnalyzer = new ScopeAnalyzer();
    ast.accept(scopeAnalyzer);
    Intrinsics.defIntrinsics(scopeAnalyzer._symTab);
    SemanticAnalyzer semanticAnalyzer =
      new SemanticAnalyzer(scopeAnalyzer._symTab);
    ast.accept(semanticAnalyzer);
    if (0 < ErrorPrinter._count)
      ErrorPrinter.exit();
    IRGenerator irGenerator = new IRGenerator(scopeAnalyzer._symTab);
    ast.accept(irGenerator);
    IRPrinter visitor = new IRPrinter(new PrintWriter(System.out, true));
    ast.accept(visitor);
  }
}
