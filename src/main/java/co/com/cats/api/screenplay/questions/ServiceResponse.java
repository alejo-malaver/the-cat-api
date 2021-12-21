/**
 * ©2021 CONFIDENCIAL©
 * Todos los derechos reservados.
 *
 * @Autor: Alejandro Malaver
 */
package co.com.cats.api.screenplay.questions;

import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public class ServiceResponse implements Question<Response> {

    @Override
    public Response answeredBy(Actor actor) {

        return LastResponse.received().answeredBy(actor);
    }

    public static ServiceResponse sentBackByService() {

        return new ServiceResponse();
    }
}
