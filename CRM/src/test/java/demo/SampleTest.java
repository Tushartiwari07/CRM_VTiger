package demo;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.tek.crm.genericutility.JsonUtility;


public class SampleTest  {

	
	@Test
	public void samlpe() throws FileNotFoundException, IOException, ParseException
	{
		JsonUtility jsonlib= new JsonUtility();
		String username = jsonlib.getDataFromJson("Username");
		String password = jsonlib.getDataFromJson("Password");
		System.out.println(username+"---"+ password);
	}
}
