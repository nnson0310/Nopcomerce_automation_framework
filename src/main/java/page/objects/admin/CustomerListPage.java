package page.objects.admin;

import commons.AdminBasePage;
import org.openqa.selenium.WebDriver;
import page.interfaces.admin.CustomerListPageUI;

public class CustomerListPage extends AdminBasePage {
    WebDriver driver;

    String cellData;

    public CustomerListPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAddressDisplayedCorrectly(WebDriver driver, String[] verifyData) {
        boolean result = true;
        //except edit and delete column
        int rowCellNum = getElementSize(driver, CustomerListPageUI.ADDRESS_TABLE_ROW_DATA) - 2;
        for(int i = 1; i <= rowCellNum;  i++) {
            cellData =  getElementText(driver, CustomerListPageUI.ADDRESS_TABLE_CELL_BY_INDEX, String.valueOf(i));
            if (!cellData.equals(verifyData[i-1])) {
                result = false;
            }
        }
        return result;
    }
}
