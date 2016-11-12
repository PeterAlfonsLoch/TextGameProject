package de.anghenfil.maingame;

import java.util.Objects;
import java.util.Scanner;

import de.anghenfil.room.Room;
import de.anghenfil.sql.RoomSQL;
import de.anghenfil.textdesign.TD;

public class MainControl {
	static boolean exit = false;
	static String rawinput;
	static String[] input;
	public static void checkInputs(Room room){
		Scanner sc = new Scanner(System.in);
		while(exit != true){
			TD.input();
			rawinput = sc.nextLine();
			rawinput = rawinput.toLowerCase();
			input = rawinput.split("\\s");
			switch(input[0]){
			case "help":
				commandHelp();
				break;
			case "ende":
			case "exit":
				commandExit();
				break;
			case "gehe":
				commandGehe(input, room);
				break;
			default:
				TD.error();
				break;
			}
		}
		sc.close();
	}
	private static void commandGehe(String[] input, Room room) {
		if(Objects.equals(input[1], "nach")){
			switch(input[2]){
			case "norden":
				System.out.println("Gehe nach Norden ...");
				RoomSQL.loadRoom(room.getNextRoomN());
				TD.description(room.getRoomDescription());
				break;
			case "sueden":
				System.out.println("Gehe nach Süden ...");
				RoomSQL.loadRoom(room.getNextRoomS());
				TD.description(room.getRoomDescription());
				break;
			case "westen":
				System.out.println("Gehe nach Westen ...");
				RoomSQL.loadRoom(room.getNextRoomW());
				TD.description(room.getRoomDescription());
				break;
			case "osten":
				System.out.println("Gehe nach Osten ...");
				RoomSQL.loadRoom(room.getNextRoomE());
				TD.description(room.getRoomDescription());
				break;
			default:
				TD.error();
			}
		}
	}
	private static void commandExit() {
		TD.description("Du schläfst langsam ein und verlässt diese Welt.");
		exit = true;
	}
	public static void commandHelp(){
		
	}
}
