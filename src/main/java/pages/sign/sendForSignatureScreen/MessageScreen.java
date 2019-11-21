package pages.sign.sendForSignatureScreen;

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
import pages.drivers.Drivers;

public class MessageScreen extends SignScreen {

    public MessageScreen() {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public static String agreementName = null;
    public static String agreementMessage = null;
    private final Waiters waiters = new Waiters();
    private final AssertsUtils assertsUtils = new AssertsUtils();
    private final Gestures gestures = new Gestures();
    private  final Swipe swipe = new Swipe();
    private String agreementNamePlaceHolder = "Required";
    private String messagePlaceHolder = "Please review and sign this document.";


    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/agreement_name\")")
    private MobileElement agreementNameField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/agreement_body\")")
    private MobileElement agreementBody;



    public MessageScreen enterAgreementName() {
        try {
            MyLogger.log.info("Entering Agreement Name");
            gestures.clickOnMobileElement(agreementNameField);
            gestures.sendText(agreementNameField, agreementName);
            AppiumDriver driver = Drivers.getMobileDriver();
            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot enter Agreement Name");
        }
    }

    public MessageScreen enterAgreementMessage() {
        try {
            MyLogger.log.info("Entering Agreement Message");
            gestures.clickOnMobileElement(agreementBody);
            gestures.sendText(agreementBody, agreementMessage);
            AppiumDriver driver = Drivers.getMobileDriver();
            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot enter Agreement Message");
        }
    }

    public String getAgreementNameActualPlaceHolder() {
        return agreementNameField.getText();
    }

    public String getMessageActualPlaceHolder() {
        return agreementBody.getText();
    }

    public MessageScreen verifyMessageScreenPlaceHolders() {
        MyLogger.log.info("Verifying Message screen placeholders");
        try {
            assert agreementNamePlaceHolder.equals(getAgreementNameActualPlaceHolder()) : "expected " + agreementNamePlaceHolder + " but got instead " + getAgreementNameActualPlaceHolder();
            assert messagePlaceHolder.equals(getMessageActualPlaceHolder()) : "expected " + messagePlaceHolder + " but got instead " + getMessageActualPlaceHolder();
            MyLogger.log.info("Message page Agreement Name and Message placeholders are OK!");
            clickDone();
            return this;
        }catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Agreement name and message are not written well in message section");
        }
    }



}
