package ie.gmit.sw.client.config;

public class Context
{
	public static final String CONFIG_FILE="config.xml";
	private String host;
	private int port;
	
	public Context() 
	{
		super();
	}//Context()

//Getters & Setter
	public String getHost() 
	{
		return host;
	}//getHost()

	public void setHost(String host) 
	{
		this.host = host;
	}//setHost()

	public int getPort() 
	{
		return port;
	}//getPort()

	public void setPort(int port) 
	{
		this.port = port;
	}//setPort

	//
	@Override
	//toString - to tie in the host & port and change it to a string and output it
	public String toString()
	{
		return "Context [host=" + host + ", port=" + port + "]";
	}//toString
}//Context