JCC = javac

# just builds the program
default:
	mkdir bin
	$(JCC) -d bin -sourcepath src src/Main.java

clean: 
	$(RM) src/*.class
	$(RM) -r out/