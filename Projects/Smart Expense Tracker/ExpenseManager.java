import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;

public class ExpenseManager {
    private TreeSet<Expense> expenses;
    private Map<Category, List<Expense>> categoryMap;
    private Map<String, Expense> idMap;
    private long nextId;
    
    public ExpenseManager() {
        this.expenses = new TreeSet<>();
        this.categoryMap = new HashMap<>();
        this.idMap = new HashMap<>();
        this.nextId = 1;
        
        for (Category cat : Category.values()) {
            categoryMap.put(cat, new ArrayList<>());
        }
    }
    
    public boolean addExpense(double amount, Category category, String desc) {
        if (amount <= 0 || desc == null || desc.trim().isEmpty()) {
            return false;
        }
        
        String id = "EXP" + String.format("%04d", nextId++);
        Expense expense = new Expense(id, amount, category, desc.trim());
        
        expenses.add(expense);
        categoryMap.get(category).add(expense);
        idMap.put(id, expense);
        
        return true;
    }
    
    public boolean removeExpense(String id) {
        Expense expense = idMap.get(id);
        if (expense == null) return false;
        
        expenses.remove(expense);
        categoryMap.get(expense.getCategory()).remove(expense);
        idMap.remove(id);
        
        return true;
    }
    
    public boolean updateExpense(String id, Double amount, Category category, String desc) {
        Expense expense = idMap.get(id);
        if (expense == null) return false;
        
        expenses.remove(expense);
        categoryMap.get(expense.getCategory()).remove(expense);
        
        if (amount != null && amount > 0) expense.setAmount(amount);
        if (category != null) expense.setCategory(category);
        if (desc != null && !desc.trim().isEmpty()) expense.setDesc(desc.trim());
        
        expenses.add(expense);
        categoryMap.get(expense.getCategory()).add(expense);
        
        return true;
    }
    
    public List<Expense> getAllExpenses() {
        return new ArrayList<>(expenses);
    }
    
    public List<Expense> getExpensesByCategory(Category category) {
        return new ArrayList<>(categoryMap.get(category));
    }
    
    public List<Expense> searchExpenses(String keyword) {
        List<Expense> results = new ArrayList<>();
        String search = keyword.toLowerCase().trim();
        
        for (Expense exp : expenses) {
            if (exp.getDesc().toLowerCase().contains(search) || 
                exp.getCategory().getDisplayName().toLowerCase().contains(search)) {
                results.add(exp);
            }
        }
        
        return results;
    }
    
    public List<Expense> getRecentExpenses(int count) {
        List<Expense> recent = new ArrayList<>();
        List<Expense> all = getAllExpenses();
        
        Collections.reverse(all);
        
        for (int i = 0; i < Math.min(count, all.size()); i++) {
            recent.add(all.get(i));
        }
        
        return recent;
    }
    
    public double getTotalExpenses() {
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }
    
    public Map<Category, Double> getCategoryTotals() {
        Map<Category, Double> totals = new HashMap<>();
        
        for (Category cat : Category.values()) {
            double total = categoryMap.get(cat).stream()
                    .mapToDouble(Expense::getAmount).sum();
            totals.put(cat, total);
        }
        
        return totals;
    }
    
    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("[");
            
            List<Expense> allExpenses = getAllExpenses();
            for (int i = 0; i < allExpenses.size(); i++) {
                writer.print("  " + allExpenses.get(i).toJson());
                if (i < allExpenses.size() - 1) writer.print(",");
                writer.println();
            }
            
            writer.println("]");
            System.out.println("✓ Data saved to " + filename);
        } catch (IOException e) {
            System.out.println("✗ Error saving data: " + e.getMessage());
        }
    }
    
    public int getExpenseCount() {
        return expenses.size();
    }
    
    public Expense findExpenseById(String id) {
        return idMap.get(id);
    }
}