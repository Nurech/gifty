package com.example.demo.model;

import javax.persistence.*;


@Entity
@Table(name="gifts")
public class Gift {

    // PrimaryKey
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String giftTitle;
    private String giftAmount;
    private String giftDescription;
    private String eventId;

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

    public String getGiftDescription() {
        return giftDescription;
    }

    public void setGiftDescription(String giftDescription) {
        this.giftDescription = giftDescription;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Gift() {
    }

    @Override
    public String toString() {
        return "Gift{" +
                "id=" + id +
                ", giftTitle='" + giftTitle + '\'' +
                ", giftAmount='" + giftAmount + '\'' +
                ", giftDescription='" + giftDescription + '\'' +
                ", eventId='" + eventId + '\'' +
                '}';
    }

    public Gift(long id, String giftTitle, String giftAmount, String giftDescription, String eventId) {
        this.id = id;
        this.giftTitle = giftTitle;
        this.giftAmount = giftAmount;
        this.giftDescription = giftDescription;
        this.eventId = eventId;
    }
}
