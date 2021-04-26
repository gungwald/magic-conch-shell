package com.alteredmechanism.magicconchshell.commands;

import java.util.List;

import com.alteredmechanism.magicconchshell.ShellException;

public class CpCommand extends Command {

    public CpCommand(List<String> arguments) {
        super(arguments);
    }

    @Override
    public int execute() throws ShellException {
        if (System.getProperty("os.name").startsWith("Windows")) {
            arguments.set(0, "copy");
        }
        ExternalCommand cp = new ExternalCommand(arguments);
        return cp.execute();
    }
}
