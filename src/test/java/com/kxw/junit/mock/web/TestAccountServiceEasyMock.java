package com.kxw.junit.mock.web;

import com.kxw.junit.mock.accounts.Account;
import com.kxw.junit.mock.accounts.AccountManager;
import com.kxw.junit.mock.accounts.AccountService;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA
 * Author: kangxiongwei1
 * Date: 2016/1/15 17:16
 */
public class TestAccountServiceEasyMock {

    //声明想要Mock的对象
    private AccountManager mockAccountManager;

    @Before
    public void setUp(){
        //创建mock对象
        this.mockAccountManager = EasyMock.createMock("mockAccountManager", AccountManager.class);
    }

    @Test
    public void testTransferOk(){
        //1用户有200余额，2用户100
        Account senderAccount = new Account("1", 200);
        Account beneficiaryAccount = new Account("2", 100);
        //使用EasyMock进行测试，定义预期对象
        mockAccountManager.updateAccount(senderAccount);
        mockAccountManager.updateAccount(beneficiaryAccount);
        //
        expect(mockAccountManager.findAccountForUser("1")).andReturn(senderAccount);
        expect(mockAccountManager.findAccountForUser("2")).andReturn(beneficiaryAccount);
        //预期值一旦定义完成，需要发布Mock对象
        replay(mockAccountManager);
        //开始测试逻辑
        AccountService accountService = new AccountService();
        accountService.setAccountManager(mockAccountManager);
        accountService.transfer("1", "2", 50);
        assertEquals(150, senderAccount.getBalance());
        assertEquals(150, beneficiaryAccount.getBalance());
    }

    @After
    public void tearDown(){
        verify(mockAccountManager);
    }
}
