package com.sbrf.reboot;

public class AccountService {

    private AccountRepository repository;
    public AccountService(AccountRepository repository){
        this.repository=repository;
    }

    public boolean isAccountExist(long client, Account account){
        return repository.getAllAccountsByClientId(client).contains(account);
    }
}

