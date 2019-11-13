package api.sign.loginScreen;

import api.drivers.Drivers;
import core.classic.methods.*;
import core.watchers.MyLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

import static core.json.parsers.ConfigJasonFileReading.runningSetup;

public class SignLoginScreen {

    public SignLoginScreen() throws FileNotFoundException {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    private String userPassword = runningSetup().getUserPassword();
    private final Waiters waiters = new Waiters();
    private final AssertsUtils assertsUtils = new AssertsUtils();
    private final Gestures gestures = new Gestures();
    public static String deviceId;



    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeNavigationBar' AND name MATCHES[c] 'LOG IN'")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"userEmail\")")
    private MobileElement userEmailField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"userPassword\")")
    private MobileElement userPasswordField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"login\")")
    private MobileElement signInButton;



    public SignLoginScreen enterUserName(String userName) {
        try {
            MyLogger.log.info("Typing user name: " + userName + " to e-mail address input");
            waiters.waitForMobileElementToBeClickable(userEmailField);
            gestures.sendText(userEmailField, userName);
            return this;
        } catch (WebDriverException e) {
            throw new AssertionError("Cannot send text: " + userName + " to e-mail address input");
        }
    }

    public SignLoginScreen enterPassword() {
        try {
            MyLogger.log.info("Typing password: " + userPassword + " to password input");
            waiters.waitForMobileElementToBeClickable(userPasswordField);
            gestures.sendText(userPasswordField, userPassword);
            return this;
        } catch (WebDriverException e) {
            throw new AssertionError("Cannot send text: " + userPassword + " to password input field");
        }
    }

    public SignLoginScreen clickOnSignInButton()  {
        try {
            if(deviceId.equals("ce041604406c423d01")) {
                MyLogger.log.info("Clicking on sign in button on login screen using S7");
                waiters.waitForMobileElementToBeClickable(signInButton);
                try {
                waiters.sleep(2000);
                }catch (Exception e) {throw new AssertionError("Cannot sleep");}
                new TouchAction(Drivers.getMobileDriver()).press(PointOption.point(500, 1070))
                        .release()
                        .perform();
                return this;
            } else {
                MyLogger.log.info("Click on Sign In button");
                gestures.clickOnMobileElement(signInButton);
                return this;
            }
        } catch (WebDriverException e) {
            throw new AssertionError("Cannot click on sign in button");
        }
    }

    public SignLoginScreen restartApp() {
        try {
             MyLogger.log.info("Restarting the app because Sing login screen is not loading");
            AppiumDriver driver = Drivers.getMobileDriver();
            driver.resetApp();
            return this;
        } catch (Exception e) {
            throw new AssertionError("Could not restart the app");
        }
    }
}


