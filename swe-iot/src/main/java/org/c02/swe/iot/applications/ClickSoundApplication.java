package org.c02.swe.iot.applications;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.behaviour.CountAndPlay;
import org.c02.swe.iot.behaviour.CountAndShowLed;
import org.c02.swe.iot.cloud.api.ParticleApi;

public class ClickSoundApplication {

    public static void main(String[] args) {
        ParticleApi api = new ParticleApi(new ButtonConnection());
        Button button = new Button(api);
        button.resetButtonClickCounters();
        CountAndPlay app = new CountAndPlay(button);
        Thread thread = new Thread(app);
        thread.start();
    }
}
