package app.controllers;

public enum Category {
    IT("IT"),
    ENTERTAINMENT("entertainment"),
    EDUCATION("education");

    private String categoryValue;

    Category(String categoryValue) {
        this.categoryValue = categoryValue;
    }
}
