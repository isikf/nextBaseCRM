package com.Bitrix24.tests.components;

import com.Bitrix24.pages.EmployeesPage;
import com.Bitrix24.pages.LoginPage;
import com.Bitrix24.tests.TestBase;
import com.Bitrix24.utilities.BrowserUtils;
import com.Bitrix24.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmployeesTest extends TestBase {

    @DataProvider
    public Object [][] employeeData(){
        ExcelUtil employeeList= new ExcelUtil("src/test/resources/Bitrix24_Employees.xlsx", "Employees");
        String[][] arrayWithoutFirstRow = employeeList.getDataArrayWithoutFirstRow();
        return arrayWithoutFirstRow;
    }

    @Test (dataProvider= "employeeData")
    public void verifyEmployeeEmail (String fullName, String emailAddress, String department){
        extentLogger=report.createTest("EmployeeTest" + fullName + " " + emailAddress);
        LoginPage loginPage = new LoginPage();
        EmployeesPage employeesPage= new EmployeesPage();

        loginPage.loginAsHR();
        extentLogger.info("user logs into the page");
        employeesPage.navigateToModule("Employees");
        extentLogger.info("user navigates to the Employees module");
        BrowserUtils.waitForPageToLoad(2);
        employeesPage.findEmployeeModule.click();
        extentLogger.info("user clicks on the Find Employee tab");
        BrowserUtils.waitForPageToLoad(2);

        System.out.println(fullName+ " " + emailAddress+ " " + department);

        String actualEMail= employeesPage.getEmailAddress(fullName);
        String expectedEmail= emailAddress;

        Assert.assertEquals(actualEMail, expectedEmail, "verify employees' email address");
        extentLogger.info("verify employees' email address");

        extentLogger.pass("user data validation passed");

    }




}
