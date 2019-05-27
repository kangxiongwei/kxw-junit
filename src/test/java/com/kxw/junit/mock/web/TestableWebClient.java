package com.kxw.junit.mock.web;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by IntelliJ IDEA
 * Author: kangxiongwei1
 * Date: 2016/1/15 16:30
 */
public class TestableWebClient extends WebClient {

    private HttpURLConnection connection;

    public void setHttpURLConnection(HttpURLConnection connection) {
        this.connection = connection;
    }

    public HttpURLConnection createHttpURLConnection(URL url) throws IOException {
        return this.connection;
    }


}
