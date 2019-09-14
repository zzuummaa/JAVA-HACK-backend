package app;

public enum Category {
    IT("IT"),
    ENTERTAINMENT("entertainment"),
    EDUCATION("education");

    private String categoryValue;

    Category(String categoryValue) {
        this.categoryValue = categoryValue;
    }

    public static Category valueOfIgnoreCase(String channelName) {
        channelName = channelName.toUpperCase();
        return valueOf(channelName);
    }
}
