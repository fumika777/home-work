package com.sbrf.reboot;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component("account")
public class AccountBean {
    private String currency;
    private int amount;
    private String number;

    public AccountBean() {
        this.currency="RUR";
        this.amount=0;
        this.number="0001920929102991";
    }
}
