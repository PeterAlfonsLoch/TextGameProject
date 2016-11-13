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
			System.out.println("Raum erstellen, Raum editieren, oder Editor verlassen?");
			choise = sc.nextLine();
			choise = choise.toLowerCase();
			switch(choise){
			case "raum erstellen":
				RoomEdit.createRoom(); //Room Creation
				break;
			case "raum editieren":
				//Room Editing comes here
				break;
			case "exit":
			case "editor verlassen":
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
