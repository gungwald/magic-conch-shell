package com.alteredmechanism.mcsh;

import java.util.List;

import com.alteredmechanism.mcsh.commands.Command;
import com.alteredmechanism.mcsh.commands.EchoCommand;
import com.alteredmechanism.mcsh.commands.ExternalCommand;

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
