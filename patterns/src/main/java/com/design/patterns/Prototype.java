package com.design.patterns;
import java.io.*;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
abstract class Prototype implements Cloneable 
	{ 
	static final Logger LOGGER=LogManager.getLogger(App.class);

		protected String animaltype; 
		abstract void print(); 
		public Object clone() 
		{ 
			Object clone = null; 
			try
			{ 
				clone = super.clone(); 
			} 
			catch (CloneNotSupportedException e) 
			{ 
				e.printStackTrace(); 
			} 
			return clone; 
		} 
	} 

	class Bird extends Prototype
	{ 
		public Bird() 
		{ 
			this.animaltype = "bird"; 
		} 
		void print() 
		{ 
			LOGGER.info("This is bird"); 
		} 
		
	} 
	class Snake extends Prototype{ 

		public Snake() 
		{ 
			this.animaltype= "Snake"; 
		} 
		void print() 
		{ 
		LOGGER.info("This is snake"); 
		} 
	} 

	class Animal { 

		private static Map<String, Prototype> animal = new HashMap<String, Prototype>(); 
		
		static
		{ 
			animal.put("bird", new Bird()); 
			animal.put("Snake", new Snake()); 
		} 
		
		public static Prototype getanimaltype(String animaltype) 
		{ 
			return (Prototype) animal.get(animaltype).clone(); 
		} 
	} 
