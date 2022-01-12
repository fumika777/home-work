package com.sbrf.reboot;

public class Account {
    private String number;
    private long clientId;

    public Account(String number) {
        this.clientId=1L;
        this.number=number;
    }

    public Account(String number, long clientId) {
        this.clientId=clientId;
        this.number=number;
    }
    public long getClientId() {
        return this.clientId;
    }
    public String getNumber() {
        return this.number;
    }
}
