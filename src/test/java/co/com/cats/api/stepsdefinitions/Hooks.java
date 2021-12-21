/**
 * ©2021 CONFIDENCIAL©
 * Todos los derechos reservados.
 *
 * @Autor: Alejandro Malaver
 */
package co.com.cats.api.stepsdefinitions;

import co.com.cats.api.util.ManageConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Hooks {
    @Before
    public void doSomethingBeforeStep() {

        RestAssured.baseURI = ManageConfig.BASE_URL;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        OnStage.setTheStage(new OnlineCast());
    }

    @After
    public void afterScenario() {

        Serenity.clearCurrentSession();
    }
}
