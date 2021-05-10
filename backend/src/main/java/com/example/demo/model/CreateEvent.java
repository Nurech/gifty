package com.example.demo.model;

import java.util.List;

public class CreateEvent {

    private EventRequest event;
    private List<GiftRequest> gifts;
    private List<RoleRequest> role;
    private List<UserRequest> users;

    public List<GiftRequest> getGifts() {
        return gifts;
    }

    public void setGifts(List<GiftRequest> gifts) {
        this.gifts = gifts;
    }

    public List<RoleRequest> getRole() {
        return role;
    }

    public void setRole(List<RoleRequest> role) {
        this.role = role;
    }

    public List<UserRequest> getUsers() {
        return users;
    }

    public void setUsers(List<UserRequest> users) {
        this.users = users;
    }

    public EventRequest getEvent() {
        return event;
    }

    public void setEvent(EventRequest event) {
        this.event = event;
    }
}
