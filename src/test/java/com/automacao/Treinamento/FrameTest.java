package com.automacao.Treinamento;

import org.junit.Assert;
import org.junit.Test;


public class FrameTest extends BaseTest {

	private DSL dsl;

	@Test
	public void deveInteragirComFrames() {
		try {
			dsl.entrarFrame("frame1");
			dsl.clicarBotao("frameButton");
			String msg = dsl.alertaObterTextoEAceita();
			Assert.assertEquals("Frame OK!", msg);

			dsl.sairFrame();
			dsl.escrever("elementosForm:nome", msg);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
