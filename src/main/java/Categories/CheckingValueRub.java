package Categories;

public enum CheckingValueRub {

    DISCOUNT_DOM_CLICK ("Сумма кредита"),
    DISCOUNT_DOM_CLICK_VALUE ("2 122 000"),

    MONTHLY_PAYMENTS ("Ежемесячный платеж"),
    MONTHLY_PAYMENTS_VALUE ("16 922"),

    REQUIRED_INCOME ("Необходимый доход"),
    REQUIRED_INCOME_VALUE ("21 784");

    private String title;

    CheckingValueRub(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
