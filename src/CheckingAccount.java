public class CheckingAccount extends Account{

    public CheckingAccount(String name, String accountNumber) {
        super(name, accountNumber);
    }

    @Override
    public double withdraw(double amt)  {
        if (amt >balance){
            throw new InsufficientFundsException("Insufficient Funds", amt - balance);
        }
        else{
            balance -= amt;
            return amt;
        }

    }

}
