package Pages;

import managers.DriverManager;
import managers.PageManager;
import managers.TestPropManager;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    /**
     * Менеджер WebDriver
     */
    protected final DriverManager driverManager = DriverManager.getDriverManager();

    /**
     * Менеджер страничек
     */
    protected PageManager pageManager = PageManager.getPageManager();


    /**
     * Объект явного ожидания
     * При применении будет ожидать заданного состояния 7 секунд с интервалом в 1 секунду
     */
    protected WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), 7, 1000);


    /**
     * Менеджер properties
     */
    protected final TestPropManager props = TestPropManager.getTestPropManager();


    /**
     * Конструктор позволяющий инициализировать все странички и их элементы
     */
    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);
    }


    /**
     * Явное ожидание состояния clickable элемента
     *
     * @param element - веб-элемент который требует проверки clickable
     * @return WebElement - возвращаем тот же веб элемент, что был передан в функцию
     */
    protected WebElement waitUtilElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Явное ожидание того что элемент станет видимым
     *
     * @param element - веб элемент который мы ожидаем что будет виден на странице
     */
    protected WebElement waitUtilElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Явное ожидание, что в элементе содержится текст
     * @param element - веб элемент текст которого мы ожидаем что будет виден на странице
     * @param text - текс для проверки
     * @return boolean
     */
    protected boolean waitUtilTextToBePresent(WebElement element, String text) {
        try {
            wait.until(ExpectedConditions.textToBePresentInElement(element, text));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    /**
     * Общий метод по заполнения полей ввода
     *
     * @param field - веб-элемент поле ввода
     * @param value - значение вводимое в поле
     */
    protected void fillInputField(WebElement field, String value) {
        waitUtilElementToBeClickable(field).click();
        field.click();
        field.sendKeys(value);
    }

}
