package com.vectree.billing.service;

import com.vectree.billing.entity.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {

    public User doIt(User user) {
        if (user.getId() == 0) {
            user.setId(1);
        }

        if ((user.getName() == null) || (user.getName().isEmpty())) {
            user.setName("Billing");
        }

        if ((user.getDebit() == null) || (user.getDebit().intValue() == 0)) {
            user.setDebit(new BigDecimal("1000.00"));
        } else {
            user.setDebit(new BigDecimal("" + (user.getDebit().intValue() + 1) + ".00"));
        }
        return user;
    }

    public User setIt(User user) {
        User result = User.getUser();
        result.setId(user.getId());
        result.setName(user.getName());
        result.setDebit(user.getDebit());

        return result;
    }
}
