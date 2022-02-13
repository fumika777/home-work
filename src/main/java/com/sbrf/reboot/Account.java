package com.sbrf.reboot;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Account {
    private String currency;
    private int amount;
    private LocalDate date;
}
