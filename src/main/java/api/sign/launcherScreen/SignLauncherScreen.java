package api.sign.launcherScreen;

import api.drivers.Drivers;
import core.classic.methods.AssertsUtils;
import core.classic.methods.Gestures;
import core.classic.methods.Swipe;
import core.classic.methods.Waiters;
import core.watchers.MyLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;


public class SignLauncherScreen {

    public SignLauncherScreen() {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private final Waiters waiters = new Waiters();
    private final AssertsUtils assertsUtils = new AssertsUtils();
    private final Gestures gestures = new Gestures();
    private  final Swipe swipe = new Swipe();

    /**
     * LAUNCHER VIEW ELEMENTS
     */



    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/sign_fte_page_content_image\")")
    private MobileElement launcherScreen1;


    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/sign_fte_page_sign_in_button\")")
    private MobileElement login;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Your mobile companion\")")
    private MobileElement yourMobileCompanion;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Manage documents\")")
    private MobileElement menageDocuments;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Scan to PDF\")")
    private MobileElement scanToPDF;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Sign on the go\")")
    private MobileElement signOnTheGo;



    //    public SignLauncherScreen validateElementsLauncherScreem() {
//        try {
//            MyLogger.log.info("Validating elements from Launcher Screen");
//            waiters.waitForElementVisibility(createAcc);
//            assertsUtils.isElementDisplayed(createAcc);
//            assertsUtils.isElementDisplayed(login);
//            assertsUtils.isElementEnabled(logo);
//            return this;
//        } catch (WebDriverException e) {
//            throw new AssertionError("Cannot validate elements from Launcher Screen");
//        }
//    }

    public SignLauncherScreen swipeLeftThreeTimes() {
        try {
            MyLogger.log.info("Swyping three times to get the screen with login button");
            for (int i = 0; i <= 2; i++) {

             swipe.swipeLeftElementMobile(launcherScreen1);
            }
            return new SignLauncherScreen();
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot swipe left damn it!");
        }
    }

    public SignLauncherScreen clickRightArrowButtonToGetToSignInButton() {
        try{
            AppiumDriver driver = Drivers.getMobileDriver();
            MyLogger.log.info("Click right arrow button 3 times to get to Sign In button");
                 Thread.sleep(2000);
///                waiters.waitForElementVisibilityMobileElement(yourMobileCompanion);
                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));
                ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));
                waiters.waitForElementVisibilityMobileElement(menageDocuments);
               ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));
                waiters.waitForElementVisibilityMobileElement(scanToPDF);
               ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_RIGHT));
                waiters.waitForElementVisibilityMobileElement(signOnTheGo);
            return this;
        } catch (Exception e){
            throw new AssertionError("Cannot click on righ arrow button for 3 times");
        }
    }


    public SignLauncherScreen SwipeLeftThreeTimesS10() {
        try {
            MyLogger.log.info("Swyping four times to get the screen with login button");
            for (int i = 0; i <= 2; i++) {
                swipe.swipeLeftElementMobile(launcherScreen1);
            }
            return new SignLauncherScreen();
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot swipe left s10 damn it!");
        }
    }

    public SignLauncherScreen clickOnLoginButton() {
        try {
            MyLogger.log.info("Clicking on Login button on launcherScreen screen");
            gestures.clickOnMobileElement(login);
            return new SignLauncherScreen();
        } catch (WebDriverException e) {
            throw new AssertionError("Cannot click on Login button from Sign Launcher screen");
        }
    }
//
//    public SignLauncherScreen clickOnDontAllowNotificationBtn() {
//        try {
//            MyLogger.log.info("Check if Send Notification Pop-Up is displayed");
//            try {
//                if (SignMobileApp.isEnabled()) {
//                    MyLogger.log.info("Send Notification Pop-Up is displayed?: " + SignMobileApp.isDisplayed());
//                    Drivers.getMobileDriver().switchTo().alert().dismiss();
//                    MyLogger.log.info("Send Notification Pop-Up was dismissed");
//                }
//            } catch (WebDriverException e) {
//                MyLogger.log.info("Send Notification Pop-Up is not displayed and we should validate elements from Launcher View");
//            }
//        } catch (WebDriverException e) {
//            throw new AssertionError("Cannot check if Send Notification Pop-Up is displayed");
//        }
//        return this;
//    }

}


