package org.c02.swe.iot.applications;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.behaviour.CountAndShowLed;
import org.c02.swe.iot.cloud.api.ParticleApi;

public class LedAndCountApplication {

    public static void main(String[] args) {
        ParticleApi api = new ParticleApi(new ButtonConnection());
        Button button = new Button(api);
        button.allLedsOff();
        CountAndShowLed app = new CountAndShowLed(button);
        Thread thread = new Thread(app);
        thread.start();
    }
}
