package veryRed.tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 文件处理工具类
 */
public class File {
    public static String[] get_url(String path){
        String[] urls={};
        int index = 0;
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while (line != null) {
                urls[index] = line;
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return urls;
    }
}
