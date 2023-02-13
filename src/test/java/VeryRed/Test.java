package VeryRed;

import veryRed.controller.Attack;
import veryRed.info.Info;
import veryRed.tools.Cmd_Tools;
import veryRed.tools.Request_Tools;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static veryRed.tools.File_Tools.Get_Poc_Json;

public class Test {
    public static void main(String[] args) {
       String url = "https://192.168.149.137/qdPM";
        System.out.println(url.substring(0,url.indexOf("/",9)));
//        Info.GET_POC();
//        String[] a = new String[]{"http://192.168.149.137/qdPM"};
//
//        // 开始测试
//        Attack attack = new Attack();
//        attack.Run(a);


    }
}
