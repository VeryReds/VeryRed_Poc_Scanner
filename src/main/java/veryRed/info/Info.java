package veryRed.info;

import veryRed.entity.PocJsonObject;
import veryRed.tools.File_Tools;

import java.util.List;



/**
 * 静态数据
 */
public class Info {
    public static List<PocJsonObject> POCS;

    public static void GET_POC(){
        POCS = File_Tools.Get_Poc_Json();
    }
}


