package veryRed;


import veryRed.tools.Cmd;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        for (String s : Cmd.get_url(args)) {
            System.out.println(s);
        }
    }
}
