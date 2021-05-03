package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.UserObject;
import com.example.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BackendController {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @RequestMapping(path = "api/user/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public long addNewUser(@RequestBody UserObject request) {
        User savedUser = new User();
        savedUser.setFirstName(request.getFirstName());
        savedUser.setLastName(request.getLastName());
        userRepository.save(savedUser);
        LOG.info(savedUser.toString() + " successfully saved into DB");
        return savedUser.getId();
    }


}
