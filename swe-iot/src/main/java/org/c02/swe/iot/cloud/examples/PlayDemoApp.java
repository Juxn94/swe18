package org.c02.swe.iot.cloud.examples;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.cloud.api.ParticleApi;

public class PlayDemoApp {

	public static void main(String[] args) {
		
		Button b1 = new Button(new ParticleApi(new ButtonConnection()));
		b1.playSound();
	}

}
