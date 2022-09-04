package com.automacao.Treinamento;

import org.junit.Test;
import org.openqa.selenium.By;

public class PopupTest extends BaseTest {

    @Test
     public void devoInteragirComPopup(){
         try {
             driver.findElement(By.xpath("//input[@id='buttonPopUpEasy']")).click();
             driver.switchTo().window("PopUp");
             driver.findElement(By.tagName("textarea")).sendKeys("teste");
             driver.close();
             driver.switchTo().window("");
         }catch (Exception e) {
             System.out.println(e.getMessage());
         }
     }
}
