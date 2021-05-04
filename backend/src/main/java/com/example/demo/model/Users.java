package com.example.demo.model;

import javax.persistence.*;


@Entity
@Table(name="users")
public class Users {

    // PrimaryKey
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String guestName;
    private String username;
    private String password;
    private String firstName;
    private String lastname;
    private String email;

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", guestName='" + guestName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Users() {
        this.id = id;
        this.guestName = guestName;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastname = lastname;
        this.email = email;
    }
}
