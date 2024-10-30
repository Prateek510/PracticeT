package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.Set;

public class LanguageAndCurrency extends TestBase {

    @FindBy(xpath = "//*[@id=\"__next\"]/div[1]/div[1]/div/header/" +
            "nav/ul/li[2]/button/span[2]//child::span[1]")
    WebElement languageIcon;
    @FindBy(id = "language-select")
    WebElement languageSelect;
    @FindBy(id="currency-select")
    WebElement currencySelect;
    @FindBy(xpath="//button[contains(text(),'Apply')]")
    WebElement applyButton;

    public LanguageAndCurrency() throws FileNotFoundException {
        super();
    }

    @BeforeClass
    public void setUp(){
        initialization();
        PageFactory.initElements(driver,this);
    }
    @Test(priority = 1)
    public void clickOnLanguageIcon(){
        languageIcon.click();
    }
    @Test(priority = 2)
    public void selectLanguage(){
        Select s=new Select(languageSelect);
        s.selectByVisibleText("English");
    }
    @Test(priority = 3)
    public void selectCurrency(){
        Select s=new Select(currencySelect);
        if(!s.getFirstSelectedOption().equals("USD - US Dollar")){
            s.selectByVisibleText("USD - US Dollar");
        }
    }
    @Test(priority = 4)
    public void clickApplyButton(){
        applyButton.click();
    }
    @Test(priority = 5)
    public void acceptCookies(){
        //WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        //wait.until(ExpectedConditions.alertIsPresent());
        //driver.switchTo().alert().accept();
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Main Window Handle: " + mainWindowHandle);

        // Adjust as necessary

        // Get all window handles
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                // Switch to the new window
                driver.switchTo().window(windowHandle);
                System.out.println("Switched to new window: " + windowHandle);
        }
    }
}}
