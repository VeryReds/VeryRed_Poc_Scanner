package veryRed.controller;

import veryRed.entity.PocJsonObject;
import veryRed.info.Info;
import veryRed.tools.Request_Tools;

import java.io.IOException;

/**
 * 攻击模块
 */
public class Attack {
    /**
     * 启动攻击模块
     * @param urls 检测地址
     * @return 是否成功，成功 true，失败 false
     */
    public boolean Run(String[] urls){
        // 遍历urls与poc
        Request_Tools request_tools = new Request_Tools();

        for (String url : urls) {
            for (PocJsonObject poc : Info.POCS) {
                try {
                    request_tools.http_request(url,poc);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return false;
    }


}
