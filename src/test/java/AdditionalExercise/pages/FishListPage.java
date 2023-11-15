package AdditionalExercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishListPage {

    private WebDriver driver;

    @FindBy(linkText = "FI-SW-01")
    private WebElement angelfishId;

    public void FishListPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnAnglefishId(){
        angelfishId.click();
    }
}
