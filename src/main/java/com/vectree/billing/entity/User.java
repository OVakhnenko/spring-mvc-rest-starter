package com.vectree.billing.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
public class User {
    private static final User USER = new User();
    private int id;
    private String Name;
    private BigDecimal Debit;

    private User() {
        // NOPE
    }

    public static User getUser() {
        return USER;
    }
}
