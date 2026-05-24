// Abstract class representing a Gym Member.
// This class contains common properties and methods
// that will be shared by RegularMember and PremiumMember classes.

public abstract class GymMember 
{
    // Member ID number
    protected int id;

    // Full name of the member
    protected String name;

    // Address or location of the member
    protected String location;

    // Contact phone number
    protected String phone;

    // Email address of the member
    protected String email;

    // Gender of the member
    protected String gender;

    // Date of birth of the member
    protected String DOB;

    // Membership starting date
    protected String membershipStartDate;

    // Total attendance count
    protected int attendance;

    // Loyalty points earned by member
    protected double loyaltyPoints;

    // Membership active status
    // true = active
    // false = inactive
    protected boolean activeStatus;

    // Constructor used to initialize member details
    public GymMember(int id, String name, String location, String phone,
                     String email, String gender, String DOB,
                     String membershipStartDate) 
    {
        // Assign values to attributes
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;

        // Default values when member is first created
        this.attendance = 0;
        this.loyaltyPoints = 0.0;
        this.activeStatus = false;
    }

    // Getter method to return member ID
    public int getId() 
    {
        return this.id;
    }

    // Getter method to return member name
    public String getName() 
    {
        return this.name;
    }

    // Getter method to return member location
    public String getLocation() 
    {
        return this.location;
    }

    // Getter method to return phone number
    public String getPhone() 
    {
        return this.phone;
    }

    // Getter method to return email address
    public String getEmail() 
    {
        return this.email;
    }

    // Getter method to return gender
    public String getGender() 
    {
        return this.gender;
    }

    // Getter method to return date of birth
    public String getDOB() 
    {
        return this.DOB;
    }

    // Getter method to return membership start date
    public String getMembershipStartDate() 
    {
        return this.membershipStartDate;
    }

    // Getter method to return attendance count
    public int getAttendance() 
    {
        return this.attendance;
    }

    // Getter method to return loyalty points
    public double getLoyaltyPoints() 
    {
        return this.loyaltyPoints;
    }

    // Getter method to return membership status
    public boolean getActiveStatus() 
    {
        return this.activeStatus;
    }

    // Abstract method for attendance.
    // This method must be implemented in child classes.
    public abstract void markAttendance();

    // Method to activate membership
    public void activateMembership() 
    {
        // Change membership status to active
        this.activeStatus = true;
    }

    // Method to deactivate membership
    public void deactivateMembership() 
    {
        // Check if membership is active
        if (this.activeStatus) 
        {
            // Change status to inactive
            this.activeStatus = false;
        } 
        else 
        {
            // Display message if already inactive
            System.out.println("Membership is already deactivated.");
        }
    }

    // Method to reset member details
    public void resetMember() 
    {
        // Set membership inactive
        this.activeStatus = false;

        // Reset attendance count
        this.attendance = 0;

        // Reset loyalty points
        this.loyaltyPoints = 0.0;
    }

    // Method to display all member information
    public void display() 
    {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("DOB: " + DOB);
        System.out.println("Membership Start Date: " + membershipStartDate);
        System.out.println("Attendance: " + attendance);
        System.out.println("Loyalty Points: " + loyaltyPoints);
        System.out.println("Active Status: " + activeStatus);
    }
}