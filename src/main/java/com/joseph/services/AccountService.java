package com.joseph.services;

import com.joseph.models.Account;

import java.util.List;

/**
 * Created by joseph on 4/3/17.
 * Email: developergitch@outlook.com
 */
public interface AccountService {
   void createAccount(Account account);
   void removeAccount(Account account);
   Account getAccount(String email);
   List<Account> getUserAccounts();
   List<Account> getUserAccounts(String email);
}
