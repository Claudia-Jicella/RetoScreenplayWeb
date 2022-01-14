package com.automationpractice.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/practiceWebsite/contacUs.feature"},
        glue = {"com.automationpractice.stepdefinition.contacUs"},
        tags = {"not Scenario2"}

)
public class ContacUsTest {
}
