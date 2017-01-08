package ie.gmit.sw.client;

import java.util.*;

import javax.naming.Context;

//import ie.gmit.sw.client.config.Context;
//import ie.gmit.sw.client.config.XMLParser;

public class ClientRunner 
{
		static Scanner console = new Scanner(System.in);
		
		public static void main(String[] args) throws Throwable
		{
			
			//Context ctx = new Context();
			//XMLParser cp = new XMLParser(ctx);
			//cp.init();
			// System.out.println(ctx);
			
			int userChoice = 0;
			
			//Do while loop - the statement below will execute while the statement is true
			do
			{
				System.out.println("\n1. Connect to Server");
				System.out.println("2. Print File Listing");
				System.out.println("3. Download File");
				System.out.println("4. Quit");
				userChoice = console.nextInt();
			
			
				//If statement - allowing the user to complete the tasks
				if(userChoice == 1)
				{
					System.out.println("Connects to the server");
					Client client = new Client();
					client.connect();
				}//if
				else if(userChoice == 2)
				{
					System.out.println("\nPrint File");
				}//elseif
				else if(userChoice == 3)
				{
					System.out.println("\nDownload File");
				}//elseif
				else
				{
					System.out.println("\nQuit");
				}//else
				
			}while(userChoice <= 3);

			
		}// End main
	}// End class
