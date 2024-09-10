package com.merlin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/kyr/Documentos/automatizacion web/AutomatizacionWeb/chromedriver");

        // Configura ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Inicia el navegador en modo maximizado
        options.addArguments("user-data-dir=/tmp/temp-profile"); // Usa un perfil temporal

        // Inicializa el WebDriver con las opciones configuradas
        WebDriver driver = new ChromeDriver(options);


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
