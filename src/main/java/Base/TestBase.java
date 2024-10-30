package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

    Properties prop;
   public static WebDriver driver;
    public String mainWindowHandle;
    public TestBase() throws FileNotFoundException {
        prop=new Properties();
        FileInputStream file=new FileInputStream("/Users/prateekbhardwaj/IdeaProjects/" +
                "Practicet/src/" +
                "main/resources/config.properties");
        try {
            prop.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void initialization(){
        String browserName=prop.getProperty("browser");
        if(browserName.equals("chrome")){
            System.setProperty("Webdriver.chrome.driver","/Users/prateekbhardwaj/Desktop" +
                    "/ChromDriver");
            driver=new ChromeDriver();
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(prop.getProperty("url"));
        mainWindowHandle= mainWindowHandle=driver.getWindowHandle();
    }
}
