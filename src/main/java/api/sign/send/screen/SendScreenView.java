package api.sign.send.screen;

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
import api.drivers.Drivers;

public class SendScreenView {


    public SendScreenView() {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private final Waiters waiters = new Waiters();
    private final AssertsUtils assertsUtils = new AssertsUtils();
    private final Gestures gestures = new Gestures();
    private  final Swipe swipe = new Swipe();

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/send_document_card\")")
    private MobileElement documents;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/send_recipients_card\")")
    private MobileElement recipients;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/send_message_card\")")
    private MobileElement message;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/send_options_card\")")
    private MobileElement options;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/send_agreement\")")
    private MobileElement sendAgreementButton;


    public SendScreenView clickOnDocumentsButton() {
        try {
            MyLogger.log.info("Clicking on documents button");
            gestures.clickOnMobileElement(documents);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click on documents button");
        }
    }

    public SendScreenView clickOnRecipientsButton() {
        try {
            MyLogger.log.info("Clicking on recipients button");
            gestures.clickOnMobileElement(recipients);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click on recipients button");
        }
    }

    public SendScreenView clickOnMessageButton() {
        try {
            MyLogger.log.info("Clicking on message button");
            gestures.clickOnMobileElement(message);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click on message button");
        }
    }

    public SendScreenView clickOnSendAgreementButton() {
        try {
            MyLogger.log.info("Clicking on send agreement button");
            gestures.clickOnMobileElement(sendAgreementButton);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Clicking on send agreement button");
        }
    }


}
