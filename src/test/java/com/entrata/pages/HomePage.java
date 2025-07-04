package com.entrata.pages;

import com.entrata.utilities.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private String breakingNewsText = "//*[@class='h2-link-text bar']";
    private String watchDemoButton = "//*[@class='button is-nav w-button' and text()='Watch demo']";
    private String resourcesDropdown = "//*[starts-with(@id,'w-dropdown-toggle-2')]";
    private String resourcesGuide = "//div[@class='dropdown_link-heading' and text()='Guides']";
    private String productDropdown = "//*[starts-with(@id,'w-dropdown-toggle-0')]";
    private String aiAndAutomationTab = "(//a[@data-w-tab='AI & Automation'])[1]";
    private String leasingAI = "//div[@class='dropdown_link-heading' and text()='Leasing AI']";
    private String guidesTab = "//a[@id='guides']";
    private String leasingAiTitle = "//h1[@id='product-banner-h1']/strong";
    private String sourcesDropdown = "//*[starts-with(@id,'w-dropdown-toggle-1')]";
    private String learnMoreLink = "//a[@class='dropdown_cta-component w-inline-block']";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getBreakingNewsText() {
        return getText(breakingNewsText);
    }

    public void clickOnWatchDemoButton(){
        click(watchDemoButton);
    }

    public void clickOnResourcesGuide(){
        mouseHoverAndClick(resourcesDropdown, resourcesGuide);
    }

    public void clickOnProductsAiAutomationAndLeasingAi(){
        mouseHoverAndClick(productDropdown, aiAndAutomationTab, leasingAI);
    }

    public boolean isUserOnResourcesGuidesTabPage(){
        boolean value = false;
        if(getAttributeValue(guidesTab, "aria-selected").equalsIgnoreCase("true")){
            value = true;
        }
        return value;
    }

    public String getLeasingAiTitle(){
        return getText(leasingAiTitle);
    }

    public void clickOnSourcesLearnMore(){
        mouseHoverAndClick(sourcesDropdown, learnMoreLink);
    }
}
