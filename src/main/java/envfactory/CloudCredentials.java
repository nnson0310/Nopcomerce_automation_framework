package envfactory;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:cloud_credentials.properties"})
public interface CloudCredentials extends Config {

    @Key("cloudUsername")
    String cloudUsername();

    @Key("cloudAutomateKey")
    String cloudAutomateKey();
}
