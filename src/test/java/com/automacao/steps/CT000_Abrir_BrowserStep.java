package com.automacao.steps;

import cucumber.api.java.pt.Dado;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.automacao.config.Base;

import cucumber.api.java.pt.Então;

public class CT000_Abrir_BrowserStep extends Base {

    @Dado("^a abertura do browser \"([^\"]*)\"$")
    public void a_abertura_do_browser(String url) throws Throwable {
        try {
            browserChrome();
            driver.get(url);
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Então("^verificar se o sistema está disponivel pela \"([^\"]*)\"$")
    public void verificar_se_o_sistema_está_disponivel_pela(String titulo) throws Throwable {
        try {
            Assert.assertEquals(titulo,
                    driver.findElement(By.xpath("//h4[@class='header col orange-text']")).getText());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
