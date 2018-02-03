package org.c02.iot.behaviour.test;

import org.c02.swe.iot.IButton;
import org.c02.swe.iot.behaviour.ChangeColorXYZ;
import org.c02.swe.iot.behaviour.TiltingAndLog;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ChangeColorXYZTest {

	@Mock
	private IButton buttonInstance;

	@Test
	public void testCountAndShowLed() {
		ChangeColorXYZ beh = new ChangeColorXYZ(buttonInstance);
		when(buttonInstance.getXValue()).thenReturn(1.0);
		when(buttonInstance.getYValue()).thenReturn(1.0);
		when(buttonInstance.getZValue()).thenReturn(1.0);
		Thread thread = new Thread(beh);
		thread.start();
		thread.interrupt();
	}

}
