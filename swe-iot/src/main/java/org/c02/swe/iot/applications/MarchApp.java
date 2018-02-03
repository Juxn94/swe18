package org.c02.swe.iot.applications;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.cloud.api.ParticleApi;

public class MarchApp {

	public static void main(String[] args) {
		Button b1 = new Button(new ParticleApi(new ButtonConnection()));
		b1.march();
	}

}
