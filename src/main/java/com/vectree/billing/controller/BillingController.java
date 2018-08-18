package com.vectree.billing.controller;

import com.vectree.billing.entity.User;
import com.vectree.billing.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.vectree.billing.utils.Variables.user;

/**
 * class BillingController Spring MVC.
 *
 * @version 1.0
 */
@Controller
@RequestMapping("/")
public class BillingController {
    private static final Logger logger = LoggerFactory.getLogger(BillingController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/billing", method = RequestMethod.GET)
    public String billingGet(Model model) {
        logger.info("method get controller /billing");

        model.addAttribute("user", user);
        return "billing";
    }

    @RequestMapping(value = "/billing/post/request", method = RequestMethod.POST)
    public String billingPostRequest(@ModelAttribute User user, Model model) {
        logger.info("method post to rest controller /billing/post/request");

        user = userService.doIt(user);
        model.addAttribute("user", user);
        return "billing";
    }
}
