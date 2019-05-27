package com.kxw.junit.mock.web;

import com.kxw.junit.mock.accounts.Account;
import com.kxw.junit.mock.accounts.AccountManager;
import com.kxw.junit.mock.accounts.AccountService;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA
 * Author: kangxiongwei1
 * Date: 2016/1/15 18:45
 */
@RunWith(JMock.class)
public class TestAccountServiceJMock {

    private Mockery context = new JUnit4Mockery();
    private AccountManager mockAccountManager;

    @Before
    public void setUp() {
        mockAccountManager = context.mock(AccountManager.class);
    }

    @Test
    public void testTransferOk() {
        final Account senderAccount = new Account("1", 200);
        final Account beneficiaryAccount = new Account("2", 100);
        context.checking(new Expectations() {
            {
                oneOf(mockAccountManager).findAccountForUser("1");
                will(returnValue(senderAccount));
                oneOf(mockAccountManager).findAccountForUser("2");
                will(returnValue(beneficiaryAccount));
                oneOf(mockAccountManager).updateAccount(senderAccount);
                oneOf(mockAccountManager).updateAccount(beneficiaryAccount);
            }
        });

        AccountService accountService = new AccountService();
        accountService.setAccountManager(mockAccountManager);
        accountService.transfer("1", "2", 50);
        assertEquals(150, senderAccount.getBalance());
        assertEquals(150, beneficiaryAccount.getBalance());
    }
}
