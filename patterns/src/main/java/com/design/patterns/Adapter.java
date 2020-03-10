package com.design.patterns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
interface Adapter
	{ 
	static final Logger LOGGER=LogManager.getLogger(App.class);

		public void fly(); 
		public void makeSound(); 
	} 

	class Sparrow implements Adapter 
	{ 		public void fly() 
		{ 
			LOGGER.info("Flying"); 
		} 
		public void makeSound() 
		{ 
			LOGGER.info("Chirp Chirp"); 
		} 
	} 

	interface Duck 
	{ 
		public void squeak(); 
	} 

	class ToyDuck implements Duck 
	{ 
		static final Logger LOGGER=LogManager.getLogger(App.class);

		public void squeak() 
		{ 
			LOGGER.info("Squeak"); 
		} 
	} 

	class BirdAdapter implements Duck 
	{ 
	   Adapter bird; 
		public BirdAdapter( Adapter bird) 
		{ 
			this.bird = bird; 
		} 

		public void squeak() 
		{ 
			bird.makeSound(); 
		} 
	} 

//	class Main 
//	{ 
//		public static void main(String args[]) 
//		{ 
//			Sparrow sparrow = new Sparrow(); 
//			ToyDuck toyDuck = new PlasticToyDuck(); 
//			ToyDuck birdAdapter = new BirdAdapter(sparrow); 
//
//			System.out.println("Sparrow..."); 
//			sparrow.fly(); 
//			sparrow.makeSound(); 
//
//			System.out.println("ToyDuck..."); 
//			toyDuck.squeak(); 
//			System.out.println("BirdAdapter..."); 
//			birdAdapter.squeak(); 
//		} 
//	} 
//
//}
