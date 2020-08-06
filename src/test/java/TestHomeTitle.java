import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;


public class TestHomeTitle {
    @Test
    public void test() {
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

}
