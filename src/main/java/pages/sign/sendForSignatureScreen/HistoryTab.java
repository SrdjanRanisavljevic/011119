package pages.sign.sendForSignatureScreen;

import core.classic.methods.AssertsUtils;
import core.classic.methods.Gestures;
import core.classic.methods.Waiters;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import pages.drivers.Drivers;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static core.json.parsers.ConfigJasonFileReading.runningSetup;

public class HistoryTab {

    public HistoryTab() throws FileNotFoundException {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    private final Waiters waiters = new Waiters();
    private final AssertsUtils assertsUtils = new AssertsUtils();
    private final Gestures gestures = new Gestures();
    public static String deviceId;

    private ArrayList<String> historyTab = new ArrayList<>();



}


