
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Handles all calculations
 *
 * @author Vance Field
 * @date 20-Oct-2015
 */
public class Service {

    NumberFormat formatter = new DecimalFormat("#.00");

    private double loanAmount;
    private double loanRate;
    private int loanDuration;

    private double monthlyInterest;
    private int loanDurationInMonths;

    private double monthlyPayment;
    private double totalCost;

    private double rateOfReturn;
    private double investmentInterest;
    private double investmentTotal;
    private double annualInvestmentGains;
    private String output;

    /**
     * Method runs when the calculate button is clicked
     *
     * <p>
     * Uses two helper methods: calculateMonthlyPayment() and
     * calculateTotalCost()</p>
     *
     * @param _loanAmount String of the loan amount
     * @param _loanDuration String of the loan duration
     * @param _loanRate String of the loan rate
     */
    public void calculateButton(String _loanAmount, String _loanDuration, String _loanRate) {
        loanAmount = Double.parseDouble(_loanAmount);
        loanDuration = Integer.parseInt(_loanDuration);
        loanRate = Double.parseDouble(_loanRate);

        monthlyInterest = loanRate / (12 * 100);
        loanDurationInMonths = loanDuration * 12;

        monthlyPayment = calculateMonthlyPayment();
        totalCost = calculateTotalCost();
    }

            /**
             * Calculates the monthly payments of the loan
             *
             * @return the monthly payment
             */
            public double calculateMonthlyPayment() {
                double denominator = 1 - Math.pow((1 + monthlyInterest), -loanDurationInMonths);
                double monthlyPayment = loanAmount * (monthlyInterest / denominator);
                return monthlyPayment;
            }

            /**
             * Calculates the total cost of the loan
             *
             * @return the total cost of the loan
             */
            public double calculateTotalCost() {
                double totalCost = monthlyPayment * loanDurationInMonths;
                return totalCost;
            }

    /**
     * Method runs when the generate button is clicked
     *
     * <p>Uses helper methods: calculateInvestment() and setOutput()</p>
     *
     * @param _rateOfReturn String of the rate of return
     */
    public void generateButton(String _rateOfReturn) {
        rateOfReturn = Double.parseDouble(_rateOfReturn);
        investmentInterest = rateOfReturn / (100);
        investmentTotal = calculateInvestmentTotal();
        setOutput();
    }

            /**
             * Calculates the investmentTotal
             *
             * @return the investment total
             */
            public double calculateInvestmentTotal() {
                double investmentTotal = loanAmount * Math.pow(1 + investmentInterest, loanDuration);
                return investmentTotal;
            }

            /**
             * Creates a string that is formatted as a table
             */
            public void setOutput() {
                output = "";
                annualInvestmentGains = (investmentTotal - loanAmount) / loanDuration;
                double currentInvestmentTotal = loanAmount + annualInvestmentGains;
                for (int i = 1; i < loanDuration + 1; i++) {
                    output += " " + i + ")\t" + " $" + formatter.format(currentInvestmentTotal) + "\n";
                    currentInvestmentTotal += annualInvestmentGains;
                }
            }

    /**********************************
     ********* GETTER METHODS *********
     **********************************/
            
    /**
     * Returns the monthly payment
     *
     * @return monthlyPayment
     */
    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    /**
     * Returns the total cost
     *
     * @return totalCost
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * Returns the duration of the loan
     *
     * @return the loans duration
     */
    public int getLoanDuration() {
        return loanDuration;
    }

    /**
     * Returns the investment total
     *
     * @return investmentTotal
     */
    public double getInvestmentTotal() {
        return investmentTotal;
    }

    /**
     * Returns the table as a string
     *
     * @return the output
     */
    public String getOutput() {
        return output;
    }
} //class
