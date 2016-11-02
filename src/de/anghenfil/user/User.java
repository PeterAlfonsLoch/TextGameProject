package de.anghenfil.user;
import java.io.Serializable;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6159905496838092464L;
	String name; //Character Name
	String klasse; //Character Class
	String rasse; //Character race
	int health; //Actual Health
	int ap; //Action Points -> = mana
	int act_room; //Room where the player is
	}

