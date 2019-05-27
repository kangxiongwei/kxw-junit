package com.kxw.junit.mock.service;

import com.kxw.junit.mock.dao.UserDao;
import com.kxw.junit.mock.entity.User;
import org.junit.Before;
import org.junit.Test;

import static org.easymock.EasyMock.*;

/**
 * Created by kangxiongwei on 2017/8/24 11:42.
 */
public class UserServiceTest {

    private UserService userService;
    private UserDao userDao;

    /**
     * 初始化
     */
    @Before
    public void setUp() {
        userDao = createMock("userDao", UserDao.class);
        userService = new UserService();
        userService.setUserDao(userDao);
    }

    /**
     * 测试更新用户
     */
    @Test
    public void testUpdateNoException() {
        //重置Mock对象状态和行为
        reset(userDao);
        //录制行为
        User user = new User();
        user.setId(1);
        user.setUsername("zhangsan");
        user.setFirstName("zhang");
        user.setLastName("san");
        expect(userDao.getById(1)).andReturn(user).times(1);
        userDao.update(user);
        expectLastCall().times(1);
        //录制结束，声明期望
        replay(userDao);
        //回放行为
        userService.update(1, user);
        //验证
        verify(userDao);
    }

    /**
     * 测试抛出异常
     */
    @Test(expected = RuntimeException.class)
    public void testUpdateWithException() {
        reset(userDao);
        expect(userDao.getById(1)).andReturn(null);
        replay(userDao);
        userService.update(1, null);
        verify(userDao);
    }

}
