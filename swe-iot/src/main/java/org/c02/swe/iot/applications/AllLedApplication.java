package org.c02.swe.iot.applications;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.cloud.api.ParticleApi;

import java.awt.*;

public class AllLedApplication {



    public static void main(String[] args) {
        ParticleApi api = new ParticleApi(new ButtonConnection());
        Button button = new Button(api);

        System.out.println("all leds off");
        button.allLedsOff();
        System.out.println("turn on leds");
        button.setAllLed( Color.GREEN);
    }
}
