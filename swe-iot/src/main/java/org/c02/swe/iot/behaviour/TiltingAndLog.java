package org.c02.swe.iot.behaviour;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.IButton.ButtonDirection;

public class TiltingAndLog extends AbstractBehaviour {

	public TiltingAndLog(IButton buttonInstance) {
		super(buttonInstance);
	}

	@Override
	public void run() {
		while(!Thread.interrupted()) {
			try {
				System.out.println("X: "+button.getXValue());
				System.out.println("Y: "+button.getYValue());
				System.out.println("Z: "+button.getZValue());
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}

}
