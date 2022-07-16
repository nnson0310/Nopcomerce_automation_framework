package commons;

import lombok.Getter;
import lombok.Setter;

import java.io.File;

/**
 * Define all constant variables which will be used in project context
 * through getters methods (Singleton Pattern applying)
 *
 * @author Son
 */
@Getter
@Setter
public class GlobalConstants {

    private static GlobalConstants globalConstants;
    // Uncomment below lines if using method 1
    // private final CloudCredentials cloudCredentials = ConfigFactory.create(CloudCredentials.class);

    //Uncomment below lines if using method 3
    // Dotenv dotenv = Dotenv.load();

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
    private final String pathToMainResources = projectPath + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator;
    private final String reportScreenshot = pathToMainResources + "reportScreenshot" + File.separator;

    // Only valid when running on local machine. When running on cloud device
    // please specify valid url to file
    private final String downloadFilePath = pathToMainResources + "downloadedFiles" + File.separator;
    private final String uploadFilePath = pathToMainResources + "uploadFiles" + File.separator;

    private final String dataTestPath = pathToMainResources + "testData" + File.separator;
    private final String browserLogFilePath = projectPath + File.separator + "browserLogs" + File.separator;
    private final String browserExtensionPath = projectPath + File.separator + "browserExtensions" + File.separator;
    private final String javaVersion = System.getProperty("java.version");

    // Cloud testing info (browserStack)
    // Method 1: Uncomment below lines if you store cloud credentials in .properties file (using java owner lib)
    // private final String cloudUsername = cloudCredentials.cloudUsername();
    // private final String cloudAutomateKey = cloudCredentials.cloudAutomateKey();

    // Method 2: Uncomment below lines if you store cloud credentials in system variables (run setCloudCredentials.bat file)
    private final String cloudUsername = System.getenv("BROWSERSTACK_USERNAME");
    private final String cloudAutomateKey = System.getenv("BROWSERSTACK_AUTOMATE_KEY");

    // Method 3: using .env file (.dotenv lib)
    //    private final String cloudUsername = dotenv.get("BROWSERSTACK_USERNAME");
    //    private final String cloudAutomateKey = dotenv.get("BROWSERSTACK_AUTOMATE_KEY");

    private final String cloudUrl = "https://" + cloudUsername + ":" + cloudAutomateKey + "@hub-cloud.browserstack.com/wd/hub";

}
