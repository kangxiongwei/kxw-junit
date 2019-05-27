package com.kxw.junit.mock.service;

import com.kxw.junit.mock.dao.UserDao;
import com.kxw.junit.mock.entity.User;

/**
 * Created by kangxiongwei on 2017/8/24 11:38.
 */
public class UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 更新用户
     *
     * @param id
     */
    public void update(Integer id, User user) {
        User u = this.userDao.getById(id);
        if (u == null) throw new RuntimeException("需要更新的用户不存在");
        u.setUsername(user.getUsername());
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        this.userDao.update(u);
    }


}
