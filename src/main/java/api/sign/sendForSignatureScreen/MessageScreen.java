package api.sign.sendForSignatureScreen;

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
import api.drivers.Drivers;

public class MessageScreen {

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


    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/agreement_name\")")
    private MobileElement agreementNameField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/agreement_body\")")
    private MobileElement agreementBody;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/send_done_button\")")
    private MobileElement doneButtonOnMessagePage;


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

    public MessageScreen clickOnDone() {
        try {
            MyLogger.log.info("Clicking On Done Button on message page");
            gestures.clickOnMobileElement(doneButtonOnMessagePage);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click on Done button on message page");
        }
    }

}
