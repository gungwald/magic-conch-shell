@echo off

set THIS_SCRIPT_ABS_PATH=%~dp0
set TOP_DIR=%THIS_SCRIPT_ABS_PATH%..
set JAR_DIR=%TOP_DIR%/share/java
set CLAZZ_PATH=%JAR_DIR%/magic-conch-shell.jar:%JAR_DIR%/bsf-api-3.1.jar
set MAIN_CLASS=com.alteredmechanism.magicconchshell.Main

java -classpath %CLAZZ_PATH% %MAIN_CLASS% %*
