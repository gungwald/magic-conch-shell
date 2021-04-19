package com.alteredmechanism.magic_conch_shell;

import java.util.List;

import com.alteredmechanism.magic_conch_shell.commands.Command;
import com.alteredmechanism.magic_conch_shell.commands.EchoCommand;
import com.alteredmechanism.magic_conch_shell.commands.ExternalCommand;

public class CommandFactory {
	
	public Command create(List<String> arguments) {
		String cmd = arguments.get(0);
		if (cmd.equalsIgnoreCase("echo")) {
			return new EchoCommand(arguments);
		} else {
			return new ExternalCommand(arguments);
		}
	}
}
