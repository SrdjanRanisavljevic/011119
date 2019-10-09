package api.sign.settings.screen;

import api.drivers.Drivers;
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

public class SettingsView {


    public SettingsView() {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private final Waiters waiters = new Waiters();
    private final AssertsUtils assertsUtils = new AssertsUtils();
    private final Gestures gestures = new Gestures();
    private  final Swipe swipe = new Swipe();
    private final String signOutText = "Sign Out";
  

    public static String deviceId;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/rl_abt\")")
    private MobileElement aboutButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/rl_about_version\")")
    private MobileElement versionButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")")
    private MobileElement yesOKButton;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[4]")
    private MobileElement stageServer;


    // S I G N    O U T      B U T T O N    L O C A T O R S
    @AndroidFindBy(xpath = "//android.widget.TextView[3]")
    private MobileElement signOutXpath;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Sign Out\")")
    private MobileElement signOutXpathText;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/tv_signout\")")
    private MobileElement signOut;



    public SettingsView clickOnAboutButton() {
        try {
            MyLogger.log.info("Clicking on about button");
            gestures.clickOnWebElement(aboutButton);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click on about button");
        }
    }

    public SettingsView clickOnVersionButton() {
        try {
            MyLogger.log.info("Clicking on version button");
            gestures.clickOnMobileElement(versionButton);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click on version button");
        }
    }

    public SettingsView clickYesOrOk() {
        try {
            MyLogger.log.info("Clicking on yes button on set server dialog");
            gestures.clickOnMobileElement(yesOKButton);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click on yes button on set server dialog");
        }
    }

    public SettingsView chooseStageServer() {
        try {
            MyLogger.log.info("Clicking on STAGE SERVER radio button");
            gestures.clickOnMobileElement(stageServer);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click on stage server radio button");
        }
    }

    public SettingsView clickOnSignOut() {
        try {
            if(deviceId.equals("579bb89d")) {

            }

            MyLogger.log.info("Clicking on SIGN OUT button");
            gestures.clickOnMobileElement(signOut);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click on SIGN OUT button");
        }
    }


}
