package webElemets;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class DropdownList_Test {
    private WebDriver driver;
    DropdownList_Page ddLPage;

    @Before
    public void setUp() throws Exception {
        ddLPage = new DropdownList_Page(driver);
        driver = ddLPage.chromeDriverConnectioin();
        driver.manage().window().maximize(); // este metodo se incluye en la clase base por el momento lo hacemos aqui


    }

    @After
    public void tearDown() throws Exception {
        
    }

    @Test
    public void testing_Classic_DDL() throws InterruptedException {
        ddLPage.visit("https://demo.guru99.com/test/newtours/index.php");
            ddLPage.SingIn();
            assertEquals(ddLPage.selectDropdownList_Passengers(),"4");
            assertEquals(ddLPage.selectDropdownList_DepartingFrom(),"Paris");

    }
}

