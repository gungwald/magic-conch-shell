package com.alteredmechanism.magicconchshell.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;

import com.alteredmechanism.magicconchshell.ShellException;

public class ExternalCommand extends Command {

    public ExternalCommand(List<String> arguments) {
        super(arguments);
    }

    @Override
    public int execute() throws ShellException {
        Process mvn;
        try {
            mvn = Runtime.getRuntime().exec(
                    arguments.toArray(new String[arguments.size()]));
            copyLines(mvn.getInputStream(), System.out);
            copyLines(mvn.getErrorStream(), System.err);
            return mvn.waitFor();
        } catch (Exception e) {
            throw new ShellException(e);
        }
    }

    public void copyLines(InputStream in, PrintStream out) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(in));
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null)
                break;
            else
                out.println(line);
        }
        out.flush();
    }

}
