package data.provider;

import org.testng.annotations.DataProvider;
import utilities.DataFaker;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class UserCheckout {

    public Map<String, String> billingAddress = new HashMap<String, String>();

    public UserCheckout() {
        billingAddress.put("first_name", "Robert");
        billingAddress.put("last_name", "Mountain");
        billingAddress.put("email", DataFaker.getDataFaker().generateEmail());
        billingAddress.put("company", "Huawei");
        billingAddress.put("country", "United States");
        billingAddress.put("state", "Colorado");
        billingAddress.put("city", "Newyork");
        billingAddress.put("address1", "12 Fucking Street");
        billingAddress.put("postal_code", "99502");
        billingAddress.put("phone_number", "0988767895");
    }

    @DataProvider(name = "user-checkout")
    public Object[][] dataProvider(Method method) {
        return new Object[][] {{billingAddress}};
    }
}
