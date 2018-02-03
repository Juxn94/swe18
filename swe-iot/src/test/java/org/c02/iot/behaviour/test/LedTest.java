package org.c02.iot.behaviour.test;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.awt.*;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public class LedTest {

    @Mock
    private IParticleApi api;

    @Test
    public void shouldTurnOffAllLeds() throws Exception{
        Button button = new Button(api);
        button.allLedsOff();
        verify(api).callMethod("ledsOff", null);
        verifyNoMoreInteractions(api);
    }

    @Test
    public void shouldTurnOnLedOnPosition1WithColorRed() throws Exception {
        Button button = new Button(api);
        button.setLed(1, Color.RED);
        verify(api).callMethod("led", "01255000000");
        verifyNoMoreInteractions(api);
    }

    @Test
    public void shouldTurnOnAllLedWithColorRed() throws Exception {
        Button button = new Button(api);
        button.setAllLed(Color.RED);
        verify(api).callMethod("allLed", "255000000");
        verifyNoMoreInteractions(api);
    }

    @Test
    public void shouldToNothingWhenPosition50WithColorRed() throws Exception {
        Button button = new Button(api);
        button.setLed(50, Color.RED);
        verifyNoMoreInteractions(api);
    }
}
