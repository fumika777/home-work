package com.sbrf.reboot;

public class Account {
    private String accountNm;
    private Long clientId;

    public Account(String newAccountNm, Long clientId) {
        this.clientId=clientId;
        this.accountNm=newAccountNm;
    }

    public Account(String newAccountNm) {
        this.clientId=1L;
        this.accountNm=newAccountNm;
    }

}
