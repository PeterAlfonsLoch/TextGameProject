package de.anghenfil.editor;

import java.util.Scanner;

import de.anghenfil.mainmenu.MainMenu;
import de.anghenfil.textdesign.TD;

public class Editor {
	public static void editor(){
		boolean exit = false;
		String choise;
		Scanner sc = new Scanner(System.in);
		
		while(exit != true){
			choise = sc.nextLine();
			choise = choise.toLowerCase();
			switch(choise){
			case "Raum erstellen":
				RoomEdit.createRoom(); //Room Creation
				break;
			case "Raum editieren":
				//Room Editing comes here
				break;
			case "exit":
				exit = true;
				break;
			default:
				TD.error();
			}
		}
		sc.close();
		MainMenu.main(null);
	}
}
