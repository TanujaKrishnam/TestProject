package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() throws IOException
	{
	
	File src = new File("./Configuration/Config.properties");

	FileInputStream fis = new FileInputStream(src);
	
	pro.load(fis);
	

}
	public String rt()
	{
		String url = pro.getProperty("baseURL");
		return url;
		
	}
	
	public String gcs()
	{
		String unam = pro.getProperty("username");
		return unam;
	}
	public String fsh()
	{
		String pswd = pro.getProperty("password");
		return pswd;
		
	}
}


