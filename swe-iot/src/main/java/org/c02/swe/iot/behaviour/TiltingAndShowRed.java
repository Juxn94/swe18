package org.c02.swe.iot.behaviour;

import org.c02.swe.iot.IButton;

import java.awt.*;

public class TiltingAndShowRed extends AbstractBehaviour {

	public TiltingAndShowRed(IButton buttonInstance) {
		super(buttonInstance);
	}

	@Override
	public void run() {
		while(!Thread.interrupted()) {
			try {
				int red = 0;
				red = (int) ((button.getXValue() + 90) * 1.4); // - 90  +90
				button.setLed(1, new Color(red,20,20));
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}

}
