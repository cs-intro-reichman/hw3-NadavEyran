public class LoanCalc {

    static double epsilon = 0.001;
    static int iterationCounter;

    public static void main(String[] args) {
        double loan = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);
        System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

        System.out.print("\nPeriodical payment, using brute force: ");
        System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
        System.out.println("number of iterations: " + iterationCounter);

        System.out.print("\nPeriodical payment, using bi-section search: ");
        System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
        System.out.println("number of iterations: " + iterationCounter);
    }

    private static double endBalance(double loan, double rate, int n, double payment) {
        rate = rate / 100 / 12;
        for (int i = 0; i < n; i = i+1) {
            loan = loan * (1 + rate) - payment;
        }
        return loan;
    }

    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
        iterationCounter = 0;
        double payment = 0;
        while (true) {
            double balance = endBalance(loan, rate, n, payment);
            iterationCounter = iterationCounter+1;
            if (Math.abs(balance) <= epsilon) {
                return payment;
            }
            payment += epsilon;
        }
    }

    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
        iterationCounter = 0;
        double low = 0;
        double high = loan * (1 + rate / 100 / 12);
        double payment = (low + high) / 2;

        while (Math.abs(endBalance(loan, rate, n, payment)) > epsilon) {
            double balance = endBalance(loan, rate, n, payment);
            iterationCounter = iterationCounter+1;
            if (balance > 0) {
                low = payment;
            } else {
                high = payment;
            }
            payment = (low + high) / 2;
        }
        return payment;
    }
}
