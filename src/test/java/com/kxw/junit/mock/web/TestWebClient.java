package com.kxw.junit.mock.web;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA
 * Author: kangxiongwei1
 * Date: 2016/1/15 16:29
 */
public class TestWebClient {

    @Test
    public void testGetContentOk() throws MalformedURLException {
        MockHttpURLConnection mockConnection = new MockHttpURLConnection();
        mockConnection.setExpectedInputStream(new ByteArrayInputStream("It works".getBytes()));
        //通过集成来覆盖父类的参数connection，从而通过重写connection来进行测试
        TestableWebClient client = new TestableWebClient();
        client.setHttpURLConnection(mockConnection);

        String result = client.getContent(new URL("http://localhost"));
        assertEquals("It works", result);
    }

}
