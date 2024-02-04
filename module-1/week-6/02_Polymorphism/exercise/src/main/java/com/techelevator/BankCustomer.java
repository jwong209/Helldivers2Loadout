package com.techelevator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankCustomer {

    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<>();

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Accountable[] getAccounts() {
        Accountable[] arr = accounts.toArray(new Accountable[accounts.size()]);
        return arr;
    }

    public void addAccount(Accountable newAccount) {
        accounts.add(newAccount);
    }

    public boolean isVip() {
        int balanceSum = 0;
        for (Accountable account : accounts) {
            balanceSum += account.getBalance();
        }
        if (balanceSum >= 25000) {
            return true;
        }
        return false;
    }
}
