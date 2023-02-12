package VeryRed;

import veryRed.info.Info;
import veryRed.tools.Request_Tools;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static veryRed.tools.File_Tools.Get_Poc_Json;

public class Test {
    public static void main(String[] args) {

        Request_Tools request_tools = new Request_Tools();
        try {
            request_tools.request();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
