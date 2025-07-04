package com.entrata.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void navigateTo(String url) {
        this.driver.get(url);
    }

    public void enterInputValue(String locator, String value) {
        WebElement webElement = driver.findElement(By.xpath(locator));
        webElement.clear();
        webElement.sendKeys(value);
    }

    public void click(String locator) {
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(locator)));
        webElement.click();
    }

    public String getText(String locator) {
        return driver.findElement(By.xpath(locator)).getText();
    }

    public void selectValueByVisibleText(String locator, String visibleText) {
        WebElement dropdown = driver.findElement(By.xpath(locator));  // find your <select>
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }

    public void mouseHoverAndClick(String locator, String subLocator) {
        Actions actions = new Actions(driver);
        WebElement mainMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(locator)));
        actions.moveToElement(mainMenu).perform();
        WebElement subMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(subLocator)));
        actions.moveToElement(subMenu).click().perform();
    }

    public void mouseHoverAndClick(String locator, String subLocator, String subLocator2) {
        Actions actions = new Actions(driver);
        WebElement mainMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(locator)));
        actions.moveToElement(mainMenu).perform();
        WebElement subMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(subLocator)));
        actions.moveToElement(subMenu).click().perform();
        WebElement subMenu2 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(subLocator2)));
        actions.moveToElement(subMenu2).click().perform();
    }

    public boolean isElementDisplayed(String locator) {
        return driver.findElement(By.xpath(locator)).isDisplayed();
    }

    public String getAttributeValue(String locator, String attribute) {
        return driver.findElement(By.xpath(locator)).getAttribute(attribute);
    }

    public void scrollIntoView(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForElementVisibility(String locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(locator)));
    }
}
