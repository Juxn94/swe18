package org.c02.swe.iot.cloud.examples;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.ButtonConnection;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;

public class ButtonCounterDemo {
	static IParticleApi api = new ParticleApi(new ButtonConnection());
	static Button but = new Button(api);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
