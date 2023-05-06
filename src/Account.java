public class Account {
    protected double balance;
    private String name;
    private String accountNumber;

    public Account(String name, String accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public Account(String name, String accountNumber,double balance) {
        this.balance = balance;
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public void deposit(double amt){
        balance += amt;
    }

    public double withdraw(double amt) {
        balance -= amt;
        return amt;
    }

    public double checkBalance(){
        return balance;
    }

    public void transferTo(Account a, double amt){
        //a.deposit(this.withdraw(amt));
        //a.balance += amt;
        //balance -= amt;
    }

//    @Override
//    public String toString() {
//        return "Account{" +
//                "balance=" + balance +
//                ", name='" + name + '\'' +
//                ", accountNumber='" + accountNumber + '\'' +
//                '}';
//    }
}



