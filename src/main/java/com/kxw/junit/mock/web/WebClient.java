package com.kxw.junit.mock.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by IntelliJ IDEA
 * Author: kangxiongwei1
 * Date: 2016/1/15 16:24
 */
public class WebClient {

    public String getContent(URL url) {
        StringBuffer content = new StringBuffer();
        try {
            HttpURLConnection connection = createHttpURLConnection(url);
            InputStream is = connection.getInputStream();
            int count;
            byte[] buffer = new byte[2048];
            while ((count = is.read(buffer)) != -1){
                content.append(new String(buffer, 0, count));
            }
        } catch (IOException e) {
           return null;
        }
        return content.toString();
    }

    protected HttpURLConnection createHttpURLConnection(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

}
