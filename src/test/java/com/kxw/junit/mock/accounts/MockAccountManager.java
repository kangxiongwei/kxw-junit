package com.kxw.junit.mock.accounts;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA
 * Author: kangxiongwei1
 * Date: 2016/1/15 14:58
 */
public class MockAccountManager implements AccountManager {

    private Map<String, Account> accounts = new HashMap<String, Account>();

    public void addAccount(String userId, Account account) {
        this.accounts.put(userId, account);
    }

    @Override
    public Account findAccountForUser(String userId) {
        return this.accounts.get(userId);
    }

    @Override
    public void updateAccount(Account account) {
        for (Map.Entry<String, Account> ac : accounts.entrySet()) {
            if (ac.getValue().getAccountId().equalsIgnoreCase(account.getAccountId())) {
                accounts.put(ac.getKey(), account);
            }
        }
    }

}
