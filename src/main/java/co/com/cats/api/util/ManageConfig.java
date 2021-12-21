/**
 * ©2021 CONFIDENCIAL©
 * Todos los derechos reservados.
 *
 * @Autor: Alejandro Malaver
 */
package co.com.cats.api.util;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.configuration.SystemPropertiesConfiguration;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.Configuration;

public class ManageConfig {
    @SuppressWarnings("rawtypes")
    private static final Configuration CONFIGURATION =
            new SystemPropertiesConfiguration(
                    SystemEnvironmentVariables.createEnvironmentVariables());

    private static final EnvironmentVariables environmentVariables =
            CONFIGURATION.getEnvironmentVariables();

    // URL base de los EndPoint y Path base del archivo de usuarios
    public static final String BASE_URL =
            EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("base.url");

    // Path base de cada servicio
    public static final String LIST_BREEDS_SERVICE =
            EnvironmentSpecificConfiguration.from(environmentVariables)
                    .getProperty("listBreeds.path");
}
