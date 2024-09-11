package com;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;

public class EsperasCondicionales {

    public static void main(String[] args) {
        // Configura la propiedad del sistema para el driver de Chrome
        System.setProperty("webdriver.chrome.driver",
                "/home/kyr/Documentos/automatizacion web/AutomatizacionWeb/chromedriver");

        // Configura ChromeOptions para usar un perfil temporal
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=path/to/temp-profile");

        WebDriver driver = null;

        try {
            // Inicializa el WebDriver con las opciones configuradas
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.manage().window().maximize();

            // Navega a Google
            driver.get("https://www.google.com.pe/?hl=es");

            // Configura una espera explícita usando FluentWait
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(10)) // Tiempo máximo de espera
                    .pollingEvery(Duration.ofMillis(500)) // Frecuencia de verificación
                    .ignoring(NoSuchElementException.class); // Ignorar excepción específica

            // Espera hasta que el título de la página contenga "Google"
            wait.until(ExpectedConditions.titleContains("Google"));

            // Encuentra el campo de búsqueda, escribe "Youtube" y realiza la búsqueda
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
            searchBox.sendKeys("Youtube");
            searchBox.submit();

            // Encuentra y hace clic en el enlace de YouTube
            WebElement linkYt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'DKV0Md')]")));
            linkYt.click();

            // Espera hasta que el título de la página de YouTube contenga "YouTube"
            wait.until(ExpectedConditions.titleContains("YouTube"));

            // Encuentra el campo de búsqueda en YouTube y realiza una búsqueda
            WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#search")));
            searchField.sendKeys("don dimadon");
            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#search-icon-legacy")));
            searchButton.click();

            System.out.println("Se encontró el botón y se hizo clic.");

            // Espera a que los resultados de búsqueda se carguen
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ytd-video-renderer")));

            // Encuentra el enlace del video usando texto con XPath
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                    "//yt-formatted-string[text()='Oscar Maydon x Remp x Victor Mendivil - Don Dimadon [Official Video]']")));

            // Realiza una acción, como hacer clic en el elemento
            element.click();

            System.out.println("Se encontró el video y se hizo clic.");

            // Espera para visualizar el resultado
            Thread.sleep(10000);

        } catch (TimeoutException e) {
            System.err.println("Se superó el tiempo de espera: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.err.println("Elemento no encontrado: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Se produjo una excepción inesperada: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cerrar el navegador
            // if (driver != null) {
            //     driver.quit();
            // }
        }
    }
}
