package com.example.demo.configuration.entity;

import javax.persistence.*;


@Entity
@Table(name="events")
public class Event {

    // PrimaryKey
    @Id
   // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long eventId;
    private String eventName;
    private String eventDescription;
    private String eventDate;
    private String eventAuthor;
    private String giftId;
    private String messageEmail;

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", eventAuthor='" + eventAuthor + '\'' +
                ", giftId='" + giftId + '\'' +
                ", messageEmail='" + messageEmail + '\'' +
                '}';
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventAuthor() {
        return eventAuthor;
    }

    public void setEventAuthor(String eventAuthor) {
        this.eventAuthor = eventAuthor;
    }

    public String getGiftId() {
        return giftId;
    }

    public void setGiftId(String giftId) {
        this.giftId = giftId;
    }

    public String getMessageEmail() {
        return messageEmail;
    }

    public void setMessageEmail(String messageEmail) {
        this.messageEmail = messageEmail;
    }

    public Event(long eventId, String eventName, String eventDescription, String eventDate, String eventAuthor, String giftId, String messageEmail) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
        this.eventAuthor = eventAuthor;
        this.giftId = giftId;
        this.messageEmail = messageEmail;
    }

    public Event() {
    }
}
