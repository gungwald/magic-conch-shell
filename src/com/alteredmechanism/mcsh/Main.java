package com.alteredmechanism.mcsh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            Main mcsh = new Main();
            for (int i = 0; i < args.length; i++) {
                mcsh.eval(new File(args[i]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Main() {
        super();
    }

    public Object eval(File script) throws IOException, ShellException {
        return eval(new FileReader(script));
    }

    public Object eval(Reader reader) throws IOException, ShellException {
        final Parser parser = new Parser();
        Object result = null;
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            parser.appendLine(line);
            while (parser.isNextCommandAvailable()) {
                result = parser.getNextCommand().execute();
            }
        }
        while (parser.isNextCommandAvailable()) {
            result = parser.getNextCommand().execute();
        }
        return result;
    }

    public Object eval(String script) throws IOException, ShellException {
        return eval(new StringReader(script));
    }
}
