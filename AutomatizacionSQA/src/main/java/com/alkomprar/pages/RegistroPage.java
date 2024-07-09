package com.alkomprar.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class RegistroPage extends PageObject {
    private By NombreLocator = By.xpath("//*[@id='register.firstName']");
    private By ApellidoLocator = By.xpath("//*[@id='register.lastName']");
    private By CelularLocator = By.xpath("//*[@id='register.mobileNumber']");
    private By ChekAutorizacionLocator =By.xpath("//*[@id='alkostoRegisterForm']/div[7]/label");
    private By BotonRegistrarLocator=By.xpath("//*[@id='alkostoRegisterForm']/div[8]/button");

    public By getNombreLocator() {
        return NombreLocator;
    }

    public By getBotonRegistrarLocator() {
        return BotonRegistrarLocator;
    }

    public By getChekAutorizacionLocator() {
        return ChekAutorizacionLocator;
    }

    public By getCelularLocator() {
        return CelularLocator;
    }

    public By getApellidoLocator() {
        return ApellidoLocator;
    }
}
