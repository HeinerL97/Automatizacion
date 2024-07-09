package com.demoblaze.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class HomeUI {
    public static final Target LNK_SIGNIN=Target.the("LNK SIGN IN")
            .located(By.id("signin2"));
    public static final Target LNK_LOG_IN=Target.the("LNK LOG IN")
            .locatedBy("//*[@id='login2']");

    public static final Target LBL_WELCOME= Target.the("LBL WELCOME")
            .locatedBy("//*[@id='nameofuser']");
}
