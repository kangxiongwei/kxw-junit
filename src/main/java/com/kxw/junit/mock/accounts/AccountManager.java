package com.kxw.junit.mock.accounts;

public interface AccountManager {

    Account findAccountForUser(String userId);

    void updateAccount(Account account);
}