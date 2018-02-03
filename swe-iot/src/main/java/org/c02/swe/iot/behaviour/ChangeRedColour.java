package org.c02.swe.iot.behaviour;

import java.awt.Color;

import org.c02.swe.iot.Button;
import org.c02.swe.iot.IButton;
import org.c02.swe.iot.IButton.ButtonDirection;
import org.c02.swe.iot.cloud.api.IParticleApi;
import org.c02.swe.iot.cloud.api.ParticleException;

public class ChangeRedColour extends AbstractBehaviour{

	IParticleApi wrapper;
	IButton button;
	
	public ChangeRedColour(IButton bt) {
		super(bt);
		button = bt;
		
	}
	

	@Override
	public void run() {
		
		int r = 0;
		int g = 20;
		int b = 20;

		/*int lastNorth = 0;
		int lastSouth = 0;
		int lastEast = 0;
		int lastWest = 0;
		
		int lastR = 0;	*/	
		
		
		int north = button.getButtonClickCounter(ButtonDirection.North);
		int south = button.getButtonClickCounter(ButtonDirection.South);
		int east = button.getButtonClickCounter(ButtonDirection.East);
		int west = button.getButtonClickCounter(ButtonDirection.West);
		
		int diffClickCount=north-south+east-west;
		
		r= diffClickCount*10;
		if(r<0)
			r=0;
		if (r>255)
			r=255;
		
		button.setLed(1, new Color(r,g,b));
		
		/*while(!Thread.interrupted()) {
			
			int north = button.getButtonClickCounter(ButtonDirection.North)-lastNorth;
			lastNorth=north;
			int south = button.getButtonClickCounter(ButtonDirection.South)-lastSouth;
			lastSouth=south;
			int east = button.getButtonClickCounter(ButtonDirection.East)-lastEast;
			lastEast=east;
			int west = button.getButtonClickCounter(ButtonDirection.West)-lastWest;
			lastWest=west;
			
			r=(r+(north*10));
			r=(r-(south*10));
			r=(r+(east*10));
			r=(r-(west*10));
			
			if(r<0)
				r=0;
			if (r>255)
				r=255;
			
			if(r!=lastR) {
				button.setLed(1, new Color(r,g,b));
				lastR=r;
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
	}
	
}
