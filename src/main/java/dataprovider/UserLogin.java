package dataprovider;

import org.testng.annotations.DataProvider;
import java.lang.reflect.Method;

public class UserLogin {

    @DataProvider(name = "user-login")
    public Object[][] dataProvider(Method method) {
        switch (method.getName()) {
            case "TC_02_Invalid_Email":
                return new Object[][]{{"thuminh.com"}, {"thuminh@.com"}, {"thuminh@"}};
            case "TC_03_Valid_Credentials":
                return new Object[][]{{"thuminh@gmail.com", "123456"}};
        }
        return null;
    }
}
