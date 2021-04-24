package com.alteredmechanism.mcsh;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;

import javax.script.AbstractScriptEngine;
import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptException;

public class MagicConchShell extends AbstractScriptEngine {

    public MagicConchShell() {
        // TODO Auto-generated constructor stub
    }

    public MagicConchShell(Bindings bindings) {
        super(bindings);
        // TODO Auto-generated constructor stub
    }

    public Bindings createBindings() {
        // TODO Auto-generated method stub
        return null;
    }

    public Object eval(Reader reader, ScriptContext context) throws ScriptException {
        Object result = null;
        try {
            final Parser parser = new Parser();
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
        } catch (Exception e) {
            throw new ScriptException(e);
        }
        return result;
    }

    public Object eval(String script, ScriptContext context)
            throws ScriptException {
        return eval(new StringReader(script));
    }

    public ScriptEngineFactory getFactory() {
        // TODO Auto-generated method stub
        return null;
    }

}
