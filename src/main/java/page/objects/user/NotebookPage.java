package page.objects.user;

import commons.UserBasePage;
import org.openqa.selenium.WebDriver;
import page.interfaces.user.NotebookPageUI;
import custom.exception.InvalidSortNameException;
import utilities.FunctionHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NotebookPage extends UserBasePage {
    WebDriver driver;

    public NotebookPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectSortByName(WebDriver driver, String sortName) {
        waitForElementClickable(driver, NotebookPageUI.SORT_DROPDOWN);
        selectItemInDropDown(driver, NotebookPageUI.SORT_DROPDOWN, sortName);
    }

    private boolean isProductTitleSortedCorrectly (WebDriver driver, String locator, boolean reverse) {
        boolean result = false;
        List<String> productTitles;
        List<String> sortedProductTitles;

        waitForAllElementVisible(driver, locator);
        productTitles = getElementsText(driver, locator);
        sortedProductTitles = new ArrayList<>(productTitles);
        Collections.sort(sortedProductTitles);
        if (reverse) {
            Collections.reverse(sortedProductTitles);
        }
        System.out.println(productTitles);
        System.out.println(sortedProductTitles);
        if (sortedProductTitles.equals(productTitles)) {
            result = true;
        }
        return result;
    }

    private boolean isProductPriceSortedCorrectly(WebDriver driver, String locator, boolean reverse) {
        List<Integer> productPrices;
        List<Integer> sortedProductPrices;
        boolean result = false;

        waitForAllElementVisible(driver, locator);
        List<String> productPriceTexts = getElementsText(driver, locator);
        productPrices = new ArrayList<>();
        productPriceTexts.forEach((productPriceText) -> {
            productPrices.add(Integer.parseInt(FunctionHelper.getProductPriceByText(productPriceText)));
        });
        sortedProductPrices = new ArrayList<>(productPrices);
        Collections.sort(sortedProductPrices);
        if (reverse) {
            Collections.reverse(sortedProductPrices);
        }
        if (sortedProductPrices.equals(productPrices)) {
            result = true;
        }
        System.out.println(productPrices);
        System.out.println(sortedProductPrices);
        return result;
    }

    /**
     * Verify that product name and product price is sorted correctly
     * @param driver webdriver instance
     * @param sortName name of sort
     * @author Son
     */
    public boolean isProductSortedCorrectly(WebDriver driver, String sortName) {
        switch (sortName) {
            case "Name: A to Z":
                return isProductTitleSortedCorrectly(driver, NotebookPageUI.PRODUCT_TITLE, false);
            case "Name: Z to A":
                return isProductTitleSortedCorrectly(driver, NotebookPageUI.PRODUCT_TITLE, true);
            case "Price: Low to High":
                return isProductPriceSortedCorrectly(driver, NotebookPageUI.PRODUCT_PRICE, false);
            case "Price: High to Low":
                return isProductPriceSortedCorrectly(driver, NotebookPageUI.PRODUCT_PRICE, true);
            default:
                throw new InvalidSortNameException(sortName);
        }
    }

    public void clickToDisplayPerPage(WebDriver driver, String perPage) {
        waitForElementClickable(driver, NotebookPageUI.DISPLAY_PER_PAGE_DROPDOWN);
        selectItemInDropDown(driver, NotebookPageUI.DISPLAY_PER_PAGE_DROPDOWN, perPage);
    }

    /**
     * Verify that items per page are displayed correctly
     * @param driver webdriver instance
     * @param perPage expected items per page
     * @return boolean value
     * @author Son
     */
    public boolean isItemPerPageDisplayedCorrectly(WebDriver driver, String perPage) {
        waitForAllElementVisible(driver, NotebookPageUI.PRODUCT_ITEM);
        int itemPerPage = getElementSize(driver, NotebookPageUI.PRODUCT_ITEM);
        if (itemPerPage <= Integer.valueOf(perPage)) {
            return true;
        }
        return false;
    }

    public boolean isPagingIconDisplayed(WebDriver driver, int itemPerPage, int currentProductNumbers) {
        if (itemPerPage < currentProductNumbers) {
            waitForAllElementVisible(driver, NotebookPageUI.PAGING_BUTTON);
            return isElementDisplayed(driver, NotebookPageUI.PAGING_BUTTON);
        }
        else {
            waitForAllElementInvisible(driver, NotebookPageUI.PAGING_BUTTON);
            return false;
        }
    }
}
