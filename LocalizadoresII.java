package com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocalizadoresII {
    @SuppressWarnings("unused")
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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        // Encuentra el cuadro de búsqueda usando el atributo id
        WebElement cuadroDeBusqueda = driver.findElement(By.id("APjFqb"));

        Thread.sleep(2000);

        // Escribe "hello world" en el cuadro de búsqueda
        cuadroDeBusqueda.sendKeys("hello world");

        Thread.sleep(2000);

        // Opcional: Enviar el formulario (esto simula presionar Enter)
        cuadroDeBusqueda.submit();

        // Espera un momento para ver los resultados (solo para demostración)
        Thread.sleep(2000);
        } finally {

        driver.quit();

        }}}

        /// ------------------------------------------------------------------------------------------
