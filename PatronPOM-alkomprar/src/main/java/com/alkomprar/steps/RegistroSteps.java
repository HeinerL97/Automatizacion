package com.alkomprar.steps;

import com.alkomprar.pages.RegistroPage;
import com.alkomprar.utils.Excel;

import net.thucydides.core.annotations.Step;

import org.fluentlenium.core.annotation.Page;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class RegistroSteps {
    @Page
    RegistroPage registroPage;

    @Step("Ingresar datos de registro")
    public void ingresarDatos(){
        ArrayList<Map<String, String>> datos;
        try {
            datos = Excel.leerDatosDeHojaExcel("src/test/resources/Data/registroAlKomprar.xlsx", "Registro");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        registroPage.getDriver().findElement(registroPage.getNombreLocator()).sendKeys(datos.get(0).get("Nombre"));
        registroPage.getDriver().findElement(registroPage.getApellidoLocator()).sendKeys(datos.get(0).get("Apellido"));
        registroPage.getDriver().findElement(registroPage.getCelularLocator()).sendKeys(datos.get(0).get("Telefono"));


    }
    @Step("dar click en boton")
    public  void autorizarYRegidtrar(){
        registroPage.getDriver().findElement(registroPage.getChekAutorizacionLocator()).click();
        registroPage.getDriver().findElement(registroPage.getBotonRegistrarLocator()).submit();
    }

}
