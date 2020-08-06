import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TestSuites {

    @Test
    public void TestHomeTitle() {
        System.setProperty("webdriver.chrome.driver", "//Users/ganapatineo/Downloads/chromedriver"); //Here you have to add your actual path to chromedriver file.
        WebDriver chromeDriver = new ChromeDriver(); //Initialising Chrome.
        //WebDriver FirefoxDriver = new FirefoxDriver();
        String url = "https://hack.me/"; //Here the actual web testing url.
        String title= "Hack.me · The house of rising sandbox"; //Here the actual home title of web testing url.
        chromeDriver.get(url);
        String actualURL = chromeDriver.getCurrentUrl();
        chromeDriver.getTitle();
        String actualTitle = chromeDriver.getTitle();
        System.out.println("Successfully opened the url.");

        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Pause to show the open web page.

        if (actualURL.equals(url)) {
            System.out.println("The correct Url is opened");
        } else {
            System.out.println("An incorrect Url is opened");
        }

        assertEquals(chromeDriver.getTitle(), title, "The Home Title is wrong.");
        if (actualTitle.equals(title)) {
            System.out.println("The Home Title is correct");
        } else {
            System.out.println("The Home Title is wrong.");
        }

        chromeDriver.quit();

    }

    @Test
    /* Preconditions: The fuzzing username field using any value other than the correct username for a given user Test111, and
    then checking for successful logins, exceptions, and other inappropriate results.

     Negative1: User can't log in with unregistered login(username) */
    public void TestLogInNegative1() {
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
        element1.sendKeys(uuid); //Set up the wrong random username.
        WebElement element2 = chromeDriver.findElement(By.id("password"));
        element2.sendKeys("Test_111");
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

    @Test
    /* Preconditions: The fuzzing password field using any value other than the correct password for a given user Test111, and
     then checking for successful logins, exceptions, and other inappropriate results.

    Negative2: User can't log in with proprietary login and bad password (when the special symbols are required for). */
    public void TestLogInNegative2() {
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

    @Test
    /* Preconditions: Server is down or no Internet connection. ?Need  to use BrowserMob Proxy. https://www.seleniumeasy.com/selenium-tutorials/browsermob-proxy-selenium-example

    Negative3: User can't log in to system with proprietary login and password (servers are down, no internet connection, etc )*/

    public void TestLogInNegative3() {
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
        element2.sendKeys("Test_111");
        //Thread.sleep(2000);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnlogin"))).click();

        WebElement error = chromeDriver.findElement(By.className("error-code"));

        if(error.getText().equals("DNS_PROBE_FINISHED_NO_INTERNET") || error.getText().equals("net::ERR_INTERNET_DISCONNECTED")) {
            System.out.println("No Internet Connection");
        } else {
            System.out.println("Internet Connected");
        }

        Assert.assertEquals(error, "error");

        try {
            System.out.println(error);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }


        chromeDriver.quit();

    }

    @Test
    /*Preconditions: A valid user logging in with a common username (no fancy characters) and a correct simple password (as simple as the security requirements will allow).
    The user is already a member of the testing web service and has access to. Username is Test111, Password is Test_111  */
    public void TestLogInPositive() throws InterruptedException {
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





