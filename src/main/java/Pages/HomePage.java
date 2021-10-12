package Pages;

import Categories.SubMenuTitle;
import Categories.ToolbarTitle;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//button[contains(@class,'cookie-warning')]")
    private WebElement cookiesButtonClose;

    @FindBy(xpath = "//nav[@aria-label='Основное меню']//li[contains(@class,'item_first')]")
    private List<WebElement> listToolbarTitle;



    /**
     * Закрытия сообщения cookies
     *
     * @return HomePage - т.е. остаемся на этой странице
     */
    public HomePage closeCookiesWindow() {
        waitUtilElementToBeClickable(cookiesButtonClose).click();
        return this;
    }


//    /**
//     * Функция клика на любой пункт мени и подменю
//     *
//     * @param toolbarTitle - наименование меню
//     * @return MortgagePage - т.е. переходим на страницу выбранного подменю
//     */
//    public MortgagePage selectToolbarTitleAndSubMenu(ToolbarTitle toolbarTitle, SubMenuTitle subMenuTitle) {
//        selectToolbarTitle(toolbarTitle);
//        selectSubMenu(toolbarTitle, subMenuTitle);
//        return pageManager.getMortgagePage();
//    }
//
//
//    /**
//     * Функция клика на любой пункт меню
//     *
//     * @param toolbarTitle - наименование меню
//     * @return HomePage - т.е. остаемся на этой странице
//     */
//    private void selectToolbarTitle(ToolbarTitle toolbarTitle) {
//        for (WebElement toolbarTitleItem : listToolbarTitle) {
//            if (toolbarTitleItem.getText().equals(toolbarTitle.getTitle())) {
//                waitUtilElementToBeClickable(toolbarTitleItem).click();
//            }
//        }
//    }
//
//    /**
//     * Функция клика на любое подменю
//     *
//     * @param subMenuTitle - наименование подменю
//     * @return InsurancePage - т.е. переходим на страницу {@link MortgagePage}
//     */
//    private void selectSubMenu(ToolbarTitle toolbarTitle, SubMenuTitle subMenuTitle) {
//        String subMenuTitleLog = "//a[contains(text(),'" + toolbarTitle.getTitle() + "')]/..//li[contains(@class,'menu__item')]/a[text()='" + subMenuTitle.getTitle() + "']";
//        try {
//            WebElement element = driverManager.getDriver().findElement(By.xpath(subMenuTitleLog));
//            element.click();
//        } catch (NoSuchElementException ignored) {
//            Assertions.fail("Подменю '" + subMenuTitle.getTitle() + "' не найдено на стартовой странице");
//        }
//    }


    /**
     * Функция клика на любой пункт мени и подменю
     *
     * @param toolbarTitle - наименование меню
     * @return MortgagePage - т.е. переходим на страницу выбранного подменю
     */
    public MortgagePage selectToolbarTitleAndSubMenu(String toolbarTitle, String subMenuTitle) {
        selectToolbarTitle(toolbarTitle);
        selectSubMenu(toolbarTitle, subMenuTitle);
        return pageManager.getMortgagePage();
    }


    /**
     * Функция клика на любой пункт меню
     *
     * @param toolbarTitle - наименование меню
     * @return HomePage - т.е. остаемся на этой странице
     */
    private void selectToolbarTitle(String toolbarTitle) {
        for (WebElement toolbarTitleItem : listToolbarTitle) {
            if (toolbarTitleItem.getText().equals(toolbarTitle)) {
                waitUtilElementToBeClickable(toolbarTitleItem).click();
            }
        }
    }

    /**
     * Функция клика на любое подменю
     *
     * @param subMenuTitle - наименование подменю
     * @return InsurancePage - т.е. переходим на страницу {@link MortgagePage}
     */
    private void selectSubMenu(String toolbarTitle, String subMenuTitle) {
        String subMenuTitleLog = "//a[contains(text(),'" + toolbarTitle + "')]/..//li[contains(@class,'menu__item')]/a[text()='" + subMenuTitle + "']";
        try {
            WebElement element = driverManager.getDriver().findElement(By.xpath(subMenuTitleLog));
            element.click();
        } catch (NoSuchElementException ignored) {
            Assertions.fail("Подменю '" + subMenuTitle + "' не найдено на стартовой странице");
        }
    }

}
