package com.entrata.pages;

import com.entrata.utilities.BasePage;
import org.openqa.selenium.WebDriver;

public class HomeBodyPage extends BasePage {

    private String homeBodyTitle = "//*[@class='section-hero spline']//h1[@class='heading-style_hero']";
    private String bookDemoButton = "//a[@class='btn-primary w-inline-block']";
    private String getDemoButton = "//button[@class='mktoButton']";
    private String firstNameToasterMessage = "//*[@id='ValidMsgFirstName']";

    public HomeBodyPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnBookDemoButton(){
        click(bookDemoButton);
    }

    public String getHomeBodyTitle(){
        return getText(homeBodyTitle);
    }

    public void clickOnGetDemoButton(){
        waitForElementVisibility(getDemoButton);
        scrollIntoView(getDemoButton);
        click(getDemoButton);
    }

    public String getFirstNameToasterMessage(){
        return getText(firstNameToasterMessage);
    }
}
