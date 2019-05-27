package com.kxw.junit.mock.web;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by IntelliJ IDEA
 * Author: kangxiongwei1
 * Date: 2016/1/15 16:24
 */
public class WebClient2 {

    public String getContent(ConnectionFactory connectionFactory) throws IOException {
        String result;
        StringBuffer content = new StringBuffer();
        InputStream is = null;
        try {
            is = connectionFactory.getData();
            int count;
            while (-1 != (count = is.read())) {
                content.append(new String(Character.toChars(count)));
            }
            result = content.toString();
        } catch (Exception e) {
            result = null;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    result = null;
                }
            }
        }
        return result;
    }

}
