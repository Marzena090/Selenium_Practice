package AdditionalExercise.pages;

import AdditionalExercise.tests.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishListPage {

    @FindBy(css = "tr:nth-child(2) a")
    private WebElement angelfishId;

    public FishListPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnAnglefishId(){
        angelfishId.click();
    }
}
