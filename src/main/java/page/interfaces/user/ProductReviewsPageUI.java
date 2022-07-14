package page.interfaces.user;

public abstract class ProductReviewsPageUI {
    public static final String REVIEW_TITLE_TEXTBOX = "css=input#AddProductReview_Title";
    public static final String REVIEW_TEXT_TEXTAREA = "css=textarea#AddProductReview_ReviewText";
    public static final String RATING_RATIO_BUTTON = "xpath=//div[@class='rating-options']//input[@aria-label='%s']";
    public static final String SUBMIT_REVIEW_BUTTON = "css=button[name='add-review']";
    public static final String DYNAMIC_RESULT_MESSAGE = "xpath=//div[@class='result' and contains(text(), '%s')]";
}
