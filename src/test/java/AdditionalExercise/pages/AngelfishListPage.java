package AdditionalExercise.pages;

import AdditionalExercise.tests.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AngelfishListPage {

    @FindBy(css = "a.Button[href$='EST-2']")
    private WebElement addSmallFishToCartLink;

    public AngelfishListPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void addSmallAngelfishToCart(){
        addSmallFishToCartLink.click();
    }
}
