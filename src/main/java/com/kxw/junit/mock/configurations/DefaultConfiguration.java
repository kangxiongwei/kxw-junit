package com.kxw.junit.mock.configurations;

/**
 * Created by IntelliJ IDEA
 * Author: kangxiongwei1
 * Date: 2016/1/15 16:04
 */
public class DefaultConfiguration implements Configuration {

    public DefaultConfiguration(String configurationName) {
    }

    @Override
    public String getSQL(String sqlString) {
        return null;
    }
}
