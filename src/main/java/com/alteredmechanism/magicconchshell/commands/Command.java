package com.alteredmechanism.magicconchshell.commands;

import java.util.List;

import com.alteredmechanism.magicconchshell.ShellException;

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
