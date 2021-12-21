/**
 * ©2021 CONFIDENCIAL©
 * Todos los derechos reservados.
 *
 * @Autor: Alejandro Malaver
 */
package co.com.cats.api.steps;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

import co.com.cats.api.screenplay.questions.SchemaValidation;
import co.com.cats.api.screenplay.questions.ServiceResponse;
import co.com.cats.api.util.Constants;
import co.com.cats.api.util.ManageConfig;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class CommonSteps {
    public void userHasPersonalInformationToLogin(String clientName) {

        theActorCalled(clientName);
        theActorInTheSpotlight().whoCan(CallAnApi.at(ManageConfig.BASE_URL));
    }

    public void shouldSeeSuccessResponse(int statusCode, String schemaName) {

        theActorInTheSpotlight()
                .should(
                        seeThatResponse(
                                Constants.RESPONSE_CODE_MESSAGE,
                                responseCode -> responseCode.statusCode(statusCode)),
                        seeThat(
                                Constants.SCHEMA_VALIDATION_MESSAGE,
                                SchemaValidation.onThisResponse(
                                        ServiceResponse.sentBackByService()
                                                .answeredBy(theActorInTheSpotlight()),
                                        schemaName),
                                equalTo(Boolean.TRUE)));
    }
}
