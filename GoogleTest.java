import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import org.junit.jupiter.api.Assertions;

public class GoogleTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        // Configura la propiedad del sistema para el driver de Chrome
              // Configura la propiedad del sistema para el driver de Chrome
              System.setProperty("webdriver.chrome.driver",
              "/home/kyr/Documentos/automatizacion web/AutomatizacionWeb/chromedriver");

      // Configura ChromeOptions para usar un perfil temporal
      ChromeOptions options = new ChromeOptions();
      options.addArguments("user-data-dir=path/to/temp-profile");

        // Opcional: Configura las opciones del navegador si es necesario
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Uso de Duration en lugar de int
        driver.get("https://www.google.com");
    }

    @Test
    public void testPageTitle() {

        driver.get("https://www.google.com");
        // Obtiene el título de la página
        String title = driver.getTitle();
        // Verifica si el título es "Google"
        Assertions.assertEquals("Google", title, "El título de la página debería ser Google.");
    }

    @Test
    public void testLogoClass() {

        driver.get("https://www.google.com");
        // Espera a que el logo de Google esté visible
        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.lnXdpd")));
        // Verifica que la clase del logo no es "logo-class"
        Assertions.assertNotEquals("logo-class", logo.getAttribute("class"), "La clase del logo no debería ser 'logo-class'.");
    }

    @Test
    public void testSearchInput() {
        // Encuentra el campo de búsqueda
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        // Escribe "hotmail" en el campo de búsqueda
        searchInput.sendKeys("hotmail");

        searchInput.submit();
        // Espera a que se muestren las opciones de autocompletado
        WebElement firstOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3")));
        // Verifica que la primera opción es "hotmail"
        Assertions.assertTrue(firstOption.getText().contains("Hotmail"), "La primera opción del autocompletado debería contener 'hotmail'.");
    }

    @Test
    public void testLoginButtonClass() {

        driver.get("https://www.youtube.com/");

        // Encuentra el botón de acceso usando XPath
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Acceder' and contains(@class, 'yt-spec-button-shape-next')]")));
        // Obtiene el atributo href del botón
        String buttonURL = loginButton.getAttribute("href");
        // Verifica que el URL sea el esperado
        Assertions.assertEquals("https://accounts.google.com/ServiceLogin?service=youtube&uilel=3&passive=true&continue=https%3A%2F%2Fwww.youtube.com%2Fsignin%3Faction_handle_signin%3Dtrue%26app%3Ddesktop%26hl%3Des-419%26next%3Dhttps%253A%252F%252Fwww.youtube.com%252F&hl=es-419&ec=65620", buttonURL, "El URL del botón de acceso no es el esperado.");
    }
    @AfterAll
    public static void tearDown() {
        // Cierra el navegador
        driver.quit();
    }
}
