package com.demoblaze.ui;

import net.serenitybdd.screenplay.targets.Target;


public class RegisterUI {
    public static final Target TXT_EMAIl = Target.the("text input email").locatedBy("//input[@id='sign-username']");

    public static final Target TXT_PASSWORD = Target.the("text input password")
            .locatedBy("//input[@id='sign-password']");
    public static final Target BTN_SIGN_UP = Target.the("BTN sign up")
            .locatedBy("(//button[@class='btn btn-primary'])[2]");

}
