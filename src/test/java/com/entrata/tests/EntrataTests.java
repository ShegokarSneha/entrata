package com.entrata.tests;

import com.entrata.configprovider.ConfigProvider;
import com.entrata.factory.AbstractSteps;
import com.entrata.reports.ExtentTestManager;
import com.entrata.reports.TestListeners;
import com.entrata.utilities.ExcelDataProvider;
import com.entrata.utilities.LogMapper;
import com.entrata.utilities.Screenshots;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Map;

import static org.testng.Assert.*;

@Listeners(TestListeners.class)
public class EntrataTests extends AbstractSteps {

    @BeforeTest
    public void setup() {
        startDriver();
        LogMapper.info("Application Url : " + ConfigProvider.getAsString("application_url"));
        getDriver().get(ConfigProvider.getAsString("application_url"));
    }

    /* Open Url and check breaking Title of Entrata.com
     */
    @Test
    public void applicationUrlOpenTest() {
        try {
            String breakingNews = pageObjectManager.getHomePage().getBreakingNewsText();
            Screenshots.addStepWithScreenshotInReport(getDriver(), "Home Page Breaking News: " + breakingNews);
            assertEquals(breakingNews, "BREAKING: Entrata Receives $200 Million Investment from Blackstone", "Breaking Title Matching");
        } catch (AssertionError e) {
            ExtentTestManager.getTest().fail(e);
            Assert.fail(e.getMessage());  // ensures TestNG failure is maintained :contentReference[oaicite:3]{index=3}
        }
    }

    /* Click on Watch Demo button and Enter details in form
     * for 2 users
     */
    @Test(dataProvider = "excelMapData")
    public void watchDemoTest(Map<String, String> data) {
        try {
            LogMapper.info("User Details Entered : " + data);
            getDriver().get(ConfigProvider.getAsString("application_url"));
            pageObjectManager.getHomePage().clickOnWatchDemoButton();
            assertTrue(pageObjectManager.getWatchDemoPage().isWatchDemoButtonDisplayed(), "Watch Demo Page Loaded successfully");
            pageObjectManager.getWatchDemoPage().enterUserDetails(data);
            Screenshots.addStepWithScreenshotInReport(getDriver(), "User Details Entered: " + data);
        } catch (AssertionError e) {
            ExtentTestManager.getTest().fail(e);
            Assert.fail(e.getMessage());  // ensures TestNG failure is maintained :contentReference[oaicite:3]{index=3}
        }
    }

    /* User Click on Resources menu and navigates
     * to Guides Tab
     * And Verify guides tab is selected
     */
    @Test
    public void navigateToResourcesGuidesTest() {
        try {
            LogMapper.info("User Navigated to Resources -> Guides");
            pageObjectManager.getHomePage().clickOnResourcesGuide();
            assertTrue(pageObjectManager.getHomePage().isUserOnResourcesGuidesTabPage(), "User Navigated to Resources -> Guides");
            Screenshots.addStepWithScreenshotInReport(getDriver(), "User Navigated to Resources -> Guides");
        } catch (AssertionError e) {
            ExtentTestManager.getTest().fail(e);
            Assert.fail(e.getMessage());  // ensures TestNG failure is maintained :contentReference[oaicite:3]{index=3}
        }
    }

    /* User Click on Products menu and AI & Automation Sub menu and then
     * navigates to Leasing AI
     * And Verify Title
     */
    @Test
    public void navigateToProductsAndAiAutomationLeasingAiTest() {
        try {
            LogMapper.info("User Navigated to Products -> AI & Automation -> Leasing AI");
            pageObjectManager.getHomePage().clickOnProductsAiAutomationAndLeasingAi();
            assertEquals(pageObjectManager.getHomePage().getLeasingAiTitle(), "Leasing AI", "User Navigated to Products -> AI & Automation -> Leasing AI");
            Screenshots.addStepWithScreenshotInReport(getDriver(), "User Navigated to Products -> AI & Automation -> Leasing AI");
        } catch (AssertionError e) {
            ExtentTestManager.getTest().fail(e);
            Assert.fail(e.getMessage());  // ensures TestNG failure is maintained :contentReference[oaicite:3]{index=3}
        }
    }

    /* User Click on Sources menu and Learn More menu and then
     * Click on Book a Demo
     * And without entering details click on Get a Demo and Verify toaster message
     */
    @Test
    public void navigateToSourcesLearnMoreLinkTest() {
        try {
            LogMapper.info("User Navigated to Sources -> Learn More -> Verifying toaster message");
            pageObjectManager.getHomePage().clickOnSourcesLearnMore();
            assertEquals(pageObjectManager.getHomeBodyPage().getHomeBodyTitle(), "Hello, Homebody", "User Navigated to Sources -> HomeBody");
            Screenshots.addStepWithScreenshotInReport(getDriver(), "User Navigated to Sources -> HomeBody");
            pageObjectManager.getHomeBodyPage().clickOnBookDemoButton();
            pageObjectManager.getHomeBodyPage().clickOnGetDemoButton();
            assertEquals(pageObjectManager.getHomeBodyPage().getFirstNameToasterMessage(), "This field is required.", "Error Message is show for First Name mandatory field.");
            Screenshots.addStepWithScreenshotInReport(getDriver(), "Error Message is show for First Name mandatory field.");
        } catch (AssertionError e) {
            ExtentTestManager.getTest().fail(e);
            Assert.fail(e.getMessage());  // ensures TestNG failure is maintained :contentReference[oaicite:3]{index=3}
        }
    }

    @AfterTest
    public void tearDown() {
        closeDriver();
    }

    @DataProvider(name = "excelMapData")
    public Object[][] excelMapData() {
        return ExcelDataProvider.getDataAsMap(
                "src/test/resources/data/TestData.xlsx",
                "Sheet1",
                0 // Header row index
        );
    }
}
