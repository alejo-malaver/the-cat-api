/**
 * ©2021 CONFIDENCIAL©
 * Todos los derechos reservados.
 *
 * @Autor: Alejandro Malaver
 */
package co.com.cats.api.stepsdefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import co.com.cats.api.screenplay.questions.ServiceResponse;
import co.com.cats.api.steps.CommonSteps;
import co.com.cats.api.steps.ListBreedsSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.thucydides.core.annotations.Steps;
import org.apache.http.HttpStatus;

public class listBreedsStepsDefinitions {

    @Steps CommonSteps commonSteps;
    @Steps ListBreedsSteps listBreedsSteps;

    @Dado("que {word} es un/una cliente activo/activa en el API-REST de Geonames")
    public void usuarioEsUnClienteAutenticadoDelApiTheCats(String clientName) {
        commonSteps.userHasPersonalInformationToLogin(clientName);
    }

    @Cuando("él/ella realice la consulta de las razas de gatos sin filtros")
    public void usuarioConsultaRazasDeGatosSinFiltros() {
        listBreedsSteps.getListBreedsInfo();
    }

    @Entonces("él/ella debe ver la información detallada de las razas de gatos consultadas")
    public void usuarioDebeVerInformacionDetalladaDeLasRazasDeGatos() {

        if (theActorInTheSpotlight().asksFor(ServiceResponse.sentBackByService()).statusCode()
                == HttpStatus.SC_NO_CONTENT)
            commonSteps.shouldSeeSuccessResponse(HttpStatus.SC_NO_CONTENT, null);
        else
            commonSteps.shouldSeeSuccessResponse(
                    HttpStatus.SC_OK, "listCatBreeds/listCatBreedsInformation");
    }
}
