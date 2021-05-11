package com.example.demo.model;

public class ChooseGiftRequest {

    private long chooseGiftId;
    private long userId;
    private long eventId;
    private long itemNr;

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
