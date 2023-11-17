package AdditionalExercise.tests;

public class DriverUtils {

   public static void setInitialConfig(){
       // maximize the window
       DriverManager.getWebDriver().manage().window().maximize();
   }

    public static void navigateToPage(String websiteUrl){
       DriverManager.getWebDriver().get(websiteUrl);
    }


}
