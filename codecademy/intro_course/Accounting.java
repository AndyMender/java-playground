package codecademy.intro_course;

public class Accounting {
    // Keeping it in the same class for convenience
    double accountBalance;   

    public Accounting(double startingBalance) {
        this.accountBalance = startingBalance;

        System.out.println("Welcome to Java Bank!");
        System.out.println(String.format(
            "You have opened an account with a starting balance of %.2f.",
            this.accountBalance
        ));
    }

    public void checkBalance() {
        System.out.println(String.format("Hello! Your account balance is %.2f.", this.accountBalance));

        if (this.accountBalance < 0) {
            System.out.println(String.format(
                    "Oh dear... your account balance is now in red! You have to pay back %.2f.",
                    Math.abs(this.accountBalance)
            ));
        }
    }

    public void deposit(double amountToDeposit) {
        this.accountBalance += amountToDeposit;
        System.out.println(String.format("You just deposited %.2f.", amountToDeposit));
    }

    public double withdraw(int amountToWithdraw) {
        // 1. Check for validity and allow overdrawing
        if ((this.accountBalance - amountToWithdraw) < 0) {
            System.err.println(String.format(
                "You are trying to withdraw %.2f and you only have %.2f. Your account is now in debit!",
                amountToWithdraw, this.accountBalance
            ));
        }       

        // 2. Adjust balance
        // NOTE: One could also adjust by the possible amount to withdraw and still return something
        this.accountBalance -= amountToWithdraw;
        
        // 3. Withdraw money
        System.out.println(String.format("You just withdrew %f.", amountToWithdraw));
        return amountToWithdraw;
    }

    public static void main(String[] args) {
        Accounting myAccount = new Accounting(256.25);

        myAccount.checkBalance();
        myAccount.deposit(25.5);
        myAccount.checkBalance();
    }
}
