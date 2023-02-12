package veryRed.tools;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import veryRed.entity.PocJsonObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件处理工具类
 */
public class File_Tools {
    /**
     * 获取url文件
     * @param path url路径
     * @return url数据
     */
    public static String[] Get_Url(String path){
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

    public static List<PocJsonObject> Get_Poc_Json() {
        System.out.println("Get_Poc_Json()调用");
        List<PocJsonObject> pocs = new ArrayList<>();
        // 创建File对象，代表目录路径
        File directory = new File("./file/poc");

        // 创建FileFilter，用于过滤所有JSON文件
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(".json");
            }
        };

        // 获取目录下所有符合条件的文件
        File[] jsonFiles = directory.listFiles(fileFilter);

        // 遍历所有文件
        for (File jsonFile : jsonFiles) {
            // 打印文件名
            // 创建FileInputStream对象，用于读取文件

            FileInputStream inputStream = null;
            try {
                inputStream = new FileInputStream(new File("./file/poc/"+jsonFile.getName()));
                // 创建InputStreamReader对象，用于读取文件内容
                InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
                StringBuilder sb = new StringBuilder();
                char[] buf = new char[1024];
                int len = 0;
                while ((len = reader.read(buf)) != -1) {
                    sb.append(buf, 0, len);
                }
                reader.close();
                String jsonString = sb.toString();
                // 使用Fastjson的parseObject方法将文件内容转换为Java对象
                PocJsonObject poc = JSON.parseObject(jsonString, PocJsonObject.class);

                // 打印转换后的对象
                pocs.add(poc);
            } catch (IOException e) {
                System.out.println("读取失败:"+jsonFile.getName());
            }

        }
        return pocs;
    }
}
