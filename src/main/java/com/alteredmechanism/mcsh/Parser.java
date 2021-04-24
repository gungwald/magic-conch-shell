package com.alteredmechanism.mcsh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alteredmechanism.mcsh.commands.Command;

public class Parser {
	
	private List<Command> commands = new ArrayList<Command>();
	private StringBuilder lineInProgress = new StringBuilder();
	private boolean atEndOfInput = false;
	private CommandFactory commandFactory = new CommandFactory();

	public void appendLine(String line) {
		if (line.endsWith("\\")) {
			// Start or additional part of a continued line
			lineInProgress.append(line);
		} else if (lineInProgress.length() > 0) {
			// Last part of a continued line
			lineInProgress.append(line);
			commands.add(parseLine(lineInProgress.toString()));
			lineInProgress.setLength(0);
		} else {
			// Self-contained line
			commands.add(parseLine(line));
		}
	}
	
	private Command parseLine(String line) {
		return commandFactory.create(split(line));
	}
	
	protected List<String> split(String s) {
		return new ArrayList<String>(Arrays.asList(s.split(" ")));
	}

	public boolean isNextCommandAvailable() {
		return commands.size() > 0;
	}
	
	public Command getNextCommand() {
		if (commands.size() > 0) {
			return commands.remove(0);
		}
		return null;
	}
	
	public void setAtEndOfInput() {
		atEndOfInput = true;
	}
	
	public boolean isAtEndOfInput() {
		return atEndOfInput;
	}
}
