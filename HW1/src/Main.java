public class Main {
    public static void main(String[] args) {

//        Loan loan1 = new Loan(1, 200.0);
//        loan1.increaseAmount(10.0);
//        System.out.println(loan1);

        Person kostia = new Person("Kostia", "Stepanenko", "cnp-1111");
        System.out.println(kostia);

        Person olesia = new Person("Olesia", "Stepanenko", "cnp-222");
        System.out.println(olesia);

        Bank bank = new Bank();

        for(int i =0; i < 10; ++i) {
            bank.addLoan(new Loan(i+1, 100.0 * (i+1), kostia));
        }

        for(int i =0; i < 5; ++i) {
            bank.addLoan(new Loan(100 + i, 100.0 * (i+1), olesia));
        }

        System.out.println(bank.remove(new Loan(3, 0.0, kostia)));
        System.out.println(bank.remove(new Loan(7, 0.0, kostia)));
        System.out.println(bank.remove(new Loan(5, 0.0, kostia)));

        System.out.println(bank.remove(new Loan(133, 0.0, olesia)));

        printLoans(bank, "Olesia");
        printLoans(bank, "olesia");
        printLoans(bank, "Kostia");

        printLoansWithMinAmount(bank, "Olesia", 300.0);

        bank.printInFile("C:\\Users\\Shade\\Desktop\\workspace\\OOP-projects\\HW1\\src\\bank-out.txt");

        System.out.println("Main done...");
    }

    private static void printLoansWithMinAmount(Bank bank, String name, double minAmount) {
        System.out.println("-----------------------------------");
        System.out.printf("Loans for '%s' with minAmount: %.0f %n", name, minAmount);
        System.out.println("-----------------------------------");
        Loan[] olesiaLoans = bank.findWithMin(name, minAmount);
        for(Loan olesiaSingleLoan : olesiaLoans ){
            System.out.println(olesiaSingleLoan);
        }
    }

    private static void printLoans(Bank bank, String name){
        System.out.println("-----------------------------------");
        System.out.printf("Loans for '%s'%n", name);
        System.out.println("-----------------------------------");
        Loan[] olesiaLoans = bank.find(name);
        for(Loan olesiaSingleLoan : olesiaLoans ){
            System.out.println(olesiaSingleLoan);
        }
    }
}