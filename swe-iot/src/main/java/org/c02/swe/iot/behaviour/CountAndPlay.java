package org.c02.swe.iot.behaviour;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.IButton.ButtonDirection;

import java.awt.*;

public class CountAndPlay extends AbstractBehaviour {

	public CountAndPlay(IButton buttonInstance) {
		super(buttonInstance);
	}

	@Override
	public void run() {
		while(!Thread.interrupted()) {
			int buttonCounter = button.getButtonClickCounter(ButtonDirection.North);
			if(buttonCounter > 0 && buttonCounter % 10 == 0) {
				button.playSound();
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}

}
