package com.automacao.Treinamento;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class TesteAlertTest extends BaseTest {

    @Test
    public void deveInteragirComAlertSimples() {
        try {
            driver.findElement(By.xpath("//input[@id='alert'][@type='button']")).click();
            // switchTo(), mude para
            Alert alert = driver.switchTo().alert();
            String texto = alert.getText();
            Assert.assertEquals("Alert Simples", texto);
            alert.accept();

            driver.findElement(By.xpath("//input[@id='elementosForm:nome'][@type='text']")).sendKeys(texto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void deveInteragirComAlertConfirm() {
        try {
            driver.findElement(By.xpath("//input[@id='confirm'][@type='button']")).click();
            // switchTo(), mude para
            // clicando no botao confirma
            Alert alert = driver.switchTo().alert();

            Assert.assertEquals("Confirm Simples", alert.getText());
            alert.accept();
            Assert.assertEquals("Confirmado", alert.getText());
            alert.accept();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void deveInteragirComAlertCancelar() {
        try {
            driver.findElement(By.xpath("//input[@id='confirm'][@type='button']")).click();
            // switchTo(), mude para
            // clicando no botao confirma
            Alert alert = driver.switchTo().alert();
            Assert.assertEquals("Confirm Simples", alert.getText());
            // clicando no botao cancelar
            alert = driver.switchTo().alert();
            Assert.assertEquals("Confirm Simples", alert.getText());
            alert.dismiss();
            Assert.assertEquals("Negado", alert.getText());
            alert.accept();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void deveInteragirComAlertPrompt() {
        try {
            driver.findElement(By.xpath("//input[@id='prompt'][@type='button']")).click();
            // switchTo(), mude para
            // clicando no botao confirma
            Alert alert = driver.switchTo().alert();
            Assert.assertEquals("Digite um numero", alert.getText());
            alert.sendKeys("12");
            alert.accept();
            Assert.assertEquals("Era 12?", alert.getText());
            alert.accept();
            Assert.assertEquals(":D", alert.getText());
            alert.accept();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
