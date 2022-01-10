package com.sbrf.reboot;


import java.util.Set;

public class AccountService {

    private AccountRepository repository;

    public AccountService(AccountRepository repository){
        this.repository=repository;
    }

    public boolean isAccountExist(long client, Account account){
        return repository.getAllAccountsByClientId(client).contains(account);
    }
}