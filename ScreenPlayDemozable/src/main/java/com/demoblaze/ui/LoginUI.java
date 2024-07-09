package com.demoblaze.ui;

import net.serenitybdd.screenplay.targets.Target;

public class LoginUI {


    public static final Target TXT_EMAIlLOGIN = Target.the("text input email")
            .locatedBy("//*[@id='loginusername]']");
    public static final Target TXT_PASSWORDLOGIN = Target.the("text input password")
            .locatedBy("//*[@id='loginpassword'");
    public static final Target BTN_LOG_IN = Target.the("BTN Log in")
            .locatedBy("(//*[@id='logInModal']/div/div/div[3]/button[2]");
    public static final Target MSM_LOG_IN = Target.the("the welcome message")
            .locatedBy("//*[@id='nameofuser']");
}
