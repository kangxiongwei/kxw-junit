package com.kxw.junit.stub;

import com.kxw.junit.stubs.WebClient;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mortbay.jetty.HttpHeaders;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.util.ByteArrayISO8859Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by IntelliJ IDEA
 * Author: kangxiongwei1
 * Date: 2016/1/15 12:03
 * 使用stub对http请求进行测试
 * stub the jetty server
 */
public class TestWebClient {

    @BeforeClass
    public static void setUp() throws Exception{
        Server server = new Server(8080);
        TestWebClient client = new TestWebClient();

        Context contentOkContext = new Context(server, "/testGetContentOk");
        contentOkContext.setHandler(client.new TestGetContentOkHandler());

        Context contentNotFoundContext = new Context(server, "/testGetContentNotFound");
        contentNotFoundContext.setHandler(client.new TestGetContentNotFoundHandler());

        server.setStopAtShutdown(true);
        server.start();
    }

    @Test
    public void testGetContentOk() throws MalformedURLException {
        WebClient webClient = new WebClient();
        String result = webClient.getContent(new URL("http://localhost:8080/testGetContentOk"));
        assertEquals("It works", result);
    }

    @Test
    public void testGetContentNotFound() throws Exception {
        WebClient client = new WebClient();
        String result = client.getContent(new URL("http://localhost:8080/testGetContentNotFound"));
        assertNull(result);
    }

    @AfterClass
    public static void tearDown(){

    }

    /**
     * 处理请求，使请求结果为：It works
     */
    private class TestGetContentOkHandler extends AbstractHandler {
        public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch)
                throws IOException, ServletException {
            OutputStream out = response.getOutputStream();
            ByteArrayISO8859Writer writer = new ByteArrayISO8859Writer();
            writer.write("It works");
            writer.flush();
            response.setIntHeader(HttpHeaders.CONTENT_LENGTH, writer.size());
            writer.writeTo(out);
            out.flush();
        }
    }

    /**
     * 未找到资源处理
     */
    public class TestGetContentNotFoundHandler extends AbstractHandler {

        public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch)
                throws IOException, ServletException {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }



}
