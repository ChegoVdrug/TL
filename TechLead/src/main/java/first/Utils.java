package first;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {

    public static String getProperty(String propName) throws IOException {

        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/server.properties");
        props.load(fis);
        String prop = (props.getProperty(propName));
        return prop;

    }
}
