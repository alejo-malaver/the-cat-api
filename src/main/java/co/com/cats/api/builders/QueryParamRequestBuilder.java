/**
 * ©2021 CONFIDENCIAL©
 * Todos los derechos reservados.
 *
 * @Autor: Alejandro Malaver
 */
package co.com.cats.api.builders;

import co.com.cats.api.model.GetBreedsRequestDto;

public class QueryParamRequestBuilder {
    public static GetBreedsRequestDto buildGetBreedsQueryParam() {
        Integer attach_breed = 10;
        Integer page = 2; // RandomDataHelper.getRandomLatitude();
        Integer limit = 3; // RandomDataHelper.getRandomLength();

        return GetBreedsRequestDto.builder()
                .attach_breed(attach_breed)
                .page(page)
                .limit(limit)
                .build();
    }

    public static GetBreedsRequestDto buildGetBreedsQueryParamEmpty() {
        Integer attach_breed = null;
        Integer page = null;
        Integer limit = null;

        return GetBreedsRequestDto.builder()
                .attach_breed(attach_breed)
                .page(page)
                .limit(limit)
                .build();
    }
}
