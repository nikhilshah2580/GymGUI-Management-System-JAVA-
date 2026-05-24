
/**
 * PremiumMember is a subclass of GymMember.
 * It represents a gym member with premium features such as:
 * personal trainer, advance payment handling, discount calculation, and premium charges.
 */
public class PremiumMember extends GymMember {

    private final double premiumcharge;      // Fixed premium membership fee
    private String personalTrainer;          // Assigned personal trainer name
    private boolean isFullPayment;           // Payment completion status
    private double paidAmount;               // Total amount paid by member
    private double discountAmount;           // Discount applied after full payment

    /**
     * Constructor initializes both GymMember (parent) and PremiumMember fields.
     */
    public PremiumMember(int id, String name, String location, String phone, String email,
            String gender, String DOB, String membershipStartDate, String personalTrainer) {

        // Initialize parent class attributes
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);

        // Initialize premium-specific attributes
        this.personalTrainer = personalTrainer;
        this.premiumcharge = 50000.0;   // Fixed premium membership fee
        this.isFullPayment = false;     // Payment initially not completed
        this.paidAmount = 0.0;          // No payment made initially
        this.discountAmount = 0.0;      // No discount initially
    }

    
    public double getPremiumcharge() {
        return this.premiumcharge;
    }

    public String getPersonalTrainer() {
        return this.personalTrainer;
    }

    public boolean getIsFullPayment() {
        return this.isFullPayment;
    }

    public double getPaidAmount() {
        return this.paidAmount;
    }

    public double getDiscountAmount() {
        return this.discountAmount;
    }

    /**
     * Overrides markAttendance() from GymMember. Increases attendance and
     * loyalty points for premium members.
     */
    @Override
    public void markAttendance() {
        this.attendance += 1;       // Increase attendance count
        this.loyaltyPoints += 10;   // Reward loyalty points
    }

    /**
     * Handles premium membership payment. Validates payment, updates balance,
     * and tracks completion status.
     *
     * @param paidAmount amount paid by member
     * @return status message of payment process
     */
    public String payDueAmount(double paidAmount) {
        if (isFullPayment) {
            return "Payment already completed.";
        }

        this.paidAmount += paidAmount;

        if (this.paidAmount > premiumcharge) {
            return "Error: Paid amount exceeds premium charge.";
        }

        if (this.paidAmount == premiumcharge) {
            this.isFullPayment = true;
            return "Payment completed successfully.";
        }

        double remainingAmount = premiumcharge - this.paidAmount;
        return "Remaining amount: " + remainingAmount;
    }

    /**
     * Calculates discount after full payment. Applies 10% discount if payment
     * is complete.
     */
    public void calculateDiscount() {
        if (isFullPayment) {
            this.discountAmount = premiumcharge * 0.10;
            System.out.println("Discount applied: " + discountAmount);
        } else {
            System.out.println("Discount not available. Full payment required.");
        }
    }

    /**
     * Resets all premium member data. Calls parent reset method and clears
     * subclass attributes.
     */
    public void revertPremiumMember() {
        super.resetMember();        // Reset base class attributes
        this.personalTrainer = "";  // Clear trainer
        this.isFullPayment = false; // Reset payment status
        this.paidAmount = 0.0;      // Reset paid amount
        this.discountAmount = 0.0;  // Reset discount
    }

    /**
     * Displays complete PremiumMember details. Includes both GymMember and
     * PremiumMember information.
     */
    @Override
    public void display() {
        super.display(); // Display parent class details

        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Payment Completed: " + isFullPayment);

        double remainingAmount = premiumcharge - this.paidAmount;
        System.out.println("Remaining Amount: " + remainingAmount);

        if (isFullPayment) {
            System.out.println("Discount Amount: " + discountAmount);
        }
    }
}
