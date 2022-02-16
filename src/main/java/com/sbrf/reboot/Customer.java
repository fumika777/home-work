package com.sbrf.reboot;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component("customer")
public class Customer {
    private long id;
    private int age;
    private AccountBean account;

    public Customer (){
        this.id=1;
        this.age=20;
    }

    @Autowired
    public void setAccount(AccountBean account){
        this.account=account;
    }
}