package api.sign.send.screen;

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
import api.drivers.Drivers;

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

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.adobe.echosign:id/btn_attach\")")
    private MobileElement addDocument;

    @AndroidFindBy(xpath = "//android.widget.LinearLayout[1]")
    private MobileElement documentLibrary;

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

    public DocumentsScreen clickOnDocumentsOnThisDevice() {
        try {
            MyLogger.log.info("Clicking on add Documents on this device");
            gestures.clickOnWebElement(documentsOnThisDevice);
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






}
