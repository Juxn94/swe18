package org.c02.swe.iot;

import java.awt.Color;
import java.io.IOException;

import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

public class Button implements IButton {

	IParticleApi wrapper;

	public Button(IParticleApi wrapperInstance) {
		wrapper = wrapperInstance;
	}

	public int getButtonClickCounter(ButtonDirection button) {
		String argument = "";
		
		switch (button) {
		case North:
			argument = "countButton1";
			break;
		case South:
			argument = "countButton2";
			break;
		case East:
			argument = "countButton3";
			break;
		case West:
			argument = "countButton4";
			break;
		default:
			return -1;
		}
		try {
			return wrapper.readVariable(argument);
		} catch (IOException e) {
			e.printStackTrace();
		}
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

		try {
			wrapper.callMethod("reset",null);
		} catch (ParticleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
		
	}

	public double getXValue() {
		try {
			return wrapper.readVariable("xValue");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public double getYValue() {
		try {
			return wrapper.readVariable("yValue");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public double getZValue() {
		try {
			return wrapper.readVariable("zValue");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void march() {
		try {
			wrapper.callMethod("march", null);
		} catch (ParticleException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setAllLed(Color color) {
		try {
			if (color != null) {
				String colorString = String.format("%03d%03d%03d", color.getRed(), color.getGreen(), color.getBlue());
				wrapper.callMethod("allLed", colorString);
			}
		} catch (ParticleException e) {
			e.printStackTrace();
		}
	}

}
