package com.example.demo.model;

import java.util.List;

public class CreateUser {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public List<UserObject> getGuests() {
        return guests;
    }

    public void setGuests(List<UserObject> guests) {
        this.guests = guests;
    }

    private List<UserObject> guests;

}
