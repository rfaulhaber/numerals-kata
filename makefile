JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = src/Main.java

# complile into .class files
default: classes

classes: $(CLASSES:.java=.class)

# remove build files
clean:
	$(RM) src/*.class
