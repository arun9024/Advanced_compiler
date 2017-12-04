import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

class Main {
  public static void main(final String[] args) throws IOException {
    String printSource = null, printSymTab = null,
      printIR = null, printAsm = null;
    TackLexer lexer = new TackLexer(new ANTLRFileStream(args[0]));
    TackParser parser = new TackParser(new CommonTokenStream(lexer));
    AstNode rawAst = parser.program().v;
    final PrintWriter writer = new PrintWriter(System.out, true);
    final SyntaxTreePrinter syntaxTreePrinter = new SyntaxTreePrinter(writer);
    System.out.println("--- Raw AST ----");
    rawAst.accept(syntaxTreePrinter);
    final TreeNormalizer normalizer = new TreeNormalizer();
    final AstNode ast = (AstNode)rawAst.accept(normalizer);
    System.out.println("--- Normalized AST ----");
    ast.accept(syntaxTreePrinter);
  }
}
