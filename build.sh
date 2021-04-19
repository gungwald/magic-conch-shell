#!/bin/sh
CLASSPATH=lib/bsf-api-3.1.jar
PKG_DIR=com/alteredmechanism/magic_conch_shell
SRCS="src/$PKG_DIR/*.java src/$PKG_DIR/commands/*.java"
CLASSES=`cd bin; ls $PKG_DIR/*.class $PKG_DIR/commands/*.class`
rm -rf bin || exit
mkdir bin
javac -cp $CLASSPATH $SRCS -d bin || exit
cd bin
jar -cvf ../magic-conch-shell.jar $CLASSES || exit