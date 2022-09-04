package com.automacao.Treinamento;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CadastroComSucesso extends BaseTest {

    @Test
    public void devoRealizarUmCadastroComSucesso() {
        try {

            // textfield
            driver.findElement(By.xpath("//input[@id='elementosForm:nome'][@type='text']")).clear();
            driver.findElement(By.xpath("//input[@id='elementosForm:nome'][@type='text']")).sendKeys("Carolina");
            driver.findElement(By.xpath("//input[@id='elementosForm:sobrenome'][@type='text']")).clear();
            driver.findElement(By.xpath("//input[@id='elementosForm:sobrenome'][@type='text']")).sendKeys("Mesquita");

            // radio button
            driver.findElement(By.xpath("//input[@id='elementosForm:sexo:1'][@type='radio']")).click();
            Assert.assertTrue(driver.findElement(By.xpath("//input[@id='elementosForm:sexo:1']")).isSelected());

            // checkbox
            driver.findElement(By.xpath("//input[@id='elementosForm:comidaFavorita:2'][@type='checkbox']")).click();
            Assert.assertTrue(
                    driver.findElement(By.xpath("//input[@id='elementosForm:comidaFavorita:2']")).isSelected());

            // combo simples
            WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
            Select combo = new Select(element);
            combo.selectByVisibleText("Superior");

            Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
            // combo multipla escolha
            WebElement element1 = driver.findElement(By.id("elementosForm:esportes"));
            combo = new Select(element1);
            combo.selectByVisibleText("Corrida");

            List<WebElement> allSelectedOptins = combo.getAllSelectedOptions();
            Assert.assertEquals(1, allSelectedOptins.size());

            // textarea

            driver.findElement(By.xpath("//textarea[@id='elementosForm:sugestoes']")).clear();
            driver.findElement(By.xpath("//textarea[@id='elementosForm:sugestoes']"))
                    .sendKeys("Teste com o selenium e java");

            driver.findElement(By.id("elementosForm:cadastrar")).click();

            devoValidarTextoDeCadastroDeSucesso();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void devoValidarTextoDeCadastroDeSucesso() {

        Assert.assertTrue("Cadastrado!", driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado!"));
        Assert.assertTrue("Nome: carolina", driver.findElement(By.id("descNome")).getText().endsWith("Carolina"));
        /*
         * Assert.assertTrue("mesquita",
         * driver.findElement(By.id("descSobrenome")).getText());
         * Assert.assertTrue("Feminino",
         * driver.findElement(By.id("descSexo")).getText());
         * Assert.assertTrue("Pizza",
         * driver.findElement(By.id("descComida")).getText());
         * Assert.assertTrue("superior",
         * driver.findElement(By.id("descEscolaridade")).getText());
         * Assert.assertTrue("Corrida",
         * driver.findElement(By.id("descEsportes")).getText());
         * Assert.assertTrue("teste",
         * driver.findElement(By.id("descSugestoes")).getText());
         */

    }

}
