package main;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class UserGameInfo {
	
	// TODO Fields and getters and setters
	private String userName; 
	private boolean finished;
	private int level; 
	private int hp; 
	private int mana;
	private int satiety; 
	private int attack;
	private int defense; 
	private int vision;
	private double hpReg; 
	private double manaReg; 
	private int experience;
	
	public String toJson() {
		// TODO Serialization
		throw new NotImplementedException();
	}
	
}
