package com.kxw.junit.mock.web;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by IntelliJ IDEA
 * Author: kangxiongwei1
 * Date: 2016/1/15 17:35
 *
 * EasyMock进行单元测试步骤：
 * 1. 使用 EasyMock 生成 Mock 对象；
 * 2. 设定 Mock 对象的预期行为和输出；
 * 3. 将 Mock 对象切换到 Replay 状态；
 * 4. 调用 Mock 对象方法进行单元测试；
 * 5. 对 Mock 对象的行为进行验证。
 */
public class TestWebClientEasyMock {

    private ConnectionFactory factory;

    private ByteArrayInputStream stream;

    @Before
    public void setUp() {
        factory = createMock("factory", ConnectionFactory.class);
        stream = createMock("stream", ByteArrayInputStream.class);
    }

    @Test
    public void testGetContentOk() throws Exception {
        expect(factory.getData()).andReturn(stream);
        expect(stream.read()).andReturn((int) 'W');
        expect(stream.read()).andReturn((int) 'o');
        expect(stream.read()).andReturn((int) 'r');
        expect(stream.read()).andReturn((int) 'k');
        expect(stream.read()).andReturn((int) 's');
        expect(stream.read()).andReturn((int) '!');

        expect(stream.read()).andReturn(-1);
        stream.close();

        replay(factory);
        replay(stream);

        WebClient2 client = new WebClient2();

        String result = client.getContent(factory);

        assertEquals("Works!", result);
    }

    @Test
    public void testGetContentInputStreamNull() throws Exception {
        expect(factory.getData()).andReturn(null);

        replay(factory);
        replay(stream);

        WebClient2 client = new WebClient2();

        String result = client.getContent(factory);

        assertNull(result);
    }

    @Test
    public void testGetContentCannotCloseInputStream() throws Exception {
        expect(factory.getData()).andReturn(stream);
        expect(stream.read()).andReturn(-1);
        stream.close();
        expectLastCall().andThrow(new IOException("cannot close"));

        replay(factory);
        replay(stream);

        WebClient2 client = new WebClient2();
        String result = client.getContent(factory);

        assertNull(result);
    }

    @After
    public void tearDown() {
        verify(factory);
        verify(stream);
    }
}
