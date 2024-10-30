package Pages;

import Base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class SearchDestination extends TestBase {
    @FindBy(id = "input-auto-complete")
    WebElement destination;
    @FindBy(xpath="//*[@id=\"suggestion-list\"]/ul/li[1]/div/div/div[2]/span[1]")
    WebElement searchDestination;

    @FindBy(xpath="//div[@id='usercentrics-root']")
    WebElement shadowHost;
    @FindBy(xpath = "//button(contains(text(),'OK'))")
    WebElement okButton;
    @FindBy(xpath = "q0nnsl hmTTnR _gW_vO")
    WebElement dateContainer;
    public SearchDestination() throws FileNotFoundException {
        super();
    }
    @BeforeClass
    public void setUp(){
        initialization();
        PageFactory.initElements(driver,this);
    }

    @DataProvider(name = "SelectDestination")
    public Object [][] provideDestination(){
       return new Object[][]{
               {"New Delhi"}
       };
    }

    @Test(dataProvider="SelectDestination",priority = 1)
    public void searchDestination(String des) throws InterruptedException {
       // WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        //wait.until(ExpectedConditions.visibilityOf(destination));
        //driver.switchTo().window(mainWindowHandle);
        Thread.sleep(3000);
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement okButton=shadowRoot.findElement(By.cssSelector("#focus-lock-id > div > div > " +
                "div.sc-eBMEME.cJNbyl > div > div > " +
                "div.sc-jsJBEP.iXSECa > div > button.sc-dcJsrY.NmLox"));
       okButton.click();
        //driver.switchTo().window(mainWindowHandle);
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(destination));
        destination.click();
        destination.sendKeys(des);
        searchDestination.click();
    }

    @Test(priority = 2)
    public void selectDate(){
        // Create a JavascriptExecutor instance
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        // Scroll down by 1000 pixels
        jsExecutor.executeScript("window.scrollBy(0, 200);");
        //selectDate.click();

        driver.findElement(By.xpath("//time[@datetime='2024-10-31']")).click();;

    }
}
