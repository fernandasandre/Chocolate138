package webtest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.groovy.json.internal.Chr;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class seleniumSimples {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testSelectBackdrop(){
        driver.get("https://www.saucedemo.com");
        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.clear();
        username.sendKeys("standard_user");
        //username.sendKeys(Keys.chord("standard_user"));
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement btnLogin = driver.findElement(By.id("login-button"));
        btnLogin.click();
        assertEquals(driver.findElement(By.cssSelector("span.title")).getText(), "Products");
        assertTrue(driver.findElement(By.id("shopping_cart_container")).isDisplayed());
        driver.findElement(By.id("item_4_title_link")).click();
        assertEquals(driver.findElement(By.cssSelector("div.inventory_details_name.large_size")).getText(), "Sauce Labs Backpack");
        assertEquals(driver.findElement(By.cssSelector("div.inventory_details_price")).getText(), "$29.99");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        assertEquals(driver.findElement(By.cssSelector("span.title")).getText(), "Your Cart");
        assertEquals(driver.findElement(By.id("item_4_title_link")).getText(), "Sauce Labs Backpack");
        assertEquals(driver.findElement(By.cssSelector("div.cart_quantity")).getText(), "1");
        assertEquals(driver.findElement(By.cssSelector("div.inventory_item_price")).getText(), "$29.99");
    }
}
