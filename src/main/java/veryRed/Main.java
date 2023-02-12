package veryRed;


import veryRed.controller.Attack;
import veryRed.info.Info;
import veryRed.tools.Cmd_Tools;

public class Main {
    public static void main(String[] args) {
        Info.GET_POC();

        String[] urls = Cmd_Tools.get_url(args);
        if(urls.length == 0){
            System.out.println("url文件为空");
            System.exit(-1);
        }
        // 开始测试
        Attack attack = new Attack();
        attack.Run(urls);
    }
}
