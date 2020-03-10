package com.design.patterns;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Hello world!
 *
 */
public class App 
{
	private static final Logger LOGGER=LogManager.getLogger(App.class);
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
       Animal.getanimaltype("bird").print();
       Animal.getanimaltype("Snake").print();
      Bridge v1 = new Car(new Produce(), new Assemble()); 
		v1.manufacture(); 
	Bridge v2 = new Bike(new Produce(), new Assemble()); 
			v2.manufacture(); 
			Sparrow sparrow = new Sparrow(); 
			Duck toyDuck = new ToyDuck(); 
			Duck birdAdapter = new BirdAdapter(sparrow);
			LOGGER.info("Sparrow..."); 
			sparrow.fly(); 
			sparrow.makeSound(); 
			LOGGER.info("ToyDuck..."); 
			toyDuck.squeak(); 
			LOGGER.info("BirdAdapter..."); 
			birdAdapter.squeak(); 
			Mediator atcMediator = new ATCMediator(); 
			Flight sparrow101 = new Flight(atcMediator); 
			Runway mainRunway = new Runway(atcMediator); 
			atcMediator.registerFlight(sparrow101); 
			atcMediator.registerRunway(mainRunway); 
			sparrow101.getReady(); 
			mainRunway.land(); 
			sparrow101.land();
			Chainofresponsibility c1 = new Negative(); 
			Chainofresponsibility c2 = new Zero(); 
			Chainofresponsibility c3 = new Positive(); 
			c1.setNext(c2); 
			c2.setNext(c3); 
			c1.process(new Number(90)); 
			c1.process(new Number(-50)); 
			c1.process(new Number(0));
    }
}
