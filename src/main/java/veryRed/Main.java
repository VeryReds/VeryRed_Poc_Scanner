package veryRed;


import veryRed.controller.Attack;
import veryRed.tools.Cmd;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] urls = Cmd.get_url(args);
        if(urls.length == 0){
            System.out.println("url文件为空");
            System.exit(-1);
        }

        Attack attack = new Attack();
        attack.Run(urls);
    }
}
