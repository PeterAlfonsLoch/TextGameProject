package de.anghenfil.sql;
import java.sql.*;
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
}
