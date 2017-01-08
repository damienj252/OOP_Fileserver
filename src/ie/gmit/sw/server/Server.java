package ie.gmit.sw.server;

import java.io.*; 
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Calendar; 

public class Server 
{
	private ServerSocket serversocket;
	
	private static final int SERVER_PORT = 7777;  
	
	private volatile boolean keepRunning = true;
	
	public Server()
	{
		//Try catch 
		try 
		{ 
			
			serversocket = new ServerSocket(SERVER_PORT); 
			
			Thread server = new Thread(new Listener(), "Web Server Listener");
			server.setPriority(Thread.MAX_PRIORITY); 
			server.start();
			
			System.out.println("Server started and listening on port " + SERVER_PORT);
			
		}//try
		catch (IOException e)
		{
			System.out.println("Error: " + e.getMessage());
		}//catch
	} // end Server
	
	//Main method - to start the server
	public static void main(String[] args)
	{
		new Server(); 
	}//main
	
	private class Listener implements Runnable
	{
		
		public void run() 
		{
			int counter = 0; 
			while (keepRunning)
			{ 
				//try catch
				try 
				{
					
					Socket s = serversocket.accept(); 
					
					new Thread(new HTTPRequest(s), "Thread " + counter).start(); 
					counter++; 
				}//try
				catch (IOException e) 
				{ 
					System.out.println("Error: " + e.getMessage());
				}//catch
			}//while loop
		}// end run
		
	} // end listerner
	
	private class HTTPRequest implements Runnable
	{
		private Socket socket; 
		
		private HTTPRequest(Socket request) 
		{ 
			this.socket = request; 
		}//HTTPRequest
		
		//Run method 
        public void run() 
        {
            try
            { 
            	//Origin source: https://docs.oracle.com/javase/7/docs/api/java/io/ObjectOutputStream.html
            	ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Object command = in.readObject(); 
                
                Calendar now = Calendar.getInstance();
                SimpleDateFormat formatter = new SimpleDateFormat("hh:mma zzz 'on' dd MMMM yyyy");
                String message = formatter.format(now.getTime());
                
            	ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(message);
                out.flush();
                out.close(); 
                
            }//try 
            catch (Exception e) 
            { 
            	System.out.println("Error: " + socket.getRemoteSocketAddress());
            	e.printStackTrace();
            }//catch
        } // end run
        
	} // end HTTPRequest
}//Server