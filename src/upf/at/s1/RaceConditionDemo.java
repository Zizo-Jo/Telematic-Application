package upf.at.s1;

public class RaceConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        
        BankAccount sharedAccount = new BankAccount();
        
        int increments = 10000; // Big enough

        BankClient client1 = new BankClient(sharedAccount, increments);
        BankClient client2 = new BankClient(sharedAccount, increments);

        client1.start();
        client2.start();
        client1.join();
        client2.join();

        System.out.println("Expected Balance: " + (increments * 2));
        System.out.println("Actual Balance:   " + sharedAccount.getBalance());
    }
}
