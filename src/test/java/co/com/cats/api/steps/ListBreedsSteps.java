/**
 * ©2021 CONFIDENCIAL©
 * Todos los derechos reservados.
 *
 * @Autor: Alejandro Malaver
 */
package co.com.cats.api.steps;

import static co.com.cats.api.builders.QueryParamRequestBuilder.buildGetBreedsQueryParamEmpty;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import co.com.cats.api.screenplay.tasks.GetListOfBreeds;

public class ListBreedsSteps {
    public void getListBreedsInfo() {
        theActorInTheSpotlight().attemptsTo(GetListOfBreeds.all(buildGetBreedsQueryParamEmpty()));
    }
}
