package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.net.MalformedURLException;
import java.net.URL;

public class dockerSeleniumGridTest {
    public WebDriver driver;

    @Parameters("browser")
    @BeforeTest
    public void setup(String browserType) throws MalformedURLException{

        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (browserType.equalsIgnoreCase("chrome")){
            capabilities.setBrowserName(BrowserType.CHROME);
            System.out.println("#######TEST CASE EXECUTION STARTED ON ==> " + browserType);

        }else if (browserType.equalsIgnoreCase("firefox")){
            capabilities.setBrowserName(BrowserType.FIREFOX);
            System.out.println("#######TEST CASE EXECUTION STARTED ON ==> " + browserType);

        } else {
            capabilities.setBrowserName(BrowserType.EDGE);
            System.out.println("#######TEST CASE EXECUTION STARTED ON ==> " + browserType);

        }
        driver = new RemoteWebDriver(new URL("http://localhost:4445"), capabilities);
    }

    @Test
    public void googleOnCHROMETest() throws MalformedURLException, InterruptedException{
        try {
            driver.get("https://www.google.com");
            Assertion assertion = new Assertion();
            assertion.assertEquals(driver.getTitle(), "Google", "WRONG Page Title");
            Thread.sleep(8000);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void linkedInOnFIREFOXTest() throws MalformedURLException, InterruptedException {
        try {
            driver.get("https://www.linkedin.com");
            Assertion assertion = new Assertion();
            assertion.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up", "WRONG Page Title");
            Thread.sleep(8000);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Test
    public void gmailOnEdgeTest() throws MalformedURLException, InterruptedException {
        try {
            driver.get("https://www.gmail.com");
            Assertion assertion = new Assertion();
            assertion.assertEquals(driver.getTitle(), "Gmail", "WRONG Page Title");
            Thread.sleep(8000);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }


    @Test
    public void facebookOnCHROMETest() throws MalformedURLException, InterruptedException{
        try{
            driver.get("https://www.facebook.com");
            Assertion assertion = new Assertion();
            assertion.assertEquals(driver.getTitle(), "Facebook – log in or sign up", "WRONG Website");
            Thread.sleep(8000);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }


}
