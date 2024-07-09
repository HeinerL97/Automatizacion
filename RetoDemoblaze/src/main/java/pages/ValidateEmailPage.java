package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ValidateEmailPage extends PageObject {
    private By txtEmailLocator = By.id("nameofuser");

    public By getTxtEmailLocator() {
        return txtEmailLocator;
    }
}
