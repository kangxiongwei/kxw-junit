package com.kxw.junit.mock.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by IntelliJ IDEA
 * Author: kangxiongwei1
 * Date: 2016/1/15 16:35
 */
public class MockHttpURLConnection extends HttpURLConnection {

    private InputStream stream;

    public MockHttpURLConnection() {
        super(null);
    }

    protected MockHttpURLConnection(URL url) {
        super(url);
    }

    public void setExpectedInputStream(InputStream stream) {
        this.stream = stream;
    }

    public InputStream getInputStream() throws IOException {
        return this.stream;
    }

    @Override
    public void disconnect() {

    }

    @Override
    public boolean usingProxy() {
        return false;
    }

    @Override
    public void connect() throws IOException {

    }
}
