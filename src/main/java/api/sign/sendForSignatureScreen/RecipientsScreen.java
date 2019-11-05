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

import java.io.FileNotFoundException;


public class RecipientsScreen {

    public RecipientsScreen() {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }



    private final Waiters waiters = new Waiters();
    private final AssertsUtils assertsUtils = new AssertsUtils();
    private final Gestures gestures = new Gestures();
    private  final Swipe swipe = new Swipe();



    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/send_done_button\")")
    private MobileElement done;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/signing_order_switch\")")
    private MobileElement completeInOrderListed;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/add_recipient\")")
    private MobileElement addRecipientField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/addMeButton\")")
    private MobileElement addMe;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/ccButton\")")
    private MobileElement cc;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/approverButton\")")
    private MobileElement approver;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/delegateToSignerButton\")")
    private MobileElement delegateToSigner;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/delegateToApproverButton\")")
    private MobileElement delegateToApprover;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/okButton\")")
    private MobileElement okOnRolePage;





    public RecipientsScreen clickOnCompleteInOrderListed() {
        try {
            MyLogger.log.info("Clicking Complete in Order Listed");
            gestures.clickOnMobileElement(completeInOrderListed);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click on Complete in Order Listed");
        }
    }

    public RecipientsScreen clickOnDone() {
        try {
            MyLogger.log.info("Clicking On Done Button on Recipients Page");
            gestures.clickOnMobileElement(done);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click on Done button on Recipients Page");
        }
    }

    public RecipientsScreen clickOnAddRecipientField() {
        try {
            MyLogger.log.info("Clicking On Add Recipient Field");
            gestures.clickOnMobileElement(addRecipientField);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click on Add Recipient Field");
        }
    }

    public RecipientsScreen addRecipient(String recipient) {
        try {
            AppiumDriver driver = Drivers.getMobileDriver();
            MyLogger.log.info("Typing recipient address");
            gestures.sendText(addRecipientField, recipient);
            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot type recipient Address");
        }
    }

    public RecipientsScreen clickOnAddMeButton() {
        try {
            MyLogger.log.info("Clicking On Add Me button");
            gestures.clickOnMobileElement(addMe);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click on Add me button");
        }
    }

    public RecipientsScreen clickOnCc() {
        try {
            MyLogger.log.info("Clicking On CC button");
            gestures.clickOnMobileElement(cc);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click on CC buton");
        }
    }


    public RecipientsScreen setDelegatorToSigner (String recipientEmail) {
        try {
            MyLogger.log.info("Changing recipient role to delegator to signer");
            AppiumDriver driver = Drivers.getMobileDriver();

            MobileElement recipient = (MobileElement) (driver.findElementByXPath("//android.widget.TextView[@text='"+recipientEmail+"']"));
            gestures.clickOnMobileElement(recipient);
            gestures.clickOnWebElement(delegateToSigner);
            gestures.clickOnMobileElement(okOnRolePage);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot change recipient role to delegator to signer");
        }
    }

    public RecipientsScreen setDelegatorToApprover (String recipientEmail) {
        try {
            MyLogger.log.info("Changing recipient role to delegate to approver");
            AppiumDriver driver = Drivers.getMobileDriver();
            MobileElement recipient = (MobileElement) (driver.findElementByXPath("//android.widget.TextView[@text='"+recipientEmail+"']"));
            gestures.clickOnMobileElement(recipient);
            gestures.clickOnWebElement(delegateToApprover);
            gestures.clickOnMobileElement(okOnRolePage);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot change recipient role to delegator to approver");
        }
    }

    public RecipientsScreen setRoleToApprover (String recipientEmail) {
        try {
            MyLogger.log.info("Changing recipient role APPROVER");
            AppiumDriver driver = Drivers.getMobileDriver();
            MobileElement recipient = (MobileElement) (driver.findElementByXPath("//android.widget.TextView[@text='"+recipientEmail+"']"));
            gestures.clickOnMobileElement(recipient);
            gestures.clickOnWebElement(approver);
            gestures.clickOnMobileElement(okOnRolePage);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot change recipient role to APPROVER");
        }
    }

    //  Need to add check if Add me and RecipientField are present before scrolling
    public RecipientsScreen swipeToFindAddMeAndRecipientNameField () throws FileNotFoundException {
        MyLogger.log.info("Checking if Add me button is visible...");
        boolean isAddMeVisible = new AssertsUtils().isElementVisible(addMe);
        if(!isAddMeVisible) {
            while (!isAddMeVisible) {
                try {
                    MyLogger.log.info("Swiping to find AddMe button");
                    Swipe.customSwipeUp();
                    isAddMeVisible = new AssertsUtils().isElementVisible(addMe);
                    if(isAddMeVisible) {
                        break;
                    }
                }catch (WebDriverException e) {
                    MyLogger.log.info("Cannot swipe or cannot find addMe button");

                }
            }
        }
        MyLogger.log.info("Add me button is visible!");
        return this;
    }




}
