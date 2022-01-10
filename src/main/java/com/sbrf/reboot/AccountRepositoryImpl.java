package com.sbrf.reboot;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class AccountRepositoryImpl implements AccountRepository {

    private Set<Account> repository;

    public AccountRepositoryImpl(String path) throws FileNotFoundException, IOException {
        this.repository = new HashSet<Account>();
        String textFile = "";
        try (FileReader fileReader=new FileReader(path); BufferedReader reader = new BufferedReader(fileReader);){
            while (reader.ready()) {
                textFile = textFile + reader.readLine();
            }
        }
        String[] arrayAccounts = textFile.split(",");
        String pattern = "(\"clientId\": )(.*)(\\p{P}+.*)(\"number\": )(.*)(})";
        Pattern r = Pattern.compile(pattern);
        Matcher m;
        for (int i = 0; i < arrayAccounts.length; i++) {
            m = r.matcher(arrayAccounts[i]);
            if (m.find()) {
                assert this.repository != null;
                this.repository.add(new Account(m.group(5), Long.parseLong(m.group(2))));
                System.out.println(this.repository.stream().count());
            }
        }
    }

    @Override
    public Set<Account> getAllAccountsByClientId(long clientId) {
        return this.repository.stream().filter(el-> el.getClientId()==clientId).collect(Collectors.toSet());
    }
}
