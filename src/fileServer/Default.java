package fileServer;

import java.util.Scanner;

public class Default 
{
	public static void main(String[] args) 
	{
		//Variables
		int mainMenu = 0;
		//int serverConnect;
		//int printFile;
		//int downloadFile;
		//int quit;
		
		//Scanner - allows the user input from the console
		Scanner console = new Scanner(System.in);	
		
		//While Loop
		while(mainMenu <= 3)
		{
			//Main menu options
			System.out.println("1.Connect to server");
			System.out.println("2.Print File Listing");
			System.out.println("3.Download File");
			System.out.println("4.Quit");
			mainMenu = console.nextInt();
			
		}//end of while
		
	}//main

}//Default
