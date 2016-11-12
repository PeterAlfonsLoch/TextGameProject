package de.anghenfil.maingame;
import de.anghenfil.user.*;
import de.anghenfil.textdesign.*;
import de.anghenfil.room.Room;
import de.anghenfil.sql.*;
public class MainGame {
	public static void play(User user){
		
		TD.headline("The TextGame Project V0.1");
		Room room = new Room();
		room = RoomSQL.loadRoom(1); //Later load last room from user
		MainControl.checkInputs(room);
	}
}
