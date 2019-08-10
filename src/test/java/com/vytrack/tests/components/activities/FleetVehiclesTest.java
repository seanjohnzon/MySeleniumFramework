package com.vytrack.tests.components.activities;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FleetVehiclesTest extends TestBase {
    @Test
    public void verifyDefaultAscendingOrder() {
        extentLogger = report.createTest("• Verify that all records that are displayed are sorted by LICENSE PLATE in Ascending order");

        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");

        pages.loginPage().login(username, password);

        pages.dashboardPage().navigateToModule("Fleet", "Vehicles");

        String licensexPath = "//span[starts-with (text(), \"License Plate\")]";

        BrowserUtils.waitPlease(2);

        driver.findElement(By.xpath(licensexPath)).click();
        BrowserUtils.waitPlease(1);


        List<WebElement> LicensePlates = driver.findElements(By.xpath("//td[contains (@class, \"LicensePlate\")]"));

        BrowserUtils.waitPlease(1);

        List<String> actualResult = new ArrayList<>();
        List<String> order = new ArrayList<>();
        int k = 0;

        for (int i = 0; i < LicensePlates.size(); i++) {
            actualResult.add(LicensePlates.get(k).getText());
            order.add(LicensePlates.get(k).getText());
            k++;
        }

        Collections.sort(order);

        System.out.println(order + "/n" + actualResult);

        Assert.assertEquals(order, actualResult);
        BrowserUtils.waitPlease(1);

        driver.findElement(By.xpath(licensexPath)).click();
        BrowserUtils.waitPlease(3);

        List<WebElement> LicensePlates2 = driver.findElements(By.xpath("//td[contains (@class, \"LicensePlate\")]"));


        List<String> actualResult2 = new ArrayList<>();
        int j = 0;

        for (int i = 0; i < LicensePlates2.size(); i++) {
            actualResult2.add(LicensePlates2.get(j).getText());
            j++;
        }

        Collections.reverse(order);

        Assert.assertEquals(actualResult2, order);
    }

}
