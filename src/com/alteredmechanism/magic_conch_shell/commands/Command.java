package com.alteredmechanism.magic_conch_shell.commands;

import java.util.List;

public abstract class Command {

	protected List<String> arguments;
	
	public Command(List<String> arguments) {
		this.arguments = arguments;
	}
	
	public List<String> getParameters() {
		return arguments;
	}
	
	public abstract int execute();
}
