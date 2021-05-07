package com.example.demo.service;

import com.example.demo.controller.BackendController;
import com.example.demo.model.*;
import com.example.demo.repository.EventsRepository;
import com.example.demo.repository.GiftsRepository;
import com.example.demo.repository.RolesRepository;
import com.example.demo.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class GiftService {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    @Autowired
    EventsRepository eventsRepository;

    @Autowired
    GiftsRepository giftsRepository;

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    UsersRepository usersRepository;

    public String addNewUser(CreateUser request) {
        for (int i = 0; i < request.getGuests().size(); i++) {
            Users savedUsers = new Users();
            savedUsers.setUserId(request.getGuests().get(i).getUserId());
            savedUsers.setGuestName(request.getGuests().get(i).getGuestName());
            savedUsers.setUsername(request.getGuests().get(i).getUsername());
            savedUsers.setPassword(request.getGuests().get(i).getPassword());
            savedUsers.setFirstName(request.getGuests().get(i).getFirstName());
            savedUsers.setLastName(request.getGuests().get(i).getLastName());
            savedUsers.setEmail(request.getGuests().get(i).getEmail());
            usersRepository.save(savedUsers);
            LOG.info(savedUsers + " successfully saved user into DB");
            com.example.demo.model.SendGmail.sendGmail(request.getGuests().get(i).getGuestName(), request.getGuests().get(i).getEmail(), request.getMessage());
        }
        return "Guests added to the db and email sent.";
    }

    public List<GiftObject> addNewGiftList(List<GiftObject> request) {
        for (int i = 0; i < request.size(); i++) {
            Gift savedGift = new Gift();
            savedGift.setGiftTitle(request.get(i).getGiftTitle());
            savedGift.setGiftAmount(request.get(i).getGiftAmount());
            savedGift.setGiftDescription(request.get(i).getGiftDescription());
            giftsRepository.save(savedGift);
            LOG.info(savedGift + " successfully saved gift into DB");
        }
        return request;
    }

    public EventObject addNewEvent(EventObject request) {
        Events savedEvent = new Events();
        savedEvent.setEventId(request.getEventId());
        savedEvent.setEventName(request.getEventName());
        savedEvent.setEventDescription(request.getEventDescription());
        savedEvent.setEventDate(request.getEventDate());
        savedEvent.setEventAuthor(request.getEventAuthor());
        eventsRepository.save(savedEvent);
//        usersRepository.save()
        LOG.info(savedEvent + "successfully saved event into DB");
        return request;
    }

    public List<RolesObject> addNewRoles(List<RolesObject> request) {
        for (RolesObject userObject : request) {

        }
        return request;
    }

    public List<CreatorObject> createNewEvent(List<CreatorObject> request){
        for (int i = 0; i < request.size(); i++) {
            //EVENT
            Events event = new Events();
            event.setEventAuthor(request.get(i).getEventAuthor());
            event.setEventDate(request.get(i).getEventDate());
            event.setEventName(request.get(i).getEventName());
            eventsRepository.save(event);
            //GIFT
            Gift gift = new Gift();
            gift.setEventId(request.get(i).getEventId());
            giftsRepository.save(gift);
            //USERS

            //ROLES
        }
        return request;
    }

}
