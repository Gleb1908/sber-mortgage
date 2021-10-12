package Categories;

public enum InputFields {

    INITIAL_CONTRIBUTION ("Первоначальный взнос"),
    INITIAL_CONTRIBUTION_VALUE ("3058000"),
    PROPERTY_VALUE ("Стоимость недвижимости"),
    PROPERTY_VALUE_VALUE ("5180000");

    private String title;

    InputFields(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
