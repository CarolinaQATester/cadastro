package com.automacao.Treinamento;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastroComSucesso {

	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;

	@Before
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
		dsl = new DSL(driver);
		page = new CampoTreinamentoPage(driver);
	}

	@After
	public void after() {
		// driver.quit();
	}

	@Test
	public void deveRealizarCadastroComSucesso() {
		try {

			page.setNome("Carolina");
			page.setSobrenome("Mesquita");
			page.setSexoMasculino();
			page.setComidaFavorita();
			page.setSelecinarEscolaridade("Superior");
			page.setSelecionarEsporte("Corrida");
			page.setCadastrar();

			Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
			Assert.assertTrue(page.obterNomeCadastro().endsWith("Wagner"));
			Assert.assertEquals("Sobrenome: Costa", page.obterSobreNomeCadastro());
			Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastro());
			Assert.assertEquals("Comida: Pizza", page.obterComidaFavoritaCadastro());
			Assert.assertEquals("Escolaridade: mestrado", page.obterEscolaridadeCadastro());
			Assert.assertEquals("Esportes: Natacao", page.obterEsporteFavoritoCadastro());

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Test
	public void deveValidarNomeObrigatorio() {
		try {
			page.setCadastrar();
			;
			Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Test
	public void deveValidarSobrenomeObrigatorio() {
		try {
			page.setNome("Carolina");
			page.setCadastrar();
			Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Test
	public void deveValidarSexoObrigatorio() {
		try {
			page.setNome("Carolina");
			page.setSobrenome("Mesquita");
			page.setCadastrar();
			
			Assert.assertEquals("Sexo eh obrigatorio", dsl.alertaObterTextoEAceita());

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Test
	public void deveValidarComidaVegetariana() {
		try {

			page.setNome("Carolina");
			page.setSobrenome("Mesquita");
			page.setSexoMasculino();
			page.setComidaFavoritaCarne();
			page.setComidaFavoritaVerdura();
			page.setCadastrar();
			Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTextoEAceita());

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Test
	public void deveValidarEsportistaIndeciso() {
		try {
			dsl.escrever("elementosForm:nome", "Nome qualquer");
			dsl.escrever("elementosForm:sobrenome", "Sobrenome qualquer");
			dsl.clicarRadio("elementosForm:sexo:1");
			dsl.clicarRadio("elementosForm:comidaFavorita:0");
			dsl.selecionarCombo("elementosForm:esportes", "Karate");
			dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
			dsl.clicarBotao("elementosForm:cadastrar");
			Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTextoEAceita());

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}