package com.ajay.automation.orgproperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) throws IOException {
		FileInputStream fip=new FileInputStream("C:\\Users\\lenovo\\eclipse-workspace\\Framework1\\src\\com\\ajay\\automation\\orgproperties\\or.properties");
 Properties properties=new Properties();
 properties.load(fip);
  String val1=properties.getProperty("un_id");
  System.out.println(val1);
  String val2=properties.getProperty("un_next");
  System.out.println(val2);
	}

}
