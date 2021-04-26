package com.alteredmechanism.magicconchshell;

import java.util.List;

import com.alteredmechanism.magicconchshell.commands.Command;
import com.alteredmechanism.magicconchshell.commands.CommentCommand;
import com.alteredmechanism.magicconchshell.commands.CpCommand;
import com.alteredmechanism.magicconchshell.commands.EchoCommand;
import com.alteredmechanism.magicconchshell.commands.ExternalCommand;

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
