package com.design.patterns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

abstract class Bridge { 
	static final Logger LOGGER=LogManager.getLogger(App.class);

		protected Work w1; 
		protected Work w2; 
		protected Bridge(Work w1, Work w2) 
		{ 
			this.w1 = w1; 
			this.w2 = w2; 
		} 

		abstract public void manufacture(); 
	} 
	class Car extends Bridge { 
		public Car(Work w1, Work w2) 
		{ 
			super(w1, w2); 
		} 
		public void manufacture() 
		{ 
			LOGGER.info("Car "); 
			w1.work(); 
			w2.work(); 
		} 
	}  
	class Bike extends Bridge { 
		public Bike(Work w1, Work w2) 
		{ 
			super(w1, w2); 
		} 
		public void manufacture() 
		{ 
			LOGGER.info("Bike "); 
			w1.work(); 
			w2.work(); 
		} 
	} 
	interface Work
	{ 
		static final Logger LOGGER=LogManager.getLogger(App.class);

		abstract public void work(); 
	} 
	class Produce implements Work { 
		public void work() 
		{ 
			LOGGER.info("Produced"); 
		} 
	} 
	class Assemble implements Work { 
		public void work() 
		{ 
			LOGGER.info(" And"); 
			LOGGER.info(" Assembled."); 
		} 
	} 