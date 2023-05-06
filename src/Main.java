public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Account a = new Account("Steve", "xx2");
        a.deposit(100);

        a.withdraw(150);

        System.out.println(a.checkBalance());

        CheckingAccount c = new CheckingAccount("Bob", "bdjhs3");
        c.deposit(100);
        try{
        c.withdraw(150);
        }
        catch (InsufficientFundsException e){
            System.out.println(e.getShortfall());
        }
        System.out.println(c.checkBalance());
        System.out.println(c);

    }
}