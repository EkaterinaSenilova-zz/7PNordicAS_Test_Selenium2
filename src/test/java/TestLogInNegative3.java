import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.*;
import java.util.concurrent.TimeUnit;

/* Preconditions: Server is down or no Internet connection. ?Need  to use BrowserMob Proxy. https://www.seleniumeasy.com/selenium-tutorials/browsermob-proxy-selenium-example

Negative3: User can't log in to system with proprietary login and password (servers are down, no internet connection, etc )*/

public class TestLogInNegative3 {
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


          /*      // start the proxy
        BrowserMobProxyServer proxy = new BrowserMobProxyServer();
        proxy.start(0);
        int port = proxy.getPort(); // get the JVM-assigned port
                // Selenium or HTTP client configuration goes here

                //get the Selenium proxy object - org.openqa.selenium.Proxy;
        BrowserMobProxy seleniumProxy = (BrowserMobProxy) ClientUtil.createSeleniumProxy(proxy);

                // configure it as a desired capability
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);*/

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


      /*  // enable more detailed HAR capture, if desired (see CaptureType for the complete list)
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);

                // create a new HAR with the label "hack.me"
        proxy.newHar("hack.me");

                // open hack.me
        chromeDriver.get("https://hack.me/");*/

        chromeDriver.quit();

            }


    }






