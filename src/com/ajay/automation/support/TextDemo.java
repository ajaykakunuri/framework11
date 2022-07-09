package com.ajay.automation.support;

import java.io.File;
import java.io.IOException;

public class TextDemo {
public static void main(String[] args) throws IOException {
	
	File file=new File("C:\\Users\\lenovo\\eclipse-workspace\\Framework1\\src\\com\\ajay\\automation\\support\\demo.txt");
	
	boolean status=file.createNewFile();
	if(status)
	{
		System.out.println("file created");
		
	}
	else {
		System.out.println("not");
		
	}
}
}
