package pages.sign.getSignatureInPersonScreen;
import pages.drivers.Drivers;
import pages.sign.sendForSignatureScreen.PostSignScreen;
import pages.sign.sendForSignatureScreen.SendForSignatureScreen;
import core.classic.methods.AssertsUtils;
import core.classic.methods.Gestures;
import core.classic.methods.Waiters;
import core.watchers.MyLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;


public class GetSignatureInPersonScreen extends SendForSignatureScreen {

    public GetSignatureInPersonScreen() {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }






    private final String pleasePassString = "Please pass the device to the signer, %USER_EMAIL%";
    private final String byProceedingYouAfirmString = "By proceeding, you affirm that you are %USER_EMAIL% and are authorized to sign this agreement.";

    private final Waiters waiters = new Waiters();
    private final AssertsUtils assertsUtils = new AssertsUtils();
    private final Gestures gestures = new Gestures();



    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")")
    private MobileElement okOnSignatureInPerson;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View[4]")
    private MobileElement startOnSignatureInPerson;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"start\")")
    private MobileElement start;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/sign_now\")")
    private MobileElement sendButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/message\")")
    private MobileElement popUp;


    public GetSignatureInPersonScreen verifyPleasePassTheDeviceMessage(String signerEmail) {
        MyLogger.log.info("Verify Please pass the device message");
        waiters.waitForElementVisibilityMobileElement(popUp);
        String actualPleasePassString = popUp.getText();
        String expectedPleasePassString = pleasePassString.replace("%USER_EMAIL%", signerEmail);
        assert expectedPleasePassString.equals(actualPleasePassString) : "expected " + expectedPleasePassString + " but got instead " + actualPleasePassString;
        MyLogger.log.info("Please pass message is ok!");
        return this;
    }

    public GetSignatureInPersonScreen verifyByProceeedingMessageYouAfirm(String signerEmail) {
        MyLogger.log.info("Verify by proceeding, you afirm message");
        waiters.sleep(1000);
        waiters.waitForElementVisibilityMobileElement(popUp);
        String actualByProceedingYouAfirmMessage= popUp.getText();
        String expectedByProceedingYouAfirmMessage = byProceedingYouAfirmString.replace("%USER_EMAIL%", signerEmail);
        assert expectedByProceedingYouAfirmMessage.equals(actualByProceedingYouAfirmMessage) : "expected " + expectedByProceedingYouAfirmMessage + " but got instead " + actualByProceedingYouAfirmMessage;
        MyLogger.log.info("By proceeding, you afirm message is ok!");
        return this;
    }



    public GetSignatureInPersonScreen clickOnOKProceedOnDialog() {
        try {
            MyLogger.log.info("Clicking OK on please pass the device to the signer dialog");
            waiters.waitForMobileElementToBeClickable(okOnSignatureInPerson);
            gestures.clickOnMobileElement(okOnSignatureInPerson);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click on OK on please pass the device to the signer dialog");
        }
    }

    public GetSignatureInPersonScreen clickOnSendButtonOnGetSignatureInPerson() {
        try {
            MyLogger.log.info("Click on Send button on Get Signature in Person");
//            waiters.waitForMobileElementToBeClickable(sendButton);
            gestures.clickOnMobileElement(sendButton);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click on Send button on Get Signature in Person");
        }
    }












}
