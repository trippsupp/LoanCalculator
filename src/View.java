
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.*;

/**
 *
 * View - Contains the GUI
 *
 * @author Vance Field
 * @date 20-Oct-2015
 */
public class View extends JPanel {

    // instance variables
    Service srvObj = new Service();
    NumberFormat formatter = new DecimalFormat("#.00");

    private final int FRAME_WIDTH = 420;
    private final int FRAME_HEIGHT = 310;

    private JTextArea output;

    private JButton calculate;
    private JButton generate;

    private JLabel instructions;
    private JLabel instructions2;
    private JLabel loanAmountLabel;
    private JLabel loanDurationLabel;
    private JLabel interestRateLabel;
    private JLabel monthlyPaymentLabel;
    private JLabel totalCostLabel;
    private JLabel investedAmountLabel;
    private JLabel rateOfReturnLabel;
    private JLabel investmentDurationLabel;
    private JLabel yearLabel;
    private JLabel investmentTotalLabel;

    private JTextField loanAmountField;
    private JTextField loanDurationField;
    private JTextField interestRateField;
    private JTextField monthlyPaymentField;
    private JTextField totalCostField;
    private JTextField investedAmountField;
    private JTextField rateOfReturnField;
    private JTextField investmentDurationField;

    /**
     * Constructor sets up GUI
     */
    public View() {
        setLayout(null);
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

        // JLABELS 
        instructions = new JLabel("<HTML><U>If you got a loan:</U></HTML>");
        instructions.setSize(150, 30);
        instructions.setLocation(20, 3);
        add(instructions);

        instructions2 = new JLabel("<HTML><U>If you invested:</U></HTML>");
        instructions2.setSize(150, 30);
        instructions2.setLocation(220, 3);
        instructions2.setVisible(true);
        add(instructions2);

        loanAmountLabel = new JLabel("Loan amount ($):");
        loanAmountLabel.setSize(100, 30);
        loanAmountLabel.setLocation(20, 30);
        add(loanAmountLabel);

        interestRateLabel = new JLabel("Interest rate (%): ");
        interestRateLabel.setSize(100, 30);
        interestRateLabel.setLocation(20, 55);
        add(interestRateLabel);

        loanDurationLabel = new JLabel("Loan duration (yrs):");
        loanDurationLabel.setSize(120, 30);
        loanDurationLabel.setLocation(20, 80);
        add(loanDurationLabel);

        monthlyPaymentLabel = new JLabel("Monthly payments:");
        monthlyPaymentLabel.setSize(150, 30);
        monthlyPaymentLabel.setLocation(20, 140);
        add(monthlyPaymentLabel);

        totalCostLabel = new JLabel("Total cost of loan:");
        totalCostLabel.setSize(150, 30);
        totalCostLabel.setLocation(20, 165);
        add(totalCostLabel);

        investedAmountLabel = new JLabel("Invested amount ($): ");
        investedAmountLabel.setSize(130, 30);
        investedAmountLabel.setLocation(220, 30);
        add(investedAmountLabel);

        rateOfReturnLabel = new JLabel("Rate of return (%): ");
        rateOfReturnLabel.setSize(130, 30);
        rateOfReturnLabel.setLocation(220, 55);
        add(rateOfReturnLabel);

        investmentDurationLabel = new JLabel("Investment duration: ");
        investmentDurationLabel.setSize(150, 30);
        investmentDurationLabel.setLocation(220, 80);
        add(investmentDurationLabel);

        yearLabel = new JLabel("<HTML><i>Year:<i><HTML>");
        yearLabel.setSize(75, 30);
        yearLabel.setLocation(225, 145);
        add(yearLabel);

        investmentTotalLabel = new JLabel("<HTML><i>Investment Total:<i><HTML>");
        investmentTotalLabel.setSize(130, 30);
        investmentTotalLabel.setLocation(280, 145);
        add(investmentTotalLabel);

        // JTEXTFIELDS
        loanAmountField = new JTextField("");
        loanAmountField.setSize(40, 20);
        loanAmountField.setLocation(160, 35);
        add(loanAmountField);

        interestRateField = new JTextField("");
        interestRateField.setSize(40, 20);
        interestRateField.setLocation(160, 60);
        add(interestRateField);

        loanDurationField = new JTextField("");
        loanDurationField.setSize(40, 20);
        loanDurationField.setLocation(160, 85);
        add(loanDurationField);

        monthlyPaymentField = new JTextField("");
        monthlyPaymentField.setSize(70, 20);
        monthlyPaymentField.setLocation(130, 145);
        monthlyPaymentField.setVisible(true);
        monthlyPaymentField.setEditable(false);
        add(monthlyPaymentField);

        totalCostField = new JTextField("");
        totalCostField.setSize(70, 20);
        totalCostField.setLocation(130, 170);
        totalCostField.setVisible(true);
        totalCostField.setEditable(false);
        add(totalCostField);

        investedAmountField = new JTextField("");
        investedAmountField.setSize(40, 20);
        investedAmountField.setLocation(360, 35);
        investedAmountField.setEditable(false);
        add(investedAmountField);

        rateOfReturnField = new JTextField("");
        rateOfReturnField.setSize(40, 20);
        rateOfReturnField.setLocation(360, 60);
        rateOfReturnField.setEditable(false);
        add(rateOfReturnField);

        investmentDurationField = new JTextField("");
        investmentDurationField.setSize(40, 20);
        investmentDurationField.setLocation(360, 85);
        investmentDurationField.setEditable(false);
        add(investmentDurationField);

        // JBUTTONS
        calculate = new JButton("Calculate");
        calculate.setSize(180, 25);
        calculate.setLocation(20, 112);
        calculate.addActionListener(new ButtonClickHandler());
        add(calculate);

        generate = new JButton("Generate table");
        generate.setSize(180, 25);
        generate.setLocation(220, 112);
        generate.addActionListener(new ButtonClickHandler());
        add(generate);

        // JTEXTAREA
        output = new JTextArea();
        //output.setSize(180,100);
        //output.setLocation(220,170);
        output.setEditable(false);
        output.setVisible(true);    // set to false

        JScrollPane sp = new JScrollPane(output);
        sp.setBounds(220, 170, 180, 100);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(sp);
    }

