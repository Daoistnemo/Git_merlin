import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QATest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        // Configura el driver de Selenium (asegúrate de tener el chromedriver en tu PATH)
        System.setProperty("webdriver.chrome.driver", 
            "/home/kyr/Documentos/automatizacion web/AutomatizacionWeb/chromedriver");

        driver = new ChromeDriver();
        // Usa Duration para el tiempo de espera
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.youtube.com/");
    }

    @Test
    public void testPageTitle() {
        // Obtiene el título de la página

        driver.get("https://www.youtube.com/");

        String title = driver.getTitle();
        // Verifica si el título es el esperado
        assertEquals("YouTube", title, "El título de la página debería ser 'YouTube'");
    }

    @Test
    public void testElementPresence() {
        // Espera a que el campo de búsqueda sea visible
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#search")));
        // Verifica si el campo de búsqueda es visible
        assertTrue(searchField.isDisplayed(), "El campo de búsqueda debería ser visible");
    }

    @AfterAll
    public static void tearDown() {
        // Cierra el navegador
        if (driver != null) {
            driver.quit();
        }
    }
}
