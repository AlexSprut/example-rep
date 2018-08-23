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
public class RozetkaTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void categoryCheck() {
        WebElement categoryButton = driver.findElement(By.xpath("//a[@href='https://rozetka.com.ua/sport-i-uvlecheniya/c4627893/']"));
        categoryButton.click();
        String expectedUrl = "https://rozetka.com.ua/sport-i-uvlecheniya/c4627893/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue("Current url is not equal to expected", actualUrl.equals(expectedUrl));
    }
}

