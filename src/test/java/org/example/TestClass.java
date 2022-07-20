package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class TestClass {
    WebDriver driver;

    @BeforeSuite
    public void testSetup() {
        driver = WebDriverManager.chromedriver().avoidShutdownHook().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeTest
    public void openBrowser() {
        driver.get("https://www.goibibo.com/flights/");
        System.out.println("We are currently on the following URL" + driver.getCurrentUrl());
    }

    @Test(description = "This method validates radio button functionality", priority = 2)
    public void TripSel() {
        driver.findElement(By.xpath("//span[contains (text(),'Round-trip')]")).click();
    }

    @Test(description = "This method validates flight  To and From location functionality", priority = 3)
    public void CityLoc() throws InterruptedException {
        driver.findElement(By.xpath("//p[contains (text(),'Enter city or airport')]")).click();
        driver.findElement(By.xpath("//span[contains (text(),'From')]/following-sibling::input")).sendKeys("Mumbai");
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//span[contains (text(),'From')]/following-sibling::input")).sendKeys(Keys.ENTER);
        List<WebElement> dest = driver.findElements(By.xpath("//li[@role='presentation']"));
        for (int i = 0; i < dest.size(); i++) {
            String res = dest.get(i).getText();
            if (res.contains("Mumbai")) {
                dest.get(i).click();
                System.out.println(res);
                break;
            }
        }

        driver.findElement(By.xpath("//span[contains (text(),'To')]/following-sibling::input")).sendKeys("Kerala");
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//span[contains (text(),'To')]/following-sibling::input")).sendKeys(Keys.ENTER);
        List<WebElement> retdest = driver.findElements(By.xpath("//li[@role='presentation']"));
        for (int i = 0; i < retdest.size(); i++) {
            String res = retdest.get(i).getText();
            if (res.contains("Kochi")) {
                retdest.get(i).click();
                System.out.println(res);
                break;
            }
        }
    }

    @Test(priority = 4)
    public void SetDepDate() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> DepDate = driver.findElements(By.xpath("//div[@class='DayPicker-Day']/p"));
        for (int i = 0; i < DepDate.size(); i++) {
            String Date = DepDate.get(i).getText();
            if (Date.equalsIgnoreCase("28")) {
                DepDate.get(i).click();
                break;
            }
        }
    }

    @Test(priority = 5)
    public void SetRetDate() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> RetDate = driver.findElements(By.xpath("//div[@class='DayPicker-Day']/p"));
        for (int i = 0; i < RetDate.size(); i++) {
            String Date = RetDate.get(i).getText();
            if (Date.equalsIgnoreCase("30")) {
                RetDate.get(i).click();
                break;
            }
        }
    }

    @Test(priority = 6)
    public void CalDoneBtn() {
        driver.findElement(By.xpath("//div[@class='sc-iNGGcK jnsUlO']/span[2]")).click();
    }

    @Test(priority = 7)
    public void SelTravelClass() {
        driver.findElement(By.xpath("//li[contains(text(),'business')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Done')]")).click();
    }

    @Test(priority = 8)
    public void SearchFlightsBtn() {
        driver.findElement(By.xpath("//span[contains(text(),'SEARCH FLIGHTS')]")).click();
    }

}


