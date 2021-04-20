#!/bin/sh
# No need to install Ant, Maven, or Gradle. Ever tried running Gradle on a PowerPC G4? Hahahahahaaa... not.
# This is faster and simpler than any build system. Can you say "over-engineered"?
CLASSPATH=lib/bsf-api-3.1.jar
# shellcheck disable=SC2006
SOURCES=`find . -name '*.java' -print`
rm -rf bin || exit
mkdir bin || exit
# shellcheck disable=SC2086
javac -classpath $CLASSPATH $SOURCES -d bin || exit
cd bin || exit
# This won't work until after javac generates some classes.
# shellcheck disable=SC2006
CLASSES=`find . -name '*.class' -print`
# shellcheck disable=SC2086
jar -cvf ../magic-conch-shell.jar $CLASSES || exit
