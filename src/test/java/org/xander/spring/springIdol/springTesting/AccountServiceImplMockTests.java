package org.xander.spring.springIdol.springTesting;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class AccountServiceImplMockTests {
    private static final String TEST_ACCOUNT_NO = "1234";
    private EasyMock easyMock;
    private AccountDao accountDao;
    private AccountService accountService;
    @Before
    public void init() {
        accountDao = easyMock.createMock(AccountDao.class) ;
        accountService = new AccountServiceImpl(accountDao);
    }
    @Ignore
    @Test
    public void deposit() {
        Account account = new Account(TEST_ACCOUNT_NO, 100);
        accountDao.findAccount(TEST_ACCOUNT_NO);
        easyMock.expectLastCall().andReturn(account);
        account.setBalance(150);
        accountDao.updateAccount(account);
        easyMock.replay();
        accountService.deposit(TEST_ACCOUNT_NO, 50);
        easyMock.verify();
    }
    @Ignore
    @Test
    public void withdrawWithSufficientBalance() {
        Account account = new Account(TEST_ACCOUNT_NO, 100);
        accountDao.findAccount(TEST_ACCOUNT_NO);
        easyMock.expectLastCall().andReturn(account);
        account.setBalance(50);
        accountDao.updateAccount(account);
        easyMock.replay();
        accountService.withdraw(TEST_ACCOUNT_NO, 50);
        easyMock.verify();
    }
    @Ignore
    @Test(expected = InsufficientBalanceException.class)
    public void testWithdrawWithInsufficientBalance() {
        Account account = new Account(TEST_ACCOUNT_NO, 100);
        accountDao.findAccount(TEST_ACCOUNT_NO);
        easyMock.expectLastCall().andReturn(account);
        easyMock.replay();
        accountService.withdraw(TEST_ACCOUNT_NO, 150);
        easyMock.verify();
    }
}
