package dataprovider;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class UserSortAndPaging {

    @DataProvider(name = "user-sort-paging")
    public Object[][] dataProvider(Method method) {
        switch (method.getName()) {
            case "TC_01_Sort":
                return new Object[][]{{"Name: A to Z"}, {"Name: Z to A"}, {"Price: Low to High"}, {"Price: High to Low"}};
            case "TC_02_Paging":
                return new Object[][]{{"3"}, {"6"}, {"9"}};
        }
        return null;
    }
}
