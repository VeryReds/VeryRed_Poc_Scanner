package veryRed.tools;

import veryRed.entity.HttpResponseObject;
import veryRed.entity.PocJsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.*;

public class Request_Tools {
    /**
     * 获取 ip 端口
     * @param url
     * @return
     */
    public static String[] GetIp(String url){
        String[] ip_prot = url.split("://");
        if(ip_prot[1].contains("/")){
            ip_prot = Arrays.copyOf(ip_prot,3);
            ip_prot[2]= ip_prot[1].substring(ip_prot[1].indexOf("/"),ip_prot[1].length());
            ip_prot[1] = ip_prot[1].split("/")[0];

        }
        if(ip_prot[1].contains(":")){
            ip_prot = ip_prot[1].split(":");
        }else if(ip_prot[0].startsWith("https")){
            ip_prot[0]=ip_prot[1];
            ip_prot[1]="443";
        }else {
            ip_prot[0]=ip_prot[1];
            ip_prot[1]="80";
        }

        return ip_prot;
    }


    /**
     * sockt http请求
     * @param url
     * @param pocs
     * @return
     * @throws IOException
     */
    public List<HttpResponseObject>  http_request(String url, PocJsonObject pocs) throws IOException {
        List<HttpResponseObject> httpResponseObjects = new ArrayList<>();

        String[] ip_prot = GetIp(url);
        Socket client = new Socket();

        for (PocJsonObject.Req req : pocs.getReq()) {
            HttpResponseObject httpResponseObject = new HttpResponseObject();
            httpResponseObject.setUrl(url.substring(0,url.indexOf("/",9)));

            InetSocketAddress inetSocketAddress = new InetSocketAddress(ip_prot[0], Integer.parseInt(ip_prot[1]));

            client.connect(inetSocketAddress, 1000);
            String request = "";

            if(ip_prot.length==2){
                httpResponseObject.setPath(req.getUrl());
                request =String.format("%s %s HTTP/1.1\r\n",req.getRequest(),req.getUrl())+
                        String.format("Host: %s:%s\r\n",ip_prot[0],ip_prot[1]);
            }else {
                httpResponseObject.setPath(ip_prot[2]+"/"+req.getUrl());
                request =String.format("%s %s HTTP/1.1\r\n",req.getRequest(),httpResponseObject.getPath())+
                        String.format("Host: %s:%s\r\n",ip_prot[0],ip_prot[1]);
            }


            String finalRequest = request;
            HttpResponseObject finalHttpResponseObject = httpResponseObject;
            req.getHeader().forEach((k, v) ->{
                v=V_String_Tools.V_Expression(v, finalHttpResponseObject);
                        String.format("%s\r\n%s: %s", finalRequest,k,v);
                    }

            );
            request= finalRequest;

            if(!req.getBody().equals("")){
                request+="\r\n"+req.getBody()+"\r\n";
            }

            PrintWriter pWriter = new PrintWriter(client.getOutputStream(),true);
            pWriter.println(request);

            String tem;
            // 这里要注意二进制字节流转换为字符流编码要使用UTF-8
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream(), "utf-8"));
            int index = 0;

            Map<String,String> headermap = new HashMap<>();
            String body = "";
            while((tem = bufferedReader.readLine())!=null) {
                if(index==1 && tem.equals("")){
                    index++;
                }else if (index==0){
                    httpResponseObject.setStatusCode(Integer.parseInt(tem.split(" ")[1]));
                    index++;
                }else if(index==1){
                    String[] header = tem.split(": ");
                    headermap.put(header[0],header[1]);
                }else if(index==2){
                    body+=tem+"\r\n";
                }
            }

            httpResponseObject.setHeaders(headermap);
            httpResponseObject.setBody(body);
            httpResponseObjects.add(httpResponseObject);
            client.close();
        }

        return httpResponseObjects;
    }
}
