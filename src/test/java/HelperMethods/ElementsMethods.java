package HelperMethods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class ElementsMethods {

    WebDriver driver;
    Actions actions;

    public ElementsMethods(WebDriver driver) {
        this.driver = driver;
        this.actions=new Actions(driver);
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void fillElement(WebElement element, String value) {
        element.sendKeys(value);
    }

    public void uploadPicture(WebElement element) {
        String pictureFilePath = "src/test/resources/1.png";
        File file = new File(pictureFilePath);
        element.sendKeys(file.getAbsolutePath());
    }

    public void selectElementFromListByText(List<WebElement> elementsList, String value) {
        for (WebElement element : elementsList) {
            if (element.getText().equals(value)) {
                clickOnElement(element);
                break;
            }
        }
    }

    public void fillElementWithEnter(WebElement element, String value) {
        element.sendKeys(value);
        element.sendKeys(Keys.ENTER);
    }

    public void selectByValue(WebElement element, String value) {
        Select yearSelect = new Select(element);
        yearSelect.selectByValue(value);
    }

    public void selectByVisibleText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void fillMultipleValues(WebElement element, List<String> values) {
        for (String value : values) {
            element.sendKeys(value);
            element.sendKeys(Keys.ENTER);
        }
    }

    public void checkMultipleElementsByListOfValues(List<WebElement> elements, List<String> values) {
        for (String value : values) {
            for (WebElement element : elements) {
                if (element.getText().equals(value)) {
                    element.click();
                }
            }
        }
    }

    public void displayContentOfElement(WebElement element) {
        System.out.println("Textul din element este: " + element.getText());
    }

    public void fillWithActions(WebElement element, String value)
    {

        actions.sendKeys(value).perform();
        waitVisibilityElement(element);
        actions.sendKeys(Keys.ENTER).perform();
    }

    public void waitVisibilityElement(WebElement element) {
        // Definim un wait explicit ca sa astepte dupa alerta
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void fillWithMultipleValues(WebElement element, List<String> list)
    {
        for(String value:list)
        {
            element.sendKeys(value);
            element.sendKeys(Keys.ENTER);
        }
    }
    public void clickWithMultipleValues(List<WebElement>webElements, List<String>values)
    {
        for(String value:values)
        {
            for(WebElement webElement:webElements)
                if(webElement.getText().equals(value))
                    webElement.click();
        }
    }

}
