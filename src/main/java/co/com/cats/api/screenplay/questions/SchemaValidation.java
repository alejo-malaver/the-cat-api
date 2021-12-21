/**
 * ©2021 CONFIDENCIAL©
 * Todos los derechos reservados.
 *
 * @Autor: Alejandro Malaver
 */
package co.com.cats.api.screenplay.questions;

import co.com.cats.api.util.SchemaValidator;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class SchemaValidation implements Question<Boolean> {
    private Response response;
    private String schema;

    public SchemaValidation(Response response, String schema) {

        this.response = response;
        this.schema = schema;
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        SchemaValidator schemaValidator = new SchemaValidator(response, schema);
        return schemaValidator.validateSchema();
    }

    public static SchemaValidation onThisResponse(Response response, String schema) {

        return new SchemaValidation(response, schema);
    }
}
