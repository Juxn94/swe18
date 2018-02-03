package org.c02.iot.behaviour.test;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class PlaySoundTest {
	
	@Test
	public void testPlaySound() throws ParticleException{
		
		IParticleApi wrapper = mock(IParticleApi.class);
		
		Button b = new Button(wrapper);
		
		b.playSound();
		
		verify(wrapper).callMethod("play", null);
		verifyNoMoreInteractions(wrapper);
		
		
		
	}

}
