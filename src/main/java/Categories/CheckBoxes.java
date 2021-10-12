package Categories;

public enum CheckBoxes {

    TRUE ("true"),
    FALSE ("false"),
    DISCOUNT_DOM_CLICK ("Скидка 0,3% при покупке недвижимости на ДомКлик"),
    LIFE_INSURANCE ("Страхование жизни и здоровья"),
    YOUNG_SEVEN ("Молодая семья"),
    ELECTRONIC_TRANSACTION ("Электронная регистрация сделки");

    private String title;

    CheckBoxes(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
