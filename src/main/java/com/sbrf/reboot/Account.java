package com.sbrf.reboot;

import jdk.jshell.Snippet;

import java.util.Date;

public class Account {
    private String number;
    private long clientId;
    private Date date;
    private Integer balance;

    public Account(String number) {
        this.clientId=1L;
        this.number=number;
    }

    public Account(String number, long clientId) {
        this.clientId=clientId;
        this.number=number;
    }

    public static Snippet builder() {
    }

    public long getClientId() {
        return this.clientId;
    }
    public String getNumber() {
        return this.number;
    }
}
