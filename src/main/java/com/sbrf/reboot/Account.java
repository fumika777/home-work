package com.sbrf.reboot;

import lombok.Data;

@Data
public class Account {
    private String accountNm;
    private Long clientId;

    public Account(String newAccountNm) {
        this.clientId=1L;
        this.accountNm=newAccountNm;
    }

}
