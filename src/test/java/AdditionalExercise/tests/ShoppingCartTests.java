package AdditionalExercise.tests;

import AdditionalExercise.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.jar.Manifest;

import static org.testng.Assert.assertEquals;

public class ShoppingCartTests extends TestBase {

    @Test
    public void userCantCheckoutWithoutLogin(){
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnEnterStoreLink();

        MainPage mainPage = new MainPage();
        mainPage.clickOnFishImgBtn();

        FishListPage fishListPage = new FishListPage();
        fishListPage.clickOnAnglefishId();

        AngelfishListPage angelfishListPage = new AngelfishListPage();
        angelfishListPage.addSmallAngelfishToCart();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.clickOnProceedToCheckOutBtn();

        LoginPage loginPage = new LoginPage();
        assertEquals(loginPage.getWarningMessage(), "You must sign on before attempting to check out. Please sign on and try checking out again.");
    }

}
