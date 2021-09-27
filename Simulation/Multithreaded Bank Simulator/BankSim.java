import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class BankSim {

    public static class Account {

        private final int accountId;
        private double balance;

        private final ReentrantLock lock = new ReentrantLock();

        public Account(int accountId, double initialBalance) {
            this.accountId = accountId;
            this.balance = initialBalance;
        }

        public int getAccountId() {
            return accountId;
        }

        public double getBalance() {
            return balance;
        }

        public ReentrantLock getLock() {
            return lock;
        }

        public void deposit(double amount) {
            balance += amount;
        }

        public boolean withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
                return true;
            }
            return false;
        }
    }

    public static class TransactionResult {

        private final boolean success;
        private final int fromAccountId;
        private final int toAccountId;
        private final double amount;

        public TransactionResult(boolean success, int fromAccountId, int toAccountId, double amount) {
            this.success = success;
            this.fromAccountId = fromAccountId;
            this.toAccountId = toAccountId;
            this.amount = amount;
        }

        public boolean isSuccess() {
            return success;
        }
    }

    private Map<Integer, Account> accounts = new ConcurrentHashMap<>();

    public void addAccount(int id, double initialBalance) {
        accounts.put(id, new Account(id, initialBalance));
    }

    public TransactionResult transfer(int fromId, int toId, double amount) {
        Account fromAccount = accounts.get(fromId);
        Account toAccount = accounts.get(toId);

        if (fromAccount == null || toAccount == null || fromId == toId) {
            return new TransactionResult(false, fromId, toId, amount);
        }

        Account firstLock = fromId < toId ? fromAccount : toAccount;
        Account secondLock = fromId < toId ? toAccount : fromAccount;

        firstLock.getLock().lock();
        try {
            secondLock.getLock().lock();
            try {
                if (fromAccount.withdraw(amount)) {
                    toAccount.deposit(amount);
                    return new TransactionResult(true, fromId, toId, amount);
                }
            } finally {
                secondLock.getLock().unlock();
            }
        } finally {
            firstLock.getLock().unlock();
        }

        return new TransactionResult(false, fromId, toId, amount);
    }

    public double getTotalBalance() {
        double total = 0.0;
        for (Account acc : accounts.values()) {
            acc.getLock().lock();
            try {
                total += acc.getBalance();
            } finally {
                acc.getLock().unlock();
            }
        }
        return total;
    }
}
