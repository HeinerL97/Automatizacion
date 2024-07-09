package Page_Object_Model_con_Selenium.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends Base{
    By HomeLocator=By.xpath("//tbody/tr[1]/td[2]/font/a");
    By UserNameULocator = By.xpath("//tr[2]/td[2]/input");
    By PasswordULocator = By.xpath("//tbody/tr[3]/td[2]/input");
    By SubmitLocator=By.xpath("//td[2]/div/input");

    By FligthLocator = By.xpath("//tr[2]/td[2]/a");
    By  FligthPagesLocator=By.xpath("//img[@src='images/mast_flightfinder.gif']");

    public SignInPage(WebDriver driver) {
        super(driver);
    }
public void SingIn() throws InterruptedException {
        click(HomeLocator);
    if(isDisplayed(UserNameULocator)){
        type("PruebaHeiner3",UserNameULocator);
        type("123456789",PasswordULocator);
        click(SubmitLocator);
        Thread.sleep(2000);
        click(FligthLocator);
        Thread.sleep(20000);

    }else {
        System.out.println("username Textbox was not present");
    }

}
public boolean isHomePageDisplayed(){
    return isDisplayed(FligthPagesLocator);
}
}
