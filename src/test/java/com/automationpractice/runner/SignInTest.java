package com.automationpractice.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/practiceWebsite/signIn.feature"},
        glue = {"com.automationpractice.stepdefinition.signIn"} )

public class SignInTest {
}
