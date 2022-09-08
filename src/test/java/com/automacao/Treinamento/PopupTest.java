package com.automacao.Treinamento;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopupTest extends BaseTest {
    
    private WebDriver driver;
	private DSL dsl;

    @Test
     public void devoInteragirComPopup(){
         try {
            dsl.clicarBotao("buttonPopUpEasy");
		dsl.trocarJanela("Popup");
		dsl.escrever(By.tagName("textarea"), "Deu certo?");
		driver.close();
		dsl.trocarJanela("");
		dsl.escrever(By.tagName("textarea"), "e agora?");
         }catch (Exception e) {
             System.out.println(e.getMessage());
         }
     }
}
