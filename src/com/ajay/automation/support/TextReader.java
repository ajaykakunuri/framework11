package com.ajay.automation.support;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextReader {
	private String filepath;
	private FileReader filereader;
	private BufferedReader bufferreader;
	private FileWriter fr;
	private BufferedWriter buffer;
	
	
	public TextReader(String filepath) throws IOException
	{
		this.filepath=filepath;

		File file=new File(filepath);
		
		boolean status=file.createNewFile();
		if(status)
		{
			System.out.println("file created");
			
		}
		else {
			System.out.println("not");
			
		}
		filereader=new FileReader(file);
		bufferreader=new BufferedReader(filereader);
	    fr=new FileWriter(file,true);
		buffer=new BufferedWriter(fr);
		
	}	
	
	

	public void writedata(int data) throws IOException
	{
		if(buffer!=null)
		{
			buffer.write(data);
			buffer.flush();
		}
		else
		{
			System.out.println("null");
		}
		
		}
	public void writedata(String data) throws IOException
	{
		if(buffer!=null)
		{
			buffer.write(data);
			buffer.flush();
		}
		else
		{
			System.out.println("null");
		}
		
		}
	public void writedata(List<String> data) throws IOException
	{
		if(buffer!=null)
		{
			for(String str:data)
			{
			buffer.write(str);
			buffer.flush();
		}
		}
		else
		{
			System.out.println("null");
		}
		
		}
	public List<String> getTotalFileData() throws IOException {
		
		List<String> filedata=new ArrayList<String>();
		if(bufferreader!=null) {
			while(bufferreader.ready())
			{
				String data=bufferreader.readLine();
				filedata.add(data);
			}
		}
			
		else
		{
			System.out.println("null");
		}
		
		return filedata;
		}
	

	}

	
	
	

