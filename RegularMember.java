// RegularMember class inherits properties and methods from GymMember class.
// This class represents a gym member with regular membership features.

public class RegularMember extends GymMember {

    // Maximum attendance required for upgrade eligibility
    private final int attendanceLimit;

    // Checks whether member can upgrade membership plan
    private boolean isEligibleForUpgrade;

    // Stores reason if member is removed
    private String removalReason;

    // Stores who referred this member to the gym
    private String referralSource;

    // Membership plan name
    private String plan;

    // Membership plan price
    private double price;

    // Constructor to initialize RegularMember details
    public RegularMember(int id, String name, String location,
            String phone, String email,
            String gender, String DOB,
            String membershipStartDate,
            String referralSource) {
                
        // Call parent class constructor
        super(id, name, location, phone, email,
                gender, DOB, membershipStartDate);

        // Default values for RegularMember
        this.isEligibleForUpgrade = false;
        this.attendanceLimit = 30;
        this.removalReason = "";

        // Store referral source
        this.referralSource = referralSource;

        // Default membership plan
        this.plan = "basic";

        // Default plan price
        this.price = 6500;
    }

    // Getter method to return attendance limit
    public int getAttendanceLimit() {
        return this.attendanceLimit;
    }

    // Getter method to check upgrade eligibility
    public boolean getIsEligibleForUpgrade() {
        return this.isEligibleForUpgrade;
    }

    // Getter method to return removal reason
    public String getRemovalReason() {
        return this.removalReason;
    }

    // Getter method to return referral source
    public String getReferralSource() {
        return this.referralSource;
    }

    // Getter method to return membership plan
    public String getPlan() {
        return this.plan;
    }

    // Getter method to return plan price
    public double getPrice() {
        return this.price;
    }

    // Method to mark attendance
    // Overrides abstract method from GymMember class
    @Override
    public void markAttendance() {
        // Increase attendance count
        this.attendance += 1;

        // Add loyalty points
        this.loyaltyPoints += 5;

        // Check if attendance reached limit
        if (this.attendance >= attendanceLimit) {
            // Member becomes eligible for plan upgrade
            this.isEligibleForUpgrade = true;
        }
    }

    // Method to return price according to membership plan
    public double getPlanPrice(String plan) {
        // Convert plan name to lowercase for comparison
        switch (plan.toLowerCase()) {
            case "basic":
                return 6500;

            case "standard":
                return 12500;

            case "deluxe":
                return 18500;

            default:
                // Invalid plan
                return -1;
        }
    }

    // Method to upgrade membership plan
    public String upgradePlan(String plan) {
        // Get selected plan price
        double Price = getPlanPrice(plan);

        // Check if plan is invalid
        if (Price == -1) {
            return "Invalid plan.";
        }

        // Check if member is not eligible
        if (!isEligibleForUpgrade) {
            return "Not eligible for upgrade.";
        }

        // Check if member already uses same plan
        if (this.plan.equalsIgnoreCase(plan)) {
            return "Already subscribed to this plan.";
        }

        // Update membership plan
        this.plan = plan;

        // Update plan price
        this.price = Price;

        return "Plan upgraded to " + plan + " successfully.";
    }

    // Method to reset regular member details
    public void revertRegularMember(String removalReason) {
        // Call parent class reset method
        super.resetMember();

        // Store removal reason
        this.removalReason = removalReason;

        // Reset upgrade eligibility
        this.isEligibleForUpgrade = false;

        // Reset plan to default
        this.plan = "basic";

        // Reset price to default
        this.price = 6500;
    }

    // Method to display all RegularMember details
    @Override
    public void display() {
        // Display common member details
        super.display();

        // Display regular member details
        System.out.println("Plan: " + plan);
        System.out.println("Price: " + price);
        System.out.println("Referral Source: " + referralSource);

        // Display removal reason only if available
        if (!removalReason.isEmpty()) {
            System.out.println("Removal Reason: " + removalReason);
        }
    }
}
