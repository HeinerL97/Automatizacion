package com.alkomprar.stepDefinitions;

import com.alkomprar.pages.PerfilPage;
import  com.alkomprar.pages.PerfilPage;
import com.alkomprar.pages.RegistroPage;
import com.alkomprar.steps.CorreoSteps;
import com.alkomprar.steps.HomeSteps;
import com.alkomprar.steps.PerfilPageSteps;
import com.alkomprar.steps.RegistroSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.thucydides.core.annotations.Steps;

public class RegistroStepDefinitions {
    @Steps
    HomeSteps homeSteps;

    @Steps
    CorreoSteps correoSteps;
    @Steps
    RegistroSteps registroSteps;

    @Steps
    PerfilPageSteps perfilPageSteps;


    @Dado("que el usuario abre la pagina de alkomprar")
    public void queElUsuarioAbreLaPaginaDeAlkomprar() {
        homeSteps.abrirNavegador();
    }

    @Dado("pulsa el boton de mi cuenta")
    public void pulsaElBotonDeMiCuenta() {
        homeSteps.darClicCuenta();
    }

    @Cuando("el usuario ingresa la informacion de registro")
    public void elUsuarioIngresaLaInformacionDeRegistro(DataTable dataTable){
        correoSteps.ingresarCorreo();
        correoSteps.validarCorreo();
        registroSteps.ingresarDatos();
        registroSteps.autorizarYRegidtrar();
    }

    @Entonces("vera el panel de perfil de usuario")
    public void veraElPanelDePerfilDeUsuario() {
        perfilPageSteps.validarRegistro();
    }
}
