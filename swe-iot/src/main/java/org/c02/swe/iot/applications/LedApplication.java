package org.c02.swe.iot.applications;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.cloud.api.ParticleApi;

import java.awt.*;

public class LedApplication {



    public static void main(String[] args) {
        ParticleApi api = new ParticleApi(new ButtonConnection());
        Button button = new Button(api);

        System.out.println("all leds off");
        button.allLedsOff();
        System.out.println("turn on leds");
        button.setLed(1, Color.CYAN);
        button.setLed(3, Color.ORANGE);
        button.setLed(6, Color.green);
        button.setLed(9, Color.magenta);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        button.allLedsOff();
        System.out.println("all leds off");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("turn on leds");
        button.setLed(2, Color.CYAN);
        button.setLed(4, Color.ORANGE);
        button.setLed(7, Color.green);
        button.setLed(10, Color.magenta);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        button.allLedsOff();
        System.out.println("all leds off");
    }
}
