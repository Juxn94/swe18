package org.c02.iot.behaviour.test;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.behaviour.CountAndPlay;
import org.c02.swe.iot.behaviour.CountAndShowLed;
import org.c02.swe.iot.behaviour.TiltingAndLog;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TiltingTest {

    @Mock
    private IButton buttonInstance;

    @Test
    public void testCountAndShowLed() {
        TiltingAndLog beh = new TiltingAndLog(buttonInstance);
        when(buttonInstance.getXValue()).thenReturn(1.0);
        when(buttonInstance.getYValue()).thenReturn(1.0);
        when(buttonInstance.getZValue()).thenReturn(1.0);
        Thread thread = new Thread(beh);
        thread.start();
        thread.interrupt();
    }

}
