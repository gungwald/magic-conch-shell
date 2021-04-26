package com.alteredmechanism.magicconchshell.javax.script;

import java.util.Arrays;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;

import com.alteredmechanism.magicconchshell.MagicConchShell;

public class MagicConchShellFactory implements ScriptEngineFactory {
    private static final List<String> NAMES = Arrays.asList(new String[] {"Magic Conch Shell", "magic conch shell", "MagicConchShell", "magic-conch-shell", "magicconchshell", "mcsh"});
    private static final List<String> EXTENSIONS = Arrays.asList(new String[] {"sh"});

    public String getEngineName() {
        return "Magic Conch Shell";
    }

    public String getEngineVersion() {
        return "0.01";
    }

    public List<?> getExtensions() {
        return EXTENSIONS;
    }

    public String getLanguageName() {
        return "Bourne-Again Shell";
    }

    public String getLanguageVersion() {
        return "5.1";
    }

    public String getMethodCallSyntax(String objectName, String method, String[] args) {
        return null;
    }

    public List<?> getMimeTypes() {
        return null;
    }

    public List<?> getNames() {
        return NAMES;
    }

    public String getOutputStatement(String toDisplay) {
        return null;
    }

    public Object getParameter(String key) {
        return null;
    }

    public String getProgram(String[] statements) {
        return null;
    }

    public ScriptEngine getScriptEngine() {
        return new MagicConchShell();
    }
}
