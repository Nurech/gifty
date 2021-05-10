package com.example.demo.configuration.entity;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class Role {

    // PrimaryKey
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long roleId;
    private long userId;
    private long eventId;
    private String role;

    public Role() {

    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", userId=" + userId +
                ", eventId=" + eventId +
                ", role='" + role + '\'' +
                '}';
    }

    public Role(long roleId, long userId, long eventId, String role) {
        this.roleId = roleId;
        this.userId = userId;
        this.eventId = eventId;
        this.role = role;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
}
