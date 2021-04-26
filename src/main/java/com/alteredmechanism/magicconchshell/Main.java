package com.alteredmechanism.magicconchshell;

import java.io.FileReader;

public class Main {

    /**
     * Executions start here
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            MagicConchShell mcsh = new MagicConchShell();
            for (String scriptName : args) {
                mcsh.eval(new FileReader(scriptName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
