package com.kumar.user.eventbus;

/**
 * Created by User on 6/19/2017.
 */

public class ChargingEvent {

    private String data;

    public ChargingEvent(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

}
