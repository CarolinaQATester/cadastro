package com.automacao.steps;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.automacao.config.Base;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CT001_Cadastro_UsuarioStep extends Base {

    @Dado("^clico no botao comecar a automação web$")
    public void clico_no_botao_comecar_a_automação_web() throws Throwable {
        try {
            driver.findElement(By.xpath("//a[@class='btn waves-light orange']")).click();
            wait(2500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Dado("^clico no menu formulario$")
    public void clico_no_menu_formulario() throws Throwable {
        try {
            driver.findElement(By.linkText("Formulário")).click();
            wait(2500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Dado("^clico no criar usuario$")
    public void clico_no_criar_usuario() throws Throwable {
        try {
            driver.findElement(By.linkText("Criar Usuários")).click();
            driver.get("https://automacaocombatista.herokuapp.com/users/new");
            WebDriverWait wait = new WebDriverWait(driver, 10); // seconds
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@class='center']")));
            wait(2500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Quando("^preencho todos os campos: \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void preencho_todos_os_campos(String nome,
            String ultimoNome, String email,
            String endereco, String univercidade, String profissao, String genero, String idade) throws Throwable {
        try {
            driver.get("https://automacaocombatista.herokuapp.com/users/new");
            driver.findElement(By.id("user_name")).clear();
            driver.findElement(By.id("user_name")).sendKeys(nome);

            driver.findElement(By.id("user_lastname")).clear();
            driver.findElement(By.id("user_lastname")).sendKeys(ultimoNome);

            driver.findElement(By.id("user_email")).clear();
            driver.findElement(By.id("user_email")).sendKeys(email);

            driver.findElement(By.id("user_address")).clear();
            driver.findElement(By.id("user_address")).sendKeys(endereco);

            driver.findElement(By.id("user_university")).clear();
            driver.findElement(By.id("user_university")).sendKeys(univercidade);

            driver.findElement(By.id("user_profile")).clear();
            driver.findElement(By.id("user_profile")).sendKeys(profissao);

            driver.findElement(By.id("user_gender")).clear();
            driver.findElement(By.id("user_gender")).sendKeys(genero);

            driver.findElement(By.id("user_age")).clear();
            driver.findElement(By.id("user_age")).sendKeys(idade);
            wait(2500);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Quando("^clico em criar$")
    public void clico_em_criar() throws Throwable {
        try {
            driver.findElement(By.name("commit")).click();
            wait(2500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Entao("^verifico se o usuario foi cadastrado no sistema \"([^\"]*)\"$")
    public void verifico_se_o_usuario_foi_cadastrado_no_sistema(String msgSucesso) throws Throwable {
        try {
            Assert.assertEquals(msgSucesso,
                    driver.findElement(By.xpath("//p[@id='notice'][@class='light-green accent-2']")).getText());
            wait(2500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

   /*  @Entao("^verificos se os dados estao corretos: \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void verificos_se_os_dados_estao_corretos(String nome,
            String ultimoNome, String email,
            String endereco, String univercidade, String profissao, String genero, String idade) throws Throwable {
        try {
            
        Assert.assertEquals(nome,driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Nome:'])[1]/following::strong[1]")).getText());
        Assert.assertEquals(ultimoNome,driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Ultimo Nome:'])[1]/following::p[1]")).getText());
        Assert.assertEquals(email,driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email:'])[1]/following::strong[1]")).getText());
        Assert.assertEquals(univercidade,driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Univercidade:'])[1]/following::strong[1]")).getText());
        Assert.assertEquals(genero,driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Gênero:'])[1]/following::strong[1]")).getText());
        Assert.assertEquals(profissao,driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Profissão:'])[1]/following::strong[1]")).getText());
        Assert.assertEquals(idade,driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Idade:'])[1]/following::p[1]")).getText());
        Assert.assertEquals(endereco,driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Address:'])[1]/following::p[1]")).getText());

            wait(2500);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } */
}
