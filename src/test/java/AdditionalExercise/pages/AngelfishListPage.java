package AdditionalExercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AngelfishListPage {

    private WebDriver driver;

    @FindBy(css = "a.Button[href$='EST-2']")
    private WebElement addSmallFishToCartLink;

    public AngelfishListPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addSmallAngelfishToCart(){
        addSmallFishToCartLink.click();
    }
}
