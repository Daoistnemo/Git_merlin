package com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Esperas {
    
    public static void main(String[] args) {
      
            // Configura la propiedad del sistema para el driver de Chrome
            System.setProperty("webdriver.chrome.driver", "/home/kyr/Documentos/automatizacion web/AutomatizacionWeb/chromedriver");
    
            // Configura ChromeOptions para usar un perfil temporal
            ChromeOptions options = new ChromeOptions();
            options.addArguments("user-data-dir=path/to/temp-profile"); // Usa un perfil temporal
    
            WebDriver driver = null;
    
            try {
                // Inicializa el WebDriver con las opciones configuradas
                driver = new ChromeDriver(options);

                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
                driver.manage().window().maximize();
    
                // Navega a una página web
                driver.get("https://www.google.com.pe/?hl=es");

                Thread.sleep(3000);
        
                // Navega a otra página web
                driver.get("https://www.linkedin.com/");
    
                Thread.sleep(3000);
    
                WebElement loginButton = driver.findElement(By.linkText("Inicia sesión"));

                // Haz clic en el botón
                loginButton.click();
    
                System.out.println("Se hizo clic en el botón de inicio de sesión.");

                WebElement inputEmail = driver.findElement(By.id("username"));

                inputEmail.sendKeys("kelvinjose.203@gmail.com");

                WebElement inputPass = driver.findElement(By.id("password"));

                inputPass.sendKeys("Esecorreoniexiste");

                Thread.sleep(3000);


                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));

                driver.get("https://github.com/");

                WebElement signInButton = driver.findElement(By.linkText("Sign in"));

                signInButton.click();

                WebElement inputCorreo = driver.findElement(By.id("login_field"));
                inputCorreo.sendKeys("kelvin_29w@gmail.com");

                Thread.sleep(3000);

                driver.get("https://www.wikipedia.org/");

                WebElement linkEspan = driver.findElement(By.id("js-link-box-es"));

                linkEspan.click();
    
                Thread.sleep(5000);
            } catch (Exception e) {
                System.out.println("-----------------------------------------------------");
                System.out.println("Error" + e.getMessage());
            } finally {
                // Cierra el navegador
                if (driver != null) {
                    driver.quit();
                }
            }
        }
    }