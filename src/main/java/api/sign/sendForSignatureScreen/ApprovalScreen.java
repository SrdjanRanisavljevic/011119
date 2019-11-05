package api.sign.sendForSignatureScreen;

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

import java.util.List;

public class ApprovalScreen {

    public ApprovalScreen () {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private final Waiters waiters = new Waiters();
    private final AssertsUtils assertsUtils = new AssertsUtils();
    private final Gestures gestures = new Gestures();
    private  final Swipe swipe = new Swipe();

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/btn_open_sign\")")
    private MobileElement approveButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"start\")")
    private MobileElement start;

    @AndroidFindBy(xpath = "//android.widget.Button[2]")
    private MobileElement tapToApprove;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Tap to Approve\")")
    private MobileElement tapToApproveOnGetSignatureInPersonFlow;

    @AndroidFindBy(xpath = "//hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.app.Dialog/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText")
    private MobileElement enterYourInformation;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.app.Dialog/android.view.View/android.view.View/android.widget.Button[3]")
    private MobileElement approveButtonOnEnterYourInformation;


    public ApprovalScreen approveAgreement() {
        try {
            waiters.waitForMobileElementToBeClickable(start);
            MyLogger.log.info("Clicking On Start button on Approval screen");
            gestures.clickOnMobileElement(start);
            MyLogger.log.info("Click on tapToApprove button");
            waiters.waitForMobileElementToBeClickable(tapToApprove);
            gestures.clickOnMobileElement(tapToApprove);

                new WaitingForYouScreen()
                        .waitingForWFYScrenToLoadAfterSigning()
                        .clickBackButton();

            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot tapToApprove agreement");
        }
    }


    public ApprovalScreen approveAgreementInPersonFlow() {
        try {
            waiters.waitForMobileElementToBeClickable(start);
            MyLogger.log.info("Clicking On Start button on Approval screen");
            gestures.clickOnMobileElement(start);
            MyLogger.log.info("Click on tapToApprove button");
            waiters.waitForMobileElementToBeClickable(tapToApprove);
            gestures.clickOnMobileElement(tapToApprove);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot tapToApprove agreement");
        }
    }

    public ApprovalScreen enterYourInformationInPersonFlow() {
        try {
            MyLogger.log.info("Entering the name on enter your information screen");
            waiters.waitForMobileElementToBeClickable(enterYourInformation);
            gestures.sendText(enterYourInformation, "Test123");
            waiters.waitForMobileElementToBeClickable(approveButtonOnEnterYourInformation);
            gestures.clickOnMobileElement(approveButtonOnEnterYourInformation);
            return this;
        }catch (Exception e) {
            throw new AssertionError("Cannot click on START button");
        }
    }
}
