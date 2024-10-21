package fblogin.assignment;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class App {
    public static void main(String[] args) {
      

        // Initialize the Chrome WebDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
     

        try {
            // Open Facebook login page
            driver.get("https://www.facebook.com");

            // Locate the email input field
            WebElement emailField = driver.findElement(By.id("email"));
            emailField.sendKeys("feaunpxydlpzgffrpz@poplk.com");

            // Locate the password input field
            WebElement passwordField = driver.findElement(By.id("pass"));
            passwordField.sendKeys("devopsassigment1");

            // Locate the login button and click it
            WebElement loginButton = driver.findElement(By.name("login"));
            loginButton.click();

            // Optionally, you can add a wait to allow the page to load
            Thread.sleep(5000); // Adjust the sleep time as per your network speed

            // Check if the login was successful by looking for an element on the homepage
            if (driver.getCurrentUrl().contains("facebook.com")) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser after the login attempt
            driver.quit();
        }
    }
}
