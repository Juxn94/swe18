package org.c02.iot.behaviour.test;

import java.awt.Color;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.behaviour.CountAndPlay;
import org.c02.swe.iot.behaviour.CountAndShowLed;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BehaviourTest {

	@Mock
	private IButton buttonInstance;

	@Test
	public void testCountAndShowLed() {
		CountAndShowLed beh = new CountAndShowLed(buttonInstance);
		when(buttonInstance.getButtonClickCounter(IButton.ButtonDirection.North)).thenReturn(1);
		Thread thread = new Thread(beh);
		thread.start();
		thread.interrupt();
	}

	@Test
	public void testCountAndPlay() {
		CountAndPlay beh = new CountAndPlay(buttonInstance);
		when(buttonInstance.getButtonClickCounter(IButton.ButtonDirection.North)).thenReturn(10);
		Thread thread = new Thread(beh);
		thread.start();
		thread.interrupt();
	}
}
