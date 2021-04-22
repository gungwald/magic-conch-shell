@echo off

set CLAZZ_PATH=magic-conch-shell.jar;lib/bsf-api-3.1.jar
set MAIN_CLASS=com.alteredmechanism.magic_conch_shell.MagicConchShell 

java -classpath %CLAZZ_PATH% %MAIN_CLASS% %*
