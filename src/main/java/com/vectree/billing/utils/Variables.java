package com.vectree.billing.utils;

import com.vectree.billing.entity.User;

public class Variables {

    public static User user = User.getUser();

    private Variables() {
        // NOPE
    }
}
