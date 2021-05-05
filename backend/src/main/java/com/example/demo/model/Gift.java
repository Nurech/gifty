package com.example.demo.model;

import javax.persistence.*;


@Entity
@Table(name="gifts")
public class Gift {

    // PrimaryKey
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long giftId;
    private String giftTitle;
    private String giftAmount;
    private String giftDescription;
    private String eventId;

    @Override
    public String toString() {
        return "Gift{" +
                "giftId=" + giftId +
                ", giftTitle='" + giftTitle + '\'' +
                ", giftAmount='" + giftAmount + '\'' +
                ", giftDescription='" + giftDescription + '\'' +
                ", eventId='" + eventId + '\'' +
                '}';
    }

    public long getGiftId() {
        return giftId;
    }

    public void setGiftId(long giftId) {
        this.giftId = giftId;
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
        this.giftId = giftId;
        this.giftTitle = giftTitle;
        this.giftAmount = giftAmount;
        this.giftDescription = giftDescription;
        this.eventId = eventId;
    }
}
