package Pages;

import Categories.CheckBoxes;
import Categories.CheckingValuePercent;
import Categories.CheckingValueRub;
import Categories.InputFields;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MortgagePage extends BasePage {


    /**
     * Проверка открытия страницы, путём проверки title страницы
     *
     * @return MortgagePage - т.е. остаемся на этой странице
     */
    public MortgagePage checkOpenMortgagePage() {

        Assertions.assertEquals("Ипотека на вторичное жилье — СберБанк",
                driverManager.getDriver().getTitle(),
                "Заголовок отсутствует/не соответствует требуемому");
        driverManager.getDriver().switchTo().frame(driverManager.getDriver().findElement(By.xpath("//iframe[@id='iFrameResizer0']")));
        return this;
    }

    /**
     * Метод заполнения полей
     *
     * @param inputFields - имя веб элемента, поля ввода
     * @param value     - значение вводимое в поле
     * @return MortgagePage - т.е. остаемся на этой странице
     */
    public MortgagePage fillField(InputFields inputFields, InputFields value) {
        WebElement element = writeValuesToTheLine(inputFields,value.getTitle());
        Assertions.assertEquals(value.getTitle().replaceAll("\\s+",""),
                                element.getAttribute("value").replaceAll("\\s+",""),
                                "Поле '" + inputFields.getTitle() + "' было заполнено некорректно");
        return this;
    }

    /**
     * Метод заполнения поля
     *
     * @param inputFields - имя веб элемента, поля ввода
     * @param value     - значение вводимое в поле
     */
    private WebElement writeValuesToTheLine (InputFields inputFields, String value) {
        WebElement propertyValue = driverManager.getDriver().findElement(By.xpath("//div[@class='_21BkWJCWp6jizol7CbEfrm']//div[text()='" + inputFields.getTitle() + "']/..//input[@class='dc-input__input-5-3-5']"));
        waitUtilElementToBeClickable(propertyValue).click();
        propertyValue.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        propertyValue.sendKeys(value);
        return propertyValue;
    }


    /**
     * Метод заполнения полей
     *
     * @param inputFields - имя веб элемента, поля ввода
     * @param value     - значение вводимое в поле
     * @return MortgagePage - т.е. остаемся на этой странице
     */
    public MortgagePage fillField(String inputFields, String value) {
        WebElement element = writeValuesToTheLine(inputFields,value);
        Assertions.assertEquals(value.replaceAll("\\s+",""),
                element.getAttribute("value").replaceAll("\\s+",""),
                "Поле '" + inputFields + "' было заполнено некорректно");
        return this;
    }

    /**
     * Метод заполнения поля
     *
     * @param inputFields - имя веб элемента, поля ввода
     * @param value     - значение вводимое в поле
     */
    private WebElement writeValuesToTheLine (String inputFields, String value) {
        WebElement propertyValue = driverManager.getDriver().findElement(By.xpath("//div[@class='_21BkWJCWp6jizol7CbEfrm']//div[text()='" + inputFields + "']/..//input[@class='dc-input__input-5-3-5']"));
        waitUtilElementToBeClickable(propertyValue).click();
        propertyValue.sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        propertyValue.sendKeys(value);
        return propertyValue;
    }

    /**
     * Проверка чекбокса поставлен или нет
     *
     * @param nameCheckBox - имя элемента
     * @param flag    - значение элемента
     * @return MortgagePage
     */
    public MortgagePage checkOrUncheckBox(CheckBoxes nameCheckBox, CheckBoxes flag) {

        String loc = "//div[@class='_1SP5M8CKBcG5upuK036cJf']//span[text()='" + nameCheckBox.getTitle() + "']";
        WebElement element = null;
        try {
            element = driverManager.getDriver().findElement(By.xpath(loc));
        }   catch (NoSuchElementException ignored) {
            Assertions.fail("CheckBox с наименованием '" + nameCheckBox.getTitle() + "' отсутствует на странице " +
                    "'Ипотека на готовые квартиры'");
        }
        checkTrueOrFalse(loc, nameCheckBox, flag);
        return this;
    }

    /**
     * Проверка аттрибута у элемента
     *
     * @param nameCheckBox - имя элемента
     * @param flag    - значение элемента
     * @return MortgagePage
     */
    private void checkTrueOrFalse (String loc, CheckBoxes nameCheckBox, CheckBoxes flag) {

        WebElement newElement = driverManager.getDriver().findElement(By.xpath(loc + "/../..//input"));
        if (!newElement.getAttribute("aria-checked").equals(flag.getTitle()))
            newElement.click();
        wait.until(ExpectedConditions.attributeToBe(newElement,
                "aria-checked",
                flag.getTitle()));
        Assertions.assertEquals(flag.getTitle(),
                newElement.getAttribute("aria-checked"),
                "CheckBox '" + nameCheckBox.getTitle() + "' не поставился");
    }

    /**
     * Проверка чекбокса поставлен или нет
     *
     * @param nameCheckBox - имя элемента
     * @param flag    - значение элемента
     * @return MortgagePage
     */
    public MortgagePage checkOrUncheckBox(String nameCheckBox, String flag) {

        String loc = "//div[@class='_1SP5M8CKBcG5upuK036cJf']//span[text()='" + nameCheckBox + "']";
        WebElement element = null;
        try {
            element = driverManager.getDriver().findElement(By.xpath(loc));
        }   catch (NoSuchElementException ignored) {
            Assertions.fail("CheckBox с наименованием '" + nameCheckBox + "' отсутствует на странице " +
                    "'Ипотека на готовые квартиры'");
        }
        checkTrueOrFalse(loc, nameCheckBox, flag);
        return this;
    }

    /**
     * Проверка аттрибута у элемента
     *
     * @param nameCheckBox - имя элемента
     * @param flag    - значение элемента
     * @return MortgagePage
     */
    private void checkTrueOrFalse (String loc, String nameCheckBox, String flag) {

        WebElement newElement = driverManager.getDriver().findElement(By.xpath(loc + "/../..//input"));
        if (!newElement.getAttribute("aria-checked").equals(flag))
            newElement.click();
        wait.until(ExpectedConditions.attributeToBe(newElement,
                "aria-checked",
                flag));
        Assertions.assertEquals(flag,
                newElement.getAttribute("aria-checked"),
                "CheckBox '" + nameCheckBox + "' не поставился");
    }


    /**
     * Проверка заполненных рублевых значений
     *
     * @param checkingValueRub - имя элемента
     * @param valueRub    - ожидаемое значение
     * @return MortgagePage
     */
    public MortgagePage checkingValueRub (CheckingValueRub checkingValueRub, CheckingValueRub valueRub) {

        WebElement checkElement = driverManager.getDriver().findElement(By.xpath("//div[contains(@class,'-BY3mmQFf-kSCS_PJtKHe')]//span[text()='" + checkingValueRub.getTitle() + "']/..//span[contains(text(),'₽')]"));
        Assertions.assertEquals(valueRub.getTitle().replaceAll("\\s+",""),
                checkElement.getText().replaceAll("[^,0-9]", "").replace(",", "."),
                "Поле '" + checkingValueRub.getTitle() + "' было заполнено некорректно");
        return this;
    }

    /**
     * Проверка заполненных рублевых значений
     *
     * @param checkingValueRub - имя элемента
     * @param valueRub    - ожидаемое значение
     * @return MortgagePage
     */
    public MortgagePage checkingValueRub (String checkingValueRub, String valueRub) {

        WebElement checkElement = driverManager.getDriver().findElement(By.xpath("//div[contains(@class,'-BY3mmQFf-kSCS_PJtKHe')]//span[text()='" + checkingValueRub + "']/..//span[contains(text(),'₽')]"));
        Assertions.assertEquals(valueRub.replaceAll("\\s+",""),
                checkElement.getText().replaceAll("[^,0-9]", "").replace(",", "."),
                "Поле '" + checkingValueRub + "' было заполнено некорректно");
        return this;
    }

    /**
     * Проверка заполненных процентных значений
     *
     * @param checkingValuePercent - имя элемента
     * @param valuePercent    - ожидаемое значение
     * @return MortgagePage
     */
    public MortgagePage checkingValuePercent (CheckingValuePercent checkingValuePercent, CheckingValuePercent valuePercent) {

        WebElement checkElement = driverManager.getDriver().findElement(By.xpath("//span[contains(@class,'G L')]/span[contains(text(),'%')]"));
        Assertions.assertEquals(valuePercent.getTitle().replaceAll("\\s+",""),
                checkElement.getText().replaceAll("[^,0-9]", ""),
                "Поле '" + checkingValuePercent.getTitle() + "' было заполнено некорректно");
        return this;
    }

    /**
     * Проверка заполненных процентных значений
     *
     * @param checkingValuePercent - имя элемента
     * @param valuePercent    - ожидаемое значение
     * @return MortgagePage
     */
    public MortgagePage checkingValuePercent (String checkingValuePercent, String valuePercent) {

        WebElement checkElement = driverManager.getDriver().findElement(By.xpath("//span[contains(@class,'G L')]/span[contains(text(),'%')]"));
        Assertions.assertEquals(valuePercent.replaceAll("\\s+",""),
                checkElement.getText().replaceAll("[^,0-9]", ""),
                "Поле '" + checkingValuePercent + "' было заполнено некорректно");
        return this;
    }

    /**
     * Засыпание на 3 секунды
     */
    public MortgagePage sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {
        }
        return this;
    }

}