package com.sbrf.reboot;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class Account {
    private String number;
    private long id;
    private LocalDate createDate;
    private BigDecimal balance;


    public Account() {
    }

    //оставляю для работы тестов более ранних чем дз 7
    public Account(String number) {
        this.id=1L;
        this.number=number;
    }

    public long getId() {
        return this.id;
    }

    public static class builder {
        private Account account;

        public builder() {
            account = new Account();
        }

        public builder id(long id){
            account.id = id;
            return this;
        }

        public builder number(String number){
            account.number = number;
            return this;
        }

        public builder createDate(LocalDate date){
            account.createDate = date;
            return this;
        }

        public builder balance(BigDecimal balance){
            account.balance = balance;
            return this;
        }

        public Account build(){
            return this.account;
        }

    }
}
