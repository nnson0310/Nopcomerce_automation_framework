package commons;

import envfactory.CloudCredentials;
import lombok.Getter;
import lombok.Setter;
import org.aeonbits.owner.ConfigFactory;

import java.io.File;

/**
 * Define all constant variables which will be used in project context
 * through getters methods (Singleton Pattern applying)
 * @author Son
 */
@Getter
@Setter
public class GlobalConstants {

    private static GlobalConstants globalConstants;
    private final CloudCredentials cloudCredentials = ConfigFactory.create(CloudCredentials.class);;

    private GlobalConstants() {
    }

    public synchronized static GlobalConstants getGlobalConstants() {
        if (globalConstants == null) {
            return new GlobalConstants();
        }
        return globalConstants;
    }

    private final int shortTimeout = 10;
    private final int longTimeout = 20;
    private final String projectPath = System.getProperty("user.dir");
    private final String osName = System.getProperty("os.name");
    private final String pathToMainResources = projectPath + File.separator + "src" + File.separator + "main" + File.separator + "resources" +  File.separator;
    private final String reportScreenshot =  pathToMainResources + "reportScreenshot" + File.separator;
    private final String downloadFilePath = pathToMainResources + "downloadFiles";
    private final String uploadFilePath = pathToMainResources + "uploadFiles";
    private final String dataTestPath = pathToMainResources + "testData";
    private final String browserLogFilePath = projectPath + File.separator + "browserLogs" + File.separator;
    private final String browserExtensionPath = projectPath + File.separator + "browserExtensions" + File.separator;
    private final String javaVersion = System.getProperty("java.version");

    // Cloud testing info (browserStack)
    private final String cloudUsername = System.getenv("BROWSERSTACK_USERNAME");
    private final String cloudPassword = System.getenv("BROWSERSTACK_ACCESS_KEY");
    private final String cloudUrl = "https://" + cloudUsername + ":" + cloudPassword + "@hub-cloud.browserstack.com/wd/hub";

}
