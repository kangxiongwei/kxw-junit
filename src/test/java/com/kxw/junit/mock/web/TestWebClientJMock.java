package com.kxw.junit.mock.web;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA
 * Author: kangxiongwei1
 * Date: 2016/1/15 19:02
 */
@RunWith(JMock.class)
public class TestWebClientJMock {

    private Mockery context = new JUnit4Mockery() {
        {
            setImposteriser(ClassImposteriser.INSTANCE);
        }
    };

    @Test
    public void testGetContentOk() throws Exception {
        final ConnectionFactory factory = context.mock(ConnectionFactory.class);
        final InputStream stream = context.mock(InputStream.class);
        context.checking(new Expectations() {
            {
                oneOf(factory).getData();
                will(returnValue(stream));
                atLeast(1).of(stream).read();
                will(onConsecutiveCalls(
                    returnValue(new Integer((byte) 'W')),
                    returnValue(new Integer((byte) 'o')),
                    returnValue(new Integer((byte) 'r')),
                    returnValue(new Integer((byte) 'k')),
                    returnValue(new Integer((byte) 's')),
                    returnValue(new Integer((byte) '!')),
                    returnValue(-1))
                );
                oneOf(stream).close();
            }
        });
        WebClient2 client2 = new WebClient2();
        String result = client2.getContent(factory);
        assertEquals("Works!", result);
    }

}
