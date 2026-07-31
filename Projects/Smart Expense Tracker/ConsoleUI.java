import java.util.*;

public class ConsoleUI {
    private Scanner input;
    private ExpenseManager manager;
    private BudgetTracker budget;
    private ExpenseAnalyzer analyzer;
    
    public ConsoleUI() {
        this.input = new Scanner(System.in);
        this.manager = new ExpenseManager();
        this.budget = new BudgetTracker(manager);
        this.analyzer = new ExpenseAnalyzer(manager);
    }
    
    public void start() {
        showWelcome();
        loadSampleData();
        
        while (true) {
            showMainMenu();
            
            try {
                int choice = Integer.parseInt(input.nextLine().trim());
                
                switch (choice) {
                    case 1 -> addNewExpense();
                    case 2 -> viewAllExpenses();
                    case 3 -> viewByCategory();
                    case 4 -> searchExpenses();
                    case 5 -> manageBudgets();
                    case 6 -> viewReports();
                    case 7 -> updateExpense();
                    case 8 -> deleteExpense();
                    case 9 -> saveAndExit();
                    default -> System.out.println("❌ Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number.");
            }
            
            System.out.println("Press Enter to continue...");
            input.nextLine();
        }
    }
    
    private void showWelcome() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("💰 SMART EXPENSE TRACKER");
        System.out.println("   Track • Analyze • Budget • Save");
        System.out.println("=".repeat(60));
    }
    
    private void showMainMenu() {
        System.out.println("\n🏠 MAIN MENU");
        System.out.println("1. ➕ Add New Expense");
        System.out.println("2. 📋 View All Expenses");
        System.out.println("3. 📂 View by Category");
        System.out.println("4. 🔍 Search Expenses");
        System.out.println("5. 💵 Manage Budgets");
        System.out.println("6. 📊 View Reports");
        System.out.println("7. ✏️  Update Expense");
        System.out.println("8. 🗑️  Delete Expense");
        System.out.println("9. 💾 Save & Exit");
        
        showQuickStats();
        System.out.print("\nEnter your choice: ");
    }
    
    private void showQuickStats() {
        int count = manager.getExpenseCount();
        double total = manager.getTotalExpenses();
        
        System.out.println();
        System.out.printf("📊 Quick Stats: %d expenses • ₹%.2f total", count, total);
        
        List<BudgetTracker.BudgetAlert> alerts = budget.getTopAlerts(1);
        if (!alerts.isEmpty()) {
            System.out.printf(" • %s", alerts.get(0).message);
        }
    }
    
