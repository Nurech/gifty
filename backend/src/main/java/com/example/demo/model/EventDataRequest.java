package com.example.demo.model;

import java.util.List;

public class EventDataRequest {

    private EventRequest event;
    private List<GiftRequest> gifts;
    private RoleRequest role;
    private List<UserRequest> users;

    public EventRequest getEvent() {
        return event;
    }

    public void setEvent(EventRequest event) {
        this.event = event;
    }

    public List<GiftRequest> getGifts() {
        return gifts;
    }

    public void setGifts(List<GiftRequest> gifts) {
        this.gifts = gifts;
    }

    public RoleRequest getRole() {
        return role;
    }

    public void setRole(RoleRequest role) {
        this.role = role;
    }

    public List<UserRequest> getUsers() {
        return users;
    }

    public void setUsers(List<UserRequest> users) {
        this.users = users;
    }
}
