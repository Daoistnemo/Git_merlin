package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ActividadCom {

    public static void main(String[] args) {
        // Configura la propiedad del sistema para el driver de Chrome
        System.setProperty("webdriver.chrome.driver",
                "/home/kyr/Documentos/automatizacion web/AutomatizacionWeb/chromedriver");

        // Configura ChromeOptions para usar un perfil temporal
          // Configura ChromeOptions para usar un perfil temporal
          ChromeOptions options = new ChromeOptions();
          options.addArguments("user-data-dir=path/to/temp-profile"); // 
        WebDriver driver = null;

        try {
            // Inicializa el WebDriver con las opciones configuradas
            driver = new ChromeDriver(options);

            // Navega a Google
            driver.get("https://www.google.com.pe/?hl=es");

            // Espera explícita para asegurarse de que la página se haya cargado completamente
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.titleContains("Google"));

            // Navega a YouTube
            driver.get("https://www.youtube.com/");

            // Espera para asegurarse de que la página de YouTube se haya cargado
            wait.until(ExpectedConditions.titleContains("YouTube"));

            // Encuentra el campo de búsqueda
            WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#search")));
            // Escribe en el campo de búsqueda
            searchField.sendKeys("don dimadon");

            // Encuentra el botón de búsqueda y haz clic
            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#search-icon-legacy")));
            searchButton.click();

            System.out.println("Se encontró el botón y se hizo clic.");

            // Espera a que los resultados de búsqueda se carguen
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ytd-video-renderer")));

            // Encuentra el enlace del video usando ID y texto con XPath
            WebElement thumbnailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "//a[.//yt-formatted-string[text()='Oscar Maydon x Remp x Victor Mendivil - Don Dimadon [Official Video]']]")));

            // Realiza una acción, como hacer clic en el elemento
            thumbnailElement.click();

            System.out.println("Se encontró el video y se hizo clic.");

            // Espera para visualizar el resultado
            Thread.sleep(10000);

        } catch (Exception e) {
            // Manejo de excepciones
            System.err.println("Se produjo una excepción: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cierra el navegador
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
