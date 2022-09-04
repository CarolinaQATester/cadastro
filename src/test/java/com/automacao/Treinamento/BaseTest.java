package com.automacao.Treinamento;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public WebDriver driver;

    //private static final String URL_LOGIN =

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
    }

    @After
    public void after() {
         //driver.quit();
    }
    
}
