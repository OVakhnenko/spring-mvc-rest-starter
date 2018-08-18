package com.vectree.billing.controller;

import com.vectree.billing.entity.User;
import com.vectree.billing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.vectree.billing.utils.Variables.user;

/**
 * class REST BillingController Spring MVC.
 *
 * @version 1.0
 */

@RestController
@RequestMapping("/billing/api/v1/user")
public class RestControlleV1 {

    @Autowired
    UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<User> getUser() {
        user = userService.doIt(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<User> userBilling(@RequestBody User newUser, HttpServletRequest request, HttpServletResponse response) {
        HttpHeaders headers = new HttpHeaders();

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        user = userService.setIt(newUser);
        return new ResponseEntity<>(user, headers, HttpStatus.OK);
    }
}
