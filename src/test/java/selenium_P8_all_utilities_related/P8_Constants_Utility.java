package selenium_P8_all_utilities_related;

import com.utils.PropertyUtils; // Your utility class to load properties
import com.enums.PropertyFileConstants;
import com.utils.PropertyUtils;

public class P8_Constants_Utility
{
         private P8_Constants_Utility()
         {

         }

         static
         {
             PropertyUtils.loadAllFiles(); // Load all properties once
         }

         // Invariant constants (hardcoded)
         public static final String RESOURCE_PATH = System.getProperty("user.dir");

         // Configurable constants (loaded from properties)
         public static final String CONFIG_PROPERTY_PATH = PropertyUtils.getValue("CONFIG_PROPERTY_PATH");
         public static final String TEST_DATA_FILE_PATH = PropertyUtils.getValue("TEST_DATA_FILE_PATH");
         public static final int MAX_EXPLICIT_WAIT_IN_SECONDS = Integer.parseInt(PropertyUtils.getValue("MAX_EXPLICIT_WAIT_IN_SECONDS"));
         public static final int EXPLICIT_WAIT_POLLING_DURATION = Integer.parseInt(PropertyUtils.getValue("EXPLICIT_WAIT_POLLING_DURATION"));

         // Method to handle default values or fallback mechanisms
         public static String getDefaultOrConfigValue(String key, String defaultValue)
         {
             String value = PropertyUtils.getValue(key);
             return (value != null && !value.isEmpty()) ? value : defaultValue;
         }
     }
