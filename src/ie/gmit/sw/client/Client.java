package ie.gmit.sw.client;

import java.io.*; 
import java.net.*;
import ie.gmit.sw.server.*;

public class Client
{
		
	public void connect() 
	{ 
		//try catch - if an error occurs it will catch it and output to the console
		try 
		{ 
			Socket s = new Socket("localhost", 7777);
			
			ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
			out.writeObject(new Server());
			out.flush();
			
			Thread.yield();
			
			ObjectInputStream in = new ObjectInputStream(s.getInputStream());
			String response = (String) in.readObject();
			
			String threadName = Thread.currentThread().getName(); 
			
			s.close(); // Tidy up
			
		}//try 
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		} // end try/catch
	} //connect()
		
}//client