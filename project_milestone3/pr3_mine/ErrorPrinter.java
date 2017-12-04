import java.io.IOException;

class ErrorPrinter {
  static int _numErrors;
  ErrorPrinter() { _numErrors = 0; }
  static void exit() {
    if (_numErrors == 0)
      System.exit(0);
    System.err.println("There were " + _numErrors + " errors.");
    System.exit(-1);      
  }

  static void print(Location loc, String msg) {
    _numErrors++;
    System.err.println(loc.toString() + ": " + msg + ".");
  }
}
