package com.alkomprar.pages;

import org.openqa.selenium.By;
public class PerfilPage extends RegistroPage{

    private By ValidarTxtLocator = By.xpath("/html/body/main/section/div/div/div/div");

    public By getValidarTxtLocator() {
        return ValidarTxtLocator;
    }
}
