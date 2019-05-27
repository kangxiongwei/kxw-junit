package com.kxw.junit.mock.web;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by IntelliJ IDEA
 * Author: kangxiongwei1
 * Date: 2016/1/15 16:48
 */
public class HttpURLConnectionFactory implements ConnectionFactory {

    private URL url;

    public HttpURLConnectionFactory(URL url) {
        this.url = url;
    }

    @Override
    public void setData(InputStream stream) {

    }

    @Override
    public InputStream getData() throws Exception {
        HttpURLConnection connection = (HttpURLConnection) this.url.openConnection();
        return connection.getInputStream();
    }
}
