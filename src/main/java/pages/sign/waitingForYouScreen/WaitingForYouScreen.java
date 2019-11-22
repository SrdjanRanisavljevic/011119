package pages.sign.waitingForYouScreen;

import core.classic.methods.AssertsUtils;
import core.classic.methods.Gestures;
import core.classic.methods.Swipe;
import core.classic.methods.Waiters;
import core.watchers.MyLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.bridj.cpp.std.list;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import pages.drivers.Drivers;
import pages.sign.completedScreen.CompletedScreen;
import pages.sign.homeScreen.HomeScreen;
import pages.sign.sendForSignatureScreen.RecursionLimiter;

import java.io.FileNotFoundException;
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

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/agreement_list_section_header\")")
    private MobileElement sectionHeader;


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

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/agreementName\")")
    private MobileElement agreementNameContainer;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"To Delegate\")")
    private MobileElement toDelegateSection;


    // Finding "NO DOCUMENTS" on WFY page does not fail the test. It is posible scenario, in case user had only this agreement on Waiting for you screen
    public WaitingForYouScreen waitingForWFYScrenToLoadAfterSigning() throws TimeoutException {
        waiters.sleep(5000);
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
        waiters.sleep(5000);
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
            int counter = 0;
            while(!new AssertsUtils().isElementVisible(new HomeScreen().getCompleted()) && counter < 5) {
                waiters.waitForMobileElementToBeClickable(backButton);
                gestures.clickOnMobileElement(backButton);
                waiters.sleep(500);
                counter++;
            } return this;
        } catch (WebDriverException e) {
            e.printStackTrace();
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

    static int rnum = 5;

    public WaitingForYouScreen clickOnAgreementOnWaitingForYouPage() throws FileNotFoundException {
//        if (rnum < 0)
//            throw new AssertionError("MAXIMUM DEPT");
//        rnum--;
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
                waiters.sleep(2000);
                gestures.clickOnMobileElement(signButtonInMoreMenu);
                return this;
            } else {
                MyLogger.log.info("No agreement present in waiting for me, RELOADING SCREEN!!!!");
                searchField.clear();
                waiters.sleep(4000);
                Swipe.customSwipeDown();
                waiters.sleep(10000);
                clickOnSearchbuttonAndEnterAgreementName();
                clickOnAgreementOnWaitingForYouPage();
                return this;
            }
        } catch (AssertionError e) {
            e.printStackTrace();
            System.out.println("Maximum number of method calls reached");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new AssertionError("Cannot click on agreement on waiting page, probably not located");
        }
        return null;
    }

    public WaitingForYouScreen verifyThatAgreementIsInCurrentSection() throws FileNotFoundException {
//         RecursionLimiter.emerge();
        try {
            MyLogger.log.info("Trying to find the document;");
            AppiumDriver driver = Drivers.getMobileDriver();
            List<MobileElement> listAgr = (List<MobileElement>) driver.findElementsByXPath("//android.widget.TextView[@text='" + agreementName + "']");
            boolean isPresent = listAgr.size() > 0;
            if (isPresent) {
                MobileElement agreement = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='" + agreementName + "']");
                MyLogger.log.info("AGREEMENT FOUND!!!");
                return this;
            } else {
                MyLogger.log.info("No agreement present on current screen, RELOADING SCREEN!!!!");
                searchField.clear();
                waiters.sleep(4000);
                Swipe.customSwipeDown();
                waiters.sleep(10000);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    MyLogger.log.debug("Cannot Sleep");
                }
                clickOnSearchbuttonAndEnterAgreementName();
                verifyThatAgreementIsInCurrentSection();

                return this;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new AssertionError("CANNOT FIND THE AGREEMENT ON CURRENT SCREEN EVEN AFTER SEVERAL RELOADS");
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
            waiters.sleep(1000);
            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ESCAPE));
            return this;
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Cannot dismiss More Button Drop Down");
        }
    }

    public WaitingForYouScreen verifyThatDocumentIsUnderWantedSection(String section) {
         MyLogger.log.info("Verifying that document is under " + section);
        try {
            waitingForAgreementsToLoadAfterClickOnWFYButtonOnHomeScreen();
            waiters.sleep(2000);
            Swipe.customSwipeDown();
            waitingForWFYScrenToLoadAfterSigning();
            clickOnSearchbuttonAndEnterAgreementName();
            AppiumDriver driver = Drivers.getMobileDriver();
            MobileElement agreement = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='" + agreementName + "']");
            boolean isAgreementVisible = new AssertsUtils().isElementVisible(agreement);

            List<MobileElement> container = driver.findElements(MobileBy.xpath("//android.widget.ListView/*"));
            String sectionHeaderString = section + " (1)";

            if (sectionHeader.getText().equals(sectionHeaderString) && agreementNameContainer.getText().equals(agreementName) && container.size()==2 ) {
                MyLogger.log.info("Agreement is under " + section + " section!");
                waiters.waitForMobileElementToBeClickable(searchField);
                searchField.clear();
                waiters.sleep(3000);
                clickBackButton();
            } else {
                throw new AssertionError("Agreement is not under " + section);

            }
            return this;
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Cannot verify that document is under " + section);
        }
    }


    public WaitingForYouScreen verifyThatDocumentIsNOTInCurrentScreen(String screen) {

        try {
            MyLogger.log.info("Verify that document is NOT under " + screen);
            waitingForWFYScrenToLoadAfterSigning();
            waiters.sleep(2000);
            Swipe.customSwipeDown();
            waitingForWFYScrenToLoadAfterSigning();
            clickOnSearchbuttonAndEnterAgreementName();
            AppiumDriver driver = Drivers.getMobileDriver();
            List<MobileElement> listAgr = (List<MobileElement>) driver.findElementsByXPath("//android.widget.TextView[@text='" + agreementName + "']");

            if (listAgr.size() == 0) {
                MyLogger.log.info("Agreement is NOT under the " + screen + " screen, and this is how it should be!");
                waiters.waitForMobileElementToBeClickable(searchField);
                searchField.clear();
                waiters.sleep(3000);
                clickBackButton();
                return this;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Cannot verify that agreement is not under " + screen + " screen");
        } return this;

    }
}












