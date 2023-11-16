package AdditionalExercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(css = "area[alt='Fish']")
    private WebElement enterFishListPage;

    @FindBy(css = "#Content ul[class='messages'] li")
    private WebElement warningMessage;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getWarningMessage(){
        String warningMsg = warningMessage.getText();
        return warningMsg;
    }
}
