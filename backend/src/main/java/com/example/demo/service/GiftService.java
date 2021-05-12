package com.example.demo.service;

import com.example.demo.configuration.entity.*;
import com.example.demo.controller.BackendController;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
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

    @Autowired
    ChooseRepository chooseRepository;

    public List<UserRequest> addNewUser(List<UserRequest> request) {

        for (int i = 0; i < request.size(); i++) {
            User savedUser = new User();
            savedUser.setUserId(request.get(i).getUserId());
            savedUser.setGuestName(request.get(i).getGuestName());
            savedUser.setUsername(request.get(i).getUsername());
            savedUser.setPassword(request.get(i).getPassword());
            savedUser.setFirstName(request.get(i).getFirstName());
            savedUser.setLastName(request.get(i).getLastName());
            savedUser.setEmail(request.get(i).getEmail());
            usersRepository.save(savedUser);
            LOG.info(savedUser + " successfully saved user into DB");
        }
        return request;
    }

    public List<GiftRequest> addNewGiftList(List<GiftRequest> request) {
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

    public EventRequest addNewEvent(EventRequest request) {
        Event savedEvent = new Event();
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

    public List<RoleRequest> addNewRoles(List<RoleRequest> request) {
//        for (RolesObject userObject : request) {
//        }
        return request;
    }

    public CreateEvent createNewEvent(CreateEvent request) {

        //EVENT
        Event event = new Event();
        event.setEventId(request.getEvent().getEventId());
        event.setEventName(request.getEvent().getEventName());
        event.setEventDescription(request.getEvent().getEventDescription());
        event.setEventDate(request.getEvent().getEventDate());
        event.setEventAuthor(request.getEvent().getEventAuthor());
        event.setGiftId(request.getEvent().getGiftId());
        eventsRepository.save(event);

        //GIFT LIST
        for (int i = 0; i < request.getGifts().size(); i++) {
            Gift gift = new Gift();
            gift.setGiftTitle(request.getGifts().get(i).getGiftTitle());
            gift.setGiftAmount(request.getGifts().get(i).getGiftAmount());
            gift.setGiftDescription(request.getGifts().get(i).getGiftDescription());
            gift.setGiftId(request.getGifts().get(i).getGiftId());
            gift.setEventId(request.getGifts().get(i).getEventId());
            giftsRepository.save(gift);
        }
        //USERS
        for (int i = 0; i < request.getUsers().size(); i++) {
            User user = new User();
            user.setUserId(request.getUsers().get(i).getUserId());
            user.setGuestName(request.getUsers().get(i).getGuestName());
            user.setPassword(request.getUsers().get(i).getPassword());
            user.setFirstName(request.getUsers().get(i).getFirstName());
            user.setEmail(request.getUsers().get(i).getEmail());
            usersRepository.save(user);

            // sends all info to sendGmail class on each loop
            SendGmail.sendGmail(
                    request.getUsers().get(i).getUserId(),
                    request.getUsers().get(i).getGuestName(),
                    request.getEvent().getEventId(),
                    request.getEvent().getEventName(),
                    request.getUsers().get(i).getEmail(),
                    request.getEvent().getMessageEmail());
        }

        //ROLES
        for (int i = 0; i < request.getRole().size(); i++) {
            Role role = new Role();
            role.setUserId(request.getRole().get(i).getUserId());
            role.setEventId(request.getRole().get(i).getEventId());
            role.setRole(request.getRole().get(i).getRole());
            rolesRepository.save(role);
        }
        return request;
    }

    public CreateEvent getEventData(Long eventId, Long userId) {

        // return info obj
        CreateEvent info = new CreateEvent();

        // event
        List<RoleRequest> role = new ArrayList<>();
        Role roleEntity = rolesRepository.findAllByUserId(userId);

        // role info
        RoleRequest roleRequest = new RoleRequest();

        roleRequest.setRoleId(roleEntity.getRoleId());
        roleRequest.setUserId(roleEntity.getUserId());
        roleRequest.setEventId(roleEntity.getEventId());
        roleRequest.setRole(roleEntity.getRole());
        role.add(roleRequest);
        info.setRole(role);

        // check if user exists at said event


        List<GiftRequest> gift = new ArrayList<>();
        // how many gifts event has?
        List<Gift> giftEntity = giftsRepository.findAllByEventId(eventId);

        for (int i = 0; i < giftEntity.size();i++) {
            GiftRequest giftRequest = new GiftRequest();
            giftRequest.setGiftId(giftEntity.get(i).getGiftId());
            giftRequest.setGiftAmount(giftEntity.get(i).getGiftAmount());
            giftRequest.setGiftTitle(giftEntity.get(i).getGiftTitle());
            giftRequest.setGiftDescription(giftEntity.get(i).getGiftDescription());
            giftRequest.setEventId(giftEntity.get(i).getEventId());
            gift.add(giftRequest);
            info.setGifts(gift);
        }

        return info;
        // if exists
        // check what role user has

        // if user exists and has role, return event info and gift list

    }

    public ChooseGiftRequest ChooseGiftRequest(ChooseGiftRequest request) {
        Choose entity = new Choose();
        entity.setChooseGiftId(request.getChooseGiftId());
        entity.setUserId(request.getUserId());
        entity.setEventId(request.getEventId());
        entity.setItemNr(request.getItemNr());
        chooseRepository.save(entity);
        return null;
    }
}
