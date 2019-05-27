package com.kxw.junit.mock.web;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA
 * Author: kangxiongwei1
 * Date: 2016/1/15 16:52
 */
public class TestWebClient2 {

    @Test
    public void testGetContentOk() throws IOException {
        WebClient2 client2 = new WebClient2();
        MockURLConnectionFactory factory = new MockURLConnectionFactory();
        factory.setData(new ByteArrayInputStream("It works".getBytes()));
        String result = client2.getContent(factory);
        assertEquals("It works", result);
    }

    @Test
    public void  testGetContentOk2() throws IOException {
        MockURLConnectionFactory mockConnectionFactory = new MockURLConnectionFactory();
        MockInputStream mockStream = new MockInputStream();
        mockStream.setBuffer("It works");
        mockConnectionFactory.setData(mockStream);
        WebClient2 client = new WebClient2();
        String result = client.getContent(mockConnectionFactory);
        assertEquals("It works", result);
        mockStream.verify();
    }
}
