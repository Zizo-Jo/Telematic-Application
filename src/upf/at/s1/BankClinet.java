package upf.at.s1;

// 2. The BankClient class (The Thread)
class BankClient extends Thread {
    private BankAccount account;
    private int timesToIncrement;

    public BankClient(BankAccount account, int timesToIncrement) {
        this.account = account;
        this.timesToIncrement = timesToIncrement;
    }

    @Override
    public void run() {
        for (int i = 0; i < timesToIncrement; i++) {
            account.increment();
        }
    }
}
