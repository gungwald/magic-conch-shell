@echo off

set CLAZZ_PATH=magic-conch-shell.jar
set MAIN_CLASS=com.alteredmechanism.mcsh.Main 

java -classpath %CLAZZ_PATH% %MAIN_CLASS% %*
