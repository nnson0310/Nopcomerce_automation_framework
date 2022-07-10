package browserdriverfactory;

import commons.GlobalConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ChromeDriverFactory implements BrowserFactory {

    @Override
    public WebDriver getBrowserDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
        //use chromeOptions class to setup before running testcases
        //such as set language, disable notifications
        chromeOptions.addArguments("--lang=vi");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-geolocation");

        //hide browser prompt when downloading files
        Map<String, Object> preferences = new HashMap<String, Object>();
        preferences.put("download.prompt_for_download", false);
        preferences.put("safebrowsing.enabled", true);
        preferences.put("download.directory_upgrade", true);
        preferences.put("download.default_directory", GlobalConstants.getGlobalConstants().getDownloadFilePath());
        chromeOptions.setExperimentalOption("prefs", preferences);

        // add extension
//        chromeOptions.addExtensions(new File(GlobalConstants.getGlobalConstants().getBrowserExtensionPath() + "adblock.crx"));
        chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

        return new ChromeDriver(chromeOptions);
    }
}
