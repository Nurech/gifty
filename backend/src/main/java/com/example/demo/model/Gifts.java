package com.example.demo.model;

import javax.persistence.*;


@Entity
@Table(name="gifts")
public class Gifts {

    // PrimaryKey
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String giftTitle;
    private String giftAmount;
    private String eventId;

    public Gifts(long id, String giftTitle, String giftAmount, String eventId) {
        this.id = id;
        this.giftTitle = giftTitle;
        this.giftAmount = giftAmount;
        this.eventId = eventId;
    }

    public Gifts() {

    }

    @Override
    public String toString() {
        return "Gifts{" +
                "id=" + id +
                ", giftTitle='" + giftTitle + '\'' +
                ", giftAmount='" + giftAmount + '\'' +
                ", eventId='" + eventId + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGiftTitle() {
        return giftTitle;
    }

    public void setGiftTitle(String giftTitle) {
        this.giftTitle = giftTitle;
    }

    public String getGiftAmount() {
        return giftAmount;
    }

    public void setGiftAmount(String giftAmount) {
        this.giftAmount = giftAmount;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}
