package com.automacao.Treinamento;

import org.openqa.selenium.WebDriver;

public class CampoTreinamentoPage extends BaseTest {

    private DSL dsl;

    CampoTreinamentoPage(WebDriver driver) {
        dsl = new DSL(driver);
    }

    public void setNome(String nome) {
        dsl.escrever("elementosForm:nome", nome);
    }
    public void setSobrenome(String sobrenome) {
        dsl.escrever("elementosForm:sobrenome", sobrenome);
    }
    public void setSexoMasculino(){
        dsl.clicarRadio("elementosForm:sexo:0");
    }
    public void setSexoFeminino(){
        dsl.clicarRadio("elementosForm:sexo:1");
    }
    public void setComidaFavoritaPizza(){
        dsl.clicarRadio("elementosForm:comidaFavorita:2");
    }
    public void setComidaFavoritaCarne(){
        dsl.clicarRadio("elementosForm:comidaFavorita:0");
    }
    public void setComidaFavoritaVerdura(){
        dsl.clicarRadio("elementosForm:comidaFavorita:3");
    }
    public void setSelecinarEscolaridade(String valor){
        dsl.selecionarCombo("elementosForm:escolaridade", valor);
    }
    public void setSelecionarEsporte(String valor){
        dsl.selecionarCombo("elementosForm:esportes", valor);
    }
    public void setCadastrar(){
        dsl.clicarBotao("elementosForm:cadastrar");
    }
    public String  obterResultadoCadastro(){
        return dsl.obterTexto("resultado");
    }
    public String obterNomeCadastro(){
        return dsl.obterTexto("descNome");
    }
    public String obterSobreNomeCadastro(){
        return dsl.obterTexto("descSobrenome");
    }
    public String obterSexoCadastro(){
        return dsl.obterTexto("descSexo");
    }
    public String obterComidaFavoritaCadastro(){
        return dsl.obterTexto("descComida");
    }
    public String obterEscolaridadeCadastro(){
        return dsl.obterTexto("descEscolaridade");
    }
	public String obterEsporteFavoritoCadastro(){
        return dsl.obterTexto("descEsportes");
    }
    
			
			
			
			

}
