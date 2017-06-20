package com.kumar.user.eventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {
    private EventBus bus=new EventBus();

    TextView textView;

    @Override
    @Subscribe
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       textView= (TextView) findViewById(R.id.textV);

        //Register as a Subscriber
        bus.register(this);
    }

    @Override
    protected void onDestroy() {

        //Unregister the event
        bus.unregister(this);
        super.onDestroy();
    }
    public void onEvent(ChargingEvent event){
        textView.setText(textView.getText() + "\n" + event.getData());
    }
}
