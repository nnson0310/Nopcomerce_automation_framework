package dataprovider;

import org.testng.annotations.DataProvider;
import utilities.DataFaker;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class UserRegister {

    public Map<String, String> credentials = new HashMap<String, String>();
    public String registeredEmail;

    public UserRegister() {
        credentials.put("firstName", "ngoc");
        credentials.put("lastName", "minh");
        credentials.put("password", "123456");
        credentials.put("gender", "gender-male");
        credentials.put("birthDate", "3");
        credentials.put("birthMonth", "June");
        credentials.put("birthYear", "1977");
        credentials.put("companyName", "Samsung");
        credentials.put("email", DataFaker.getDataFaker().generateEmail());
        credentials.put("registeredEmail", "thuminh@gmail.com");
    }

    @DataProvider(name = "user-register")
    public Object[][] dataProvider(Method method) {
        switch (method.getName()) {
            case "TC_02_Invalid_Email":
                return new Object[][]{{"son@gmail", credentials}, {"songmail.com", credentials}, {"son@.com", credentials}, {"son.com", credentials}};
            case "TC_03_Registered_Email":
            case "TC_04_Valid_Info":
                return new Object[][]{{credentials}};
        }
        return null;
    }
}
