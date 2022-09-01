package com.automacao.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/", glue = {
                "" },tags = {"@CT000, @CT001" }, monochrome = true, dryRun = false, plugin = {"html:target/cucumber-html-report", "json:target/cucumber.json"})
public class RunCucumberTest {
}