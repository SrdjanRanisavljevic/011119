package api.sign.waitingForOthersScreen;

import api.drivers.Drivers;
import api.sign.waitingForYouScreen.WaitingForYouScreen;
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

import java.util.List;

public class WaitingForOthersScreen extends WaitingForYouScreen {



    public WaitingForOthersScreen() {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private final Waiters waiters = new Waiters();
    private final AssertsUtils assertsUtils = new AssertsUtils();
    private final Gestures gestures = new Gestures();
    private final Swipe swipe = new Swipe();

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private MobileElement backButton;

    public WaitingForOthersScreen clickOnSpecificUser(String user) {
        try {
            MyLogger.log.info("Click on user: " + user);
            AppiumDriver driver = Drivers.getMobileDriver();
            List<MobileElement> lista = (List<MobileElement>) driver.findElementsByXPath("//android.widget.TextView[@text='" + user + "']");
            boolean isPresent = lista.size() > 0;
            if (isPresent) {
                MobileElement selectSigner = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='" + user + "']");
                MyLogger.log.info("Click on signer to choose it from the list of the signers in paralel sign/approval workflow");
                waiters.waitForMobileElementToBeClickable(selectSigner);
                gestures.clickOnMobileElement(selectSigner);
                return this;
            }
            else {
               sleep(2000);
                clickOnSpecificUser(user);
            }return this;
        } catch (Exception e) {
            throw new AssertionError("Cannot click on specific user in paralel workflow");
        }
    }

    public WaitingForOthersScreen clickBackButton() {
        try {
            MyLogger.log.info("Clicking on back button on Waiting for you page");
            waiters.waitForMobileElementToBeClickable(backButton);
            gestures.clickOnMobileElement(backButton);
            return this;
        } catch (WebDriverException e) {
            throw new AssertionError("Cannot click on back on waiting for you page");
        }
    }


    public void sleep(int time) {
        try {
            MyLogger.log.info("Sleeping now because i cannot find better solution");
            Thread.sleep(time);
        } catch (InterruptedException e) {
            MyLogger.log.debug("Cannot Sleep");
        }
    }

}
