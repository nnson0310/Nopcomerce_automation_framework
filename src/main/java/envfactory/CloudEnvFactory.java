package envfactory;

import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class CloudEnvFactory {

    WebDriver driver;

    private String browserName, browserVersion, os, osVersion;

    public CloudEnvFactory(String browserName, String browserVersion, String os, String osVersion) {
        this.browserName = browserName;
        this.os = os;
        this.browserVersion = browserVersion;
        this.osVersion = osVersion;
    }

    public WebDriver getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("os", os);
        capabilities.setCapability("os_version", osVersion);
        capabilities.setCapability("browser", browserName);
        capabilities.setCapability("browser_version", browserVersion);
        capabilities.setCapability("project", "Nopcommerce automation framework");
        capabilities.setCapability("build", "beta");
        capabilities.setCapability("name", "Run on Browser Stack with os = " + os + " and browser = " + browserName);

        try {
            driver = new RemoteWebDriver(new URL(GlobalConstants.getGlobalConstants().getCloudUrl()), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }
}
