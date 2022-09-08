package com.automacao.Treinamento;

import org.junit.Assert;
import org.junit.Test;

public class TesteAlertTest extends BaseTest {

    private DSL dsl;

    @Test
    public void deveInteragirComAlertSimples() {
        try {
            dsl.clicarBotao("alert");
            String texto = dsl.alertaObterTextoEAceita();
            Assert.assertEquals("Alert Simples", texto);

            dsl.escrever("elementosForm:nome", texto);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void deveInteragirComAlertConfirm() {
        try {
            dsl.clicarBotao("confirm");
            Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoEAceita());
            Assert.assertEquals("Confirmado", dsl.alertaObterTextoEAceita());

            dsl.clicarBotao("confirm");
            Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoENega());
            Assert.assertEquals("Negado", dsl.alertaObterTextoENega());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void deveInteragirComAlertPrompt() {
        try {
            dsl.clicarBotao("prompt");
            Assert.assertEquals("Digite um numero", dsl.alertaObterTexto());
            dsl.alertaEscrever("12");
            Assert.assertEquals("Era 12?", dsl.alertaObterTextoEAceita());
            Assert.assertEquals(":D", dsl.alertaObterTextoEAceita());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
