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
    @Test(description = "Verify that all records that are displayed are sorted by LICENSE PLATE in Ascending and Descending order")
    public void verifyLicensePlateSort() {
        extentLogger = report.createTest("Verify that all records that are displayed are sorted by LICENSE PLATE in Ascending and Descending order");

        String username = ConfigurationReader.getProperty("salesmanagerusername");
        String password = ConfigurationReader.getProperty("salesmanagerpassword");

        pages.loginPage().login(username, password);

        pages.fleetActivitiesPage().navigatePage();

        pages.fleetActivitiesPage().waitUntilLoaderScreenDisappear();

        pages.fleetActivitiesPage().licensePlateTab.click();
        BrowserUtils.waitPlease(1);


        List<WebElement> LicensePlates = driver.findElements(By.xpath(pages.fleetActivitiesPage().licensePlates));

        BrowserUtils.waitPlease(1);

        List<String> actualResult = new ArrayList<>();
        List<String> expectedResult = new ArrayList<>();
        boolean check = pages.fleetActivitiesPage().ascendingOrder(actualResult, expectedResult, LicensePlates);

        Assert.assertTrue(check);
        extentLogger.pass("Verified that all records that are displayed are sorted by LICENSE PLATE in Ascending order");

        pages.fleetActivitiesPage().licensePlateTab.click();
        extentLogger.info("click on License Plate Tabs on the Table");
        BrowserUtils.waitPlease(2);

        List<WebElement> LicensePlates2 = driver.findElements(By.xpath(pages.fleetActivitiesPage().licensePlates));


        List<String> actualResult2 = new ArrayList<>();
        boolean check2 = pages.fleetActivitiesPage().descendingAfterAscending(actualResult2, expectedResult, LicensePlates2);

        Assert.assertTrue(check2);
        extentLogger.pass("Verified that all records that are displayed are sorted by LICENSE PLATE in Descending order");
    }
    @Test
    public void verifyDriverSort(){
        extentLogger = report.createTest("Verify that all records that are displayed are sorted by DRIVER in Ascending and Descending order");

        String username = ConfigurationReader.getProperty("salesmanagerusername");
        String password = ConfigurationReader.getProperty("salesmanagerpassword");

        pages.loginPage().login(username, password);

        pages.fleetActivitiesPage().navigatePage();

        pages.fleetActivitiesPage().waitUntilLoaderScreenDisappear();

        pages.fleetActivitiesPage().driverTab.click();
        extentLogger.info("click on Driver Tabs on the Table");
        BrowserUtils.waitPlease(1);


        List<WebElement> drivers = driver.findElements(By.xpath(pages.fleetActivitiesPage().drivers));

        BrowserUtils.waitPlease(1);

        List<String> actualResult = new ArrayList<>();
        List<String> expectedResult = new ArrayList<>();
        boolean check = pages.fleetActivitiesPage().ascendingOrder(actualResult, expectedResult, drivers);

        System.out.println(actualResult +"\n" +expectedResult);
        Assert.assertTrue(check);
        extentLogger.pass("Verified that all records that are displayed are sorted by DRIVER in Ascending order");

        pages.fleetActivitiesPage().driverTab.click();
        BrowserUtils.waitPlease(2);

        List<WebElement> drivers2 = driver.findElements(By.xpath(pages.fleetActivitiesPage().drivers));


        List<String> actualResult2 = new ArrayList<>();
        boolean check2 = pages.fleetActivitiesPage().descendingAfterAscending(actualResult2, expectedResult, drivers2);

        System.out.println(actualResult2 +"\n"+expectedResult);
        Assert.assertTrue(check2);
        extentLogger.pass("Verified that all records that are displayed are sorted by DRIVER in Descending order");
    }
    @Test(description = "Verify that none of the checkboxes on the left side of the table are selected")
    public void verifyCheckBox(){
        extentLogger = report.createTest("Verify that none of the checkboxes on the left side of the table are selected");

        String username = ConfigurationReader.getProperty("salesmanagerusername");
        String password = ConfigurationReader.getProperty("salesmanagerpassword");

        pages.loginPage().login(username, password);

        pages.fleetActivitiesPage().navigatePage();

        pages.fleetActivitiesPage().waitUntilLoaderScreenDisappear();

        List<WebElement> checkBoxes = driver.findElements(By.xpath(pages.fleetActivitiesPage().checkBoxes));

        boolean check = pages.fleetActivitiesPage().checkBoxNotChecked(checkBoxes);

        Assert.assertTrue(check);
        extentLogger.pass("Verified that none of the checkboxes on the left side of the table are selected");

        pages.fleetActivitiesPage().checkBox.click();
        extentLogger.info("Click on the CheckBox on the Headers Row");

        List<WebElement> checkBoxes2 = driver.findElements(By.xpath(pages.fleetActivitiesPage().checkBoxes));

        boolean check2 = pages.fleetActivitiesPage().checkBoxChecked(checkBoxes2);

        Assert.assertTrue(check2);
        extentLogger.pass("Verified that all of the checkboxes on the left side of the table are selected");

    }

}
