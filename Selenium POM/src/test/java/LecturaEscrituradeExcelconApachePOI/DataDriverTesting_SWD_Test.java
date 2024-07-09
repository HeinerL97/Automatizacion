package LecturaEscrituradeExcelconApachePOI;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.IOException;

public class DataDriverTesting_SWD_Test {
    private WebDriver driver;

    private WriteExcelFile writeFile;
    private  ReadExcelFile readFile;
    private By searchBoxLocator = By.id("search_query_top");
    private By searchBTNLocator = By.name("submit_search");
    private By resultTextLocator = By.xpath("//*[@id='center_column']/h1/span[2]");


    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","src/test/resources/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        writeFile = new WriteExcelFile();
        readFile = new ReadExcelFile();

        driver.get("http://www.automationpractice.pl/index.php");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void name() throws IOException, InterruptedException {
        String filepath ="src/test/resources/Excel/Test.xlsx";
        String searchText = readFile.getCellValue(filepath,"Sheet1",0,0);

        driver.findElement(searchBoxLocator).sendKeys(searchText);
        driver.findElement(searchBTNLocator).click();
        String resultText =  driver.findElement(resultTextLocator).getText();

        System.out.println("page result text:" + resultText);

        readFile.readExcel(filepath,"Sheet1");

        writeFile.writeCellValue(filepath,"Sheet1",0,1,resultText);

        readFile.readExcel(filepath,"Sheet1");
    }
}
