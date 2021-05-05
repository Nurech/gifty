package com.example.demo.model;

import javax.persistence.*;


@Entity
@Table(name="roles")
public class Roles {

    // PrimaryKey
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long roleId;
    private String guestName;
    private String username;
    private long eventId;
    private String role;

    public Roles() {

    }

    @Override
    public String toString() {
        return "Roles{" +
                "roleId=" + roleId +
                ", guestName='" + guestName + '\'' +
                ", username='" + username + '\'' +
                ", eventId=" + eventId +
                ", role='" + role + '\'' +
                '}';
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
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

    public Roles(long roleId, String guestName, String username, long eventId, String role) {
        this.roleId = roleId;
        this.guestName = guestName;
        this.username = username;
        this.eventId = eventId;
        this.role = role;
    }
}
