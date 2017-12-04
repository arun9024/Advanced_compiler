import java.io.IOException;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

class ErrorPrinter extends BaseErrorListener {
  static int _count;
  ErrorPrinter() { _count = 0; }
  static void exit() {
    if (0 == _count)
      System.exit(0);
    if (1 == _count)
      System.err.println("There was 1 error.");
    else
      System.err.println("There were " + _count + " errors.");
    System.exit(-1);      
  }
  static void print(Location loc, String msg) {
    _count++;
    System.err.println(loc.toString() + ": " + msg + ".");
  }
/* Underline listener from the ANTLR book */
  public void syntaxError(Recognizer<?, ?> recognizer,
                          Object offendingSymbol,
                          int line, int charPositionInLine, String msg,
                          RecognitionException e)
  {
    _count++;
    Token tok = (Token)offendingSymbol;
    String source = tok.getTokenSource().getSourceName();
    System.err.println(source+":"+line+":"+(charPositionInLine+1)+": "+msg);
    underlineError(recognizer,(Token)offendingSymbol,
                   line, charPositionInLine);
  }

  protected void underlineError(Recognizer recognizer,
                                Token offendingToken, int line,
                                int charPositionInLine) {
    CommonTokenStream tokens =
        (CommonTokenStream)recognizer.getInputStream();
    String input = tokens.getTokenSource().getInputStream().toString();
    String[] lines = input.split("\n");
    try {
      String errorLine = lines[line - 1];
      System.err.println(errorLine);
      for (int i=0; i<charPositionInLine; i++)
        System.err.print(" "); int start = offendingToken.getStartIndex();
      int stop = offendingToken.getStopIndex();
      if ( start>=0 && stop>=0 ) {
        for (int i=start; i<=stop; i++) System.err.print("^");
      }
      System.err.println();
    } catch (ArrayIndexOutOfBoundsException e) {
    }
  }
}
