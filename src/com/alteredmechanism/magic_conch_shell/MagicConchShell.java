package com.alteredmechanism.magic_conch_shell;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import javax.script.AbstractScriptEngine;
import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptException;

public class MagicConchShell extends AbstractScriptEngine {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MagicConchShell mcsh = new MagicConchShell();
			for (int i = 0; i < args.length; i++) {
				mcsh.eval(new File(args[i]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MagicConchShell() {
		super();
	}

	public MagicConchShell(Bindings bindings) {
		super(bindings);
	}

	public Bindings createBindings() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object eval(File script) throws FileNotFoundException, ScriptException {
		return eval(new FileReader(script), getContext());
	}
	
	public Object eval(Reader reader, ScriptContext context) throws ScriptException {
		final Parser parser = new Parser();
		Object result = null;
		try {
			BufferedReader in = new BufferedReader(reader);
			String line;
			while ((line = in.readLine()) != null) {
				parser.appendLine(line);
				while (parser.isNextCommandAvailable()) {
					result = parser.getNextCommand().execute();
				}
			}
			while (parser.isNextCommandAvailable()) {
				result = parser.getNextCommand().execute();
			}
		} catch (IOException e) {
			throw new ScriptException(e);
		}
		return result;
	}

	public Object eval(String script, ScriptContext context) throws ScriptException {
		return eval(new StringReader(script), context);
	}

	public ScriptEngineFactory getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
