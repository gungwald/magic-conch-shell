#!/bin/sh
PKG_DIR=com/alteredmechanism/magic_conch_shell
rm -rf bin || exit
javac -cp lib/bsf-api-3.1.jar src/$PKG_DIR/*.java -d bin || exit
jar -cvf magic-conch-shell.jar -C bin com/$PKG_DIR/*.class || exit