package org.example;

import Utility.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;
import java.time.Duration;


public class TestClass extends BaseClass {

    FlightsPage fp;

    @BeforeSuite
    public void testSetup() {
        driver = WebDriverManager.chromedriver().avoidShutdownHook().create();
        fp=new FlightsPage();
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
        fp.ClkRadioBtn();
    }

    @Test(description = "This method validates flight  To and From location functionality", priority = 3)
    public void CityLoc() throws InterruptedException {
        fp.EnterCity(); // 1st method by using list

        // 2nd method by using Keys class
        //driver.findElement(By.xpath("//span[contains (text(),'From')]/following-sibling::input")).sendKeys(Keys.ENTER);
        //driver.findElement(By.xpath("//span[contains (text(),'To')]/following-sibling::input")).sendKeys(Keys.ENTER);
    }

    @Test(priority = 4)
    public void SetDepDate() throws InterruptedException {
        Thread.sleep(1000);
        fp.EnterCheckinCalDate();
    }

    @Test(priority = 5)
    public void SetRetDate() throws InterruptedException {
        Thread.sleep(1000);
        fp.EnterCheckoutCalDate();
    }

    @Test(priority = 6)
    public void CalDoneBtn() {
        fp.ClkCaldoneBtn();
    }

    @Test(priority = 7)
    public void SelTravelClass() {
        fp.SelectTravelClass();
    }

    @Test(priority = 8)
    public void SearchFlightsBtn() {
        fp.SearchFlights();
    }

}


