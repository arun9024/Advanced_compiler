JAVA_FILES=$(sort TackLexer.java TackParser.java $(wildcard *.java))
CLASS_FILES=$(patsubst %.java,classes/%.class,$(JAVA_FILES))

test: test/_run.py $(CLASS_FILES) IRInterpreter.jar
	-mkdir -p tmp
	test/_run.py

test.tar:
	-tar cf test.tar test/{001,002,003,004,005,006,007,008,009,010,011,018,019,020}.*

classes/%.class: $(JAVA_FILES)
	-mkdir -p classes
	javac -g -cp /usr/local/lib/antlr-4.5.1-complete.jar -Xlint:unchecked -d classes $(JAVA_FILES)


TackLexer.java TackParser.java: Tack.g4
	java -jar /usr/local/lib/antlr-4.5.1-complete.jar -no-listener -no-visitor Tack.g4

IRInterpreter.jar: manifest.txt $(CLASS_FILES)
	jar cfm $@ $< -C classes .

pr4.pdf: pr4.tex
	pdflatex pr4.tex
	pdflatex pr4.tex

clean:
	-rm -f TackParser.java
	-rm -f TackLexer.java
	-rm -f TackBaseListener.java
	-rm -f TackListener.java
	-rm -f TackBaseVisitor.java
	-rm -f TackVisitor.java
	-rm -f *.tokens
	-rm -rf classes
	-rm -rf tmp
	-rm -f pr4.pdf *.aux *.log *.out
	-rm -f IRInterpreter.jar

.PHONY: test clean
