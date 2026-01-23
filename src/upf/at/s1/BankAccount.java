package upf.at.s1;

class BankAccount {
    private int balance = 0;

    // Without synchronization
    public synchronized void increment() {
        balance++;
    }

    public int getBalance() {
        return balance;
    }
}
