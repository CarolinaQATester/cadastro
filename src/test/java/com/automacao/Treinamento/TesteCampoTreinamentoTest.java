package com.automacao.Treinamento;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TesteCampoTreinamentoTest extends BaseTest {

    @Test
    public void deveInteragiTextField() {

        try {

            String nome = "Carolina";
            String sobrenome = "Mesquita";

            driver.findElement(By.xpath("//input[@id='elementosForm:nome']")).clear();
            driver.findElement(By.xpath("//input[@id='elementosForm:nome']")).sendKeys(nome);
            driver.findElement(By.xpath("//input[@id='elementosForm:sobrenome']")).clear();
            driver.findElement(By.xpath("//input[@id='elementosForm:sobrenome']")).sendKeys(sobrenome);

            Assert.assertEquals(nome,
                    driver.findElement(By.xpath("//input[@id='elementosForm:nome']")));
            Assert.assertEquals(sobrenome,
                    driver.findElement(By.xpath("//input[@id='elementosForm:sobrenome']")));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void deveInteragirComTextArea() {

        try {

            driver.findElement(By.xpath("//textarea[@id='elementosForm:sugestoes']")).clear();
            driver.findElement(By.xpath("//textarea[@id='elementosForm:sugestoes']"))
                    .sendKeys("Teste com o selenium e java");

            // Assert.assertEquals("Teste com o selenium e java",
            // driver.findElement(By.xpath("//textarea[@id='elementosForm:sugestoes']")).getText());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void devoInteragirComRadioButton() {
        try {

            driver.findElement(By.xpath("//input[@id='elementosForm:sexo:1']")).click();
            // verificar se o elemento esta mesmo selecionado
            Assert.assertTrue(driver.findElement(By.xpath("//input[@id='elementosForm:sexo:1']")).isSelected());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void devoInteragirComCheckButton() {
        try {
            driver.findElement(By.xpath("//input[@id='elementosForm:comidaFavorita:2']")).click();

            Assert.assertTrue(
                    driver.findElement(By.xpath("//input[@id='elementosForm:comidaFavorita:2']")).isSelected());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void devoInteragirComComboDeSelecaoEscolaridade() {
        try {
            WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
            Select combo = new Select(element);
            // combo.selectByIndex(4);
            // combo.selectByValue("Superior");
            combo.selectByVisibleText("Superior");

            Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void deveVerificarOsValoresDoCombo() {

        try {
            WebElement element = driver.findElement(By.xpath("//select[@id='elementosForm:escolaridade']/option[5]"));
            Select combo = new Select(element);

            List<WebElement> options = combo.getOptions();
            Assert.assertEquals(8, options.size());

            boolean encontrou = true;
            for (WebElement option : options) {
                if (option.getText().equals("Especializacao")) {
                    encontrou = true;
                    break;
                }
            }
            Assert.assertTrue(encontrou);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void devoSelecionarComboMultiplaEscolha() {

        try {
            WebElement element = driver.findElement(By.xpath("//select[@id='elementosForm:esportes']"));
            Select combo = new Select(element);
            combo.selectByVisibleText("Natacao");
            combo.selectByVisibleText("Corrida");
            combo.selectByVisibleText("O que eh esporte?");

            List<WebElement> allSelectedOptins = combo.getAllSelectedOptions();
            Assert.assertEquals(3, allSelectedOptins.size());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void devoClicarNoBotao() {

        try {
            WebElement botao = driver.findElement(By.xpath("//input[@id='buttonSimple'][@type='button']"));
            botao.click();

            Assert.assertEquals("Obrigado!", botao.getAttribute("value"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test

    public void devoClicarNoLink() {

        try {
            WebElement linkVoltar = driver.findElement(By.xpath("/html/body/center/a"));
            linkVoltar.click();

            Assert.assertEquals("Voltou!", driver.findElement(By.xpath("//div[@id='resultado']")).getText());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void deveVerificarTextoNaPagina() {

        try {
            /*
             * String texto = driver.findElement(By.tagName("body")).getText();
             * System.out.println(texto);
             */
            /*
             * Assert.assertTrue(driver.findElement(By.tagName("body"))
             * .getText().contains("Campo de Treinamento"));
             */
            Assert.assertEquals("Campo de Treinamento",
                    driver.findElement(By.xpath("//form[@id='elementosForm']/h3")).getText());
            Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
                    driver.findElement(By.xpath("//span[@class='facilAchar']")).getText());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
