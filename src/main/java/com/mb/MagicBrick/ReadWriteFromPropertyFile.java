package com.mb.MagicBrick;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

public class ReadWriteFromPropertyFile
{
	public String FileName=null;
	public ReadWriteFromPropertyFile(String fileName)
	{
		this.FileName=fileName;
	}
	
	public static void main(String args[]) throws IOException
	{
		ReadWriteFromPropertyFile prop=new ReadWriteFromPropertyFile("andriod_config_");
		System.out.println(prop.readProperty().getProperty("ip"));
		System.out.println(prop.readProperty().getProperty("port"));
		System.out.println(prop.readProperty().getProperty("deviceName"));
		System.out.println(prop.readProperty().getProperty("platformName"));
	}

	public Properties readProperty() throws IOException 
	{
		Properties prop=new Properties();
		InputStream input=null;
		String filename="utils/"+FileName+".properties";
		input=ReadWriteFromPropertyFile.class.getClassLoader().getResource(filename).openStream();
		if(input==null)
		{
			System.out.println("Sorry, unable to find " +FileName);
		}
		prop.load(input);
		return prop;
		
	}
	
	public void writeProperties() throws IOException
	{
		String filename="utils/"+FileName+".properties";
		FileInputStream in=new FileInputStream(filename);
		Properties props=new Properties();
		props.load(in);
		in.close();
		
		FileOutputStream out=new FileOutputStream(filename);
		props.store(out,null);
		out.close();
		
	}

}
