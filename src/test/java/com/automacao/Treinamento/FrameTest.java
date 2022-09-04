package com.automacao.Treinamento;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class FrameTest extends BaseTest{

    @Test
    public void deveInteragirComFrame(){
        try {
            //driver.findElement(By.id("frameButton")).click();
            //switchTo(), mude para
            //clicando no botao confirma
            driver.switchTo().frame("frame1");
            driver.findElement(By.id("frameButton")).click();
            Alert alert = driver.switchTo().alert();
            String texto = alert.getText();
            Assert.assertEquals("Frame OK!", texto);
            alert.accept();
            driver.findElement(By.xpath("//input[@id='elementosForm:nome'][@type='text']")).sendKeys(texto);
        
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
    }
    
}
