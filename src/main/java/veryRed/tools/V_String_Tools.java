package veryRed.tools;

import veryRed.entity.HttpResponseObject;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class V_String_Tools {
    private static Map<String,String> map;
    public static String V_Expression(String str, HttpResponseObject httpResponseObject){
        // 判断是否存在表达式
        String pattern = "^\\[V\\]\\{.*?\\}$";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        if(m.find()){
            if (m.group(1).equals("PATH")) {
                str=httpResponseObject.getUrl()+httpResponseObject.getPath();
            }
        }
        return str;
    }

}
