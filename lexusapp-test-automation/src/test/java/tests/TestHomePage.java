package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.UXPage;
import utilities.BaseTest;
import pages.HomePage;
import utilities.TestReport;
public class TestHomePage extends BaseTest {
    private HomePage homePage;
    private UXPage uxPage;

    @Test (priority=0)
    @Parameters("browser")
    public void testBanner() throws InterruptedException {
        homePage=new HomePage(driver);
        TestReport.startTest("Validation for Banner and Video Test","Chrome","Enoch Mahesh","Smoke test");
        homePage.goToHomePage();
        if (homePage.getAcceptAlert().isDisplayed()){
            homePage.getAcceptAlert().click();
            TestReport.logInfo("Accept Cookies alert clicked.");
        }
        else{
            Thread.sleep(1000);
        }
        TestReport.logInfo("Home Page loaded.");
        pause(1000);
        Assert.assertTrue((homePage.getBanner().isDisplayed()), "Banner is not displayed");
        Assert.assertEquals(
                homePage.getBanner().getText(),"ALL-NEW\n" +
                        "LEXUS LBX\n" +
                        "WORLD\n" +
                        "PREMIERE");
        TestReport.logPass("Verified displaying banner successfully.");
    }

    @Test (priority=1)
    public void testVideo() throws InterruptedException {
        homePage=new HomePage(driver);
        uxPage=new UXPage(driver);

        TestReport.logInfo("Scrolled down the page.");
        pause(2000);
        homePage.compactLuxury().click();
        uxPage.getVideo();
        Assert.assertTrue((uxPage.getVideo().isDisplayed()),"Video was not displayed.");

        //Playing video
        uxPage.getVideo().click();
       pause(4000);
        Assert.assertTrue((uxPage.closeIcon()).isDisplayed(),"Youtube video was not loaded.");
        TestReport.logPass("Verified displaying and playing video successfully.");
    }
}