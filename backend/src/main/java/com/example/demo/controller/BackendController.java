package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BackendController {

    @Autowired
    private GiftService giftService;

    @ResponseBody
    @RequestMapping(path = "api/user/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List<UserRequest> addNewUser(@RequestBody List<UserRequest> request) {
        return giftService.addNewUser(request);
    }

    @ResponseBody
    @RequestMapping(path = "api/gift/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List<GiftRequest> addNewGift(@RequestBody List<GiftRequest> request) {
        return giftService.addNewGiftList(request);
    }

    @ResponseBody
    @RequestMapping(path = "api/event/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public EventRequest addNewEvent(@RequestBody EventRequest request) {
        return giftService.addNewEvent(request);
    }

    @ResponseBody
    @RequestMapping(path = "api/creator/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public EventDataRequest addNewEvent(@RequestBody EventDataRequest request) {
       return giftService.createNewEvent(request);
    }

    @ResponseBody
    @RequestMapping(path = "api/role/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public RoleRequest addNewRole(@RequestBody RoleRequest request) {
        return giftService.addNewRoles(request);
    }


//    @RequestMapping(path = "api/event/{eventId}/user/{userId}", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    public  pullEventInfo(@RequestParam("eventId") String eventId, @RequestParam("userId") String userId) {
//        return null;
//    }



}
