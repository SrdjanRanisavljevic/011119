package pages.sign.sendForSignatureScreen;

import pages.drivers.Drivers;
import pages.sign.loginScreen.SignLoginScreen;
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

import java.io.FileNotFoundException;

public class PostSignScreen {

    public PostSignScreen() throws FileNotFoundException {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public static String agreementName = null;

    private final Waiters waiters = new Waiters();
    private final AssertsUtils assertsUtils = new AssertsUtils();
    private final Gestures gestures = new Gestures();
    private final Swipe swipe = new Swipe();
    SignLoginScreen signLoginScreen = new SignLoginScreen();


    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"You assigned\")")
    private MobileElement postDelegationMessage1;

    @AndroidFindBy(accessibility = "More options")
    private MobileElement moreOptionsButton;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]")
    private MobileElement backToAgreementsListButton;

//    @AndroidFindBy(xpath = "//android.widget.LinearLayout[2]")
//    private MobileElement backToHomeButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Back to Home\")")
    private MobileElement backToHomeButton;



    // This waiting methods should be replaced by assert methods that wait for all the documents from the screen to load

    public PostSignScreen waitingForPostSignScreenToLoad() {
        try {
            MyLogger.log.info("Waiting for Post Sign page elements to load...");
            Waiters waiters = new Waiters();
            waiters.waitForElementVisibilityMobileElement(postDelegationMessage1);
            return this;
        }catch (Exception e) {
            throw new AssertionError("Cannot find the post delegation message element");
        }
    }

    public String getActualPostDelegationMessage () {
        MyLogger.log.info("Actual Post Delegation Message: " + postDelegationMessage1.getText() );
         return postDelegationMessage1.getText();
    }

    public String createExpectedPostDelegationMessageApproval(String delegatee) {
        String expectedPostDelegationMessage = "You assigned \"" + agreementName + '"' + " to " + delegatee + " for approving.";
        MyLogger.log.info(expectedPostDelegationMessage);
        return expectedPostDelegationMessage;
    }

    public String createExpectedPostDelegationMessageSigning(String delegatee) {
        String expectedPostDelegationMessage = "You assigned \"" + agreementName + '"' + " to " + delegatee + " for signing.";
        MyLogger.log.info(expectedPostDelegationMessage);
        return expectedPostDelegationMessage;
    }


    // ENTER ASSERTATION
    public PostSignScreen isActualPostDelegationMessageAsExpectedApproval(String delegatee) {
        String expectedPostDelegationMessage = createExpectedPostDelegationMessageApproval(delegatee);
        String actualPostDelegationMessage = getActualPostDelegationMessage();
        assert expectedPostDelegationMessage.equals(actualPostDelegationMessage) : "expected " + expectedPostDelegationMessage + " but got instead " + actualPostDelegationMessage;
        return this;
    }

    public PostSignScreen isActualPostDelegationMessageAsExpectedSigning(String delegatee) {
        String expectedPostDelegationMessage = createExpectedPostDelegationMessageSigning(delegatee);
        String actualPostDelegationMessage = getActualPostDelegationMessage();
        assert expectedPostDelegationMessage.equals(actualPostDelegationMessage) : "expected " + expectedPostDelegationMessage + " but got instead " + actualPostDelegationMessage;
        return this;
    }

    public PostSignScreen backToHomePage() {
        try {
            MyLogger.log.info("Clicking on more options button and than on back to home button");
            waiters.waitForMobileElementToBeClickable(moreOptionsButton);
            gestures.clickOnMobileElement(moreOptionsButton);
            waiters.waitForMobileElementToBeClickable(backToHomeButton);
            gestures.clickOnMobileElement(backToHomeButton);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click on more options button and than on back to home button");
        }
    }

}
