package steps;

import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import pages.ValidateEmailPage;
import utils.Excel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ValidateEmailSteps {
    @Page
    ValidateEmailPage validateEmailPage;

    @Step("Validate email address")
    public void validateEmail() {
        ArrayList<Map<String, String>> data;
        try {
            // Leer los datos del archivo Excel
            data = Excel.leerDatosDeHojaExcel("src/test/resources/Data/Excel.xlsx", "Login");
        } catch (IOException e) {
            throw new RuntimeException("Error al leer datos de Excel", e);
        }

        // Obtener el email esperado desde el archivo Excel
        String expectedEmail = data.get(0).get("Email");

        // Obtener el texto del elemento en la página
        String actualEmail = validateEmailPage.getDriver().findElement(validateEmailPage.getTxtEmailLocator()).getText();

        // Validar que el email es el esperado
        assertEquals("Welcome " + expectedEmail, actualEmail);
    }
}
