package rozetka;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

/**
 * Created by Alex on Aug, 2018
 */
public class RozetkaTest2 {

    private WebDriver driver;

    @Before
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
        WebElement searchField = driver.findElement(By.xpath("//input[@placeholder='Поиск']"));
        searchField.sendKeys("велосипеды");
        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit' and contains(., 'Найти')]"));
        searchButton.click();
        WebElement addToCart = driver.findElement(By.xpath("//form[1][@method='POST']"));
        addToCart.click();
        sleep(5000);
        WebElement continueShopping = driver.findElement(By.xpath("//a[text()='Продолжить покупки']"));
        continueShopping.click();
        WebElement openYourCart = driver.findElement(By.xpath("//span[text()='Корзина']"));
        openYourCart.click();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void basketCheck() {
        String itemUrl = "https://rozetka.com.ua/formula_ret_frk_20_008/p35568225/";
        WebElement itemInCart = driver.findElement(By.xpath("(//a[@name='goods-link'])[2]"));
        Assert.assertEquals("no such item in the cart", itemUrl, itemInCart.getAttribute("href"));
    }
}
