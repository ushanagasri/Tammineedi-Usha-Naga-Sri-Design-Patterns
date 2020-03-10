package com.design.patterns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

interface Chainofresponsibility 
{ 
	static final Logger LOGGER=LogManager.getLogger(App.class);

	public abstract void setNext(Chainofresponsibility nextInChain); 
	public abstract void process(Number request); 
} 

class Number 
{ 
	private int number; 

	public Number(int number) 
	{ 
		this.number = number; 
	} 

	public int getNumber() 
	{ 
		return number; 
	} 

} 

class Negative implements Chainofresponsibility
{ 
	private Chainofresponsibility nextInChain; 

	public void setNext(Chainofresponsibility c) 
	{ 
		nextInChain = c; 
	} 

	public void process(Number request) 
	{ 
		if (request.getNumber() < 0) 
		{ 
			LOGGER.info("Negative : " + request.getNumber()); 
		} 
		else
		{ 
			nextInChain.process(request); 
		} 
	} 
} 

class Zero implements Chainofresponsibility
{ 
	
	private Chainofresponsibility nextInChain; 

	public void setNext(Chainofresponsibility c) 
	{ 
		nextInChain = c; 
	} 

	public void process(Number request) 
	{ 
		if (request.getNumber() == 0) 
		{ 
			LOGGER.info("Zero : " + request.getNumber()); 
		} 
		else
		{ 
			nextInChain.process(request); 
		} 
	} 
} 

class Positive implements Chainofresponsibility
{ 

	private Chainofresponsibility nextInChain; 

	public void setNext(Chainofresponsibility c) 
	{ 
		nextInChain = c; 
	} 

	public void process(Number request) 
	{ 
		if (request.getNumber() > 0) 
		{ 
			LOGGER.info("Positive : " + request.getNumber()); 
		} 
		else
		{ 
			nextInChain.process(request); 
		} 
	} 
} 


