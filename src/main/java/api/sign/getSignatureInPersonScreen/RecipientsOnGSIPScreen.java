package api.sign.getSignatureInPersonScreen;

import api.drivers.Drivers;
import api.sign.sendForSignatureScreen.RecipientsScreen;
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

public class RecipientsOnGSIPScreen extends RecipientsScreen {

    public RecipientsOnGSIPScreen() {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private final Waiters waiters = new Waiters();
    private final AssertsUtils assertsUtils = new AssertsUtils();
    private final Gestures gestures = new Gestures();



    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.EditText")
    private MobileElement inPersonSignerField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/add_recipient\")")
    private MobileElement additionalSignersField;


    public RecipientsOnGSIPScreen addInPersonSigner(String inPersonSigner) {
        try {
            AppiumDriver driver = Drivers.getMobileDriver();
            MyLogger.log.info("Typing In Person Signer address");
            gestures.sendText(inPersonSignerField, inPersonSigner);
            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
            return this;
        } catch (WebDriverException e) {
            throw new AssertionError("Cannot type the address of In Person Signer");
        }
    }

    public RecipientsOnGSIPScreen addAdditionalSigner(String additionalSigner) {
        try {
            AppiumDriver driver = Drivers.getMobileDriver();
            MyLogger.log.info("Typing Additional Signer address");
            gestures.sendText(additionalSignersField, additionalSigner);
            ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
            return this;
        } catch (WebDriverException e) {
            throw new AssertionError("Cannot type the address of Additional Signer");
        }
    }




}


