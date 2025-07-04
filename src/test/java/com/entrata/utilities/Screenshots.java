package com.entrata.utilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.entrata.reports.ExtentTestManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshots {
    private Screenshots() {
    }

    static {
        createDirectory();
    }
    private static String screenshotsFolderPath;

    private static void createDirectory() {
        screenshotsFolderPath = "AutomationReports/screenshots/";
        File file = new File(screenshotsFolderPath);
        if (!file.exists() && !file.mkdir()) {
            System.out.println("Failed Creation");
        }
    }

    public static void addStepWithScreenshotInReport(WebDriver driver, String message) {
        ExtentTest extentTest = ExtentTestManager.getTest();
        if (extentTest != null) {
            if (driver != null) {
                String path = captureScreenshot(driver, "screenshot");
                try {
                    extentTest.pass(message, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                extentTest.pass(message);
            }
        }
    }

    public static void addStepInReport(boolean condition, String message){
        ExtentTest extentTest = ExtentTestManager.getTest();
        if(extentTest != null){
            if(condition){
                extentTest.pass(message);
            }else{
                extentTest.fail(message);
            }
        }
    }
    private static String captureScreenshot(WebDriver driver, String screenshot) {
        String randomNumber = RandomStringUtils.randomNumeric(5);
        String destinationPath = screenshotsFolderPath + screenshot + randomNumber + ".png";
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(destinationPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return destinationPath.substring(destinationPath.indexOf("/") + 1);
    }
}
