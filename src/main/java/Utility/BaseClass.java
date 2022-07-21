package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseClass {

    public static WebDriver driver;

    public static void Location(List<WebElement> dest,String DestinationPlace){
        //List<WebElement> dest = driver.findElements(By.xpath("//li[@role='presentation']"));
        for (int i = 0; i < dest.size(); i++) {
            String res = dest.get(i).getText();
            if (res.contains(DestinationPlace)) {
                dest.get(i).click();
                System.out.println(res);
                break;
            }
        }
    }

    public static void Calender(List<WebElement> Caldate,String date){
        //List<WebElement> DepDate = driver.findElements(By.xpath("//div[@class='DayPicker-Day']/p"));
        for (int i = 0; i < Caldate.size(); i++) {
            String Date = Caldate.get(i).getText();
            if (Date.equalsIgnoreCase(date)) {
                Caldate.get(i).click();
                break;
            }
        }
    }





}
