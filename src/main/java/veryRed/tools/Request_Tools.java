package veryRed.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Request_Tools {
    public void request() throws IOException {
        Socket client = new Socket();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("192.168.149.137", 80);
        // 建立TCP连接，虚拟机的地址为192.168.194.129
        // Nginx监听的端口设置为8080
        client.connect(inetSocketAddress, 1000);
        String request = "GET /index.html HTTP/1.1\r\n"+
                "Host: 192.168.194.129:80\r\n";
        PrintWriter pWriter = new PrintWriter(client.getOutputStream(),true);
        pWriter.println(request);

        String tem;
        // 这里要注意二进制字节流转换为字符流编码要使用UTF-8
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream(), "utf-8"));
        while((tem = bufferedReader.readLine())!=null) {
            System.out.println(tem);
        }

        client.close();
    }
}
