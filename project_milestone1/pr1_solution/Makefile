
JAVA_FILES=$(sort TackLexer.java $(wildcard *.java))
CLASS_FILES=$(patsubst %.java,classes/%.class,$(JAVA_FILES))

test: test/_run.py $(CLASS_FILES)
	-mkdir -p tmp
	test/_run.py

success.jar:
	-tar cf success.tar test/{001,002,003,004,005,006,007,008,009,010,011,018,019,020}.tack

failure.jar:
	-tar cf failure.tar test/{022,023,024}.tack

classes/%.class: $(JAVA_FILES) 
	-mkdir -p classes
	javac -g -cp /usr/local/lib/antlr-4.5-complete.jar -Xlint:unchecked -d classes $(JAVA_FILES) TackParser.java

TackLexer.java: Tack.g4  
	java -jar /usr/local/lib/antlr-4.5-complete.jar -no-listener Tack.g4  

pr1.pdf: pr1.tex
	pdflatex pr1.tex

clean:
	-rm -f TackParser.java
	-rm -f TackLexer.java
	-rm -f *.tokens
	-rm -rf classes
	-rm -rf tmp
	-rm -f pr1.pdf *.aux *.log *.out

.PHONY: test clean