    private void addNewExpense() {
        System.out.println("\n➕ ADD NEW EXPENSE");
        System.out.println("-".repeat(25));
        
        System.out.print("💰 Amount: ₹");
        double amount;
        try {
            amount = Double.parseDouble(input.nextLine().trim());
            if (amount <= 0) {
                System.out.println("❌ Amount must be positive");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid amount");
            return;
        }
        
        System.out.println("\n📂 Choose Category:");
        Category[] categories = Category.values();
        for (int i = 0; i < categories.length; i++) {
            System.out.printf("%2d. %s%n", i + 1, categories[i]);
        }
        
        System.out.print("Enter category number: ");
        int catChoice;
        try {
            catChoice = Integer.parseInt(input.nextLine().trim());
            if (catChoice < 1 || catChoice > categories.length) {
                System.out.println("❌ Invalid category");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid category number");
            return;
        }
        
        System.out.print("📝 Description: ");
        String desc = input.nextLine().trim();
        
        if (manager.addExpense(amount, categories[catChoice - 1], desc)) {
            System.out.printf("✅ Expense added: ₹%.2f for %s%n", amount, desc);
            
            List<BudgetTracker.BudgetAlert> newAlerts = budget.getTopAlerts(1);
            if (!newAlerts.isEmpty() && newAlerts.get(0).category == categories[catChoice - 1]) {
                System.out.println("⚠️  " + newAlerts.get(0).message);
            }
        } else {
            System.out.println("❌ Failed to add expense");
        }
    }
    
    private void viewAllExpenses() {
        System.out.println("\n📋 ALL EXPENSES");
        System.out.println("-".repeat(25));
        
        List<Expense> expenses = manager.getAllExpenses();
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }
        
        Collections.reverse(expenses);
        
        for (int i = 0; i < Math.min(20, expenses.size()); i++) {
            Expense exp = expenses.get(i);
            System.out.printf("%s [%s]%n", exp.toString(), exp.getId());
        }
        
        if (expenses.size() > 20) {
            System.out.printf("... and %d more expenses%n", expenses.size() - 20);
        }
        
        System.out.printf("%nTotal: ₹%.2f from %d expenses%n", 
                manager.getTotalExpenses(), expenses.size());
    }
    
    private void viewByCategory() {
        System.out.println("\n📂 VIEW BY CATEGORY");
        System.out.println("-".repeat(25));
        
        Map<Category, Double> totals = manager.getCategoryTotals();
        
        for (Category cat : Category.values()) {
            double total = totals.get(cat);
            List<Expense> catExpenses = manager.getExpensesByCategory(cat);
            
            if (!catExpenses.isEmpty()) {
                System.out.printf("%n%s: ₹%.2f (%d expenses)%n", 
                        cat.toString(), total, catExpenses.size());
                
                catExpenses.stream()
                        .sorted((a, b) -> b.getDate().compareTo(a.getDate()))
                        .limit(3)
                        .forEach(exp -> System.out.printf("  • %s - ₹%.2f%n", 
                                exp.getDesc(), exp.getAmount()));
                
                if (catExpenses.size() > 3) {
                    System.out.printf("  ... and %d more%n", catExpenses.size() - 3);
                }
            }
        }
    }
    
    private void searchExpenses() {
        System.out.println("\n🔍 SEARCH EXPENSES");
        System.out.println("-".repeat(25));
        
        System.out.print("Enter keyword: ");
        String keyword = input.nextLine().trim();
        
        if (keyword.isEmpty()) {
            System.out.println("❌ Please enter a search term");
            return;
        }
        
        List<Expense> results = manager.searchExpenses(keyword);
        
        if (results.isEmpty()) {
            System.out.println("No expenses found matching: " + keyword);
            return;
        }
        
        System.out.printf("Found %d results:%n", results.size());
        results.forEach(exp -> System.out.printf("%s [%s]%n", exp.toString(), exp.getId()));
        
        double total = results.stream().mapToDouble(Expense::getAmount).sum();
        System.out.printf("Total: ₹%.2f%n", total);
    }
    
    private void manageBudgets() {
        System.out.println("\n💵 BUDGET MANAGEMENT");
        System.out.println("-".repeat(25));
        
        System.out.println("1. Set Budget");
        System.out.println("2. View Budget Status");
        System.out.println("3. Remove Budget");
        System.out.print("Choose: ");
        
        try {
            int choice = Integer.parseInt(input.nextLine().trim());
            
            switch (choice) {
                case 1 -> setBudget();
                case 2 -> viewBudgetStatus();
                case 3 -> removeBudget();
                default -> System.out.println("❌ Invalid choice");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid choice");
        }
    }
    
    private void setBudget() {
        System.out.println("\n💵 SET BUDGET");
        
        Category[] categories = Category.values();
        for (int i = 0; i < categories.length; i++) {
            System.out.printf("%2d. %s%n", i + 1, categories[i]);
        }
        
        System.out.print("Choose category: ");
        try {
            int catChoice = Integer.parseInt(input.nextLine().trim());
            if (catChoice < 1 || catChoice > categories.length) {
                System.out.println("❌ Invalid category");
                return;
            }
            
            System.out.print("Budget amount: ₹");
            double amount = Double.parseDouble(input.nextLine().trim());
            
            if (amount <= 0) {
                System.out.println("❌ Budget must be positive");
                return;
            }
            
            budget.setBudget(categories[catChoice - 1], amount);
            System.out.printf("✅ Budget set: %s - ₹%.2f%n", 
                    categories[catChoice - 1].getDisplayName(), amount);
            
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid input");
        }
    }
    
    private void viewBudgetStatus() {
        System.out.println("\n📊 BUDGET STATUS");
        System.out.println("-".repeat(25));
        
        List<BudgetTracker.BudgetStatus> statusList = budget.getAllBudgetStatus();
        
        if (statusList.isEmpty()) {
            System.out.println("No budgets set yet.");
            return;
        }
        
        for (BudgetTracker.BudgetStatus status : statusList) {
            System.out.println(status);
        }
        
        System.out.printf("%nTotal Budget: ₹%.2f | Total Spent: ₹%.2f%n", 
                budget.getTotalBudget(), budget.getTotalSpent());
        
        List<BudgetTracker.BudgetAlert> alerts = budget.getTopAlerts(5);
        if (!alerts.isEmpty()) {
            System.out.println("\n🚨 ACTIVE ALERTS:");
            alerts.forEach(System.out::println);
        }
    }
    
    private void removeBudget() {
        System.out.println("\n🗑️ REMOVE BUDGET");
        
        if (!budget.hasAnyBudgets()) {
            System.out.println("No budgets to remove.");
            return;
        }
        
        Map<Category, Double> budgets = budget.getAllBudgets();
        List<Category> budgetList = new ArrayList<>(budgets.keySet());
        
        for (int i = 0; i < budgetList.size(); i++) {
            Category cat = budgetList.get(i);
            System.out.printf("%d. %s (₹%.2f)%n", i + 1, cat.getDisplayName(), budgets.get(cat));
        }
        
        System.out.print("Choose budget to remove: ");
        try {
            int choice = Integer.parseInt(input.nextLine().trim());
            if (choice < 1 || choice > budgetList.size()) {
                System.out.println("❌ Invalid choice");
                return;
            }
            
            Category toRemove = budgetList.get(choice - 1);
            budget.removeBudget(toRemove);
            System.out.printf("✅ Removed budget for %s%n", toRemove.getDisplayName());
            
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid choice");
        }
    }
    
    private void viewReports() {
        System.out.println("\n📊 EXPENSE REPORTS");
        System.out.println("-".repeat(25));
        
        analyzer.generateReport();
    }
    
    private void updateExpense() {
        System.out.println("\n✏️ UPDATE EXPENSE");
        System.out.println("-".repeat(25));
        
        System.out.print("Enter expense ID: ");
        String id = input.nextLine().trim().toUpperCase();
        
        Expense expense = manager.findExpenseById(id);
        if (expense == null) {
            System.out.println("❌ Expense not found: " + id);
            return;
        }
        
        System.out.println("Current: " + expense);
        System.out.println("Leave blank to keep current value");
        
        System.out.printf("New amount (current: ₹%.2f): ₹", expense.getAmount());
        String amountStr = input.nextLine().trim();
        Double newAmount = null;
        if (!amountStr.isEmpty()) {
            try {
                newAmount = Double.parseDouble(amountStr);
                if (newAmount <= 0) {
                    System.out.println("❌ Amount must be positive");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid amount");
                return;
            }
        }
        
        System.out.printf("New description (current: %s): ", expense.getDesc());
        String newDesc = input.nextLine().trim();
        if (newDesc.isEmpty()) newDesc = null;
        
        if (manager.updateExpense(id, newAmount, null, newDesc)) {
            System.out.println("✅ Expense updated successfully");
        } else {
            System.out.println("❌ Failed to update expense");
        }
    }
    
    private void deleteExpense() {
        System.out.println("\n🗑️ DELETE EXPENSE");
        System.out.println("-".repeat(25));
        
        System.out.print("Enter expense ID: ");
        String id = input.nextLine().trim().toUpperCase();
        
        Expense expense = manager.findExpenseById(id);
        if (expense == null) {
            System.out.println("❌ Expense not found: " + id);
            return;
        }
        
        System.out.println("Are you sure you want to delete:");
        System.out.println(expense);
        System.out.print("Type 'YES' to confirm: ");
        
        if ("YES".equals(input.nextLine().trim())) {
            if (manager.removeExpense(id)) {
                System.out.println("✅ Expense deleted successfully");
            } else {
                System.out.println("❌ Failed to delete expense");
            }
        } else {
            System.out.println("❌ Delete cancelled");
        }
    }
    
    private void saveAndExit() {
        System.out.println("\n💾 SAVING DATA...");
        manager.saveToFile("expenses.json");
        
        System.out.println("\n👋 Thank you for using Smart Expense Tracker!");
        System.out.println("📊 Session Summary:");
        System.out.printf("   • Total Expenses: ₹%.2f%n", manager.getTotalExpenses());
        System.out.printf("   • Total Transactions: %d%n", manager.getExpenseCount());
        
        if (budget.hasAnyBudgets()) {
            System.out.printf("   • Budget Status: ₹%.2f/₹%.2f%n", 
                    budget.getTotalSpent(), budget.getTotalBudget());
        }
        
        System.exit(0);
    }
    
    private void loadSampleData() {
        manager.addExpense(250.0, Category.FOOD, "Lunch at restaurant");
        manager.addExpense(45.0, Category.TRANSPORT, "Metro card recharge");
        manager.addExpense(1200.0, Category.GROCERIES, "Weekly groceries");
        manager.addExpense(350.0, Category.ENTERTAINMENT, "Movie tickets");
        manager.addExpense(80.0, Category.FOOD, "Coffee and snacks");
        
        budget.setBudget(Category.FOOD, 2000.0);
        budget.setBudget(Category.TRANSPORT, 1500.0);
        budget.setBudget(Category.ENTERTAINMENT, 1000.0);
    }
}