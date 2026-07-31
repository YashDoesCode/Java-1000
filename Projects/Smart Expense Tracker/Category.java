public enum Category {
    FOOD("Food & Dining", "🍽️"),
    TRANSPORT("Transportation", "🚗"),
    SHOPPING("Shopping", "🛒"),
    ENTERTAINMENT("Entertainment", "🎬"),
    BILLS("Bills & Utilities", "💡"),
    HEALTH("Healthcare", "🏥"),
    EDUCATION("Education", "📚"),
    TRAVEL("Travel", "✈️"),
    GROCERIES("Groceries", "🥕"),
    OTHER("Miscellaneous", "📦");
    
    private final String displayName;
    private final String icon;
    
    Category(String displayName, String icon) {
        this.displayName = displayName;
        this.icon = icon;
    }
    
    public String getDisplayName() { return displayName; }
    public String getIcon() { return icon; }
    
    @Override
    public String toString() {
        return icon + " " + displayName;
    }
}