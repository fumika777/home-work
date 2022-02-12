package com.sbrf.reboot;

import java.io.IOException;
import java.util.Set;

public interface AccountRepository {
    Set<Account> getAllAccountsByClientId(long l) throws IOException;
//    Set<Account> getMaxAccountBalance(long l) throws IOException;
}