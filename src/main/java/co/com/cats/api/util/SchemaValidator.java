/**
 * ©2021 CONFIDENCIAL©
 * Todos los derechos reservados.
 *
 * @Autor: Alejandro Malaver
 */
package co.com.cats.api.util;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SchemaValidator {

    private String schemaName;
    private Response response;

    public SchemaValidator(Response response, String schemaName) {
        this.response = response;
        this.schemaName = schemaName;
    }

    public Boolean validateSchema() {
        log.info("Validating Json Schema structure for " + schemaName + " service");

        if (schemaName == null || schemaName.equals("")) {

            return true;
        } else {

            try {

                response.then()
                        .body(matchesJsonSchemaInClasspath("schemas/" + schemaName + ".json"));
                log.info("Response validated with success " + response.toString());
                return true;
            } catch (AssertionError error) {
                log.error(error.toString());
                return false;
            }
        }
    }
}
