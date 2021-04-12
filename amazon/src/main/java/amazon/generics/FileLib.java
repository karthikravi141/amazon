package amazon.generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileLib {

	public String getProperty(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/main/resources/config.property");
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
}
