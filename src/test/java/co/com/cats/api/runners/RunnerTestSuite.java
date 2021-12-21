/**
 * ©2021 CONFIDENCIAL©
 * Todos los derechos reservados.
 *
 * @Autor: Alejandro Malaver
 */
package co.com.cats.api.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/",
        tags = "@CatBreeds",
        glue = {"co.com.cats.api.stepsdefinitions"})
public class RunnerTestSuite {

    private RunnerTestSuite() {}

    @AfterClass
    public static void afterAll() {}
}
