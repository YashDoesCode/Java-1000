import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Expense implements Comparable<Expense> {
    private String id;
    private double amount;
    private Category category;
    private String desc;
    private LocalDateTime date;
    
    public Expense(String id, double amount, Category category, String desc) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.desc = desc;
        this.date = LocalDateTime.now();
    }
    
    public Expense(String id, double amount, Category category, String desc, LocalDateTime date) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.desc = desc;
        this.date = date;
    }
    
    @Override
    public int compareTo(Expense other) {
        int dateComp = this.date.compareTo(other.date);
        return dateComp != 0 ? dateComp : this.id.compareTo(other.id);
    }
    
    public String getId() { return id; }
    public double getAmount() { return amount; }
    public Category getCategory() { return category; }
    public String getDesc() { return desc; }
    public LocalDateTime getDate() { return date; }
    
    public void setAmount(double amount) { this.amount = amount; }
    public void setCategory(Category category) { this.category = category; }
    public void setDesc(String desc) { this.desc = desc; }
    
    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm");
        return String.format("₹%.2f | %s | %s | %s", 
                amount, category.name(), desc, date.format(fmt));
    }
    
    public String toJson() {
        return String.format("{\"id\":\"%s\",\"amount\":%.2f,\"category\":\"%s\",\"desc\":\"%s\",\"date\":\"%s\"}", 
                id, amount, category.name(), desc, date.toString());
    }
}