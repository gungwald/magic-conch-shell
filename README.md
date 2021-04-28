# magic-conch-shell
A shell

Rules:
1. Java 1.5 - to enable true "Write once, run anywhere" because some systems don't support the latest version of Java, like Solaris 8 or Mac OS 10.4 for PowerPC.
1. Backport with retrotranslator...to support even more machines stuck on Java 1.4 and 1.3
1. No dependencies...because they suck
1. Ant 1.7 (Java 1.5 compatible) is used as the build system because:
	1. If the bundled Java tools, like javac and jar, are used, then both a shell script for UNIX-like systems and a batch file for Windows have to be written. Ant solves the build problem for all platforms with one script.
	1. Maven and Gradle need to download artifacts over https which does not work in Java 1.5. The https algorithms in Java 1.5 are not up-to-date with the protocol being used on servers. The latest versions of Java do not support compiling to a 1.5 target.

