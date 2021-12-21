/**
 * ©2021 CONFIDENCIAL©
 * Todos los derechos reservados.
 *
 * @Autor: Alejandro Malaver
 */
package co.com.cats.api.util;

import java.util.Map;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.rest.questions.RestQueryFunction;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.ContentType;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RestBuilder {

    public static RestQueryFunction bodyInfo(String body) {

        return requestSpecification ->
                requestSpecification
                        .contentType(ContentType.APPLICATION_JSON.toString())
                        .header(
                                HttpHeaders.ACCEPT,
                                ContentType.APPLICATION_JSON
                                        + ","
                                        + ContentType.TEXT_PLAIN
                                        + ","
                                        + ContentType.WILDCARD)
                        .body(body);
    }

    public static RestQueryFunction noBodyInfo(Map<String, Object> queryParams) {

        if (queryParams == null)
            return requestSpecification ->
                    requestSpecification
                            .contentType(ContentType.APPLICATION_JSON.toString())
                            .header(
                                    HttpHeaders.ACCEPT,
                                    ContentType.APPLICATION_JSON
                                            + ","
                                            + ContentType.TEXT_PLAIN
                                            + ","
                                            + ContentType.WILDCARD);
        else
            return requestSpecification ->
                    requestSpecification
                            .queryParams(queryParams)
                            .contentType(ContentType.APPLICATION_JSON.toString())
                            .header(
                                    HttpHeaders.ACCEPT,
                                    ContentType.APPLICATION_JSON
                                            + ","
                                            + ContentType.TEXT_PLAIN
                                            + ","
                                            + ContentType.WILDCARD);
    }
}
