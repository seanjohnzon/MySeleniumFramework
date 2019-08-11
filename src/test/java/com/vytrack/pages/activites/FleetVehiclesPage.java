package com.vytrack.pages.activites;

import com.vytrack.utilities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;

public class FleetVehiclesPage extends BasePage {

    @FindBy(xpath = "//span[starts-with (text(), \"License Plate\")]")
    public WebElement licensePlateTab;

    @FindBy(xpath = "//span[starts-with (text(), \"Driver\")]")
    public WebElement driverTab;

    @FindBy(xpath = "//button[@class= \"btn btn-default btn-small dropdown-toggle\"]/input")
    public WebElement checkBox;

    public String licensePlates = "//td[contains (@class, \"LicensePlate\")]";

    public String drivers = "//td[contains(@class, \"Driver\")]";

    public String checkBoxes = "//input[@data-role= \"select-row-cell\"]";

    public void navigatePage(){
        navigateToModule("Fleet", "Vehicles");
    }

    public boolean ascendingOrder(List<String> actual, List<String> expected, List<WebElement> list){
        int k = 0;

        for (int i = 0; i < list.size(); i++) {
            actual.add(list.get(k).getText());
            expected.add(list.get(k).getText());
            k++;
        }
        Collections.sort(expected);
        if(actual.equals(expected)) return true;
        else return false;
    }

    public boolean descendingAfterAscending(List<String> actual, List<String> expected, List<WebElement> list){
        int j = 0;

        for (int i = 0; i < list.size(); i++) {
            actual.add(list.get(j).getText());
            j++;
        }
        Collections.reverse(expected);
        if(actual.equals(expected)) return true;
        else return false;
    }
    public boolean checkBoxNotChecked(List<WebElement> list){
        for(int i=0;i<list.size();i++){
            if(list.get(i).isSelected()) return false;
            else continue;
        }
        return true;
    }
    public boolean checkBoxChecked(List<WebElement> list){
        for(int i=0;i<list.size();i++){
            if(!list.get(i).isSelected()) return false;
            else continue;
        }
        return true;
    }
}
