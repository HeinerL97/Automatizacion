package com.alkomprar.steps;

import com.alkomprar.pages.PerfilPage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;

public class PerfilPageSteps {
    @Page
    PerfilPage perfilPage;
    @Step("validar registro")
    public void validarRegistro(){
        Assert.assertTrue(perfilPage.getDriver().findElement(perfilPage.getValidarTxtLocator()).isDisplayed());
    }
}
