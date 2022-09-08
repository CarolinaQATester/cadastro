package com.automacao.Treinamento;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowsHandlerTest extends BaseTest {

    private WebDriver driver;

    private DSL dsl;

   
    @Test
    public void deveInteragirComJanelasSemTitulo() {

        try {
            dsl.clicarBotao("buttonPopUpHard");
            System.out.println(driver.getWindowHandle());
            System.out.println(driver.getWindowHandles());
            dsl.trocarJanela((String) driver.getWindowHandles().toArray()[1]);
            dsl.escrever(By.tagName("textarea"), "Deu certo?");
            dsl.trocarJanela((String) driver.getWindowHandles().toArray()[0]);
            dsl.escrever(By.tagName("textarea"), "e agora?");
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}
