package com.kxw.junit.mock.accounts;

import com.kxw.junit.mock.configurations.Configuration;
import com.kxw.junit.mock.configurations.DefaultConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Created by IntelliJ IDEA
 * Author: kangxiongwei1
 * Date: 2016/1/15 15:56
 */
public class DefaultAccountManager2 implements AccountManager {

    /**
     * Logger instance.
     */
    private Log logger;

    /**
     * Configuration to use.
     */
    private Configuration configuration;

    /**
     * Constructor with no parameters.
     */
    public DefaultAccountManager2() {
        this(LogFactory.getLog(DefaultAccountManager2.class), new DefaultConfiguration("technical"));
    }

    /**
     * Constructor with logger and configration parameters.
     *
     * @param logger
     * @param configuration
     */
    public DefaultAccountManager2(Log logger, Configuration configuration)
    {
        this.logger = logger;
        this.configuration = configuration;
    }

    /**
     * Finds an account for user with the given userID.
     *
     * @param
     */
    public Account findAccountForUser(String userId)
    {
        this.logger.debug("Getting account for user [" + userId + "]");
        this.configuration.getSQL("FIND_ACCOUNT_FOR_USER");

        // Some code logic to load a user account using JDBC
        return null;
    }

    /**
     * Updates the given account.
     */
    public void updateAccount(Account account)
    {
        // Perform database access here
    }
}
