package org.c02.swe.iot.applications;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.behaviour.TiltingAndLog;
import org.c02.swe.iot.behaviour.TiltingAndShowRed;
import org.c02.swe.iot.cloud.api.ParticleApi;

public class TiltingRedApp {
    public static void main(String[] args) {
        ParticleApi api = new ParticleApi(new ButtonConnection());
        Button button = new Button(api);
        button.resetButtonClickCounters();
        button.allLedsOff();
        TiltingAndShowRed app = new TiltingAndShowRed(button);
        Thread thread = new Thread(app);
        thread.start();
    }
}
