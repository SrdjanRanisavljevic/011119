package api.sign.waitingForOthersScreen;

import api.drivers.Drivers;
import api.sign.waitingForYouScreen.WaitingForYouScreen;
import core.classic.methods.AssertsUtils;
import core.classic.methods.Gestures;
import core.classic.methods.Swipe;
import core.classic.methods.Waiters;
import core.watchers.MyLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

public class WaitingForOthersScreen extends WaitingForYouScreen {


    public WaitingForOthersScreen() {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private final Waiters waiters = new Waiters();
    private final AssertsUtils assertsUtils = new AssertsUtils();
    private final Gestures gestures = new Gestures();
    private final Swipe swipe = new Swipe();

//    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
//    private MobileElement backButton;

    @AndroidFindBy(accessibility = "Navigate up")
    private MobileElement backButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/iv_overflow\")")
    private MobileElement moreButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/search_src_text\")")
    private MobileElement searchField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/history_menu\")")
    private MobileElement historyOnMoreMenu;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/sign_menu\")")
    private MobileElement signButtonInMoreMenu;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")")
    private List <MobileElement> okOnThisActionIsNotAvailable;





    public WaitingForOthersScreen clickOnSpecificUser(String user) {
        try {
            MyLogger.log.info("Click on user: " + user);
            AppiumDriver driver = Drivers.getMobileDriver();
            List<MobileElement> lista = (List<MobileElement>) driver.findElementsByXPath("//android.widget.TextView[@text='" + user + "']");
            boolean isPresent = lista.size() > 0;
            if (isPresent) {
                MobileElement selectSigner = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='" + user + "']");
                MyLogger.log.info("Click on signer to choose it from the list of the signers in paralel sign/approval workflow");
                waiters.waitForMobileElementToBeClickable(selectSigner);
                gestures.clickOnMobileElement(selectSigner);
                return this;
            }
            else {
               sleep(2000);
                clickOnSpecificUser(user);
            }return this;
        } catch (Exception e) {
            throw new AssertionError("Cannot click on specific user in paralel workflow");
        }
    }

    public WaitingForOthersScreen clickBackButton() {
        try {
            MyLogger.log.info("Clicking on back button on Waiting for others page");
            waiters.waitForMobileElementToBeClickable(backButton);
            gestures.clickOnMobileElement(backButton);
            return this;
        } catch (WebDriverException e) {
            throw new AssertionError("Cannot click on back on waiting for others page");
        }
    }


    public WaitingForOthersScreen verifyThatSignButtonIsNotPresent() throws FileNotFoundException {
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
                MyLogger.log.info("Waiting for sign/delegate/approve button");
                waiters.waitForMobileElementToBeClickable(signButtonInMoreMenu);
                sleep(5000);
                gestures.clickOnMobileElement(signButtonInMoreMenu);
                sleep(3000);
                List<MobileElement> okOnThisActionIsNotAvailable = (List<MobileElement>) driver.findElementsById("android:id/button1");
                boolean isOkPresent = okOnThisActionIsNotAvailable.size() > 0;
                if (isOkPresent) {
                    MyLogger.log.info("Host Signing / Approving / Delegation is NOT available, and this is how it should be!");
                    MyLogger.log.info("Click ok on This action is not available for this agreement");
                    waiters.waitForMobileElementToBeClickable(okOnThisActionIsNotAvailable.get(0));
                    gestures.clickOnMobileElement(okOnThisActionIsNotAvailable.get(0));
                    searchField.clear();
                    waitingForWFYScrenToLoadAfterSigning();
                    clickBackButton();
                } else {
                    throw new AssertionError("Host Signing/Approval/Delgation are available, and this should not be!");
                }
                return this;
            } else {
                MyLogger.log.info("No agreement present in waiting for me, RELOADING SCREEN!!!!");
                searchField.clear();
                sleep(3000);
                Swipe.customSwipeDown();
                sleep(10000);
                clickOnSearchbuttonAndEnterAgreementName();
                clickOnAgreementOnWaitingForYouPage();
                return this;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new AssertionError("Host sign/delegate/approve is enabled, and that should not be!");
        }
    }



}
