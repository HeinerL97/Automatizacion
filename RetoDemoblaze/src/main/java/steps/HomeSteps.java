package steps;

import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import pages.HomePage;

public class HomeSteps {
    @Page
    HomePage homePage;

    @Step("Open browser")
    public void openbrowser() {
        homePage.openUrl("https://www.demoblaze.com/");
    }

    @Step("Open Login")
    public void clickLogin() {
        homePage.getDriver().findElement(homePage.getBtnLoginLocator()).click();
    }
}
