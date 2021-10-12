package Categories;

public enum CheckingValuePercent {

    INTEREST_RATE ("Процентная ставка"),
    INTEREST_RATE_VALUE ("11");

    private String title;

    CheckingValuePercent(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
