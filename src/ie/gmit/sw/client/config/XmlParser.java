package ie.gmit.sw.client.config;

import javax.xml.parsers.*;
import org.w3c.dom.*;

public class XmlParser 
{
	private Context ctx;

	public XmlParser(Context ctx) 
	{
		super();
		this.ctx = ctx;
	}
	
	//initialise()
	public void initialise() throws Throwable
	{
		//Origin source: https://www.tutorialspoint.com/java_xml/java_dom_parse_document.html
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(Context.CONFIG_FILE);
		
		Element root = doc.getDocumentElement(); 
		NodeList children = root.getChildNodes(); 
		
		//For Loop
		for (int i = 0; i < children.getLength(); i++)
		{ 
			Node next = children.item(i); 
			//if statement - if the element e = next element execute
			if (next instanceof Element)
			{ 
				Element e = (Element) next; 
				
				if (e.getNodeName().equals("database"))
				{ 
					NamedNodeMap atts = e.getAttributes(); 
					
					//for loop
					for (int j = 0; j < atts.getLength(); j++)
					{ 
						if (atts.item(j).getNodeName().equals("host"))
						{ 
							ctx.setHost(atts.item(j).getNodeValue());
						}//if
						else if (atts.item(j).getNodeName().equals("port"))
						{ 
							ctx.setPort(Integer.parseInt(atts.item(j).getNodeValue()));
						}//else if
					}//for loop
				}//if
			}//if
		}//for		
	}//initialise()

	public Context getCtx() 
	{
		return ctx;
	}

	public void setCtx(Context ctx) 
	{
		this.ctx = ctx;
	}
}//XmlParser
