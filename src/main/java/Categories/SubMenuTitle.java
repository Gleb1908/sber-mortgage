package Categories;

public enum SubMenuTitle {

    ALL_MORTGAGES ("Все ипотечные кредиты"),
    MORTGAGE_FOR_SECONDARY_BUILDINGS ("Ипотека на вторичное жильё"),
    MORTGAGE_FOR_NEW_BUILDINGS ("Ипотека на новостройки"),
    MORTGAGE_REFINANCING ("Рефинансирование ипотеки"),
    MORTGAGE_WITH_STATE_SUPPORT ("Ипотека с господдержкой от 0,1%"),
    USEFUL ("Полезное"),
    MORTGAGE_QUESTIONS ("Вопросы по ипотеке"),
    PERSONAL_ACCOUNT_DOMCLICK ("Личный кабинет ДомКлик"),
    FIND_AN_APARTMENT ("Найти квартиру"),
    ESTIMATE_THE_COST_OF_THE_APARTMENT ("Оценить стоимость квартиры"),
    MORTGAGE_HOLIDAYS ("Ипотечные каникулы");

    private String title;

    SubMenuTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
