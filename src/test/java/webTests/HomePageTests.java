package webTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class HomePageTests {

    private WebDriver driver;
    private static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @Test
    void openHomePageTest() {
        String actualTitle = driver.getTitle();
        assertEquals("Hands-On Selenium WebDriver with Java", actualTitle);
    }

    @Test
    void openWebFormTest() {
        String webFormUrl = "web-form.html";
        driver.findElement(By.linkText("Web form")).click();
        WebElement actualTitle = driver.findElement(By.className("display-6"));
        String currentUrl = driver.getCurrentUrl();
        assertEquals(BASE_URL + webFormUrl, currentUrl);
        assertEquals("Web form", actualTitle.getText());
    }
}
