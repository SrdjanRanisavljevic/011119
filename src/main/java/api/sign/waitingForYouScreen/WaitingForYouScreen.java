package api.sign.waitingForYouScreen;

import api.sign.sendForSignatureScreen.RecursionLimiter;
import com.jcraft.jsch.Session;
import core.classic.methods.AssertsUtils;
import core.classic.methods.Gestures;
import core.classic.methods.Swipe;
import core.classic.methods.Waiters;
import core.watchers.MyLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.support.PageFactory;
import api.drivers.Drivers;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.*;

public class WaitingForYouScreen {

    public WaitingForYouScreen() {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private final Waiters waiters = new Waiters();
    private final AssertsUtils assertsUtils = new AssertsUtils();
    private final Gestures gestures = new Gestures();
    private final Swipe swipe = new Swipe();

    public static String agreementName = null;


    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/lv_agreements\")")
    private MobileElement agreementsScreen;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/bubble_layout\")")
    private MobileElement tapToRevealQuickActions;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/bubble_layout\")")
    private MobileElement bubbleLayout;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ListView/android.widget.LinearLayout")
    private List<MobileElement> agreementSections;

    @AndroidFindBy(accessibility = "Navigate up")
    private MobileElement backButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/search\")")
    private MobileElement search;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/lv_agreements\")")
    private MobileElement emptyAgreementsScreen;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"No Documents\")")
    private MobileElement noDocuments;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/search_src_text\")")
    private MobileElement searchField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/iv_overflow\")")
    private MobileElement moreButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/sign_menu\")")
    private MobileElement signButtonInMoreMenu;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/home_overflow_menu\")")
    private MobileElement moreButtonDropDown;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/history_menu\")")
    private MobileElement historyOnMoreMenu;




    // Finding "NO DOCUMENTS" on WFY page does not fail the test. It is posible scenario, in case user had only this agreement on Waiting for you screen
    public WaitingForYouScreen waitingForWFYScrenToLoadAfterSigning() throws TimeoutException {
        sleep(5000);
        waiters.waitForElementVisibilityMobileElement(search);
        waiters.waitForMobileElementToBeClickable(search);
        waiters.waitForElementVisibilityMobileElement(emptyAgreementsScreen);
        boolean isElementVisible = false;
        MyLogger.log.info("Waiting for visibility of Agreement sections after signing the agreement");
        long delta;
        long end = System.currentTimeMillis() + 600000;
        while (!isElementVisible) {
            delta = end - System.currentTimeMillis();
            if (delta <= 0) {
                throw new TimeoutException("None of agreement sections have appeared in 10 minutes...");
            }
            if (new AssertsUtils().isElementVisible(noDocuments)) {
                MyLogger.log.info("No documents on Waiting for you screen after signing/approving/acknowledge...");
                break;
            }
            for (int i = 0; i < agreementSections.size(); i++) {
                if (new AssertsUtils().isElementVisible(agreementSections.get(i))) {
                    MyLogger.log.info("Agreement Section found!");
                    isElementVisible = true;
                    break;
                }
            }
        }
        return this;
    }


    // Finding "NO DOCUMENTS" on WFY page in this method throws assertion error and fails the test
    public WaitingForYouScreen waitingForAgreementsToLoadAfterClickOnWFYButtonOnHomeScreen() throws TimeoutException {
        MyLogger.log.info("Verifying elements on Waiting For you page, waiting to load");
        sleep(5000);
        waiters.waitForElementVisibilityMobileElement(search);
        waiters.waitForMobileElementToBeClickable(search);
        waiters.waitForElementVisibilityMobileElement(emptyAgreementsScreen);
        boolean isElementVisible = false;
        MyLogger.log.info("Waiting for visibility of Agreement sections");
        long delta;
        long end = System.currentTimeMillis() + 600000;
        while (!isElementVisible) {
            delta = end - System.currentTimeMillis();
            if (delta <= 0) {
                throw new TimeoutException("None of agreement sections have appeared in 10 minutes...");
            }
            if (new AssertsUtils().isElementVisible(noDocuments)) {
                throw new AssertionError("No documents in Waiting for you");
            }
            if (new AssertsUtils().isElementVisible(tapToRevealQuickActions)) {
                dismisTapToRevealQuickActions();
            }
            for (int i = 0; i < agreementSections.size(); i++) {

                if (new AssertsUtils().isElementVisible(agreementSections.get(i))) {
                    isElementVisible = true;
                    MyLogger.log.info("Agreement Section found!");
                    break;
                }
            }
        }
        return this;
    }


    public WaitingForYouScreen clickBackButton() {
        try {
            MyLogger.log.info("Clicking on back button on Waiting for you page");
            waiters.waitForMobileElementToBeClickable(backButton);
            gestures.clickOnMobileElement(backButton);
            return this;
        } catch (WebDriverException e) {
            throw new AssertionError("Cannot click on back on waiting for you page");
        }
    }


    public WaitingForYouScreen clickOnSearchbuttonAndEnterAgreementName() {
        try {
            MyLogger.log.info("Click on search button and enter agreement name " + agreementName);
            waiters.waitForMobileElementToBeClickable(search);
            gestures.clickOnMobileElement(search);
            gestures.sendText(searchField, agreementName);
            return this;
        } catch (Exception e) {
            throw new AssertionError("Cannot type the agreement name in search field on WFY screen");
        }
    }


    public WaitingForYouScreen clickOnAgreementOnWaitingForYouPage() throws FileNotFoundException {
//        RecursionLimiter.emerge();
        try {
            MyLogger.log.info("Trying to find the document;");
            AppiumDriver driver = Drivers.getMobileDriver();
            List<MobileElement> lista = (List<MobileElement>) driver.findElementsByXPath("//android.widget.TextView[@text='" + agreementName + "']");
            boolean isPresent = lista.size() > 0;
            if (isPresent) {
                MobileElement agreement = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='" + agreementName + "']");
                MyLogger.log.info("Click on more button on waiting for you screen");
                waiters.waitForMobileElementToBeClickable(moreButton);
                gestures.clickOnMobileElement(moreButton);
                MyLogger.log.info("Click on sign button on more menu on waiting for you screen");
                waiters.waitForMobileElementToBeClickable(signButtonInMoreMenu);
                sleep(2000);
                gestures.clickOnMobileElement(signButtonInMoreMenu);
                return this;
            } else {
                MyLogger.log.info("No agreement present in waiting for me, RELOADING SCREEN!!!!");
                searchField.clear();
                sleep(4000);
                Swipe.customSwipeDown();
                sleep(10000);
                clickOnSearchbuttonAndEnterAgreementName();
                clickOnAgreementOnWaitingForYouPage();
                return this;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new AssertionError("Cannot click on agreement on waiting page, probably not located");
        }
    }

    public void sleep(int time) {
        try {
            MyLogger.log.info("Sleeping now for " + time/1000 + " seconds because there is no better solution");
            Thread.sleep(time);
        } catch (InterruptedException e) {
            MyLogger.log.debug("Cannot Sleep");
        }
    }

    public WaitingForYouScreen dismisTapToRevealQuickActions() {
        try {
            MyLogger.log.info("Dismiss Tap to Reveal Quick Actions Bubble");
            AppiumDriver driver = Drivers.getMobileDriver();
            Actions action = new Actions(driver);
            waiters.waitForElementVisibilityMobileElement(tapToRevealQuickActions);
            action.moveToElement(tapToRevealQuickActions);
            action.contextClick();
            action.perform();
            return this;
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Cannot dismiss Tap to Reveal Quick Actions Bubble");
        }
    }

    public WaitingForYouScreen dismissMoreButtonDropDown() {
        try {
            MyLogger.log.info("Dismiss More Button Drop Down");
            AppiumDriver driver = Drivers.getMobileDriver();
            waiters.waitForElementVisibilityMobileElement(historyOnMoreMenu);
            sleep(1000);
            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ESCAPE));
            return this;
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Cannot dismiss More Button Drop Down");
        }
    }



}












