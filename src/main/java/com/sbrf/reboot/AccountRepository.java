package com.sbrf.reboot;

import java.util.Set;

public interface AccountRepository {
    Set<Account> repository = null;
    Set<Account> getAllAccountsByClientId(long l);
}