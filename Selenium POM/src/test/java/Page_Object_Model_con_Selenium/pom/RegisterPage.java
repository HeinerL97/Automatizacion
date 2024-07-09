package Page_Object_Model_con_Selenium.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage extends Base {

    By registerLinkLocator = By.linkText("REGISTER");
    By registerPagesLocator = By.xpath("//img[@src='images/mast_register.gif']");
    By FirstNameLocator = By.name("firstName");
    By LastNameLocator =By.name("lastName");
    By PhoneLocator = By.name("phone");
    By EmailLocator = By.id("userName");
    By AddressLocator = By.xpath("//td//tr[7]/td[2]/input");
    By CityLocator= By.xpath("//tbody/tr[8]/td[2]/input");
    By StateLocator = By.xpath("//td/form//tr[9]/td[2]/input");
    By PostalCodeLocator = By.xpath("//table/tbody/tr[10]/td[2]/input");
    By CountryLocator =By.xpath("//tr[11]/td[2]/select/option[52]");
    By UserNameLocator = By.xpath("//*[@id=\'email\']");
    By PasswordLocator= By.xpath("//table/tbody/tr[14]/td[2]/input");
    By ConfirmPasswordLocator=By.xpath("//table/tbody/tr[15]/td[2]/input");
    By EnviarLocator=By.name("submit");
    By registeredMessage = By.tagName("font");



    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    public void registerUser() throws InterruptedException {
        click(registerLinkLocator);
        Thread.sleep(2000);
        if (isDisplayed(registerPagesLocator)){
            type("prueba heiner",FirstNameLocator);
            type("urrego",LastNameLocator);
            type("123456798",PhoneLocator);
            type("heinerprueba@yopmail.com",EmailLocator);
            type("calle146a#54-10",AddressLocator);
            type("Bogota",CityLocator);
            type("suba",StateLocator);
            type("123456",PostalCodeLocator);
            click(CountryLocator);
            type("PruebaHeiner3",UserNameLocator);
            type("123456789",PasswordLocator);
            type("123456789",ConfirmPasswordLocator);
            click(EnviarLocator);


        }else{
            System.out.println("Register pages was not found");
        }

    }
    public String registeredMessage() {
            List<WebElement> fonts=findElements(registeredMessage);
        return getText(fonts.get(5));
    }

}
