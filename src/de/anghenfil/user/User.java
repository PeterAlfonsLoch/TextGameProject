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
	//Get and Set Methods:
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKlasse() {
		return klasse;
	}
	public String getRasse() {
		return rasse;
	}
	public void setRasse(String rasse) {
		this.rasse = rasse;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getAp() {
		return ap;
	}
	public void setAp(int ap) {
		this.ap = ap;
	}
	public int getAct_room() {
		return act_room;
	}
	public void setAct_room(int act_room) {
		this.act_room = act_room;
	}

	
}