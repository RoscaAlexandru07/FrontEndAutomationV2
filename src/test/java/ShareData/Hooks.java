package ShareData;

import PropertyUtility.PropertyUtility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks extends ShareData{

    public PropertyUtility propertyUtility;

    @BeforeMethod
    public void prepareEnvironment(){
        prepareBrowser();
        String testName = this.getClass().getSimpleName();
        propertyUtility = new PropertyUtility(testName);
    }

    @AfterMethod
    public void closeDrivers(){
        clearBrowser();
    }
}
