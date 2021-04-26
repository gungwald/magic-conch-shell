package com.alteredmechanism.magicconchshell.commands;

import java.util.List;


public class EchoCommand extends Command {

	public EchoCommand(List<String> arguments) {
		super(arguments);
	}

	@Override
	public int execute() {
		for (int i = 1; i < arguments.size(); i++) {
			System.out.print(arguments.get(i));
			if (i < arguments.size() - 1) {
				System.out.print(' ');
			}
		}
		System.out.println();
		return 0;
	}

}
