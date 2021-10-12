package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.И;
import managers.PageManager;

public class MortgagePageSteps {

    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Проверяем что открылась страница 'Ипотека на готовые квартиры'$")
    public void checkOpenMortgagePage() {
        pageManager.getMortgagePage().checkOpenMortgagePage();
    }

    @И("^Заполняем поля формы:$")
    public void fillField(DataTable mapFieldsAndValue) {
        mapFieldsAndValue.asMap(String.class, String.class).forEach((key, value) ->
                pageManager.getMortgagePage().fillField((String) key, (String) value));
    }

    @И("^(Поставить|Убрать) галочку \"(.+)\"$")
    public void checkOrUncheckBox(String nameCheckBox, String flag) {
        pageManager.getMortgagePage().checkOrUncheckBox(nameCheckBox, flag);
    }

    @И("^Подождать загрузку данных")
    public void sleep() {
        pageManager.getMortgagePage().sleep();
    }

    @И("^Проверить расчет (рубли)")
    public void checkingValueRub(DataTable mapFieldsAndValue) {
        mapFieldsAndValue.asMap(String.class, String.class).forEach((key, value) ->
                pageManager.getMortgagePage().checkingValueRub((String) key, (String) value));
    }

    @И("^Проверить расчет (проценты)")
    public void checkingValuePercent(DataTable mapFieldsAndValue) {
        mapFieldsAndValue.asMap(String.class, String.class).forEach((key, value) ->
                pageManager.getMortgagePage().checkingValuePercent((String) key, (String) value));
    }

}
