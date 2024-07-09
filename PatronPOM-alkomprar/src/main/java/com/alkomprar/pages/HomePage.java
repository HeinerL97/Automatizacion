package com.alkomprar.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class HomePage extends PageObject {
    private By MycuentaBTNLocator= By.xpath("//*[@id='js-myaccount-header']/a");

    public By getMycuentaBTNLocator() {

        return MycuentaBTNLocator;
    }


}
