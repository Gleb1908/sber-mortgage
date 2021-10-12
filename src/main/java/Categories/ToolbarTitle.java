package Categories;

public enum ToolbarTitle {

    CREDITS ("Кредиты"),
    MORTGAGE ("Ипотека"),
    CARDS ("Карты"),
    DEPOSITS ("Вклады"),
    INVESTMENTS ("Инвестиции"),
    PAYMENTS ("Платежи"),
    TRANSLATION ("Переводы"),
    INSURANCE ("Страхование"),
    SUPPORT ("Поддержка"),
    SERVICES ("Сервисы"),
    PREMIUM ("Премиум");

    private String title;

    ToolbarTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
