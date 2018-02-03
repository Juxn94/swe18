package org.c02.iot.behaviour.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.awt.Color;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.IButton.ButtonDirection;
import org.c02.swe.iot.behaviour.ChangeRedColour;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.junit.Test;

public class ChangeRedColourTest {
	
	@Test
	public void testIncreaseRed() throws ParticleException {
		
		Button b = mock(Button.class);
		ChangeRedColour crc = new ChangeRedColour(b);

		when(b.getButtonClickCounter(ButtonDirection.North)).thenReturn(3);
		when(b.getButtonClickCounter(ButtonDirection.South)).thenReturn(2);
		when(b.getButtonClickCounter(ButtonDirection.East)).thenReturn(2);
		when(b.getButtonClickCounter(ButtonDirection.West)).thenReturn(1);
		
		crc.run();
		
		verify(b).getButtonClickCounter(ButtonDirection.North);
		verify(b).getButtonClickCounter(ButtonDirection.South);
		verify(b).getButtonClickCounter(ButtonDirection.East);
		verify(b).getButtonClickCounter(ButtonDirection.West);
		
		verify(b).setLed(1, new Color(20,20,20));
		

		/*
		verify(b).getButtonClickCounter(ButtonDirection.East);
		verify(b).setLed(1, new Color(235,255,255));
		*/

	}

}
