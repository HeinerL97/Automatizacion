package com.demoblaze.tasks;


import com.demoblaze.interactions.SwichAlert;
import com.demoblaze.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowsingTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static com.demoblaze.ui.RegisterUI.*;


public class RegisterTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        ArrayList<Map<String, String>> data;
        try {
            data = Excel.leerDatosDeHojaDeExcel("Data/Excel.xlsx", "Datos");
            actor.attemptsTo(
                    Enter.theValue(data.get(0).get("EMAIL")).into(TXT_EMAIl),
                    Enter.theValue(data.get(0).get("PASSWORD")).into(TXT_PASSWORD),
                    Click.on(BTN_SIGN_UP),
                    SwichAlert.onAlert(BrowsingTheWeb.as(actor).getDriver())

            );

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ocurrió un error: " + e.getMessage());

        }
    }
    public static RegisterTask on(){
        return new RegisterTask();
    }

}
