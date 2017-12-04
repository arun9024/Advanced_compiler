import java.io.IOException;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;

public class Location implements Comparable {

  public final String file;
  public final int line;
  public final int column;
  public Location(String file, int line, int column) {
    this.file   = file;
    this.line   = line;
    this.column = column;
  }

  public Location(ParserRuleContext ctx) {
    Token firstToken = ctx.getStart();
    this.file = firstToken.getTokenSource().getSourceName();
    this.line = firstToken.getLine();
    this.column = firstToken.getCharPositionInLine() + 1;
  }

  public int hashCode() {
    return file.hashCode() + line * 7 + column;
  }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (! (o instanceof Location)) return false;
    Location other = (Location)o;
    if (! file.equals(other.file)) return false;
    if (line != other.line) return false;
    return column == other.column;
  }

  public int compareTo(Object o) {
    Location other = (Location)o;

    if (! file.equals(other.file)) {
      return file.compareTo(other.file);
    } else if (line != other.line) {
      return (line < other.line ? -1 : 1);
    } else {
      return (column < other.column ? -1 : (column == other.column ? 0 : 1));
    }
  }

  public void write(Appendable out) throws IOException {
    out.append(file);
    out.append(':');
    out.append(Integer.toString(line));
    out.append(':');
    out.append(Integer.toString(column));
  }

  public String toString() {
    StringBuilder buf = new StringBuilder();

    buf.append(file);
    buf.append(':');
    buf.append(line);
    buf.append(':');
    buf.append(column);

    return buf.toString();
  }    

}
