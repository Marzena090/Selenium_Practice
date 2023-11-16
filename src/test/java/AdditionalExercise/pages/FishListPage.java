package AdditionalExercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishListPage {

    private WebDriver driver;

    @FindBy(css = "tr:nth-child(2) a")
    private WebElement angelfishId;

    public FishListPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnAnglefishId(){
        angelfishId.click();
    }
}
