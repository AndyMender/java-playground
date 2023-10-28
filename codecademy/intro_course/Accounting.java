package codecademy.intro_course;

public class Accounting {
    // Keeping it in the same class for convenience
    double accountBalance;   

    public Accounting(double startingBalance) {
        this.accountBalance = startingBalance;

        System.out.println("Welcome to Java Bank!");
        System.out.printf("You have opened an account with a starting balance of %.2f.\n",
            this.accountBalance
        );
    }

    public void checkBalance() {
        System.out.printf("Hello! Your account balance is %.2f.\n", this.accountBalance);

        if (this.accountBalance < 0) {
            System.out.printf(
                    "Oh dear... your account balance is now in red! You have to pay back %.2f.\n",
                    Math.abs(this.accountBalance)
            );
        }
    }

    public void deposit(double amountToDeposit) {
        this.accountBalance += amountToDeposit;
        System.out.printf("You just deposited %.2f.\n", amountToDeposit);
    }

    public double withdraw(int amountToWithdraw) {
        // 1. Check for validity and allow overdrawing
        if ((this.accountBalance - amountToWithdraw) < 0) {
            System.err.printf(
                "You are trying to withdraw %.2f and you only have %.2f. Your account is now in debit!\n",
                amountToWithdraw, this.accountBalance
            );
        }

        // 2. Adjust balance
        // NOTE: One could also adjust by the possible amount to withdraw and still return something
        this.accountBalance -= amountToWithdraw;
        
        // 3. Withdraw money
        System.out.printf("You just withdrew %.2f.\n", amountToWithdraw);
        return amountToWithdraw;
    }

    public static void main(String[] args) {
        Accounting myAccount = new Accounting(256.25);

        myAccount.checkBalance();
        myAccount.deposit(25.5);
        myAccount.checkBalance();
    }
}
