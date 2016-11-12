package de.anghenfil.sql;
import java.sql.*;
import java.util.Scanner;

import de.anghenfil.room.Room;

public class RoomSQL {
	public static Room loadRoom(int roomID){
		Room room = new Room();
		Connection c = null;
		Statement stmt = null;
	    try {
	        Class.forName("org.sqlite.JDBC");
	        c = DriverManager.getConnection("jdbc:sqlite:data/rooms.db");
	        
	        stmt = c.createStatement();
	        ResultSet rs = stmt.executeQuery("SELECT * FROM rooms");
	        while(rs.next()){
	        	room.setRoomID(rs.getInt("roomID"));
	        	room.setNextRoomE(rs.getInt("nextRoomE"));
	        	room.setNextRoomW(rs.getInt("nextRoomW"));
	        	room.setNextRoomN(rs.getInt("nextRoomN"));
	        	room.setNextRoomS(rs.getInt("nextRoomS"));
	        	room.setRoomDescription(rs.getString("roomDescription"));
	        }
	        rs.close();
	        stmt.close();
	        c.close();
	      } catch ( Exception e ) {
	        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	        System.exit(0);
	      }
	    return room;
	}
	public static void saveRoom(int roomID, int nextRoomE, int nextRoomW, int nextRoomN, int nextRoomS, String roomDescription){
		Connection c = null;
		
		try{
		Class.forName("org.sqlite.JDBC");
        c = DriverManager.getConnection("jdbc:sqlite:data/rooms.db");
        PreparedStatement ps = c.prepareStatement("INSERT INTO rooms (roomID, nextRoomE, nextRoomW, nextRoomN, nextRoomS, roomDescription) VALUES (?, ?, ?, ?, ?, ?)");
        ps.setInt(1, roomID);
        ps.setInt(2, nextRoomE);
        ps.setInt(3, nextRoomW);
        ps.setInt(4, nextRoomN);
        ps.setInt(5, nextRoomS);
        ps.setString(6, roomDescription);
        ps.executeQuery();
        ps.close();
        c.close();
      } catch ( Exception e ) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
      }
	}
}
