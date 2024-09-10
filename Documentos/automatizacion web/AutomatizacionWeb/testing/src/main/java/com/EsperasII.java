package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class EsperasII {

    public static void main(String[] args) {
        // Configura la propiedad del sistema para el driver de Chrome
        System.setProperty("webdriver.chrome.driver",
                "/home/kyr/Documentos/automatizacion web/AutomatizacionWeb/chromedriver");

        // Configura ChromeOptions para usar un perfil temporal
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=path/to/temp-profile"); // Usa un perfil temporal

        WebDriver driver = null;

        try {
            // Inicializa el WebDriver con las opciones configuradas
            driver = new ChromeDriver(options);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            // Navega a una página web
            driver.get("https://www.google.com.pe/?hl=es");

            // Espera explícita para asegurarse de que la página se haya cargado
            // completamente
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            Thread.sleep(3000);

            // Encuentra el campo de búsqueda(
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
            searchBox.click();

            // Escribe en el campo de búsqueda
            searchBox.sendKeys("Bandalos Chinos");
            searchBox.submit();

            Thread.sleep(3000);

            // Ir al Github

            driver.get("https://github.com/");

            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign in")));

            loginButton.click();

            WebElement inputCorreo = driver.findElement(By.id("login_field"));
            inputCorreo.sendKeys("kelvin_29w@gmail.com");

            Thread.sleep(3000);

            driver.get("https://9gag.com/");

          
            WebElement menuLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("menu")));
            menuLink.click();
            menuLink.click();

            WebElement signIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign up")));
            signIn.click();

          WebElement useMail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-btn.btn-color-inherit.btn-outlined.list-item")));
            useMail.click();
          

            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cierra el navegador
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
