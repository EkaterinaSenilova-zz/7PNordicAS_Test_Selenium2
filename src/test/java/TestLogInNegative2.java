import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.UUID;

import static org.testng.Assert.*;

/* Preconditions: The fuzzing password field using any value other than the correct password for a given user Test111, and
then checking for successful logins, exceptions, and other inappropriate results.

Negative2: User can't log in with proprietary login and bad password (when the special symbols are required for). */

public class TestLogInNegative2 {
    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "//Users/ganapatineo/Downloads/chromedriver"); //Here you have to add your actual path to chromedriver file.
        WebDriver chromeDriver = new ChromeDriver(); //Initialising Chrome.
        //WebDriver FirefoxDriver = new FirefoxDriver();
        String url = "https://hack.me/"; //Here the actual web testing url.
        chromeDriver.get(url);
        String actualURL = chromeDriver.getCurrentUrl();
        String uuid = UUID.randomUUID().toString();

        System.out.println("Successfully opened the url.");

        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Pause to show the open web page.

        if (actualURL.equals(url)) {
            System.out.println("The correct Url is opened");
        } else {
            System.out.println("An incorrect Url is opened");
        }

        WebDriverWait wait = new WebDriverWait(chromeDriver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign in"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("icon-signin"))).click();
        WebElement element1 = chromeDriver.findElement(By.id("username"));
        element1.sendKeys("Test111");
        WebElement element2 = chromeDriver.findElement(By.id("password"));
        element2.sendKeys("Test111");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnlogin"))).click();
        //Thread.sleep(2000);

        // This will capture error message
        String actual_msg=chromeDriver.findElement(By.className("alert-heading")).getText();

        // Store message in variable
        String expect="Oh snap! You got an error!";

        // Verify error message
        Assert.assertEquals(actual_msg, expect);

        try {
            System.out.println(actual_msg);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }


        chromeDriver.quit();

    }


}


