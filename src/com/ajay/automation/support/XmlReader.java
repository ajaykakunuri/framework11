package com.ajay.automation.support;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlReader {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		File file=new File("C:\\Users\\lenovo\\eclipse-workspace\\Framework1\\src\\com\\ajay\\automation\\support\\demo.xml");

		DocumentBuilderFactory dbfc=DocumentBuilderFactory.newInstance();
		DocumentBuilder db=dbfc.newDocumentBuilder();
		Document document=db.parse(file);
		document.getDocumentElement().normalize();
		String nodename=document.getDocumentElement().getNodeName();
		System.out.println(nodename);
		NodeList nodelist=document.getElementsByTagName("emp");
		for(int i=0;i<nodelist.getLength();i++)
		{
			Node node=nodelist.item(i);
			System.out.println("node names are"+node.getNodeName());
			if(node.getNodeType()==Node.ELEMENT_NODE)
			{
				Element element=(Element) node;
				System.out.println("emp id:"+element.getElementsByTagName("empname").item(0).getTextContent());
				System.out.println("emp id:"+element.getElementsByTagName("empsal").item(0).getTextContent());
				
				
			}
			
				
			
			
				
			
		}

	}

}
