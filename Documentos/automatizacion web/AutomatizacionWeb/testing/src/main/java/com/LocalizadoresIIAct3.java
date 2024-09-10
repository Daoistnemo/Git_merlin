package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LocalizadoresIIAct3 {
    public static void main(String[] args) throws InterruptedException {

        // Configura la propiedad del sistema para el driver de Chrome
        System.setProperty("webdriver.chrome.driver",
                "/home/kyr/Documentos/automatizacion web/AutomatizacionWeb/chromedriver");

        // Configura ChromeOptions para usar un perfil temporal
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=/tmp/temp-profile"); // Usa un perfil temporal

        WebDriver driver = null;
        try {
            // Inicializa el WebDriver con las opciones configuradas
            driver = new ChromeDriver(options);

            // Navega a una página web
            driver.get("https://www.google.com.pe/?hl=es");

            Thread.sleep(2000);

            driver.get("https://asuracomic.net/");


   
            Thread.sleep(5000);

            WebElement enlacePerfil = driver.findElement(By.xpath("//a[@href='/login']"));
            enlacePerfil.click(); // Esto hará clic en el enlace con el href "/login"
            Thread.sleep(2000);

            WebElement inputEmail = driver.findElement(By.id(":r0:-form-item"));
            inputEmail.sendKeys("daoistnemo21@gmail.com");
            Thread.sleep(2000);
            WebElement inputPas = driver.findElement(By.id(":r1:-form-item"));
            inputPas.sendKeys("Wolfy.21");
            Thread.sleep(2000);

         // Crea un objeto WebDriverWait para esperar, usando Duration
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
         // Encuentra el botón usando XPath
         WebElement botonLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and contains(@class, 'bg-purple-600') and contains(@class, 'text-white') and contains(@class, 'rounded-lg') and text()='Login']")));
         
         // Desplazar la ventana al botón si es necesario
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", botonLogin);

         botonLogin.click();
         
            Thread.sleep(5000);

        } finally {

            // driver.quit();

        }

    }

}