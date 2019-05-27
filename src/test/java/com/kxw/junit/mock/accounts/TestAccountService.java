package com.kxw.junit.mock.accounts;

import com.kxw.junit.mock.configurations.MockConfiguration;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA
 * Author: kangxiongwei1
 * Date: 2016/1/15 15:38
 */
public class TestAccountService {

    /**
     * 一般情况下，测试分为3步：
     * 1. 启动测试
     * 2. 执行测试
     * 3. 验证测试
     */
    @Test
    public void testTransferOk(){
        MockAccountManager mockAccountManager = new MockAccountManager();
        Account senderAccount = new Account("1", 200);
        Account beneficiaryAccount = new Account("2", 100);
        mockAccountManager.addAccount("1", senderAccount);
        mockAccountManager.addAccount("2", beneficiaryAccount);
        AccountService accountService = new AccountService();
        accountService.setAccountManager(mockAccountManager);

        accountService.transfer("1", "2", 50);

        assertEquals(150, senderAccount.getBalance());
        assertEquals(150, beneficiaryAccount.getBalance());
    }

    @Test
    public void testFindAccountByUser(){
        MockLog mockLog = new MockLog();
        DefaultAccountManager2 accountManager2 = new DefaultAccountManager2(mockLog, new MockConfiguration());
        Account account = accountManager2.findAccountForUser("1234");
        //assert account
    }

}
