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
    public static void main(String[] args) throws InterruptedException, IOException {
      

        // Initialize the Chrome WebDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
     

        
            // Open  contact page
            driver.get("http://3.80.172.32:8081/contact.html");
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
            
            driver.findElement(By.name("your_name")).sendKeys("DevsopsUser");
            driver.findElement(By.name("phone_number")).sendKeys("999-999-99");
            driver.findElement(By.name("email_address")).sendKeys("xyc@abz");
            
            driver.findElement(By.id("my-button")).click();
            
            Thread.sleep(2000);
            // Close the browser after 
            
            
          //assert Result
    		String message = driver.findElement(By.id("response")).getText();
    		
    		System.out.println(message);
    		
    		TakesScreenshot scrShot = ((TakesScreenshot) driver);

    		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

    		File destFile = new File("test-report.jpg");

    		FileUtils.copyFile(srcFile, destFile);

    		driver.quit();

    		System.out.println("Script Executed and Result Captured");
        
    }
}
