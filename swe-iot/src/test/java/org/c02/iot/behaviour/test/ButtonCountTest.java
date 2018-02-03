package org.c02.iot.behaviour.test;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.IButton.ButtonDirection;
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

public class ButtonCountTest {

	 @Mock
	    private IParticleApi api;

	    @Test
	    public void getButtonCount() throws Exception{
	        Button button = new Button(api);
	        button.getButtonClickCounter(ButtonDirection.West);

	    }

	    @Test
	    public void resetButtonCount() throws Exception {
	        Button button = new Button(api);
	        button.resetButtonClickCounters();
	    }

}
