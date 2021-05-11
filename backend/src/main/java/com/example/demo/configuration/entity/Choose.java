package com.example.demo.configuration.entity;


import javax.persistence.*;

@Entity
@Table(name="choose_gift")
public class Choose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long chooseGiftId;
    private long userId;
    private long eventId;
    private long itemNr;

    @Override
    public String toString() {
        return "Choose{" +
                "chooseGiftId=" + chooseGiftId +
                ", userId=" + userId +
                ", eventId=" + eventId +
                ", itemNr=" + itemNr +
                '}';
    }

    public long getChooseGiftId() {
        return chooseGiftId;
    }

    public void setChooseGiftId(long chooseGiftId) {
        this.chooseGiftId = chooseGiftId;
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

    public long getItemNr() {
        return itemNr;
    }

    public void setItemNr(long itemNr) {
        this.itemNr = itemNr;
    }
}
