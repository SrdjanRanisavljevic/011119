package pages.sign.settingsScreen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pages.drivers.Drivers;
import pages.sign.getSignatureInPersonScreen.GetSignatureInPersonScreen;
import core.classic.methods.AssertsUtils;
import core.classic.methods.Gestures;
import core.classic.methods.Swipe;
import core.classic.methods.Waiters;
import core.watchers.MyLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;

public class SettingsScreen {


    public SettingsScreen() {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private final Waiters waiters = new Waiters();
    private final AssertsUtils assertsUtils = new AssertsUtils();
    private final Gestures gestures = new Gestures();
    private  final Swipe swipe = new Swipe();

        GetSignatureInPersonScreen getSignatureInPersonScreen = new GetSignatureInPersonScreen();


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



    public SettingsScreen clickOnAboutButton() {
        try {
            MyLogger.log.info("Clicking on about button");
            gestures.clickOnWebElement(aboutButton);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click on about button");
        }
    }

    public SettingsScreen clickOnVersionButton() {
        try {
            MyLogger.log.info("Clicking on version button");
            long period = 10000;
            long start = System.currentTimeMillis();
            long end = start + period;
            boolean condition = new AssertsUtils().isElementVisible(yesOKButton);
            while(!condition){
                gestures.clickOnMobileElement(versionButton);
                waiters.sleep(500);
                start += 500;
                condition = new AssertsUtils().isElementVisible(yesOKButton);
                if(start>end)
                    throw new AssertionError("Unable to position itself on next screen in " + period + " sec");
            }
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click on version button");
        }
    }

    public SettingsScreen clickYesOrOk() {
        try {
            MyLogger.log.info("Clicking on yes button on set server dialog");
            gestures.clickOnMobileElement(yesOKButton);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click on yes button on set server dialog");
        }
    }

    public SettingsScreen chooseStageServer() {
        try {
            MyLogger.log.info("Clicking on STAGE SERVER radio button");
            gestures.clickOnMobileElement(stageServer);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click on stage server radio button");
        }
    }


    // Driver is unable to grab SIGN OUT button on SAMSUNG S5, so driver clicks on hardcoded coordinates

    public SettingsScreen clickOnSignOut() {
        try {
            if(deviceId.equals("579bb89d")) {
                MyLogger.log.info("Clicking on SIGN OUT button on SAMSUNG S5");
                new TouchAction(Drivers.getMobileDriver()).press(PointOption.point(150, 1320))
                        .release()
                        .perform();
                return this;
            } else {

                MyLogger.log.info("Clicking on SIGN OUT button");
                gestures.clickOnMobileElement(signOut);
                return this;
            }
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click on SIGN OUT button");
        }
    }
}
