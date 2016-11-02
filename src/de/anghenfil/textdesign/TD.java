package de.anghenfil.textdesign;
import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
//import static org.fusesource.jansi.Ansi.Color.*;

public class TD {
	public static void headline(String content){
		AnsiConsole.systemInstall();
		int countchars;
		String line = "";
		
		countchars = content.length();
		for(int i = 0;i<countchars+2;i++){
			line = line.concat("=");
		}
		System.out.println(ansi().render("@|green "+ line + "|@"));
		System.out.println(content);
		System.out.println(ansi().render("@|green "+ line + "|@"));
		AnsiConsole.systemUninstall();
	}public static void input_question(String content){
		AnsiConsole.systemInstall();
		System.out.println(ansi().render("@|green "+"|| " + "|@" + content));
		System.out.print(ansi().render("@|red "+ "=> |@"));
		AnsiConsole.systemUninstall();
	}public static void input(){
		AnsiConsole.systemInstall();
		System.out.print(ansi().render("@|red "+ "=> |@"));
		AnsiConsole.systemUninstall();
	}
	public static void description(String content){
		AnsiConsole.systemInstall();
		System.out.println(ansi().render("@|bold "+ content + "|@"));
		AnsiConsole.systemUninstall();
	}public static void error(String content){
		AnsiConsole.systemInstall();
		System.out.println(ansi().render("@|red "+ content + "|@"));
		AnsiConsole.systemUninstall();
	}public static void error(){
		error("Deine Antwort konnte nicht erkannt werden. Bitte wiederhole deine Eingabe!");
	}
}
