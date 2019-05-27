package com.kxw.junit.mock.web;

import java.io.InputStream;

/**
 * Created by IntelliJ IDEA
 * Author: kangxiongwei1
 * Date: 2016/1/15 16:45
 */
public interface ConnectionFactory {

    void setData(InputStream stream);

    InputStream getData() throws Exception;

}
