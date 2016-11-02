package de.anghenfil.mainmenu;
import de.anghenfil.user.*;
import de.anghenfil.editor.*;
import java.util.Scanner;
import de.anghenfil.textdesign.*;

public class MainMenu {

	public static void main(String[] args) {
		boolean createnew; //True if no save file exists
		String decision;
		Scanner sc = new Scanner(System.in);
		
		TD.input_question("Editor oder Spiel starten?");
		decision = sc.next();
		decision = decision.toLowerCase(); //Making input lower case
		switch(decision){
		case "editor":
			Editor.editor();
			break;
		case "spiel":
			createnew = UserManager.checkUserData(); //Check if User file already exists
			if(createnew){ //If new user needed
				UserManager.userCreation(); //Start User Creation
				UserManager.loadUser(); //Load  User data (from User Creation) and start game
			}else if(createnew == false){
				UserManager.loadUser(); //Load User data and starts game
			}
			break;
		default:
			main(args);
		}
		sc.close();
	}

}
