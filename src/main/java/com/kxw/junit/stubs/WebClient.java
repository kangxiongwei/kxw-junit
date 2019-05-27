package com.kxw.junit.stubs;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by IntelliJ IDEA
 * Author: kangxiongwei1
 * Date: 2016/1/15 11:39
 */
public class WebClient {

    /**
     * 根据一个url来获取http响应
     *
     * @param url
     * @return
     */
    public String getContent(URL url) {
        StringBuffer content = new StringBuffer();
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream is = connection.getInputStream();
            //将is的输入流内容读取出来，并全部拼接成字符串
            int count;
            byte[] buffer = new byte[2048];
            while (-1 != (count = is.read(buffer))){
                content.append(new String(buffer, 0, count));
            }

        } catch (IOException e) {
            return null;
        }
        return content.toString();
    }


}
