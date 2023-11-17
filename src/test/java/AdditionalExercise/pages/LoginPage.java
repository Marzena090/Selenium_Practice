package AdditionalExercise.pages;

import AdditionalExercise.tests.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(css = "area[alt='Fish']")
    private WebElement enterFishListPage;

    @FindBy(css = "#Content ul[class='messages'] li")
    private WebElement warningMessage;

    public LoginPage(){
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public String getWarningMessage(){
        String warningMsg = warningMessage.getText();
        return warningMsg;
    }
}
