package com.demoblaze.tasks;

import com.demoblaze.ui.LoginUI;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LoginTasks implements Task {

    private final String username;
    private final String password;

    public LoginTasks(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static LoginTasks withCredentials(String username, String password) {
        return instrumented(LoginTasks.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(LoginUI.TXT_EMAIlLOGIN),
                Enter.theValue(password).into(LoginUI.TXT_PASSWORDLOGIN),
                Click.on(LoginUI.BTN_LOG_IN)
        );
    }
}
