import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
  public static void main(final String[] args) throws IOException {
    String printSource = null, printSymTab = null,
      printIR = null, printAsm = null;
    TackLexer lexer = new TackLexer(new ANTLRFileStream(args[0]));
    TackParser parser = new TackParser(new CommonTokenStream(lexer));

    AstNode rawAst = parser.program().v;

    final TreeNormalizer normalizer = new TreeNormalizer();
    final AstNode ast = (AstNode)rawAst.accept(normalizer);
    final PrintWriter writer = new PrintWriter(System.out, true);
    final SyntaxTreePrinter syntaxTreePrinter = new SyntaxTreePrinter(writer);
    ast.accept(syntaxTreePrinter);
  }
}


// class Main {
//   public static void main(final String[] args) throws IOException {
//     String fileName = args[0];
//     final Reader reader = new FileReader(fileName);
//     final TackParser parser = new TackParser(reader, fileName);
//     final xtc.parser.Result result = parser.pprogram(0);
//     if (!result.hasValue()) {
//       Location loc = parser.location(result.index);
//       System.err.println(loc.toString() + ": Syntax error.");
//       System.exit(-1);
//     }
//     final AstNode rawAst = (AstNode)result.semanticValue();
//     final TreeNormalizer normalizer = new TreeNormalizer();
//     final AstNode ast = (AstNode)rawAst.accept(normalizer);
//     final PrintWriter writer = new PrintWriter(System.out, true);
//     final SyntaxTreePrinter syntaxTreePrinter = new SyntaxTreePrinter(writer);
//     ast.accept(syntaxTreePrinter);
//   }
// }
