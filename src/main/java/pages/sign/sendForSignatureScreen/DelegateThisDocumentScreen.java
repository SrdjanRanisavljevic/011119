package pages.sign.sendForSignatureScreen;

import pages.drivers.Drivers;
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

import java.io.FileNotFoundException;

import static core.json.parsers.ConfigJasonFileReading.getAndroidJasonResults;

public class DelegateThisDocumentScreen {

    public DelegateThisDocumentScreen () {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    private final Waiters waiters = new Waiters();
    private final AssertsUtils assertsUtils = new AssertsUtils();
    private final Gestures gestures = new Gestures();
    private  final Swipe swipe = new Swipe();

    public static String delegateeMessage = null;

    private final String toSendThisDocumentToAnotherIndividualExpected = "To send this document to another individual for signature, enter their email address and a message below.";


    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"delegatee-email\")")
    private MobileElement delegateeEmailField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"delegatee-message\")")
    private MobileElement delegateeMessageField;

    @AndroidFindBy(xpath = "//android.widget.Button[3]")
    private MobileElement delegateButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textMatches(\"Delegate\")")
    private MobileElement delegateButtonTablet;

    @AndroidFindBy(xpath = "//android.view.View[1]")
    private MobileElement sendThisDocumentToAnotherIndividual;



    // This method should be replaced by Assertation method that checks if all elements of this screen are present


    public DelegateThisDocumentScreen enterDelegateeMail (String delegateMail) {
        try {
            MyLogger.log.info("Entering Delegatee mail on Delegate This Document Page\"");
            waiters.waitForMobileElementToBeClickable(delegateeEmailField);
            gestures.sendText(delegateeEmailField, delegateMail);
            AppiumDriver driver = Drivers.getMobileDriver();
            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot enter Delgatee mail on Delegate This Document Page");
        }
    }

    public DelegateThisDocumentScreen enterDelegateeMessage () {
        try {
            MyLogger.log.info("Entering Delegatee message");
            waiters.waitForMobileElementToBeClickable(delegateeMessageField);
            gestures.sendText(delegateeMessageField, delegateeMessage);
            AppiumDriver driver = Drivers.getMobileDriver();
//            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot enter Delgatee message on Delegate This Document Page");
        }
    }

    public DelegateThisDocumentScreen clickOnDelegateButton() throws FileNotFoundException {
        try {
            if (((getAndroidJasonResults().getDeviceID()).equals("3204db2bb5fe7121"))) {
                MyLogger.log.info("Click on delegate button on DelegateThisDocumentPage using Samsung Tablet");
                waiters.waitForMobileElementToBeClickable(delegateButton);
                gestures.clickOnMobileElement(delegateButton);
                return this;
            } else {
                MyLogger.log.info("Clicking On delegate button on DelegateThisDocumentPage");
                waiters.waitForMobileElementToBeClickable(delegateButton);
                gestures.clickOnMobileElement(delegateButton);
                return this;
            }
        }catch(WebDriverException e){
                e.printStackTrace();
                throw new AssertionError("Cannot click on delegate button on Delegate This Document Page");
            }
    }

    public DelegateThisDocumentScreen verifyTextOnDelegateThisDocumentWebView() {
        MyLogger.log.info("Verifying text on delegate this document web view");
            waiters.waitForElementVisibilityMobileElement(sendThisDocumentToAnotherIndividual);
            String toSendThisDocumentToAnotherIndividualActual = sendThisDocumentToAnotherIndividual.getText();
            assert toSendThisDocumentToAnotherIndividualExpected.equals(toSendThisDocumentToAnotherIndividualActual) : "Expected " + toSendThisDocumentToAnotherIndividualExpected + " but got instead " + toSendThisDocumentToAnotherIndividualActual;
            MyLogger.log.info("Text on delegate this document is ok!");
            return this;
        }

    }

