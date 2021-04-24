package com.alteredmechanism.mcsh.commands;

import java.util.List;

import com.alteredmechanism.mcsh.ShellException;

public abstract class Command {

	protected List<String> arguments;
	
	public Command(List<String> arguments) {
		this.arguments = arguments;
	}
	
	public List<String> getParameters() {
		return arguments;
	}
	
	public abstract int execute() throws ShellException;
}
