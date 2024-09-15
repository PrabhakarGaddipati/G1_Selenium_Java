package selenium_utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Config_Utility
{
    private static final Logger logger = LogManager.getLogger(ConfigUtils.class);
    private static final Properties prop = new Properties();

    // Load properties from multiple configuration files
    public static void loadProperties()
    {
        loadPropertiesFromFile(System.getProperty("user.dir") + "/src/test/resources/config.properties");
    }

    // Load properties from a specific file
    private static void loadPropertiesFromFile(String filePath)
    {
        try (FileInputStream fileInputStream = new FileInputStream(new File(filePath)))
        {
            prop.load(fileInputStream);
            logger.info("Loaded properties from file: {}", filePath);
        }
        catch (IOException e)
        {
            logger.error("Failed to load properties from file: {}", filePath, e);
        }
    }

    // Retrieve a property value by key
    public static String getPropertyByKey(String key)
    {
        String value = prop.getProperty(key);
        if (value != null)
        {
            logger.info("Property retrieved - Key: {}, Value: {}", key, value);
        }
        else
        {
            logger.warn("Property not found for key: {}", key);
        }
        return value;
    }
}
