package com.alkomprar.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ValidacionCorreo extends PageObject
{
    private By TxtEMailLocator=By.id("js-login-email");
    private By BotonValidarLocator=By.xpath("//*[@id='js-login-continue']");

    public By getBotonValidarLocator() {
        return BotonValidarLocator;
    }

    public By getTxtEMailLocator() {
        return TxtEMailLocator;
    }


}
