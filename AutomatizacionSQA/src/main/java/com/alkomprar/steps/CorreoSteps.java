package com.alkomprar.steps;

import com.alkomprar.pages.ValidacionCorreo;
import com.alkomprar.utils.Excel;
import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class CorreoSteps {
    @Page
    ValidacionCorreo correo;

    @Step("Ingresar Correo")
    public void ingresarCorreo (){
        ArrayList<Map<String, String>> datos;
        try {
            datos = Excel.leerDatosDeHojaExcel("src/test/resources/Data/registroAlKomprar.xlsx", "Registro");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        correo.getDriver().findElement(correo.getTxtEMailLocator()).sendKeys(datos.get(0).get("Correo"));

    }
    @Step("Validar correo")
    public void validarCorreo(){
        correo.getDriver().findElement(correo.getBotonValidarLocator()).click();
    }
}
