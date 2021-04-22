package com.alteredmechanism.mcsh.commands;

import java.util.List;

import com.alteredmechanism.mcsh.ShellException;

public class CpCommand extends Command {

    public CpCommand(List<String> arguments) {
        super(arguments);
    }

    @Override
    public int execute() throws ShellException {
        ExternalCommand cp = new ExternalCommand(arguments);
        return cp.execute();
    }

}
