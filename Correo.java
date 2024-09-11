package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class Correo {

    public static void main(String[] args) {
        // Configura la propiedad del sistema para el driver de Chrome
        System.setProperty("webdriver.chrome.driver", "/home/kyr/Documentos/automatizacion web/AutomatizacionWeb/chromedriver");

        // Configura ChromeOptions para usar un perfil temporal
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("disable-extensions");
        options.addArguments("disable-gpu");
        options.addArguments("disable-infobars");
        options.addArguments("disable-dev-shm-usage");
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = null;

        try {
            // Inicializa el WebDriver con las opciones configuradas
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            // Navega a la página de Google
            driver.get("https://www.google.com.pe/?hl=es");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Encuentra el campo de búsqueda, escribe "Gmail" y realiza la búsqueda
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
            simulateHumanTyping(driver, searchBox, "Gmail");
            searchBox.submit();

            // Espera y mueve el mouse antes de hacer clic en el enlace de Gmail
            WebElement linkGmail = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='rso']/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3")));
            moveToAndClick(driver, linkGmail);

            // Espera y mueve el mouse antes de hacer clic en el botón "Acceder"
            WebElement accederGoogle = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Acceder")));
            moveToAndClick(driver, accederGoogle);

            // Espera y escribe el correo electrónico
            WebElement campoCorreo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
            simulateHumanTyping(driver, campoCorreo, "notarealemail");

            // Espera y mueve el mouse antes de hacer clic en el botón "Siguiente"
            WebElement botonSiguiente = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button/span[text()='Siguiente']")));
            moveToAndClick(driver, botonSiguiente);

            // Espera para observar los resultados
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

    // Función para simular la entrada de texto de forma humana
    private static void simulateHumanTyping(WebDriver driver, WebElement element, String text) {
        Actions actions = new Actions(driver);
        Random random = new Random();
        for (char c : text.toCharArray()) {
            actions.sendKeys(element, String.valueOf(c)).perform();
            try {
                Thread.sleep(50 + random.nextInt(150)); // Pausas aleatorias entre teclas
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Función para mover el mouse al elemento y hacer clic
    private static void moveToAndClick(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }
}
