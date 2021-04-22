rem @echo off

setlocal EnableDelayedExpansion

set BUILD_DIR=bin
set TARGET_JAR=magic-conch-shell.jar

if "%1"=="clean" (
    del "%TARGET_JAR%"
    rmdir /s/q "%BUILD_DIR%"
    exit /b
)

rem Theoretically just the main class could be passed to the compiler and it
rem would automatically find all the dependencies. But, if the main class
rem package or name was changed, it would break the build and this file would
rem have to be update. This method is less fragile and more change resistent.
for /f %%f in ('dir /b/s *.java') do (
    set SOURCES=!SOURCES! %%f
)
rmdir /s/q "%BUILD_DIR%" || exit /b
mkdir "%BUILD_DIR%" || exit /b
javac %SOURCES% -d "%BUILD_DIR%" || exit /b
cd "%BUILD_DIR%" || exit /b

rem This won't work until after javac generates some classes.
rem Finding all the individual class files doesn't work because they will have
rem absolute paths, so the path in the jar file ends up being wrong.
for /f %%c in ('dir /b/d') do (
    set CLASS_DIRS=!CLASS_DIRS! %%c
)
cd ..
jar -cvf "%TARGET_JAR%" -C %BUILD_DIR% %CLASS_DIRS% || exit /b

endlocal
