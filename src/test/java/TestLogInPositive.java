import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

/*Preconditions: A valid user logging in with a common username (no fancy characters) and a correct simple password (as simple as the security requirements will allow).
The user is already a member of the testing web service and has access to. Username is Test111, Password is Test_111  */

public class TestLogInPositive {
    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "//Users/ganapatineo/Downloads/chromedriver"); //Here you have to add your actual path to chromedriver file.
        WebDriver chromeDriver = new ChromeDriver(); //Initialising Chrome.
        //WebDriver FirefoxDriver = new FirefoxDriver();
        String url = "https://hack.me/"; //Here the actual web testing url.
        chromeDriver.get(url);
        String actualURL = chromeDriver.getCurrentUrl();
        String title= "Members Area"; //Here the actual web title of the member page.
        chromeDriver.getTitle();
        String actualTitle = chromeDriver.getTitle();

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
        element2.sendKeys("Test_111");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnlogin"))).click();
        Thread.sleep(2000);

        assertEquals(chromeDriver.getTitle(), title, "Members Area");
       /* if (actualTitle.equals(title)) {
            System.out.println("You are the member.");
        } else {
            System.out.println("Something went wrong.");
        }*/


        chromeDriver.quit();

    }

}

