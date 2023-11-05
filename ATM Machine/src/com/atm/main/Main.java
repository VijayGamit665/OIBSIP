package com.atm.main;

import com.atm.service.AtmService;

public class Main {
    public static void main(String[] args) {
        AtmService atm = new AtmService();
        atm.checkPin();
    }
}
