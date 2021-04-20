#!/bin/sh
CLASSPATH=lib/bsf-api-3.1.jar
PKG_DIR=com/alteredmechanism/magic_conch_shell
SRCS="src/$PKG_DIR/*.java src/$PKG_DIR/commands/*.java"
rm -rf bin || exit
mkdir bin || exit
javac -classpath $CLASSPATH $SRCS -d bin || exit
cd bin || exit
# This won't work until after javac generates some classes.
CLASSES="$PKG_DIR/*.class $PKG_DIR/commands/*.class"
jar -cvf ../magic-conch-shell.jar $CLASSES || exit
