package steps;

import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import pages.LoginPage;
import utils.Excel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class LoginSteps {
    @Page
    LoginPage loginPage;

    @Step("Enter your email address and password from Excel")
    public void enterEmailAddress() {
        ArrayList<Map<String, String>> data;
        try {
            data = Excel.leerDatosDeHojaExcel("src/test/resources/Data/Excel.xlsx", "Login");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String email = data.get(0).get("Email");
        String password = data.get(0).get("Password");

        loginPage.getDriver().findElement(loginPage.getTxtUsernameLocator()).sendKeys(email);
        loginPage.getDriver().findElement(loginPage.getTxtPasswordLocator()).sendKeys(password);
    }

    @Step("Click Login")
    public void clickLogin() {
        loginPage.getDriver().findElement(loginPage.getBtn2LoginLocator()).click();
    }
}
