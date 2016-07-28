package cn.edu.zucc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by shentao on 2016/6/12.
 */
public class ConfigUtils {

    private static Properties prop = null;

    static {
        InputStream is = ConfigUtils.class.getClassLoader().getResourceAsStream("config.properties");
        prop = new Properties();
        try {
            prop.load(is);
            is.close();
            is = null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String name){
        return prop.getProperty(name);
    }
}
