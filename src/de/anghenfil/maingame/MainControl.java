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
			case "commands":
			case "hilfe":
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
				if(room.getNextRoomN() == 0){
					TD.error("In nördlicher Richtung geht es hier nicht weiter.");
				}else{
				System.out.println("Gehe nach Norden ...");
				RoomSQL.loadRoom(room.getNextRoomN());
				TD.description(room.getRoomDescription());
				}
				break;
			case "sueden":
				if(room.getNextRoomS() == 0){
					TD.error("In südlicher Richtung geht es hier nicht weiter.");
				}else{
				System.out.println("Gehe nach SÃ¼den ...");
				RoomSQL.loadRoom(room.getNextRoomS());
				TD.description(room.getRoomDescription());
				}
				break;
			case "westen":
				if(room.getNextRoomW() == 0){
					TD.error("In westlicher Richtung geht es hier nicht weiter.");
				}else{
				System.out.println("Gehe nach Westen ...");
				RoomSQL.loadRoom(room.getNextRoomW());
				TD.description(room.getRoomDescription());
				}
				break;
			case "osten":
				if(room.getNextRoomE() == 0){
					TD.error("In östlicher Richtung geht es hier nicht weiter.");
				}else{
				System.out.println("Gehe nach Osten ...");
				RoomSQL.loadRoom(room.getNextRoomE());
				TD.description(room.getRoomDescription());
				}
				break;
			default:
				TD.error();
			}
		}
	}
	private static void commandExit() {
		TD.description("Du schlÃ¤fst langsam ein und verlÃ¤sst diese Welt.");
		exit = true;
	}
	public static void commandHelp(){
		
	}
}
