package com.example.demo.model;

import javax.persistence.*;


@Entity
@Table(name="roles")
public class Roles {

    // PrimaryKey
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String guestName;
    private String username;
    private String eventId;
    private Boolean owner;
    private Boolean user;

    public Roles(long id, String guestName, String username, String eventId, Boolean owner, Boolean user) {
        this.id = id;
        this.guestName = guestName;
        this.username = username;
        this.eventId = eventId;
        this.owner = owner;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", guestName='" + guestName + '\'' +
                ", username='" + username + '\'' +
                ", eventId='" + eventId + '\'' +
                ", owner=" + owner +
                ", user=" + user +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Boolean getOwner() {
        return owner;
    }

    public void setOwner(Boolean owner) {
        this.owner = owner;
    }

    public Boolean getUser() {
        return user;
    }

    public void setUser(Boolean user) {
        this.user = user;
    }
}
