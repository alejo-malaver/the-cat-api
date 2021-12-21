/**
 * ©2021 CONFIDENCIAL©
 * Todos los derechos reservados.
 *
 * @Autor: Alejandro Malaver
 */
package co.com.cats.api.screenplay.tasks;

import static co.com.cats.api.util.RestBuilder.noBodyInfo;
import static net.serenitybdd.screenplay.Tasks.instrumented;

import co.com.cats.api.model.GetBreedsRequestDto;
import co.com.cats.api.util.Constants;
import co.com.cats.api.util.ManageConfig;
import java.util.HashMap;
import java.util.Map;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetListOfBreeds implements Task {
    private GetBreedsRequestDto allInformationForGetBreedsRequestDto;
    private Map<String, Object> parameters;

    public GetListOfBreeds(GetBreedsRequestDto allInformationForGetBreedsRequestDto) {

        this.allInformationForGetBreedsRequestDto = allInformationForGetBreedsRequestDto;
        parameters = new HashMap<>();
        parameters.put(
                Constants.ATTACH_BREED, allInformationForGetBreedsRequestDto.getAttach_breed());
        parameters.put(Constants.PAGE, allInformationForGetBreedsRequestDto.getPage());
        parameters.put(Constants.LIMIT, allInformationForGetBreedsRequestDto.getLimit());
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(ManageConfig.LIST_BREEDS_SERVICE).with(noBodyInfo(parameters)));
    }

    public static GetListOfBreeds all(GetBreedsRequestDto allInformationForGetBreedsRequestDto) {
        return instrumented(GetListOfBreeds.class, allInformationForGetBreedsRequestDto);
    }
}
