package AdditionalExercise.pages;

import AdditionalExercise.tests.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(css = "area[alt='Fish']")
    private WebElement enterFishListPage;

    public MainPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void clickOnFishImgBtn(){
        enterFishListPage.click();
    }
}
