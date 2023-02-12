package veryRed.tools;

/**
 * cmd 工具模块
 */
public class Cmd_Tools {
    public static String[] get_url(String[] ages){
        if(ages.length!=2){
            System.out.println("参数错误：java -jar VeryRed_Poc_Scanner.jar [-u or -f] [url or file_url]");
            System.exit(-1);
        }
        if(ages[0].equals("-u")){
            return new String[]{ages[1]};
        }else if(ages[0].equals("-f")){
            return File_Tools.Get_Url(ages[1]);
        }else {
            System.out.println("参数错误：java -jar VeryRed_Poc_Scanner.jar [-u or -f] [url or file_url]");
            System.exit(-1);
        }



        return null;
    }
}
