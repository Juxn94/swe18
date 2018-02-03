package org.c02.swe.iot.applications;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

import java.awt.*;

public class TestApplication {



    public static void main(String[] args) {
        ParticleApi api = new ParticleApi(new ButtonConnection());
        try {
            api.callMethod("playSong","A4,4,R,3,A4,4,R,3,A4,4,R,3");
            api.callMethod("playSong","F3,8,R,3,C5,8,R,3,A4,4,R,3");
            api.callMethod("playSong","F3,8,R,3,C5,8,R,3,A4,4,R,3");
            api.callMethod("playSong","A5,4,R,3,A5,4,R,3,A5,4,R,3");
            api.callMethod("playSong","F4,8,R,3,C6,8,R,3,A5,4,R,3");
            api.callMethod("playSong","F4,8,R,3,C6,8,R,3,A5,4,R,3");


            /*
            a4 4
            a4 4
            f3 8
            c4 8
            a4 4
            f3 8
            c4 8
            a4 2
            A4,4,A4,4,F3,8,C4,8,A4,4,F3,8,C4,8,A4,2
             */
        } catch (ParticleException e) {
            e.printStackTrace();
        }
    }
}
