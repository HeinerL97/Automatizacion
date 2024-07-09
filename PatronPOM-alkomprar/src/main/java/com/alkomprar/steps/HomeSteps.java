package com.alkomprar.steps;

import com.alkomprar.pages.HomePage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;


public class HomeSteps {
    @Page
    HomePage homePage;

    @Step("Abrir el navegador")
    public void abrirNavegador(){
        homePage.openUrl("https://www.alkomprar.com/");

    }
    @Step("Dar Clic en boton Mi Cuenta")
    public void darClicCuenta(){
        homePage.getDriver().findElement(homePage.getMycuentaBTNLocator()).click();

    }

}
