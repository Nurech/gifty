package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.repository.EventsRepository;
import com.example.demo.repository.GiftsRepository;
import com.example.demo.repository.RolesRepository;
import com.example.demo.repository.UsersRepository;
import org.h2.util.json.JSONArray;
import org.h2.util.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

@Controller
public class BackendController {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private GiftsRepository giftsRepository;
    @Autowired
    private EventsRepository eventsRepository;
    @Autowired
    private RolesRepository rolesRepository;

    @ResponseBody
    @RequestMapping(path = "api/user/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String addNewUser(@RequestBody List<UserObject> request) {
        for (int i = 0; i < request.size(); i++) {
            Users savedUsers = new Users();
            savedUsers.setGuestName(request.get(i).getGuestName());
            savedUsers.setUsername(request.get(i).getUsername());
            savedUsers.setPassword("");
            savedUsers.setFirstName("");
            savedUsers.setLastName("");
            savedUsers.setEmail(request.get(i).getEmail());
            usersRepository.save(savedUsers);
            LOG.info(savedUsers + " successfully saved user into DB");
        }
        return "Created user";
    }

    @ResponseBody
    @RequestMapping(path = "api/gift/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public long addNewGift(@RequestBody GiftObject request) {
        Gifts savedGift = new Gifts();
        savedGift.setGiftTitle(request.getGiftTitle());
        savedGift.setGiftAmount(request.getGiftAmount());
        savedGift.setEventId(request.getEventId());
        giftsRepository.save(savedGift);
        LOG.info(savedGift + " successfully saved gift into DB");
        return savedGift.getId();
    }

    @ResponseBody
    @RequestMapping(path = "api/event/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String addNewEvent(@RequestBody EventObject request) {
        Events savedEvent = new Events();
        savedEvent.setId(request.getId());
        savedEvent.setEventName(request.getEventName());
        savedEvent.setEventDescription(request.getEventDescription());
        savedEvent.setEventDate(request.getEventDate());
        savedEvent.setEventAuthor(request.getEventAuthor());
        eventsRepository.save(savedEvent);
        LOG.info(savedEvent + "successfully saved event into DB");
        return "Event created successfully";
    }

    @ResponseBody
    @RequestMapping(path = "api/role/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public long addNewRole(@RequestBody RolesObject request) {
        return 0;
    }

}
