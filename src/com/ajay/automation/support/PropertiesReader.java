package com.ajay.automation.support;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;



public class PropertiesReader {
	private String filepath;
	private FileInputStream fip;
	private Properties properties;
	private String value;
	public PropertiesReader(String filepath) throws IOException
	{
		this.filepath=filepath;
		fip=new FileInputStream(filepath);
		properties=new Properties();
		properties.load(fip);
		
		
	}
	public String getPropertyValue(String key)
	{
		if(properties!=null)
		value=properties.getProperty(key);
		else
		{
			System.out.println("pointing to null");
		}
		return value;
	}
	public String getPropertyValue(String key,String defaultvalue)
	{
		if(properties!=null)
		value=properties.getProperty(key);
		if(value==null)
		value=defaultvalue;
		else
		{
			System.out.println("pointing to null");
		}
		return value;
	}
	
	public String getPropertyValue(Object key)
	{
		if(properties!=null)
		value=(String) properties.get(key);
		else
		{
			System.out.println("pointing to null");
		}
		return value;
	}
	public String getPropertyValue(Object key,Object defaultvalue)
	{
		if(properties!=null)
		value=(String) properties.getOrDefault(key, defaultvalue);
		if(value==null)
		value=(String) defaultvalue;
		else
		{
			System.out.println("pointing to null");
		}
		return value;
	}
	public void removeKeyValue(String key,String keyvalue) throws IOException
	{
		if(properties!=null)
	
		{
		properties.remove(key, value);
	  FileOutputStream fop=new FileOutputStream(filepath);
	  properties.store(fop, "file saved");
		}
		else
		{
			System.out.println("pointing to null");
		}
		}

	public void writeKeyValue(String key,String value) throws IOException
	{
		if(properties!=null)
			
		{
		properties.put(key, value);
	  FileOutputStream fop=new FileOutputStream(filepath);
	  properties.store(fop, "file saved");
		}
		else
		{
			System.out.println("pointing to null");
		
		}
	}
	public Set getAllKeys()
	{
		Set setKeys=null;
		if(properties!=null) {
			setKeys=properties.keySet();
		}
		else
		{
			System.out.println("pointing to null");
		
	}
		return setKeys;
		}
	public List allValues()
	{
		Set Keys=getAllKeys();
		List listKeys=new ArrayList<>();
		for(Object objkeys:Keys)
		{
			Object value=properties.get(objkeys);
			listKeys.add(value);
			
		}
		return listKeys;
	}
	public Map<String,String> getAllKeysValues()
	{
		Map<String,String> mapKeyValue=new LinkedHashMap<String,String>();
		Set setKeys=getAllKeys();
		for(Object obj:setKeys)
		{
			String key=(String) obj;
			value=properties.getProperty(key);
			mapKeyValue.put(key, value);
		}
		return mapKeyValue;
		}
		
	
public void writeKeyValue(Object key,Object value) throws IOException
{
	if(properties!=null)
		
	{
	properties.put(key, value);
  FileOutputStream fop=new FileOutputStream(filepath);
  properties.store(fop, "file saved");
	}
	else
	{
		System.out.println("pointing to null");
	
	}
}
public void removeKey(String key) throws IOException
{
if(properties!=null)
		
	{
	properties.remove(key);
  FileOutputStream fop=new FileOutputStream(filepath);
  properties.store(fop, "file saved");
	}
	else
	{
		System.out.println("pointing to null");
	
	}

}
}


