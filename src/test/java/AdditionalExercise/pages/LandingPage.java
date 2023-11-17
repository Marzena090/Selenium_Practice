package AdditionalExercise.pages;

import AdditionalExercise.tests.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    @FindBy(xpath = "//div['content']/p/a")
    private WebElement enterStoreLink;

    public LandingPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnEnterStoreLink(){
        enterStoreLink.click();
    }
}
