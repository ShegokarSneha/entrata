package com.entrata.pages;

import com.entrata.utilities.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class WatchDemoPage extends BasePage {

    public WatchDemoPage(WebDriver driver) {
        super(driver);
    }

    private String firstName = "//input[@id='FirstName']";
    private String lastname = "//input[@id='LastName']";
    private String email = "//input[@id='Email']";
    private String companyName = "//input[@id='Company']";
    private String phoneNumber = "//input[@id='Phone']";
    private String totalUnitsDropdown = "//select[@id='Unit_Count__c']";
    private String jobTitle = "//input[@id='Title']";
    private String roleDropdown = "//select[@id='demoRequest']";
    private String watchDemoButton = "//button[text()='Watch Demo']";

    public void enterUserDetails(Map<String, String> data){
        enterInputValue(firstName, data.get("First Name"));
        enterInputValue(lastname, data.get("Last Name"));
        enterInputValue(email, data.get("Email"));
        enterInputValue(companyName, data.get("Company Name"));
        enterInputValue(phoneNumber, data.get("Phone Number"));
        enterInputValue(jobTitle, data.get("Job Title"));
        selectValueByVisibleText(totalUnitsDropdown, data.get("Total Managed Units"));
        selectValueByVisibleText(roleDropdown, data.get("Role"));
    }

    public boolean isWatchDemoButtonDisplayed(){
        return isElementDisplayed(watchDemoButton);
    }
}
