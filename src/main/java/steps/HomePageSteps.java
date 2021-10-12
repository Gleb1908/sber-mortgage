package steps;

import io.cucumber.java.ru.И;
import managers.PageManager;

public class HomePageSteps {

    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Закрытия сообщения cookies$")
    public void closeCookiesDialog() {
        pageManager.getHomePage().closeCookiesWindow();
    }

    @И("^Выбираем \"(.+)\" в главном меню и \"(.+)\" в подменю$")
    public void selectToolbarTitleAndSubMenu(String toolbarTitle, String subMenuTitle) {
        pageManager.getHomePage().selectToolbarTitleAndSubMenu(toolbarTitle, subMenuTitle);
    }

}
