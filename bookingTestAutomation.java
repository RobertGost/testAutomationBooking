import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class bookingTestAutomation {

    /**
     * Initialization of Selenium WebDriver
     */

    public static WebDriver driver;
    WebDriverWait wait;

    /**
     * Global variables
     */

    String URL = "http://www.booking.com";

    /**
     * Actions which are propagated on all tests
     */

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Chrome/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    /**
     * Filing the fields for booking.com
     */

    @Test
    public void bookingTest() {

        // Going on the website
        driver.get(URL);
        System.out.println("1.Entering the website");

        // Enter the destination
        driver.findElement(By.cssSelector("#ss")).sendKeys("Paris");
        System.out.println("2.Entering the destination");

        // Choose the start date form
        driver.findElement(By.cssSelector(".sb-date-field__icon.sb-date-field__icon-btn.bk-svg-wrapper.calendar-restructure-sb")).click();
        driver.findElement(By.cssSelector(".bui-calendar__main.b-a11y-calendar-contrasts>.bui-calendar__content>div:nth-child(2)>table>tbody>.bui-calendar__row:nth-child(4)>td:nth-child(4)")).click();
        driver.findElement(By.cssSelector(".bui-calendar__main.b-a11y-calendar-contrasts>.bui-calendar__content>div:nth-child(2)>table>tbody>.bui-calendar__row:nth-child(5)>td:nth-child(3)")).click();
        System.out.println("3.Define the start and end date");

        // Enter the number of passengers
        driver.findElement(By.cssSelector(".xp__input-group.xp__guests")).click();
        driver.findElement(By.cssSelector("#xp__guests__inputs-container>div>.u-clearfix>div:nth-child(2)>div>.bui-stepper__wrapper.sb-group__stepper-a11y>.bui-button.bui-button--secondary.bui-stepper__add-button ")).click();
        System.out.println("4.Define family members");

        // Click on the search button
        driver.findElement(By.cssSelector(".sb-searchbox__button ")).click();
        System.out.println("5.Click on the search button");

        // Selecting the hotel
        driver.findElement(By.cssSelector(".bui-pagination.results-paging>nav>ul>li:nth-child(2)>ul>li:nth-child(4)")).click();
        driver.findElement(By.cssSelector("#ajaxsrwrap>div>div>div>div:nth-child(12)>div>div>div")).click();
        System.out.println("6.Select the hotel");
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
