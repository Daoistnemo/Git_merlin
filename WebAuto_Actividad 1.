package com.merlin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) {
        // Configura la propiedad del sistema para el driver de Chrome
        System.setProperty("webdriver.chrome.driver", "/home/kyr/Documentos/automatizacion web/AutomatizacionWeb/chromedriver");

        // Configura ChromeOptions para usar un perfil temporal
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=/tmp/temp-profile"); // Usa un perfil temporal

        WebDriver driver = null;
        try {
            // Inicializa el WebDriver con las opciones configuradas
            driver = new ChromeDriver(options);

            // Navega a una página web
            driver.get("https://www.example.com");

            // Imprime el título de la página
            System.out.println("Title: " + driver.getTitle());
        } finally {
            // Cierra el navegador si el WebDriver fue inicializado
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
