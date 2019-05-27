package com.kxw.junit.stubs;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by IntelliJ IDEA
 * Author: kangxiongwei1
 * Date: 2016/1/15 14:19
 * <p/>
 * 一个HttpURLConnection的stub实现，为了返回你想测试的任意字符串
 */
public class StubHttpURLConnection extends HttpURLConnection {

    private boolean isInput = true;

    public StubHttpURLConnection(URL url) {
        super(url);
    }

    /**
     * 重写该方法，因为HttpURLConnection只有该方法被WebClient使用，返回字符串"It works"
     *
     * @throws IOException
     */
    @Override
    public InputStream getInputStream() throws IOException {
        if (!isInput) {
            throw new ProtocolException("Cannot read from URLConnection if doInput=false (call setDoInput(true))");
        }
        return new ByteArrayInputStream("It works".getBytes());
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
