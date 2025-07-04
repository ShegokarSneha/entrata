package com.entrata.factory;


import com.entrata.configprovider.ConfigProvider;
import com.entrata.pageobjectmanager.PageObjectManager;
import com.entrata.utilities.LogMapper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public abstract class AbstractSteps {
    WebDriver driver;
    protected static PageObjectManager pageObjectManager;

    public void startDriver() {
        LogMapper.info("Browser Value : " + ConfigProvider.getAsString("browser"));
        if (ConfigProvider.getAsString("browser").equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (ConfigProvider.getAsString("browser").equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigProvider.getAsString("Implicit_Wait"))));
        driver.manage().window().maximize();
        pageObjectManager = new PageObjectManager(driver);
    }

    public void closeDriver(){
        if(driver != null){
            driver.quit();
        }
    }

    public WebDriver getDriver(){
        return driver;
    }
}
