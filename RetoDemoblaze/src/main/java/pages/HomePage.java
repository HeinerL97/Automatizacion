package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class HomePage extends PageObject {
    private By btnLoginLocator = By.id("login2");

    public By getBtnLoginLocator() {
        return btnLoginLocator;
    }
}
