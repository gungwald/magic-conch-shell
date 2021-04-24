package com.alteredmechanism.mcsh;

import java.util.List;

import com.alteredmechanism.mcsh.commands.Command;
import com.alteredmechanism.mcsh.commands.CommentCommand;
import com.alteredmechanism.mcsh.commands.CpCommand;
import com.alteredmechanism.mcsh.commands.EchoCommand;
import com.alteredmechanism.mcsh.commands.ExternalCommand;

public class CommandFactory {
	
	public Command create(List<String> arguments) {
		String cmd = arguments.get(0);
        if (cmd.startsWith("#")) {
            return new CommentCommand(arguments);
        } else if (cmd.equals("echo")) {
			return new EchoCommand(arguments);
        } else if (cmd.equals("cp")) {
			return new CpCommand(arguments);
		} else {
			return new ExternalCommand(arguments);
		}
	}
}
