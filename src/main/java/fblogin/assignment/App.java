package fblogin.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App {
    public static void main(String[] args) {
        // Set the ChromeDriver path (optional if added to system path)
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        // Initialize the Chrome WebDriver
        ChromeOptions options = new ChromeOptions();

        
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");  // Overcome limited resource problems
        options.addArguments("--disable-gpu");            // Disable GPU rendering as it's not needed in headless mode
        options.addArguments("--window-size=1920,1080");  // Set a fixed window size for consistent results
        options.addArguments("--disable-extensions");     // Disable any extensions
        options.addArguments("--remote-debugging-port=9222");  // Remote debugging for potential issues
        
        WebDriver driver = new ChromeDriver();
     

        try {
            // Open Facebook login page
            driver.get("https://www.facebook.com");

            // Maximize the browser window
            driver.manage().window().maximize();

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
