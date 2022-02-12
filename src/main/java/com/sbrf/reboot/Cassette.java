package com.sbrf.reboot;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Cassette<T> {
    private ArrayList<T> cassete;

    public Cassette(ArrayList<T> cassette) {
        this.cassete = cassette;
    }

    public long getCountBanknotes(){
        return this.cassete.stream().count();
    }
}
