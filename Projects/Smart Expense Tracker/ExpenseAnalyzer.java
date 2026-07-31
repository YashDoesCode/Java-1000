import java.util.*;
import java.util.stream.Collectors;

public class ExpenseAnalyzer {
    private ExpenseManager manager;
    
    public ExpenseAnalyzer(ExpenseManager manager) {
        this.manager = manager;
    }
    
    public void generateReport() {
        List<Expense> expenses = manager.getAllExpenses();
        if (expenses.isEmpty()) {
            System.out.println("📊 No expenses to analyze");
            return;
        }
        
        System.out.println("📊 EXPENSE ANALYSIS REPORT");
        System.out.println("=" + "=".repeat(50));
        
        double total = manager.getTotalExpenses();
        System.out.printf("💰 Total Expenses: ₹%.2f%n", total);
        System.out.printf("📝 Total Transactions: %d%n", expenses.size());
        System.out.printf("📈 Average per Transaction: ₹%.2f%n", total / expenses.size());
        System.out.println();
        
        showCategoryBreakdown();
        showTopExpenses(5);
        showSpendingInsights();
    }
    
    private void showCategoryBreakdown() {
        System.out.println("📂 CATEGORY BREAKDOWN");
        System.out.println("-".repeat(30));
        
        Map<Category, Double> totals = manager.getCategoryTotals();
        double grandTotal = manager.getTotalExpenses();
        
        List<Map.Entry<Category, Double>> sorted = totals.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
                .collect(Collectors.toList());
        
        for (Map.Entry<Category, Double> entry : sorted) {
            Category cat = entry.getKey();
            double amount = entry.getValue();
            double percentage = (amount / grandTotal) * 100;
            
            System.out.printf("%-20s ₹%8.2f (%5.1f%%)%n", 
                    cat.toString(), amount, percentage);
        }
        System.out.println();
    }
    
    private void showTopExpenses(int count) {
        System.out.println("🔝 TOP " + count + " EXPENSES");
        System.out.println("-".repeat(30));
        
        List<Expense> topExpenses = manager.getAllExpenses().stream()
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .limit(count)
                .collect(Collectors.toList());
        
        for (int i = 0; i < topExpenses.size(); i++) {
            Expense exp = topExpenses.get(i);
            System.out.printf("%d. ₹%.2f - %s (%s)%n", 
                    i + 1, exp.getAmount(), exp.getDesc(), exp.getCategory().getDisplayName());
        }
        System.out.println();
    }
    
    private void showSpendingInsights() {
        System.out.println("💡 SPENDING INSIGHTS");
        System.out.println("-".repeat(30));
        
        Map<Category, Double> totals = manager.getCategoryTotals();
        double total = manager.getTotalExpenses();
        
        Category topCategory = totals.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        
        if (topCategory != null) {
            double topAmount = totals.get(topCategory);
            System.out.printf("• Highest spending: %s (₹%.2f)%n", 
                    topCategory.getDisplayName(), topAmount);
        }
        
        List<Expense> recent = manager.getRecentExpenses(10);
        if (recent.size() >= 3) {
            double recentAvg = recent.stream()
                    .mapToDouble(Expense::getAmount)
                    .average().orElse(0);
            System.out.printf("• Recent average: ₹%.2f per transaction%n", recentAvg);
        }
        
        long uniqueCategories = totals.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .count();
        System.out.printf("• Active categories: %d out of %d%n", 
                uniqueCategories, Category.values().length);
        
        System.out.println();
    }
    
    public Map<Category, Integer> getCategoryFrequency() {
        Map<Category, Integer> frequency = new HashMap<>();
        
        for (Expense exp : manager.getAllExpenses()) {
            frequency.put(exp.getCategory(), 
                    frequency.getOrDefault(exp.getCategory(), 0) + 1);
        }
        
        return frequency;
    }
    
    public List<Expense> getExpensesAbove(double threshold) {
        return manager.getAllExpenses().stream()
                .filter(exp -> exp.getAmount() > threshold)
                .sorted((a, b) -> Double.compare(b.getAmount(), a.getAmount()))
                .collect(Collectors.toList());
    }
    
    public double getAverageExpense() {
        List<Expense> expenses = manager.getAllExpenses();
        if (expenses.isEmpty()) return 0;
        
        return expenses.stream()
                .mapToDouble(Expense::getAmount)
                .average().orElse(0);
    }
    
    public Category getMostFrequentCategory() {
        return getCategoryFrequency().entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}