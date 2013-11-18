package org.xander.spring.springIdol.springTesting;

public interface AccountDao {
    void createAccount(Account account);
    void updateAccount(Account account);
    void removeAccount(Account account);
    Account findAccount(String accountNo);
}
