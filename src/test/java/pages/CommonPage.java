package pages;


import HelperMethods.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonPage {

    protected WebDriver driver;
    protected ElementsMethods elementsMethods;
    protected JavascriptHelpers javascriptHelpers;
    protected AlertMethods alertMethods;
    protected Actions actions;
    protected WindowsMethods windowsMethods;
    protected FramesMethods framesMethods;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        this.elementsMethods = new ElementsMethods(driver);
        this.javascriptHelpers = new JavascriptHelpers(driver);
        this.alertMethods = new AlertMethods(driver);
        this.actions = new Actions(driver);
        this.windowsMethods = new WindowsMethods(driver);
        this.framesMethods = new FramesMethods(driver);
        PageFactory.initElements(driver,this);
    }

    // Identificam WebElement-ele specifice pentru sub-pagini
    @FindBy(xpath = "//span[@class='text']")
    private List<WebElement> elements;

    // Facem metode specifice pentru pagina
    public void goToDesiredSubMenu(String submenu) {
        javascriptHelpers.scrollDown(400);
        elementsMethods.selectElementFromListByText(elements, submenu);
    }
}
