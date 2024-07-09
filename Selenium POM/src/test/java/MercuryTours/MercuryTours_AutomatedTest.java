package MercuryTours;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MercuryTours_AutomatedTest {
    private WebDriver driver;
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

    By HomeLocator=By.xpath("//tbody/tr[1]/td[2]/font/a");
    By UserNameULocator = By.xpath("//tr[2]/td[2]/input");
    By PasswordULocator = By.xpath("//tbody/tr[3]/td[2]/input");
    By SubmitLocator=By.xpath("//td[2]/div/input");

    By FligthLocator = By.xpath("//tr[2]/td[2]/a");
    By  FligthPagesLocator=By.xpath("//img[@src='images/mast_flightfinder.gif']");

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","src/test/resources/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/index.php");

    }
    @After
    public void tearDown() throws Exception {
       // driver.quit();
    }

    @Test
    public void RegisterUser() throws InterruptedException {
    driver.findElement(registerLinkLocator).click();
        Thread.sleep(2000);
        if (driver.findElement(registerPagesLocator).isDisplayed()){
            driver.findElement(registerPagesLocator).isDisplayed();
            driver.findElement(FirstNameLocator).sendKeys("prueba heiner");
            driver.findElement(LastNameLocator).sendKeys("urrego");
            driver.findElement(PhoneLocator).sendKeys("123456798");
            driver.findElement(EmailLocator).sendKeys("heinerprueba@yopmail.com");
            driver.findElement(AddressLocator).sendKeys("calle146a#54-10");
            driver.findElement(CityLocator).sendKeys("Bogota");
            driver.findElement(StateLocator).sendKeys("suba");
            driver.findElement(PostalCodeLocator).sendKeys("123456");
            driver.findElement(CountryLocator).click();
            driver.findElement(UserNameLocator).sendKeys("PruebaHeiner3");
            driver.findElement(PasswordLocator).sendKeys("123456789");
            driver.findElement(ConfirmPasswordLocator).sendKeys("123456789");
            driver.findElement(EnviarLocator).click();
         }
        else{
        System.out.println("register pages was not found");
        }
        List<WebElement> fonts = driver.findElements(By.tagName("font"));
        assertEquals("Note: Your user name is PruebaHeiner3.",fonts.get(5).getText());
     }
    @Test
    public void SingIn() throws InterruptedException {
        driver.findElement(HomeLocator).click();
        if (driver.findElement(UserNameULocator).isDisplayed()) {
            driver.findElement(UserNameULocator).sendKeys("PruebaHeiner3");
            driver.findElement(PasswordULocator).sendKeys("123456789");
            driver.findElement(SubmitLocator).click();
            Thread.sleep(2000);
            driver.findElement(FligthLocator).click();
            Thread.sleep(20000);
            assertTrue(driver.findElement(FligthPagesLocator).isDisplayed());
        } else {
            System.out.println("username Textbox was not present");
        }
    }
}
