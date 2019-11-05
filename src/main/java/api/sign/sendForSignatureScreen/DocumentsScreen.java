package api.sign.sendForSignatureScreen;

import android.widget.Toast;
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

public class DocumentsScreen {


    public DocumentsScreen() {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private final Waiters waiters = new Waiters();
    private final AssertsUtils assertsUtils = new AssertsUtils();
    private final Gestures gestures = new Gestures();
    private  final Swipe swipe = new Swipe();


    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/send_done_button\")")
    private MobileElement done;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.android.packageinstaller:id/permission_allow_button\")")
    private MobileElement allowButtonOnAlert;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"DCIM\")")
    private MobileElement DCIM;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/btn_attach\")")
    private MobileElement addDocument;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]")
    private MobileElement documentLibrary;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Scan documents\")")
    private MobileElement scanDocumentAndAttach;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout")
    private Toast ScanDocumentAndAttachToast;

//    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Scan documents\")")
//    private Toast scanDocumentAndAttachToast;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[2]")
    private MobileElement documentsOnThisDevice;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"EmptyDoc\")")
    private MobileElement emptyDoc;




    public DocumentsScreen clickOnAddDocumentButton() {
        try {
            MyLogger.log.info("Clicking on add Document button");
            gestures.clickOnWebElement(addDocument);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click on add document button");
        }
    }

    // UBACIO SAM I OVO IS ELEMENT CLICLABLE DA VIDIMO HOCE DA JEDE GOVNA

    public DocumentsScreen clickOnDocumentsOnThisDevice() throws InterruptedException {
        try {
            MyLogger.log.info("Clicking on add Documents on this device");
            gestures.clickOnWebElement(documentsOnThisDevice);
            Waiters waiters = new Waiters();
            waiters.waitForElementVisibilityMobileElement(DCIM);
            waiters.waitForMobileElementToBeClickable(DCIM);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click on add documents on this device");
        }
    }

    public DocumentsScreen chooseEmptyDocFromThePhone() {
        try {
            MyLogger.log.info("Clicking on Empty Doc from phone");
            gestures.clickOnWebElement(emptyDoc);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click/find Empty Doc on the phone");
        }
    }

    public DocumentsScreen clickDone() {
        try {
            MyLogger.log.info("Clicking on Done button on documents page");
            gestures.clickOnWebElement(done);
            return this;
        }catch (WebDriverException e) {
            throw new AssertionError("Cannot click done button on documents page");
        }
    }

    public  DocumentsScreen swipUpUntilYouFindEmptyDoc () throws FileNotFoundException {
        Waiters waiters = new Waiters();
         //Waiter should be inserted here
        boolean isDocumentVisible = false;
        while (!isDocumentVisible) {
            Swipe.customSwipeUp();
            isDocumentVisible = new AssertsUtils().isElementVisible(emptyDoc);
        }
        return this;
    }


    public DocumentsScreen clickOnAllowOnPopUp() {
        try {
            MyLogger.log.info("Check if Allow phone storage Pop-Up is displayed");
            try {
                if (allowButtonOnAlert.isEnabled()) {
                    MyLogger.log.info("Allow phone storage is displayed?: " + allowButtonOnAlert.isDisplayed());
                    Drivers.getMobileDriver().switchTo().alert().accept();
                    MyLogger.log.info("Allow phone storage is dismissed");
                }
            } catch (WebDriverException e) {
                MyLogger.log.info("Allow phone storgae pop-up was not displayed");
            }
        } catch (WebDriverException e) {
            throw new AssertionError("Cannot check if Send Notification Pop-Up is displayed");
        }
        return this;
    }

    public DocumentsScreen dismissScanDocumentsAndAttachPopUp() {
        try {
            MyLogger.log.info("Check Scan Documents pop-up is displayed");
            try {
                if (scanDocumentAndAttach.isEnabled()) {
                    AppiumDriver driver = Drivers.getMobileDriver();
                    MyLogger.log.info("Scan documents and attach pop-up is present?: " + scanDocumentAndAttach.isDisplayed());
                    ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
                    MyLogger.log.info("Scan documents and attach pop-up is dismissed");
                }
            } catch (WebDriverException e) {
                MyLogger.log.info("Scan documents and attach pop up was not displayed");
            }
        } catch (WebDriverException e) {
            throw new AssertionError("Cannot check if Scan Documents Pop-Up is displayed");
        }
        return this;
    }



}
