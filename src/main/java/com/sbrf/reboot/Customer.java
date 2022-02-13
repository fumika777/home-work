package com.sbrf.reboot;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Customer {
    private long id;
    private int age;
    private List<Account> repository;
}
