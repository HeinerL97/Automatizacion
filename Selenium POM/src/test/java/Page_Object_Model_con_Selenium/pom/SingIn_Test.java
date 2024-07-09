package Page_Object_Model_con_Selenium.pom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SingIn_Test {
    private WebDriver driver;
    SignInPage singInPage;

    @Before
    public void setUp() throws Exception {
        singInPage =new SignInPage(driver);
        driver=singInPage.chromeDriverConnectioin();
        singInPage.visit("https://demo.guru99.com/test/newtours/index.php");

    }

    @After
    public void tearDown() throws Exception {
        //driver.quit();
    }
    @Test
    public void name() throws InterruptedException {
        singInPage.SingIn();
        Thread.sleep(2000);
        assertTrue(singInPage.isHomePageDisplayed());
    }
}
