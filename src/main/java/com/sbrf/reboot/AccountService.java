package com.sbrf.reboot;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountService {

    private AccountRepository repository;
    public AccountService(AccountRepository repository){
        this.repository=repository;
    }

    public boolean isAccountExist(long client, Account account) throws IOException {
        return repository.getAllAccountsByClientId(client).contains(account);
    }

    public Account getMaxAccountBalance(long client) throws IOException {
      Optional<Account> maxAccount =  repository.getAllAccountsByClientId(client).stream().max(Comparator.comparing((Account::getBalance)));
        return maxAccount.stream().collect(Collectors.toSet()).iterator().next();
    }
    public Set getAllAccountsByDateMoreThen(long client, LocalDate minusDays) throws IOException {
       return repository.getAllAccountsByClientId(client).stream().filter(account -> account.getCreateDate().compareTo(minusDays)>0).collect(Collectors.toSet());
    }
}




