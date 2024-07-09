package webElemets;

import Page_Object_Model_con_Selenium.pom.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownList_Page  extends Base {

    //DropdownList Clasico -Mercurytours-
    By dropdownList_Passengers = By.name("passCount");
    By dropdownList_DepartingFrom = By.name("fromPort");

    By HomeLocator = By.xpath("//tbody/tr[1]/td[2]/font/a");
    By UserNameULocator = By.xpath("//tr[2]/td[2]/input");
    By PasswordULocator = By.xpath("//tbody/tr[3]/td[2]/input");
    By SubmitLocator = By.xpath("//td[2]/div/input");

    By FligthLocator = By.xpath("//tr[2]/td[2]/a");

    public DropdownList_Page(WebDriver driver) {
        super(driver);
    }

    //codigo html de los localizadores
    //forma larga

    public void SingIn() throws InterruptedException {
        click(HomeLocator);
        if (isDisplayed(UserNameULocator)) {
            type("PruebaHeiner3", UserNameULocator);
            type("123456789", PasswordULocator);
            click(SubmitLocator);
            Thread.sleep(2000);
            click(FligthLocator);
            Thread.sleep(10000);

        } else {
            System.out.println("username Textbox was not present");
        }
    }
    public String selectDropdownList_Passengers() {
        WebElement dropdownList = findElement(dropdownList_Passengers);
        List<WebElement> options = dropdownList.findElements(By.tagName("option"));
        for (int i = 0; i < options.size(); i++) {
            if (getText(options.get(i)).equals("4")) {
                click(options.get(i));
            }
        }
        String selectedoption = "";
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).isSelected()){
             selectedoption = getText(options.get(i));
            }
        }
        return selectedoption;
    }
//
    //forma corta
    public String selectDropdownList_DepartingFrom(){
        Select selectList =new Select(findElement(dropdownList_DepartingFrom));
        selectList.selectByVisibleText("Paris");
        return  getText(selectList.getFirstSelectedOption());
    }

}