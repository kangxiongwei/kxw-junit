package com.kxw.junit.mock.web;

import java.io.InputStream;

/**
 * Created by IntelliJ IDEA
 * Author: kangxiongwei1
 * Date: 2016/1/15 16:50
 */
public class MockURLConnectionFactory implements ConnectionFactory {

    private InputStream stream;

    public void setData(InputStream stream) {
        this.stream = stream;
    }

    @Override
    public InputStream getData() throws Exception {
        return stream;
    }
}
