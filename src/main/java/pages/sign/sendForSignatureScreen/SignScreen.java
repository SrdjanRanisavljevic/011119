package pages.sign.sendForSignatureScreen;

import pages.drivers.Drivers;
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
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;

public class SignScreen {

    public SignScreen () {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    public static String deviceId;
    private final Waiters waiters = new Waiters();
    private final AssertsUtils assertsUtils = new AssertsUtils();
    private final Gestures gestures = new Gestures();
    private  final Swipe swipe = new Swipe();
    public static String agreementName = null;


    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/btn_open_sign\")")
    private MobileElement approveButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"start\")")
    private MobileElement start;

    @AndroidFindBy(xpath = "//android.view.View[5]/android.view.View/android.view.View[2]/android.view.View]")
    private MobileElement finish;

    @AndroidFindBy(xpath = "//android.view.View[5]/android.view.View/android.view.View/android.view.View[3]")
    private MobileElement finishOnTablet;

    @AndroidFindBy(xpath = "//android.widget.Button")
    private MobileElement signatureField;

    @AndroidFindBy(xpath = "//android.view.View[2]/android.view.View")
    private MobileElement signatureFieldClickToEdit;

    @AndroidFindBy(xpath = "//android.widget.Button[2]")
    private MobileElement tappToSign;

    @AndroidFindBy(xpath = "//android.widget.Image")
    private MobileElement canvas;

    @AndroidFindBy(xpath = "//android.view.View[2]")
    private MobileElement tapToChange;

    @AndroidFindBy(xpath = "//android.widget.TabWidget/android.view.View[1]")
    private MobileElement keyboardIcon;

    @AndroidFindBy(xpath = "//android.view.View[3]/android.view.View[2]/android.widget.Button[2]")
    private MobileElement applyOnEditSignatureScreen;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private MobileElement nameField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/send_done_button\")")
    private MobileElement doneButton;




    public SignScreen clickOnStartButton() {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        MyLogger.log.info("CONTEXT IS: " + driver.getContext());
        try {
            MyLogger.log.info("Click on start button");
            waiters.waitForMobileElementToBeClickable(start);
            gestures.clickOnMobileElement(start);
            return this;
        }catch (Exception e) {
            throw new AssertionError("Could not click on start button on Sign editor");
        }
    }

    public SignScreen writeTheNameOfSigner() {
        try {
            String testSignature = "test";
            MyLogger.log.info("Writing the name of signer");
            waiters.waitForMobileElementToBeClickable(nameField);
            gestures.sendText(nameField, testSignature);
            return this;
        } catch (Exception e) {
            throw new AssertionError("Could not write the name of the user");
        }
    }

    public SignScreen clickOnKeyboardIcon() {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        MyLogger.log.info("CONTEXT IS: " + driver.getContext());
        try {
            MyLogger.log.info("Click on keyboard icon");
            waiters.waitForMobileElementToBeClickable(keyboardIcon);
            gestures.clickOnMobileElement(keyboardIcon);
            return this;
        }catch (Exception e) {
            throw new AssertionError("Could not click on keyboard icon");
        }
    }

    public SignScreen clickOnApplyButtonOnEditSignatureScreen() {
        try {
            MyLogger.log.info("Click on apply button on edit signature screen");
            try{
                Thread.sleep(3000);
            } catch (Exception e) {
                MyLogger.log.info("Cannot sleep");
            }
            waiters.waitForMobileElementToBeClickable(applyOnEditSignatureScreen);
            gestures.clickOnMobileElement(applyOnEditSignatureScreen);
            return this;
        }catch (Exception e) {
            throw new AssertionError("Could not click on keyboard icon");
        }
    }


    public SignScreen clickOnSignatureField() {
        try {
            MyLogger.log.info("Click on signature field");
            waiters.waitForMobileElementToBeClickable(signatureField);
            gestures.clickOnMobileElement(signatureField);
            return this;
        }catch (Exception e) {
            throw new AssertionError("Could not click on signature field in Sign editor");
        }
    }

    public SignScreen clickSecondTimeOnSignatureFieldtoEdit() {
        try {
            MyLogger.log.info("Click second time on signature field to edit");
            waiters.waitForMobileElementToBeClickable(signatureFieldClickToEdit);
            gestures.clickOnMobileElement(signatureFieldClickToEdit);
            return this;
        }catch (Exception e) {
            throw new AssertionError("Could not click on signature field for the second time");
        }
    }


    public SignScreen clickOnTapToSign() {
        try {
            MyLogger.log.info("Click on Tap to sign button");
            waiters.waitForMobileElementToBeClickable(tappToSign);
            gestures.clickOnMobileElement(tappToSign);
            return this;
        }catch (Exception e) {
            throw new AssertionError("Could not click on Tap to sign button on Sign editor");
        }
    }

    public SignScreen clickOnFinishButton() {
        try {
            if(deviceId.equals("ce041604406c423d01")) {
                MyLogger.log.info("Clicking on FINISH button on sign editor using S7");
                waiters.waitForElementVisibilityMobileElement(signatureField);
                Thread.sleep(3000);
                new TouchAction(Drivers.getMobileDriver()).press(PointOption.point(980, 330))
                        .release()
                        .perform();
                return this;
            }
            if (deviceId.equals("3204db2bb5fe7121")) {
                MyLogger.log.info("Click on finish button on tablet");
                Thread.sleep(3000);
                waiters.waitForElementVisibilityMobileElement(finishOnTablet);
                gestures.clickOnMobileElement(finishOnTablet);
                return this;
            }
            else{
                MyLogger.log.info("Click on Finish button in Sign editor");
                waiters.waitForMobileElementToBeClickable(finish);
                gestures.clickOnMobileElement(finish);
                return this;
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new AssertionError("Could not click on Finish button on Sign editor");
        }
    }

    public SignScreen clickDone() {
        if (checkIfDoneButtonIsPresent()) {
            try {
                MyLogger.log.info("Clicking on Done button on documents/recipients/message page");
                gestures.clickOnWebElement(doneButton);
                return this;
            } catch (WebDriverException e) {
                throw new AssertionError("Cannot click done button on documents/recipients/message page");
            }
        } else {
            MyLogger.log.info("Done button is not present, test is being executed on tablet device");
            return this;
        }
    }

    // this method is necessary because tablets do not have done button document screen
    public boolean checkIfDoneButtonIsPresent() {
        MyLogger.log.info("Check if done button is present");
        if((new AssertsUtils().isElementVisible(doneButton))) {
            return true;
        } else {
            return false;
        }
    }

    public SignScreen dismissTapHereToChangePopUp() {
        try {
            MyLogger.log.info("TAP HERE TO CHANGE pop-up is displayed");
            try {
                if (tapToChange.isEnabled()) {
                    AppiumDriver driver = Drivers.getMobileDriver();
                    MyLogger.log.info("TAP HERE TO CHANGE pop-up is present?: " + tapToChange.isDisplayed());
                    ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN));
                    MyLogger.log.info("TAP HERE TO CHANGE pop-up is dismissed");
                }
            } catch (WebDriverException e) {
                MyLogger.log.info("TAP HERE TO CHANGE pop up was not displayed");
            }
        } catch (WebDriverException e) {
            throw new AssertionError("Cannot check if TAP HERE TO CHANGE Pop-Up is displayed");
    }
        return this;
    }

}
