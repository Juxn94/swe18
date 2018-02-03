package org.c02.swe.iot.applications;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.behaviour.ChangeRedColour;
import org.c02.swe.iot.behaviour.CountAndShowLed;
import org.c02.swe.iot.cloud.api.ParticleApi;

public class ChangeRedColourApp {
	
	public static void main(String args[]) {
		
		ParticleApi api = new ParticleApi(new ButtonConnection());
        Button button = new Button(api);
        button.resetButtonClickCounters();
        button.allLedsOff();
        ChangeRedColour app = new ChangeRedColour(button);
        /*Thread thread = new Thread(app);
        thread.start();*/
        
        while(!Thread.interrupted()) {
        	app.run();
        }
        
		
	}

}
