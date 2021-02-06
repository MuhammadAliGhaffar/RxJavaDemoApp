package com.example.rxjavademoapp.model;

import java.util.Date;

public class Entry {
    private final String entryName;
    private final double entryPrice;
    private final Date entryDate;


    public Entry(String entryName, double entryPrice, Date entryDate) {
        this.entryName = entryName;
        this.entryPrice = entryPrice;
        this.entryDate = entryDate;
    }

    public String getEntryName() {
        return entryName;
    }

    public double getentryPrice() {
        return entryPrice;
    }

    public Date getEntryDate() {
        return entryDate;
    }
}
