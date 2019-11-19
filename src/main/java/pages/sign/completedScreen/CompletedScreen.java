package pages.sign.completedScreen;

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
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

public class CompletedScreen {

    public CompletedScreen () {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private final Waiters waiters = new Waiters();
    private final AssertsUtils assertsUtils = new AssertsUtils();
    private final Gestures gestures = new Gestures();
    private  final Swipe swipe = new Swipe();

    public static String agreementName = null;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/btn_open_sign\")")
    private MobileElement approveButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/search_src_text\")")
    private MobileElement searchField;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"start\")")
    private MobileElement start;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ListView/android.widget.LinearLayout")
    private List<MobileElement> completedAgreementsSections;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"No Documents\")")
    private MobileElement noDocuments;

    @AndroidFindBy(xpath = "//android.widget.Button[2]")
    private MobileElement approve;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/search\")")
    private MobileElement search;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/lv_agreements\")")
    private MobileElement emptyAgreementsScreen;



    public CompletedScreen waitingForCompletedScreenToLoad() throws TimeoutException {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new AssertionError("Cannot sleep");
        }

        waiters.waitForMobileElementToBeClickable(search);
        waiters.waitForElementVisibilityMobileElement(emptyAgreementsScreen);

        MyLogger.log.info("Verifying elements COMPLETED SCREEN, waiting to load");
        boolean isElementVisible = false;
        MyLogger.log.info("Waiting for visibility of Agreement sections");

        long delta;
        long end = System.currentTimeMillis() + 600000;
        while (!isElementVisible) {
            delta = end - System.currentTimeMillis();
            if(delta <= 0){
                throw new TimeoutException("None of agreement sections have appeared in 10 minutes...");
            }
            if(new AssertsUtils().isElementVisible(noDocuments)) {
                throw new AssertionError("No documents in completed section");
            }
            for(int i =0; i<completedAgreementsSections.size(); i++){
                if(new AssertsUtils().isElementVisible(completedAgreementsSections.get(i))) {
                    MyLogger.log.info("Agreement Section found!");
                    isElementVisible = true;
                }
            }
        }
        return this;
    }


    public CompletedScreen clickOnSearchbuttonAndEnterAgreementName() {
        try {
            MyLogger.log.info("Click on search button and enter agreement name " + agreementName);
            gestures.clickOnMobileElement(search);
            gestures.sendText(searchField, agreementName);
            return this;
        }catch (Exception e) {
            throw new AssertionError("Cannot type the agreement name in search field on completed screen");
        }
    }

    public CompletedScreen verifyThatAgreementIsInCompletedSection() throws FileNotFoundException {
//         RecursionLimiter.emerge();
        try {
            MyLogger.log.info("Trying to find the document;");
            AppiumDriver driver = Drivers.getMobileDriver();
            List<MobileElement> lista = (List<MobileElement>) driver.findElementsByXPath("//android.widget.TextView[@text='" + agreementName + "']");
            boolean isPresent = lista.size() > 0;
            if (isPresent) {
                MobileElement agreement = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='" + agreementName + "']");
                MyLogger.log.info("AGREEMENT FOUND IN COMPLETED SECTION!!!");
                return this;
            } else {
                MyLogger.log.info("No agreement present on COMPLETED screen, RELOADING SCREEN!!!!");
                searchField.clear();
                sleep(4000);
                Swipe.customSwipeDown();
                sleep(10000);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    MyLogger.log.debug("Cannot Sleep");
                }
                clickOnSearchbuttonAndEnterAgreementName();
                verifyThatAgreementIsInCompletedSection();
                return this;
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            throw new AssertionError("CANNOT FIND THE AGREEMENT ON COMPLETED SCREEN EVEN AFTER SEVERAL RELOADS");
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
