package org.c02.swe.iot.behaviour;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.IButton.ButtonDirection;
import org.c02.swe.iot.cloud.api.IParticleApi;

import java.awt.*;

public class ChangeColorXYZ extends AbstractBehaviour{

	IParticleApi wrapper;
	IButton button;

	public ChangeColorXYZ(IButton bt) {
		super(bt);
		button = bt;
		
	}

	@Override
	public void run() {
		while(!Thread.interrupted()) {
			try {
				int x  = (int) ((button.getXValue() + 90) * 1.4);
				int y  = (int) ((button.getYValue() + 90) * 1.4);
				int z  = (int) ((button.getZValue() + 90) * 1.4);
				button.setLed(1, new Color(x,y,z));
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
		
	}
	
}
