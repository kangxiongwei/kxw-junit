package com.kxw.junit.mock.dao;

import com.kxw.junit.mock.entity.User;

/**
 * Created by kangxiongwei on 2017/8/24 11:36.
 */
public interface UserDao {

    User getById(Integer id);

    void update(User user);
}
