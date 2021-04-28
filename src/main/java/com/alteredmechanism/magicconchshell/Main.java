package com.alteredmechanism.magicconchshell;

import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {

    /**
     * Executions start here
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            MagicConchShell mcsh = new MagicConchShell();
            if (args.length == 0) {
                mcsh.eval(new InputStreamReader(System.in));
            } else {
                for (int i = 0; i < args.length; i++) {
                    if (args[i].equals("-c")) {
                        mcsh.eval(args[++i]);
                    } else {
                        mcsh.eval(new FileReader(args[i]));
                    }
                } 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
