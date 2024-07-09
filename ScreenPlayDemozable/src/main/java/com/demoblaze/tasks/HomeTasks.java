package com.demoblaze.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.demoblaze.ui.HomeUI.LNK_SIGNIN;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class HomeTasks implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LNK_SIGNIN)
        );

    }
    public static Performable on(){
        return instrumented(HomeTasks.class);
    }
}
