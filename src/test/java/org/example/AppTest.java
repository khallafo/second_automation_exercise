package org.example;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class AppTest  {

    public WebDriver driver =new ChromeDriver();

    @BeforeTest
    public void setUp() {
        //Use Chrome driver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //full screen window
        driver.manage().window().maximize();
        // wait for the element to appear before the exception occurs
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testSignInWithValidCredentials() {
        // Create object of HomePage class and open the page
        driver.get("https://www.saucedemo.com/");
        SignInPage signInPage = new SignInPage(driver);
        //Sign in with valid credentials
        signInPage.signIn("standard_user", "secret_sauce");
        WebElement inventory = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[1]/div[2]/div"));
        //Verifying whether user is logged in
        Assert.assertEquals("Swag Labs", inventory.getText());
    }
    @Test
    public void testSignInWithInvalidPassword() {
        driver.get("https://www.saucedemo.com/");
        SignInPage signInPage = new SignInPage(driver);
        //Sign in with valid credentials
        signInPage.signIn("standard_user", "secret_sauce1");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement invalidpass = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", invalidpass.getText());
    }

    @Test
    public void testSignInWithInvalidEmail() {
        driver.get("https://www.saucedemo.com/");
        SignInPage signInPage = new SignInPage(driver);
        //Sign in with valid credentials
        signInPage.signIn("standard_user1", "secret_sauce");
        WebElement invalidpass = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", invalidpass.getText());
    }
    @Test(dependsOnMethods = "testSignInWithValidCredentials")
    public void checkoutProduct(){
        SearchProduct searchProduct = new SearchProduct(driver);
        searchProduct.Checks();
    }

    @AfterClass
    public void closen(){
            driver.quit();
    }
}
