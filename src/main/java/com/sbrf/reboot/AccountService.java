package com.sbrf.reboot;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AccountService {

    private AccountRepository repository;
    public AccountService(AccountRepository repository){
        this.repository=repository;
    }

    public boolean isAccountExist(long client, Account account) throws IOException {
        return repository.getAllAccountsByClientId(client).contains(account);
    }
}

