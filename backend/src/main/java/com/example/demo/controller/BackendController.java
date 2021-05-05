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
    public List<UserObject> addNewUser(@RequestBody List<UserObject> request) {
        return giftService.addNewUser(request);
    }

    @ResponseBody
    @RequestMapping(path = "api/gift/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List<GiftObject> addNewGift(@RequestBody List<GiftObject> request) {
        return giftService.addNewGiftList(request);
    }

    @ResponseBody
    @RequestMapping(path = "api/event/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public EventObject addNewEvent(@RequestBody EventObject request) {
        return giftService.addNewEvent(request);
    }

    @ResponseBody
    @RequestMapping(path = "api/eventinfo/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public EventInfoObject addNewEvent(@RequestBody EventInfoObject request) {
//        giftService.createNewEvent(request);
        return request;
    }

    @ResponseBody
    @RequestMapping(path = "api/role/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public List<RolesObject> addNewRole(@RequestBody List<RolesObject> request) {
        return giftService.addNewRoles(request);
    }


//    @RequestMapping(path = "api/event/{eventId}/user/{userId}", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    public  pullEventInfo(@RequestParam("eventId") String eventId, @RequestParam("userId") String userId) {
//        return null;
//    }

    // testime giti commite


}
