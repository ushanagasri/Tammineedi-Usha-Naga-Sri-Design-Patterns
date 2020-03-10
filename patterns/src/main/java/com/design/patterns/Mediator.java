package com.design.patterns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

interface Mediator 
{ 
	static final Logger LOGGER=LogManager.getLogger(App.class);

	public void registerRunway(Runway runway); 

	public void registerFlight(Flight flight); 

	public boolean isLandingOk(); 

	public void setLandingStatus(boolean status); 
} 

class ATCMediator implements Mediator 
{ 
	private Flight flight; 
	private Runway runway; 
	public boolean land; 
	public void registerRunway(Runway runway) 
	{ 
		this.runway = runway; 
	} 
public void registerFlight(Flight flight) 
	{ 
		this.flight = flight; 
	}
	public boolean isLandingOk() 
	{ 
		return land; 
	} 
	public void setLandingStatus(boolean status) 
	{ 
		land = status; 
	} 
} 

interface Command 
{ 
	static final Logger LOGGER=LogManager.getLogger(App.class);

	void land(); 
} 


class Flight implements Command 
{ 
	private Mediator atcMediator; 

	public Flight(Mediator atcMediator) 
	{ 
		this.atcMediator = atcMediator; 
	} 

	public void land() 
	{ 
		if (atcMediator.isLandingOk()) 
		{ 
			LOGGER.info("Successfully Landed."); 
			atcMediator.setLandingStatus(true); 
		} 
		else
		LOGGER.info("Waiting for landing."); 
	} 

	public void getReady() 
	{ 
		LOGGER.info("Ready for landing."); 
	} 

} 

class Runway implements Command 
{ 
	private Mediator atcMediator; 

	public Runway(Mediator atcMediator) 
	{ 
		this.atcMediator = atcMediator; 
		atcMediator.setLandingStatus(true); 
	} 
	public void land() 
	{ 
		LOGGER.info("Landing permission granted."); 
		atcMediator.setLandingStatus(true); 
	} 

} 
