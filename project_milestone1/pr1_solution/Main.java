import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Main {
  public static void main(final String[] args) throws IOException {
    String printSource = null, printSymTab = null,
      printIR = null, printAsm = null;
    File file = new File(args[0]);
    FileInputStream fis = null;
    fis = new FileInputStream(file);
    TackLexer lexer = new TackLexer(new ANTLRInputStream(fis));
    TackParser parser = new TackParser(new CommonTokenStream(lexer));
    parser.program();
  }
}
