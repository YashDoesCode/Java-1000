import java.util.*;

public class BudgetTracker {
    private Map<Category, Double> budgets;
    private PriorityQueue<BudgetAlert> alerts;
    private ExpenseManager manager;
    
    public BudgetTracker(ExpenseManager manager) {
        this.budgets = new HashMap<>();
        this.alerts = new PriorityQueue<>((a, b) -> Double.compare(b.urgency, a.urgency));
        this.manager = manager;
    }
    
    public void setBudget(Category category, double amount) {
        if (amount <= 0) return;
        budgets.put(category, amount);
        checkBudgetAlerts();
    }
    
    public void removeBudget(Category category) {
        budgets.remove(category);
        alerts.removeIf(alert -> alert.category == category);
    }
    
    public Map<Category, Double> getAllBudgets() {
        return new HashMap<>(budgets);
    }
    
    public BudgetStatus getBudgetStatus(Category category) {
        if (!budgets.containsKey(category)) {
            return new BudgetStatus(category, 0, 0, 0, "No budget set");
        }
        
        double budget = budgets.get(category);
        double spent = manager.getCategoryTotals().get(category);
        double remaining = budget - spent;
        double percentage = (spent / budget) * 100;
        
        String status;
        if (percentage >= 100) status = "OVER BUDGET";
        else if (percentage >= 80) status = "WARNING";
        else if (percentage >= 60) status = "CAUTION";
        else status = "GOOD";
        
        return new BudgetStatus(category, budget, spent, remaining, status);
    }
    
    public List<BudgetStatus> getAllBudgetStatus() {
        List<BudgetStatus> statusList = new ArrayList<>();
        for (Category category : budgets.keySet()) {
            statusList.add(getBudgetStatus(category));
        }
        return statusList;
    }
    
    private void checkBudgetAlerts() {
        alerts.clear();
        Map<Category, Double> spent = manager.getCategoryTotals();
        
        for (Map.Entry<Category, Double> entry : budgets.entrySet()) {
            Category cat = entry.getKey();
            double budget = entry.getValue();
            double spentAmount = spent.get(cat);
            double percentage = (spentAmount / budget) * 100;
            
            if (percentage >= 80) {
                double urgency = percentage >= 100 ? 100 : percentage;
                String message = String.format("%s budget %s (₹%.2f/₹%.2f)", 
                        cat.getDisplayName(),
                        percentage >= 100 ? "exceeded" : "warning",
                        spentAmount, budget);
                alerts.offer(new BudgetAlert(cat, message, urgency));
            }
        }
    }
    
    public List<BudgetAlert> getTopAlerts(int count) {
        checkBudgetAlerts();
        List<BudgetAlert> topAlerts = new ArrayList<>();
        PriorityQueue<BudgetAlert> temp = new PriorityQueue<>(alerts);
        
        for (int i = 0; i < Math.min(count, temp.size()); i++) {
            topAlerts.add(temp.poll());
        }
        
        return topAlerts;
    }
    
    public double getTotalBudget() {
        return budgets.values().stream().mapToDouble(Double::doubleValue).sum();
    }
    
    public double getTotalSpent() {
        return manager.getTotalExpenses();
    }
    
    public boolean hasAnyBudgets() {
        return !budgets.isEmpty();
    }
    
    static class BudgetAlert {
        Category category;
        String message;
        double urgency;
        
        BudgetAlert(Category category, String message, double urgency) {
            this.category = category;
            this.message = message;
            this.urgency = urgency;
        }
        
        @Override
        public String toString() {
            String icon = urgency >= 100 ? "🚨" : "⚠️";
            return icon + " " + message;
        }
    }
    
    public static class BudgetStatus {
        public final Category category;
        public final double budget;
        public final double spent;
        public final double remaining;
        public final String status;
        
        BudgetStatus(Category category, double budget, double spent, double remaining, String status) {
            this.category = category;
            this.budget = budget;
            this.spent = spent;
            this.remaining = remaining;
            this.status = status;
        }
        
        @Override
        public String toString() {
            if (budget == 0) return category + ": No budget set";
            
            String statusIcon = switch (status) {
                case "OVER BUDGET" -> "🚨";
                case "WARNING" -> "⚠️";
                case "CAUTION" -> "🟡";
                default -> "✅";
            };
            
            return String.format("%s %s: ₹%.2f/₹%.2f (₹%.2f %s)", 
                    statusIcon, category.getDisplayName(), 
                    spent, budget, 
                    Math.abs(remaining), 
                    remaining >= 0 ? "remaining" : "over");
        }
    }
}