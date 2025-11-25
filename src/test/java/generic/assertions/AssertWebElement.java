package generic.assertions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

public class AssertWebElement extends AbstractAssert<AssertWebElement, WebElement> {

    private Logger logger = LogManager.getLogger(AssertWebElement.class);

    public AssertWebElement(WebElement element) {
        super(element, AssertWebElement.class);
    }

    public static AssertWebElement assertThat(WebElement webElement) {
        return new AssertWebElement(webElement);
    }

    public AssertWebElement isDisplayed() {
        logger.info("Checking if element is displayed");
        isNotNull();

        if (!actual.isDisplayed()) {
            logger.info("Element was not displayed");
        }
        logger.info("Element was displayed");
        return this;
    }

    public AssertWebElement hasText(String expectedText) {
        logger.info("Checking if WebElement has text: {}", expectedText);
        isNotNull();

        String actualText = actual.getText();
        if (!actualText.equals(expectedText)) {
            failWithMessage("Element text was <%s> but expected should be <%s>", actualText, expectedText);
        }
        logger.info("WebElement had expected text");
        return this;
    }
}
