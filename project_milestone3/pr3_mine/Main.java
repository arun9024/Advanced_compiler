import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
  static PrintWriter pfw(String fileName) throws IOException {
    return new PrintWriter(new FileWriter(fileName), true);
  }

  public static void main(final String[] args) throws IOException {
    TackLexer lexer = new TackLexer(new ANTLRFileStream(args[0]));
    TackParser parser = new TackParser(new CommonTokenStream(lexer));

    AstNode rawAst = parser.program().v;

    final TreeNormalizer normalizer = new TreeNormalizer();
    final AstNode ast = (AstNode)rawAst.accept(normalizer);
    
    ScopeAnalyzer scopeAnalyzer = new ScopeAnalyzer();
    ast.accept(scopeAnalyzer);
    Intrinsics.defIntrinsics(scopeAnalyzer._symTab);
    SemanticAnalyzer semanticAnalyzer =
      new SemanticAnalyzer(scopeAnalyzer._symTab);
    ast.accept(semanticAnalyzer);
    if (ErrorPrinter._numErrors > 0) {
      ErrorPrinter.exit();
    }
    System.out.print("Program ");
    semanticAnalyzer._symTab.print(new PrintWriter(System.out, true));
  }
}