    /**
     * Creates and displays the JFrame
     */
    public void display() {
        JFrame frame = new JFrame("Total Cost Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setContentPane(this);
        frame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * ButtonClickHandler provides the action listener for the buttons
     */
    private class ButtonClickHandler implements ActionListener {

        /**
         * This method handles the tasks of each button
         *
         * @param e the action event handled by this method
         */
        public void actionPerformed(ActionEvent e) {

            // If calculate is clicked
            if (e.getSource() == calculate) {
                try {
                    srvObj.calculateButton(getLoanAmount(), getLoanDuration(), getInterestRate());
                } catch (Exception error) {
                    System.out.println("Error calulating costs");
                }

                try {
                    monthlyPaymentField.setText("$" + formatter.format(srvObj.getMonthlyPayment()));
                    totalCostField.setText("$" + formatter.format(srvObj.getTotalCost()));

                    rateOfReturnField.setEditable(true);

                    investedAmountField.setText(loanAmountField.getText());
                    investmentDurationField.setText(loanDurationField.getText());
                } catch (Exception error) {
                    System.out.println("Could not display labels");
                }
            }

            // If generate is clicked
            if (e.getSource() == generate) {
                try {
                    srvObj.generateButton(getRateOfReturn());
                } catch (Exception error) {
                    System.out.println("Error calculating investment");
                }

                try {
                    output.setText(srvObj.getOutput());
                } catch (Exception error) {
                    System.out.println("Error generating table");
                }
            }
        }
    }

    // Getters
    
    /**
     * Returns the loan amount
     *
     * @return the loan amount as a string
     */
    public String getLoanAmount() {
        return loanAmountField.getText();
    }

    /**
     * Returns the loan duration
     *
     * @return the loan duration as a string
     */
    public String getLoanDuration() {
        return loanDurationField.getText();
    }

    /**
     * Returns the loan interest rate
     *
     * @return the loan interest rate as a string
     */
    public String getInterestRate() {
        return interestRateField.getText();
    }

    /**
     * Returns the rate of return
     *
     * @return rate of return for the investment
     */
    public String getRateOfReturn() {
        return rateOfReturnField.getText();
    }

}
