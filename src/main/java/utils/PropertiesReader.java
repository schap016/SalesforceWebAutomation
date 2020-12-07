package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;

public class PropertiesReader {

	InputStream inputStream;

	Hashtable<Object, Object> properties = new Hashtable<Object, Object>();

	public Hashtable<Object, Object> getProperties() throws IOException {

		try {
			Properties prop = new Properties();
			Set<Object> props = null;

			inputStream = getClass().getClassLoader().getResourceAsStream("Props.properties");

			if (inputStream != null) {
				prop.load(inputStream);
				props = prop.keySet();
			} else {
				throw new FileNotFoundException("property file not found in the classpath");
			}

			for (Object key : props) {

				properties.put(key, prop.get(key));

			}

		} catch (Exception e) {

			System.out.println(e);
		}

		return properties;
	}

}
