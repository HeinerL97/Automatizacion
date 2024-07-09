package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    private By txtUsernameLocator = By.id("loginusername");
    private By txtPasswordLocator = By.id("loginpassword");
    private By btn2LoginLocator = By.xpath("//button[text()='Log in']");

    public By getTxtUsernameLocator() {
        return txtUsernameLocator;
    }

    public By getTxtPasswordLocator() {
        return txtPasswordLocator;
    }

    public By getBtn2LoginLocator() {
        return btn2LoginLocator;
    }
}
