package com.sbrf.reboot;

import java.util.Comparator;
import java.util.List;

public class AccountUtils {

    public static void sortedById(List<Account> accounts) {
        accounts.sort(Comparator.comparing(Account::getId));
    }
    public static void sortedByIdDate(List<Account> accounts) {
        accounts.sort(Comparator.comparing(Account::getId, Comparator.reverseOrder())
                .thenComparing((p1, p2) -> p2.getCreateDate().compareTo(p1.getCreateDate())).reversed());
    }
}
