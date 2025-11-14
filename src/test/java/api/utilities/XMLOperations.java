package api.utilities;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;

public class XMLOperations {
	
	public static void xmlreadersample() throws IOException
	{
		String path = System.getProperty("user.dir");
		XmlMapper mapper = new XmlMapper();
		Employee employee = mapper.readValue(new File(path+"\\src\\main\\resources\\Employee.xml"), Employee.class);
		System.out.println(employee.getName());
	}
	
	public static void main(String[] args) throws IOException {
		
		xmlreadersample();
		
	}

}
