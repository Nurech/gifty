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
    private long eventId;
    private String role;

    public Roles() {

    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", guestName='" + guestName + '\'' +
                ", username='" + username + '\'' +
                ", eventId=" + eventId +
                ", role='" + role + '\'' +
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

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Roles(long id, String guestName, String username, long eventId, String role) {
        this.id = id;
        this.guestName = guestName;
        this.username = username;
        this.eventId = eventId;
        this.role = role;
    }
}
