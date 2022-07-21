package org.example;

import Utility.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FlightsPage extends BaseClass {

    public FlightsPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[contains (text(),'Round-trip')]")
    WebElement TripTypeRadioBtn;

    @FindBy(xpath = "//p[contains (text(),'Enter city or airport')]")
    WebElement EnterCityFld;

    @FindBy(xpath = "//span[contains (text(),'From')]/following-sibling::input")
    WebElement FromFld;

    @FindBy(xpath = "//span[contains (text(),'To')]/following-sibling::input")
    WebElement ToFld;

    @FindBy(xpath = "//li[@role='presentation']")
    List<WebElement> CityAutoSgtn;

    @FindBy(xpath = "//div[@class='DayPicker-Day']/p")
    List <WebElement> Caldate;

    @FindBy(xpath = "//div[@class='sc-iNGGcK jnsUlO']/span[2]")
    WebElement CalDoneBtn;

    @FindBy(xpath = "//li[contains(text(),'business')]")
    WebElement TravelClassChip;

    @FindBy(xpath = "//a[contains(text(),'Done')]")
    WebElement TravelClassDoneBtn;

    @FindBy(xpath = "//span[contains(text(),'SEARCH FLIGHTS')]")
    WebElement SearchBtn;

    public void ClkRadioBtn(){
        TripTypeRadioBtn.click();
    }

    public void EnterCity() throws InterruptedException {
        EnterCityFld.click();
        FromFld.sendKeys("Mumbai"); //from location
        Thread.sleep(2000);
        Location(CityAutoSgtn,"Mumbai");

        ToFld.sendKeys("Kerala");  //to location
        Thread.sleep(2000);
        Location(CityAutoSgtn,"Kochi");
    }

    public void EnterCheckinCalDate(){
        Calender(Caldate,"28");
    }

    public void EnterCheckoutCalDate(){
        Calender(Caldate,"30");
    }

    public void ClkCaldoneBtn(){
        CalDoneBtn.click();
    }

    public void SelectTravelClass(){
        TravelClassChip.click();
        TravelClassDoneBtn.click();
    }

    public void SearchFlights(){
        SearchBtn.click();
    }

}
