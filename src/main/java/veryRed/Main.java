package veryRed;


import veryRed.tools.Cmd;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] urls = Cmd.get_url(args);
        if(urls.length == 0){
            System.out.println("url文件为空");
            System.exit(-1);
        }
        for (String s : urls) {
            System.out.println(s);
        }
    }
}
