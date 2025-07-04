package com.entrata.pageobjectmanager;


import com.entrata.pages.HomeBodyPage;
import com.entrata.pages.HomePage;
import com.entrata.pages.WatchDemoPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private final WebDriver driver;
    private HomePage homePage;
    private WatchDemoPage watchDemoPage;
    private HomeBodyPage homeBodyPage;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public HomePage getHomePage(){
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public WatchDemoPage getWatchDemoPage(){
        return (watchDemoPage == null) ? watchDemoPage = new WatchDemoPage(driver) : watchDemoPage;
    }

    public HomeBodyPage getHomeBodyPage(){
        return (homeBodyPage == null) ? homeBodyPage = new HomeBodyPage(driver) : homeBodyPage;
    }
}
