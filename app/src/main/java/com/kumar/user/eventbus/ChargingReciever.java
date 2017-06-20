package com.kumar.user.eventbus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by User on 6/19/2017.
 */

public class ChargingReciever extends BroadcastReceiver {

    private EventBus bus=EventBus.getDefault();
    @Override
    public void onReceive(Context context, Intent intent) {
         ChargingEvent event=null;

        //Get Current Time
        android.text.format.Time now=new android.text.format.Time();
        now.setToNow();
        String timeOfEvent=now.format("%H:%M:%S");
        String eventData = "@" + timeOfEvent + " this device started ";
        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            event=new ChargingEvent(eventData+ " Charging ");
        }
        else if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
            event=new ChargingEvent(eventData+"Discharging");
        }
        //post the event
        bus.post(event);


    }
}
