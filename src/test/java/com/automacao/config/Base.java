package com.automacao.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Base {

    public static WebDriver driver;

    public void browserChrome(){
        try {
            System.setProperty("file.encoding", "UTF-8");
            System.setProperty("file.encoding", "UTF-8");
            System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");

            driver = new ChromeDriver();
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().wait(25000);
            driver.quit();
            
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
    }     
    
}
