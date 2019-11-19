package pages.sign.sendForSignatureScreen;

import pages.drivers.Drivers;
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

public class AgreementSummaryScreen {

    public AgreementSummaryScreen() {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private final Waiters waiters = new Waiters();
    private final AssertsUtils assertsUtils = new AssertsUtils();
    private final Gestures gestures = new Gestures();
    private  final Swipe swipe = new Swipe();

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/btn_open_sign\")")
    private MobileElement signButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/btn_view_history\")")
    private MobileElement historyButton;


    public AgreementSummaryScreen clickOnSignButton() {
        try {
            MyLogger.log.info("Clicking On Sign Button on Agreement screen");
            waiters.waitForMobileElementToBeClickable(signButton);
            gestures.clickOnMobileElement(signButton);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click on Sign button on Agreement Screen");
        }
    }




}
