package de.anghenfil.editor;
import java.util.Scanner;

import de.anghenfil.sql.RoomSQL;
import de.anghenfil.textdesign.TD;

public class RoomEdit {
	
	public static void createRoom(){
		int roomID = 0;
		int nextRoomN = 0;
		int nextRoomS = 0;
		int nextRoomE = 0;
		int nextRoomW = 0;
		String roomDescription = "unset";
		String choise = "unset";
		boolean allCorrect = false;
		boolean roomIDCorrect = false;
		boolean nextRoomNCorrect = false;
		boolean nextRoomSCorrect = false;
		boolean nextRoomECorrect = false;
		boolean nextRoomWCorrect = false;
		
		Scanner sc = new Scanner(System.in);
		//Room Creation
		while(allCorrect != true){
		TD.headline("Room Creator");
		TD.description("Die RoomID ist optional. Leerlassen um eine RoomID zu generieren.");
		while(roomIDCorrect != true){
			TD.input_question("RoomID: ");
			if(sc.hasNextLine() && sc.nextLine().equals("")){ //If User submitted no Input, only Enter Key
				roomID = (int) (Math.random() *98999) + 1000;
			}else{
				roomID = sc.nextInt();
			}
			if(!RoomSQL.roomExist(roomID)){
				roomIDCorrect = true;
			}else{
				TD.error("RoomID bereits verwendet. Bitte neue wählen oder zufällig generieren lassen.");
			}
		}
		while(nextRoomNCorrect != true){
			TD.input_question("Nördlicher Raum: ");	
			if(sc.hasNextLine() && sc.nextLine().equals("")){ //If User submitted no Input, only Enter Key
				nextRoomN = 0;
				nextRoomNCorrect = true;
			}else{
				nextRoomN = sc.nextInt();
				if(RoomSQL.roomExist(roomID)){
					nextRoomNCorrect = true;
				}else{
					TD.error("Raum mit der RoomID "+nextRoomN+" existiert nicht. Bitte neuen eingeben.");
				}
			}
		}
		while(nextRoomSCorrect != true){
			TD.input_question("Südlicher Raum: ");	
			if(sc.hasNextLine() && sc.nextLine().equals("")){ //If User submitted no Input, only Enter Key
				nextRoomS = 0;
				nextRoomSCorrect = true;
			}else{
				nextRoomS = sc.nextInt();
				if(RoomSQL.roomExist(roomID)){
					if(nextRoomS == nextRoomN){ //If the Next Room in South Direction is the same as in North Direction Abort
						TD.error("Der nächste Raum in Südlicher Richtung darf nicht dem vorherigem entsprechen!");
					}else{
						nextRoomSCorrect = true;
					}
				}else{
					TD.error("Raum mit der RoomID "+nextRoomS+" existiert nicht. Bitte neuen eingeben.");
				}
			}
		}
		while(nextRoomWCorrect != true){
			TD.input_question("Westlicher Raum: ");	
			if(sc.hasNextLine() && sc.nextLine().equals("")){ //If User submitted no Input, only Enter Key
				nextRoomW = 0;
				nextRoomWCorrect = true;
			}else{
				nextRoomW = sc.nextInt();
				if(RoomSQL.roomExist(roomID)){
					if(nextRoomW == nextRoomS || nextRoomW == nextRoomN ){
						TD.error("Der nächste Raum in Südlicher Richtung darf nicht einem der vorherigen entsprechen!");
					}else{
					nextRoomWCorrect = true;
					}
				}else{
					TD.error("Raum mit der RoomID "+nextRoomW+" existiert nicht. Bitte neuen eingeben.");
				}
			}
		}
		while(nextRoomECorrect != true){
			TD.input_question("Östlicher Raum: ");	
			if(sc.hasNextLine() && sc.nextLine().equals("")){ //If User submitted no Input, only Enter Key
				nextRoomE = 0;
				nextRoomECorrect = true;
			}else{
				nextRoomE = sc.nextInt();
				if(RoomSQL.roomExist(roomID)){
					if(nextRoomE == nextRoomS || nextRoomE == nextRoomN || nextRoomE == nextRoomW){
						TD.error("Der nächste Raum in Südlicher Richtung darf nicht einem der vorherigen entsprechen!");
					}else{
					nextRoomWCorrect = true;
					}
				}else{
					TD.error("Raum mit der RoomID "+nextRoomE+" existiert nicht. Bitte neuen eingeben.");
				}
			}
		}
		TD.input_question("Raumbeschreibung: ");
		roomDescription = sc.nextLine();
		System.out.println("Raum mit folgenden Einstellungen erstellen? (ja/nein)\n roomID: "+roomID+" | nextRoomE: "+nextRoomE+" | nextRoomW: "+nextRoomW+" | nextRoomN: "+nextRoomN+" | nextRoomS: "+nextRoomS+" | roomDescription: "+roomDescription);
		choise = sc.next();
		choise.toLowerCase();
		if(choise.equals("ja")){
			allCorrect = true;
			RoomSQL.saveRoom(roomID, nextRoomE, nextRoomW, nextRoomN, nextRoomS, roomDescription);
		}
		}
		sc.close();
	}
}
