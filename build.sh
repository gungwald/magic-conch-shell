#!/bin/sh
# No need to install Ant, Maven, or Gradle. Ever tried running Gradle on a PowerPC G4? Hahahahahaaa... not.
# This is faster and simpler than any build system. Can you say "over-engineered"?

BUILD_DIR=bin
TARGET_JAR=magic-conch-shell.jar

if [ "$1" = "clean" ]
then
  rm -rf "$BUILD_DIR" "$TARGET_JAR"
  exit
fi

# shellcheck disable=SC2006
SOURCES=`find . -name '*.java' -print`
rm -rf "$BUILD_DIR" || exit
mkdir "$BUILD_DIR" || exit
# shellcheck disable=SC2086
javac $SOURCES -d "$BUILD_DIR" || exit
cd "$BUILD_DIR" || exit
# This won't work until after javac generates some classes.
# shellcheck disable=SC2006
CLASSES=`find . -name '*.class' -print`
# shellcheck disable=SC2086
jar -cvf ../"$TARGET_JAR" $CLASSES || exit
