package org.c02.swe.iot;

import java.awt.Color;

import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

public class Button implements IButton {

	IParticleApi wrapper;

	public Button(IParticleApi wrapperInstance) {
		wrapper = wrapperInstance;
	}

	public int getButtonClickCounter(ButtonDirection button) {
		// TODO Auto-generated method stub
		return 0;
	}

    public void setLed(int postition, Color color) {
        // nn = Position 01-12
        // rrr = rot
        // ggg = grün
        // bbb = blau
        // nnrrrgggbbb
        try {
            if (postition > 0 && postition <= 12 && color != null) {
                String colorString = String.format("%02d%03d%03d%03d", postition, color.getRed(), color.getGreen(), color.getBlue());
                wrapper.callMethod("led", colorString);
            }
        } catch (ParticleException e) {
            e.printStackTrace();
        }
    }

    public void allLedsOff() {
        try {
            wrapper.callMethod("ledsOff", null);
        } catch (ParticleException e) {
            e.printStackTrace();
        }
    }

	public void playSound() {
		try {
			wrapper.callMethod("play", null);
		} catch (ParticleException e) {
			e.printStackTrace();
		}
	}

	public void resetButtonClickCounters() {
		// TODO Auto-generated method stub
		
	}

}
