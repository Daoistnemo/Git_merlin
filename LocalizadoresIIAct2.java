package com;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocalizadoresIIAct2 {
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

            // Imprime el título de la página
            System.out.println("Title: " + driver.getTitle());
            // Espera explícita para asegurar que la página esté cargada

            Thread.sleep(2000); // Pausa para asegurar la carga completa de la página

            // Encuentra el cuadro de búsqueda usando el atributo id
            WebElement cuadroDeBusqueda = driver.findElement(By.id("APjFqb"));

            Thread.sleep(2000);

            // Escribe "hello world" en el cuadro de búsqueda
            cuadroDeBusqueda.sendKeys("Tiendamia peru");

            Thread.sleep(2000);

            cuadroDeBusqueda.submit();

            // Encuentra el enlace específico usando el atributo jsname
            WebElement enlaceTiendaMia = driver.findElement(By.cssSelector("a[jsname='UWckNb']"));
            // Haz clic en el enlace
            enlaceTiendaMia.click();
            // Maximiza la ventana del navegador
            driver.manage().window().maximize();

            // Localiza el botón "Ver más" usando la clase
            WebElement botonVerMas = driver.findElement(By.cssSelector("button.component-cta"));

            // Haz clic en el botón "Ver más"
            botonVerMas.click();
            // Espera un momento para ver los resultados (solo para demostración)
        
                Thread.sleep(2000);
          
        } finally {

            driver.quit();

        }

    }


        
    }

