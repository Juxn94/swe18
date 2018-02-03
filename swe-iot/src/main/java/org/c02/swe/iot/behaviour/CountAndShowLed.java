package org.c02.swe.iot.behaviour;

import java.awt.Color;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.IButton.ButtonDirection;

public class CountAndShowLed extends AbstractBehaviour {

	public CountAndShowLed(IButton buttonInstance) {
		super(buttonInstance);
	}

	@Override
	public void run() {
		int lastButtonCount = -1;
		while(true) {
			int buttonCounter = button.getButtonClickCounter(ButtonDirection.North);
			buttonCounter %= 12;
			if(lastButtonCount != buttonCounter) {
				button.allLedsOff();
				button.setLed(buttonCounter, Color.GREEN);
				lastButtonCount = buttonCounter;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}

}
