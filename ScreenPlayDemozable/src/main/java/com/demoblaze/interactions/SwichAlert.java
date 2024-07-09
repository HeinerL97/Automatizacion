package com.demoblaze.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class SwichAlert implements Interaction {
    private WebDriver driver;

    public SwichAlert(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    public static SwichAlert onAlert(WebDriver driver){
        return new SwichAlert(driver);
    }
}
