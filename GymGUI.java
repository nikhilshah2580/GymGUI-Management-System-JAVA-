import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;

/**
 * GymGUI class represents the graphical user interface for a Gym Management System.
 * It provides interfaces for managing both Regular and Premium gym members.
 * The class implements ActionListener to handle user interactions with buttons.
 */
public class GymGUI implements ActionListener {

    // ArrayList to store all gym members (both Regular and Premium Members)
    private ArrayList<GymMember> gymMember = new ArrayList<GymMember>();

    // GUI frames for different screens
    private JFrame frame, frame2, Mainframe, displayFrame; 
    private JPanel PremiumMemberpanel;

    // Scroll pane for displaying member details
    private JScrollPane scrollPane;

    // Labels for Regular Member form
    private JLabel labelREGULARMEMBER, LabelMEMBERID, LabelNAME, LabelLOCATION, 
    LabelPHONE, LabelEMAIL, LabelGENDER, LABELDOB, 
    LabelMEMBERSHIPSTARTDATE, LabelREFERRALSOURCE,  
    LabelREMOVALREASON, LabelREGULARPLAN, LabelREGULARPRICE;

    // Labels for Premium Member form
    private JLabel labelPremiumMember, instruction, LabelMemberID, LabelName, 
    LabelLocation, LabelPhone, LabelEmail, LabelGender, LabelDOB, 
    LabelMembershipStartDate, LabelPaidAmount, LabelTrainersName, 
    Labelpremiumcharge, LabeldiscountAmount, LabelPremiumMember;

    // Text fields for Regular Member form
    private JTextField tfMEMBERID, tfNAME, tfLOCATION, tfPHONE, tfEMAIL, 
    tfREFERRALSOURCE, tfREMOVALREASON, tfPRICE;

    // Text fields for Premium Member form
    private JTextField tfMemberID, tfName, tfLocation, tfPhone, tfEmail, 
    tfPaidAmount, tfTrainersName, tfPremiumcharge, tfDiscountAmount;

    // Checkboxes for member options
    private JCheckBox JisEligibleForUpgrade, JisFullPayment;

    // Buttons for Regular Member operations
    private JButton btnPremiumMember, OpenPremiumMember, btnActivateMembership, 
    btnDeactivateMembership, btnMarkAttendance, btnRevertPremiumMember, 
    btnDisplay, btnClear, btnupgradeplan, btncalculateDiscount,
    btnpayDueAmount, btnSavetoFile, btnReadfromFile, btnhomebutton, 
    btnHomebutton, btnCalculateDiscount, btnreadfromfile, btnsavetofile;

    // Buttons for Premium Member operations 
    private JButton OpenRegularMember, btnREGULARMEMBER, btnREVERTREGULARMEMBER, 
    btnACTIVATEMEMBERSHIP, btnDEACTIVATEMEMBERSHIP, btnMARKATTENDANCE, 
    btnDISPLAY, btnCLEAR, btnHOMEBUTTON, btnUPGRADEPLAN, 
    btnSAVETOFILE, btnREADFROMFILE;

    // Radio buttons for gender selection (Regular Member)
    private JRadioButton RADIOMALE, RADIOFEMALE; 
    private ButtonGroup BUTTONGROUP;

    // Radio buttons for gender selection (Premium Member)
    private JRadioButton radiomale, radiofemale; 
    private ButtonGroup Buttongroup; 

    // Combo boxes for date selection (Regular Member)
    private JComboBox DATE, MONTH, YEAR, MEMBERSHIPDATE, MEMBERSHIPMONTH, 
    MEMBERSHIPYEAR, REGULARPLAN;

    // Combo boxes for date selection (Premium Member)
    private JComboBox Date, Month, Year, Membershipdate, Membershipmonth, Membershipyear;

    // Text area for displaying member details
    private JTextArea displayArea;

    // File handling components
    private FileReader reader;
    private FileWriter writer;
    private File file;

    /**
     * Constructor for GymGUI class.
     * Initializes all GUI components and sets up the user interface.

     * ALL JFrame & Panel like Frame.add(); OR PremiumMemberpanel.add(); OR Mainframe.add(); these all are using upcasting Method (upcast).
     * Example
    Create a JLabel object to display the "Regular-Member" title
    No upcasting here — this is direct instantiation of a JLabel.
    labelREGULARMEMBER = new JLabel("Regular-Member");

    Add the JLabel to the JFrame (frame)
    Upcasting happens implicitly here:
    frame.add(labelREGULARMEMBER);

     **/
    public GymGUI () 
    {
        // Initialize and configure the Regular Member frame
        frame = new JFrame("24046790-Nikhil Raj Sah");
        frame.setBounds(100, 5, 1330, 815);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Regular Member title label
        labelREGULARMEMBER = new JLabel("Regular-Member");
        labelREGULARMEMBER.setBounds(520, 10, 200, 30);
        frame.add(labelREGULARMEMBER);
        labelREGULARMEMBER.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        labelREGULARMEMBER.setForeground(new Color(65, 105, 225));

        // Member ID components
        LabelMEMBERID = new JLabel("Member ID:");
        LabelMEMBERID.setBounds(180, 70, 200, 25);
        frame.add(LabelMEMBERID);
        LabelMEMBERID.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        tfMEMBERID = new JTextField();
        tfMEMBERID.setBounds(360, 70, 200, 30);
        frame.add(tfMEMBERID);
        tfMEMBERID.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Name components
        LabelNAME = new JLabel("Name:");
        LabelNAME.setBounds(180, 140, 200, 25);
        frame.add(LabelNAME);
        LabelNAME.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        tfNAME = new JTextField();
        tfNAME.setBounds(360, 140, 200, 30);
        frame.add(tfNAME);
        tfNAME.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Location components
        LabelLOCATION = new JLabel("Location:");
        LabelLOCATION.setBounds(180, 210, 200, 25);
        frame.add(LabelLOCATION);
        LabelLOCATION.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        tfLOCATION = new JTextField();
        tfLOCATION.setBounds(360, 210, 200, 30);
        frame.add(tfLOCATION);
        tfLOCATION.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Phone components
        LabelPHONE = new JLabel("Phone:");
        LabelPHONE.setBounds(180, 280, 200, 25);
        frame.add(LabelPHONE);
        LabelPHONE.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        tfPHONE = new JTextField();
        tfPHONE.setBounds(360, 280, 200, 30);
        frame.add(tfPHONE);
        tfPHONE.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Email components
        LabelEMAIL = new JLabel("Email:");
        LabelEMAIL.setBounds(680, 70, 200, 25);
        frame.add(LabelEMAIL);
        LabelEMAIL.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        tfEMAIL = new JTextField();
        tfEMAIL.setBounds(930, 70, 225, 30);
        frame.add(tfEMAIL);
        tfEMAIL.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Gender components (radio buttons)
        LabelGENDER = new JLabel("Gender:");
        LabelGENDER.setBounds(680, 140, 200, 25);
        frame.add(LabelGENDER);
        LabelGENDER.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        RADIOMALE = new JRadioButton("Male");
        RADIOMALE.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        RADIOFEMALE = new JRadioButton("Female");
        RADIOFEMALE.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        BUTTONGROUP = new ButtonGroup();
        RADIOMALE.setBounds(930, 140, 100, 30);
        RADIOFEMALE.setBounds(1030, 140, 100, 30);
        frame.add(RADIOMALE);
        frame.add(RADIOFEMALE);
        BUTTONGROUP.add(RADIOMALE);
        BUTTONGROUP.add(RADIOFEMALE);

        // Date of Birth components (combo boxes)
        LABELDOB = new JLabel("DOB:");
        LABELDOB.setBounds(680, 210, 200, 25);
        frame.add(LABELDOB);
        LABELDOB.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        String[] date = {"1", "2", "3", "4", "5"};
        DATE = new JComboBox(date);
        DATE.setBounds(930, 210, 60, 25);
        frame.add(DATE);

        String[] month = {"jan", "feb", "march", "April", "May"};
        MONTH = new JComboBox(month);
        MONTH.setBounds(1010, 210, 60, 25);
        frame.add(MONTH);

        String[] year = {"1997", "1998", "1999", "2000", "2001"};
        YEAR = new JComboBox(year);
        YEAR.setBounds(1090, 210, 60, 25);
        frame.add(YEAR);

        // Membership Start Date components
        LabelMEMBERSHIPSTARTDATE = new JLabel("Membership Start Date:");
        LabelMEMBERSHIPSTARTDATE.setBounds(680, 280, 300, 25);
        frame.add(LabelMEMBERSHIPSTARTDATE);
        LabelMEMBERSHIPSTARTDATE.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        String[] mdate = {"1", "2", "3"};
        MEMBERSHIPDATE = new JComboBox(mdate);
        MEMBERSHIPDATE.setBounds(930, 280, 60, 25);
        frame.add(MEMBERSHIPDATE);

        String[] mmonth = {"jan", "feb", "march"};
        MEMBERSHIPMONTH = new JComboBox(mmonth);
        MEMBERSHIPMONTH.setBounds(1010, 280, 60, 20);
        frame.add(MEMBERSHIPMONTH);

        String[] myear = {"2025", "2026", "2027"};
        MEMBERSHIPYEAR = new JComboBox(myear);
        MEMBERSHIPYEAR.setBounds(1090, 280, 60, 20);
        frame.add(MEMBERSHIPYEAR);

        // Referral Source components
        LabelREFERRALSOURCE = new JLabel("Referral Source:");
        LabelREFERRALSOURCE.setBounds(180, 350, 200, 25);
        frame.add(LabelREFERRALSOURCE);
        LabelREFERRALSOURCE.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        tfREFERRALSOURCE = new JTextField();
        tfREFERRALSOURCE.setBounds(360, 350, 200, 30);
        frame.add(tfREFERRALSOURCE);
        tfREFERRALSOURCE.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Removal Reason components
        LabelREMOVALREASON = new JLabel("Removal Reason:");
        LabelREMOVALREASON.setBounds(680, 350, 200, 25);
        frame.add(LabelREMOVALREASON);
        LabelREMOVALREASON.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        tfREMOVALREASON = new JTextField();
        tfREMOVALREASON.setBounds(930, 350, 225, 30);
        frame.add(tfREMOVALREASON);
        tfREMOVALREASON.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Regular Plan components
        LabelREGULARPLAN = new JLabel("Regular plan:");
        LabelREGULARPLAN.setBounds(180, 420, 200, 25);
        frame.add(LabelREGULARPLAN);
        LabelREGULARPLAN.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        String[] plan = {"Basic", "Standard", "Deluxe"};
        REGULARPLAN = new JComboBox(plan);
        REGULARPLAN.setBounds(360, 420, 100, 30);
        frame.add(REGULARPLAN);

        // Regular Price components
        LabelREGULARPRICE = new JLabel("Regular Price:");
        LabelREGULARPRICE.setBounds(680, 420, 200, 25);
        frame.add(LabelREGULARPRICE);
        LabelREGULARPRICE.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        tfPRICE = new JTextField("6500");
        tfPRICE.setBounds(930, 420, 225, 30);
        frame.add(tfPRICE);
        tfPRICE.setEditable(false);

        // Checkbox for upgrade eligibility
        JisEligibleForUpgrade = new JCheckBox("isEligibleForUpgrade");
        JisEligibleForUpgrade.setBounds(180, 490, 300, 25);
        frame.add(JisEligibleForUpgrade);
        JisEligibleForUpgrade.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Regular Member button
        btnREGULARMEMBER = new JButton("Regular Member");
        btnREGULARMEMBER.setBounds(160, 560, 250, 35);
        frame.add(btnREGULARMEMBER);
        btnREGULARMEMBER.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnREGULARMEMBER.addActionListener(this);

        // Revert Regular Member button
        btnREVERTREGULARMEMBER = new JButton("Revert RegularMember");
        btnREVERTREGULARMEMBER.setBounds(850, 620, 300, 35);
        frame.add(btnREVERTREGULARMEMBER);
        btnREVERTREGULARMEMBER.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnREVERTREGULARMEMBER.addActionListener(this);

        // Activate Membership button
        btnACTIVATEMEMBERSHIP = new JButton("Activate Membership");
        btnACTIVATEMEMBERSHIP.setBounds(500, 560, 250, 35);
        frame.add(btnACTIVATEMEMBERSHIP);
        btnACTIVATEMEMBERSHIP.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnACTIVATEMEMBERSHIP.addActionListener(this);

        // Deactivate Membership button
        btnDEACTIVATEMEMBERSHIP = new JButton("Deactivate Membership");
        btnDEACTIVATEMEMBERSHIP.setBounds(850, 560, 300, 35);
        frame.add(btnDEACTIVATEMEMBERSHIP);
        btnDEACTIVATEMEMBERSHIP.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnDEACTIVATEMEMBERSHIP.addActionListener(this);

        // Mark Attendance button
        btnMARKATTENDANCE = new JButton("Mark Attendance");
        btnMARKATTENDANCE.setBounds(160, 620, 250, 35);
        frame.add(btnMARKATTENDANCE);
        btnMARKATTENDANCE.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnMARKATTENDANCE.addActionListener(this);

        // Display button
        btnDISPLAY = new JButton("Display");
        btnDISPLAY.setBounds(160, 680, 250, 35);
        frame.add(btnDISPLAY);
        btnDISPLAY.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnDISPLAY.addActionListener(this);

        // Clear button
        btnCLEAR = new JButton("Clear");
        btnCLEAR.setBounds(500, 730, 250, 35);
        frame.add(btnCLEAR);
        btnCLEAR.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnCLEAR.addActionListener(this);

        // Upgrade Plan button
        btnUPGRADEPLAN = new JButton("Upgrade Plan");
        btnUPGRADEPLAN.setBounds(500, 620, 250, 35);
        frame.add(btnUPGRADEPLAN);
        btnUPGRADEPLAN.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnUPGRADEPLAN.addActionListener(this);

        // Save to File button
        btnSAVETOFILE = new JButton("SaveToFile");
        btnSAVETOFILE.setBounds(160, 730, 250, 35);
        frame.add(btnSAVETOFILE);
        btnSAVETOFILE.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnSAVETOFILE.addActionListener(this);

        // Read from File button
        btnREADFROMFILE = new JButton("ReadFromFile");
        btnREADFROMFILE.setBounds(500, 680, 250, 35);
        frame.add(btnREADFROMFILE);
        btnREADFROMFILE.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnREADFROMFILE.addActionListener(this);

        // Home button
        btnHOMEBUTTON = new JButton("Home");
        btnHOMEBUTTON.setBounds(850, 680, 300, 35);
        frame.add(btnHOMEBUTTON);
        btnHOMEBUTTON.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnHOMEBUTTON.addActionListener(this);

        // Initially hide the Regular Member frame
        frame.setVisible(false);

        // Initialize and configure the Premium Member frame
        frame2 = new JFrame("24046790 Nikhil Raj Sah ");
        frame2.setBounds(100, 5, 1330, 815);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setLayout(null);

        // Create panel for Premium Member form
        PremiumMemberpanel = new JPanel();
        PremiumMemberpanel.setLayout(null);
        PremiumMemberpanel.setSize(1330, 790);
        frame2.add(PremiumMemberpanel);

        // Premium Member title label
        labelPremiumMember = new JLabel("Premium-Member");
        labelPremiumMember.setBounds(520, 10, 200, 20);
        PremiumMemberpanel.add(labelPremiumMember);
        labelPremiumMember.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        labelPremiumMember.setForeground(new Color(65, 105, 225));

        // Member ID components (Premium)
        LabelMemberID = new JLabel("Member ID:");
        LabelMemberID.setBounds(180, 70, 200, 25);
        PremiumMemberpanel.add(LabelMemberID);
        LabelMemberID.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        tfMemberID = new JTextField();
        tfMemberID.setBounds(360, 70, 200, 30);
        PremiumMemberpanel.add(tfMemberID);
        tfMemberID.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Name components (Premium)
        LabelName = new JLabel("Name:");
        LabelName.setBounds(180, 140, 200, 25);
        PremiumMemberpanel.add(LabelName);
        LabelName.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        tfName = new JTextField();
        tfName.setBounds(360, 140, 200, 30);
        PremiumMemberpanel.add(tfName);
        tfName.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Location components (Premium)
        LabelLocation = new JLabel("Location:");
        LabelLocation.setBounds(180, 210, 200, 25);
        PremiumMemberpanel.add(LabelLocation);
        LabelLocation.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        tfLocation = new JTextField();
        tfLocation.setBounds(360, 210, 200, 30);
        PremiumMemberpanel.add(tfLocation);
        tfLocation.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Phone components (Premium)
        LabelPhone = new JLabel("Phone:");
        LabelPhone.setBounds(180, 280, 200, 25);
        PremiumMemberpanel.add(LabelPhone);
        LabelPhone.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        tfPhone = new JTextField();
        tfPhone.setBounds(360, 280, 200, 30);
        PremiumMemberpanel.add(tfPhone);
        tfPhone.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Email components (Premium)
        LabelEmail = new JLabel("Email:");
        LabelEmail.setBounds(680, 70, 200, 25);
        PremiumMemberpanel.add(LabelEmail);
        LabelEmail.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        tfEmail = new JTextField();
        tfEmail.setBounds(930, 70, 225, 30);
        PremiumMemberpanel.add(tfEmail);
        tfEmail.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Gender components (Premium) - radio buttons
        LabelGender = new JLabel("Gender:");
        LabelGender.setBounds(680, 140, 200, 25);
        PremiumMemberpanel.add(LabelGender);
        LabelGender.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        radiomale = new JRadioButton("Male");
        radiomale.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        radiofemale = new JRadioButton("Female");
        radiofemale.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        Buttongroup = new ButtonGroup();
        radiomale.setBounds(930, 140, 100, 30);
        radiofemale.setBounds(1030, 140, 100, 30);
        PremiumMemberpanel.add(radiomale);
        PremiumMemberpanel.add(radiofemale);
        Buttongroup.add(radiomale);
        Buttongroup.add(radiofemale);

        // Date of Birth components (Premium) - combo boxes
        LabelDOB = new JLabel("DOB:");
        LabelDOB.setBounds(680, 210, 200, 25);
        PremiumMemberpanel.add(LabelDOB);
        LabelDOB.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        String[] datee = {"1", "2", "3", "4", "5"};
        Date = new JComboBox(datee);
        Date.setBounds(930, 210, 60, 25);
        PremiumMemberpanel.add(Date);

        String[] monthh = {"jan", "feb", "march", "April", "May"};
        Month = new JComboBox(monthh);
        Month.setBounds(1010, 210, 60, 25);
        PremiumMemberpanel.add(Month);

        String[] yearr = {"1997", "1998", "1999", "2000", "2001"};
        Year = new JComboBox(yearr);
        Year.setBounds(1090, 210, 60, 25);
        PremiumMemberpanel.add(Year);

        // Membership Start Date components (Premium)
        LabelMembershipStartDate = new JLabel("Membership Start Date:");
        LabelMembershipStartDate.setBounds(680, 280, 300, 25);
        PremiumMemberpanel.add(LabelMembershipStartDate);
        LabelMembershipStartDate.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        String[] msdate = {"1", "2", "3"};
        Membershipdate = new JComboBox(msdate);
        Membershipdate.setBounds(930, 280, 60, 25);
        PremiumMemberpanel.add(Membershipdate);

        String[] msonth = {"jan", "feb", "march"};
        Membershipmonth = new JComboBox(msonth);
        Membershipmonth.setBounds(1010, 280, 60, 25);
        PremiumMemberpanel.add(Membershipmonth);

        String[] msyear = {"2025", "2026", "2027"};
        Membershipyear = new JComboBox(msyear);
        Membershipyear.setBounds(1090, 280, 60, 25);
        PremiumMemberpanel.add(Membershipyear);

        // Trainer's Name components
        LabelTrainersName = new JLabel("Trainer's Name:");
        LabelTrainersName.setBounds(180, 350, 200, 25);
        PremiumMemberpanel.add(LabelTrainersName);
        LabelTrainersName.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        tfTrainersName = new JTextField();
        tfTrainersName.setBounds(360, 350, 200, 30);
        PremiumMemberpanel.add(tfTrainersName);
        tfTrainersName.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Paid Amount components
        LabelPaidAmount = new JLabel("Paid Amount:");
        LabelPaidAmount.setBounds(680, 350, 200, 25);
        PremiumMemberpanel.add(LabelPaidAmount);
        LabelPaidAmount.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        tfPaidAmount = new JTextField();
        tfPaidAmount.setBounds(930, 350, 225, 30);
        PremiumMemberpanel.add(tfPaidAmount);
        tfPaidAmount.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Premium Charge components
        Labelpremiumcharge = new JLabel("Premium Charge:");
        Labelpremiumcharge.setBounds(180, 420, 200, 25);
        PremiumMemberpanel.add(Labelpremiumcharge);
        Labelpremiumcharge.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        tfPremiumcharge = new JTextField("50000.0");
        tfPremiumcharge.setBounds(360, 420, 200, 30);
        PremiumMemberpanel.add(tfPremiumcharge);
        tfPremiumcharge.setEditable(false);

        // Discount Amount components
        LabeldiscountAmount = new JLabel("Discount Amount:");
        LabeldiscountAmount.setBounds(680, 420, 200, 25);
        PremiumMemberpanel.add(LabeldiscountAmount);
        LabeldiscountAmount.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        tfDiscountAmount = new JTextField("0.0");
        tfDiscountAmount.setBounds(930, 420, 225, 30);
        PremiumMemberpanel.add(tfDiscountAmount);
        tfDiscountAmount.setEditable(false);

        // Full Payment checkbox
        JisFullPayment = new JCheckBox("IsFullPayment");
        JisFullPayment.setBounds(180, 490, 200, 25);
        PremiumMemberpanel.add(JisFullPayment);
        JisFullPayment.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Premium Member button
        btnPremiumMember = new JButton("Premium Member");
        btnPremiumMember.setBounds(160, 560, 250, 35);
        PremiumMemberpanel.add(btnPremiumMember);
        btnPremiumMember.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnPremiumMember.addActionListener(this);

        // Revert Premium Member button
        btnRevertPremiumMember = new JButton("Revert PremiumMember");
        btnRevertPremiumMember.setBounds(850, 620, 300, 35);
        PremiumMemberpanel.add(btnRevertPremiumMember);
        btnRevertPremiumMember.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnRevertPremiumMember.addActionListener(this);

        // Activate Membership button (Premium)
        btnActivateMembership = new JButton("Activate Membership");
        btnActivateMembership.setBounds(500, 560, 250, 35);
        PremiumMemberpanel.add(btnActivateMembership);
        btnActivateMembership.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnActivateMembership.addActionListener(this);

        // Deactivate Membership button (Premium)
        btnDeactivateMembership = new JButton("Deactivate Membership");
        btnDeactivateMembership.setBounds(850, 560, 300, 35);
        PremiumMemberpanel.add(btnDeactivateMembership);
        btnDeactivateMembership.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnDeactivateMembership.addActionListener(this);

        // Mark Attendance button (Premium)
        btnMarkAttendance = new JButton("Mark Attendance");
        btnMarkAttendance.setBounds(160, 620, 250, 35);
        PremiumMemberpanel.add(btnMarkAttendance);
        btnMarkAttendance.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnMarkAttendance.addActionListener(this);

        // Pay Due Amount button
        btnpayDueAmount = new JButton("Pay Due Amount");
        btnpayDueAmount.setBounds(500, 620, 250, 35);
        PremiumMemberpanel.add(btnpayDueAmount);
        btnpayDueAmount.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnpayDueAmount.addActionListener(this);

        // Calculate Discount button
        btnCalculateDiscount = new JButton("Calculate Discount");
        btnCalculateDiscount.setBounds(160, 680, 250, 35);
        PremiumMemberpanel.add(btnCalculateDiscount);
        btnCalculateDiscount.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnCalculateDiscount.addActionListener(this);

        // Home button (Premium)
        btnhomebutton = new JButton("Home");
        btnhomebutton.setBounds(850, 730, 300, 35);
        PremiumMemberpanel.add(btnhomebutton);
        btnhomebutton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnhomebutton.addActionListener(this);

        // Display button (Premium)
        btnDisplay = new JButton("Display");
        btnDisplay.setBounds(500, 680, 250, 35);
        PremiumMemberpanel.add(btnDisplay);
        btnDisplay.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnDisplay.addActionListener(this);

        // Initialize display frame for showing member details
        displayFrame = new JFrame("Member Display");
        displayFrame.setSize(700, 500);
        displayFrame.setLayout(null);
        displayFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        displayFrame.setBounds(400, 100, 700, 500);

        // Text area for displaying member details
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Scroll pane for the text area
        scrollPane = new JScrollPane(displayArea);
        scrollPane.setBounds(20, 20, 650, 370);
        displayFrame.add(scrollPane);


        // Clear button (Premium)
        btnClear = new JButton("Clear");
        btnClear.setBounds(850, 680, 300, 35);
        PremiumMemberpanel.add(btnClear);
        btnClear.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnClear.addActionListener(this);

        // Save to File button (Premium)
        btnsavetofile = new JButton("SaveToFile");
        btnsavetofile.setBounds(160, 730, 250, 35);
        PremiumMemberpanel.add(btnsavetofile);
        btnsavetofile.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnsavetofile.addActionListener(this);

        // Read from File button (Premium)
        btnreadfromfile = new JButton("ReadFromFile");
        btnreadfromfile.setBounds(500, 730, 250, 35);
        PremiumMemberpanel.add(btnreadfromfile);
        btnreadfromfile.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        btnreadfromfile.addActionListener(this);

        // Initially hide the Premium Member frame
        frame2.setVisible(false);

        // Initialize and configure the main frame
        Mainframe = new JFrame("24046790-Nikhil Raj Sah ");
        Mainframe.setBounds(150, 60, 1200, 700);
        Mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Mainframe.setLayout(null);
        Mainframe.setVisible(true);

        // Regular Member access button on main screen
        OpenRegularMember = new JButton("RegularMember");
        OpenRegularMember.setBounds(240, 280, 250, 50);
        Mainframe.add(OpenRegularMember);
        OpenRegularMember.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        OpenRegularMember.setBackground(new Color(175, 238, 238));
        OpenRegularMember.addActionListener(this);

        // Premium Member access button on main screen
        OpenPremiumMember = new JButton("PremiumMember");
        OpenPremiumMember.setBounds(600, 280, 250, 50);
        Mainframe.add(OpenPremiumMember);
        OpenPremiumMember.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        OpenPremiumMember.setBackground(new Color(175, 238, 238));
        OpenPremiumMember.addActionListener(this);

        // Welcome message labels on main screen
        instruction = new JLabel("Welcome to Main page ");
        instruction.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        instruction.setForeground(new Color(65, 105, 225));
        instruction.setBounds(420, 30, 900, 50);
        Mainframe.add(instruction);

        instruction = new JLabel(" Gym Management System");
        instruction.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        instruction.setForeground(new Color(65, 105, 225));
        instruction.setBounds(390, 75, 900, 50);
        Mainframe.add(instruction);

        instruction = new JLabel(" Welcome to the Gym management system..!!");
        instruction.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        instruction.setBounds(320, 420, 900, 50);
        Mainframe.add(instruction);

        instruction = new JLabel("This system provides fast access to handle RegularMember and PremiumMember.");
        instruction.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        instruction.setBounds(230, 470, 900, 50);
        Mainframe.add(instruction);

        instruction = new JLabel("Just click on 'RegularMember' or 'PremiumMember' to access their respective interfaces");
        instruction.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        instruction.setBounds(180, 520, 900, 50);
        Mainframe.add(instruction);
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        // Handle 'Regular Member' button click from Main Frame
        if (ae.getSource() == OpenRegularMember) 
        {
            Mainframe.setVisible(false); // Hide the main/home frame
            frame.setVisible(true);      // Show the Regular Member frame

            // Handle 'Premium Member' button click from Main Frame
        } else if (ae.getSource() == OpenPremiumMember) 
        {
            Mainframe.setVisible(false); // Hide the main/home frame
            frame2.setVisible(true);     // Show the Premium Member frame

            // Handle 'Home' button click from either Regular or Premium Member frame
        } else if (ae.getSource() == btnHOMEBUTTON || ae.getSource() == btnhomebutton) 
        {
            Mainframe.setVisible(true);  // Show the main/home frame
            frame.setVisible(false);     // Hide the Regular Member frame
            frame2.setVisible(false);    // Hide the Premium Member frame
        }
        
        
        // REGULARMEMBER BUTTON
        if(ae.getSource() == btnREGULARMEMBER) 
        { 
            try{
                // Check if any of the required fields are empty
                if (
                tfMEMBERID.getText().isEmpty() ||
                tfNAME.getText().isEmpty() || 
                tfLOCATION.getText().isEmpty() || 
                tfPHONE.getText().isEmpty() ||
                tfREMOVALREASON.getText().isEmpty() ||
                tfEMAIL.getText().isEmpty() ||
                tfREFERRALSOURCE.getText().isEmpty()) 
                {
                    // Show a message dialog alerting the user that some fields are empty
                    JOptionPane.showMessageDialog(frame, 
                        "One or more text fields are empty  ", 
                        "Alert", JOptionPane.ERROR_MESSAGE);
                } else 
                {
                    // Parse data from the input fields
                    int id = Integer.parseInt(tfMEMBERID.getText());  
                    String name = tfNAME.getText();
                    String location = tfLOCATION.getText(); 
                    String phone = tfPHONE.getText();
                    String email = tfEMAIL.getText();
                    String removalReason = tfREMOVALREASON.getText();
                    String referralSource = tfREFERRALSOURCE.getText();

                    // Determine the selected gender from the radio buttons
                    String gender = RADIOMALE.isSelected() ? "Male" : (RADIOFEMALE.isSelected() ? "Female" : "");

                    // Construct the date of birth from the selected items in the combo boxes
                    String DOB = DATE.getSelectedItem() + "-" + MONTH.getSelectedItem() + "-" + YEAR.getSelectedItem();

                    // Construct the membership start date from the selected items in the combo boxes
                    String membershipStartDate = MEMBERSHIPDATE.getSelectedItem() + "-" + MEMBERSHIPMONTH.getSelectedItem() + 
                        "-" + MEMBERSHIPYEAR.getSelectedItem();

                    String selectedPlan = REGULARPLAN.getSelectedItem().toString();

                    // Check for gender selection
                    if (gender.isEmpty()) 
                    {
                        JOptionPane.showMessageDialog(frame, "Please select gender", "Alert", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Validate member ID
                    if (id <= 0) 
                    {
                        JOptionPane.showMessageDialog(frame, "ID should be greater than zero", "Error", JOptionPane.ERROR_MESSAGE);
                        return; 
                    }

                    // Check for duplicate ID in gymMember list
                    boolean duplicateId = false;
                    for (GymMember member : gymMember) 
                    {
                        if (member.getId() == id) 
                        {
                            duplicateId = true;
                            break;
                        }
                    }

                    // If a duplicate ID is found, show an error message
                    if (duplicateId) 
                    {
                        JOptionPane.showMessageDialog(frame, "ID already exists. Please enter a unique ID.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    } else 
                    {
                        // Upcast: Create a RegularMember object (RegularMember is a subclass of GymMember)
                        RegularMember member = new RegularMember(id, name, location, phone, email, gender, DOB, 
                                membershipStartDate, referralSource);
                        gymMember.add(member);

                        // Prepare a message to display the details of the added RegularMember
                        String message = "ID:" + id + "\nName:" + name + "\nLocation:" + location + "\nPhone:" + phone + 
                            "\nEmail:" + email + "\nGender:" + gender + "\nDOB:" + DOB + 
                            "\nMembership Start Date:" + membershipStartDate +"\nReferral Source:" +referralSource +"\n\n";

                        // Display a success message indicating that the RegularMember has been added
                        JOptionPane.showMessageDialog(frame, "Regular Member added successfully!", "Success", 
                            JOptionPane.INFORMATION_MESSAGE);
                    } 
                }
            } catch(NumberFormatException e) 
            {
                // Catch number format exceptions for invalid input
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid numbers for ID & price", "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }

        // REGULARMEMBER ACTIVATEMEMBERSHIP BUTTON
        if (ae.getSource() == btnACTIVATEMEMBERSHIP) 
        {
            try {
                // Parse the ID from the text field and convert it to an integer
                int id = Integer.parseInt(tfMEMBERID.getText());
                boolean activateMembershipFound = false;
                // Loop through the list of gym members to find the member with the specified ID
                for (GymMember member : gymMember) 
                {
                    if (member.getId() == id)   
                    {
                        // Downcast: Call the method specific to RegularMember
                        member.activateMembership();  
                        // Show a success message indicating that the membership was activated
                        JOptionPane.showMessageDialog(frame, "Membership activated successfully", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                        activateMembershipFound = true; 
                        break;
                    }
                }

                // If the membership was not activated, show an error message
                if (!activateMembershipFound) 
                {
                    JOptionPane.showMessageDialog(frame, "Member ID not found", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException e) 
            {
                JOptionPane.showMessageDialog(frame, "Invalid ID format", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // REGULARMEMBER DEACTIVATEMEMBERSHIP
        if (ae.getSource() == btnDEACTIVATEMEMBERSHIP) 
        {
            try {
                // Parse the ID from the text field and convert it to an integer
                int id = Integer.parseInt(tfMEMBERID.getText());
                boolean deactivateMembershipFound = false;
                // Loop through the list of gym members to find the member with the specified ID
                for (GymMember member : gymMember) 
                {
                    if (member.getId() == id) 
                    {
                        // Downcast: Call the method specific to RegularMember
                        member.deactivateMembership();  
                        // Show a success message indicating that the membership was deactivated
                        JOptionPane.showMessageDialog(frame, "Membership deactivated successfully","Sucess", JOptionPane.INFORMATION_MESSAGE);
                        deactivateMembershipFound = true;
                        break;
                    }
                }

                if (!deactivateMembershipFound) 
                {
                    JOptionPane.showMessageDialog(frame, "Member ID not found", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException e) 
            {
                JOptionPane.showMessageDialog(frame, "Invalid ID format", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // REGULARMEMBER MARKATTENDANCE BUTTON
        if (ae.getSource() == btnMARKATTENDANCE) 
        {
            try {
                // Parse the ID from the text field and convert it to an integer
                int id = Integer.parseInt(tfMEMBERID.getText());
                boolean markAttendance = false;
                // Loop through the list of gym members to find the member with the specified ID
                for (GymMember member : gymMember) 
                {
                    if (member.getId() == id) 
                    {
                        markAttendance = true;
                        if (member.activeStatus)  
                        {
                            // Downcast: Call the method specific to RegularMember
                            member.markAttendance();  
                      
                            JOptionPane.showMessageDialog(frame, "Attendance marked for Member ID: " + id, "Success", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(frame, "Cannot mark attendance. Membership is not active.","Error", JOptionPane.ERROR_MESSAGE);
                        }
                        break;  
                    }
                }

                if (!markAttendance) 
                {
                    JOptionPane.showMessageDialog(frame, "Member ID not found.","Error", JOptionPane.ERROR_MESSAGE);
                }

            }catch (NumberFormatException e) 
            {  
                JOptionPane.showMessageDialog(frame, "Please enter a valid numeric Member ID.","Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // REGULARMEMBER REVERTRAGULARMEMBER BUTTON
        if (ae.getSource() == btnREVERTREGULARMEMBER) 
        {
            try {
                int id = Integer.parseInt(tfMEMBERID.getText());
                GymMember memberToRemove = null; 
                for (GymMember member : gymMember) 
                {
                    if (member instanceof RegularMember && member.getId() == id) // Downcast: Check if member is an instance of RegularMember
                    {
                        memberToRemove = member; 
                        break;     
                    }
                }

                if (memberToRemove != null) 
                {
                    gymMember.remove(memberToRemove);   
                    JOptionPane.showMessageDialog(frame, "Regular Member reverted (removed).", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else 
                {
                    JOptionPane.showMessageDialog(frame, "Regular Member with ID Not Found", "Error", JOptionPane.WARNING_MESSAGE);
                }

            } catch (NumberFormatException ex)    
            {
                JOptionPane.showMessageDialog(frame, "Invalid ID. Please enter a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // REGULARMEMBER UPGRADEPLAN BUTTON
        if (ae.getSource() == btnUPGRADEPLAN) {
            try {
                int id = Integer.parseInt(tfMEMBERID.getText());

                boolean found = false;

                for (GymMember member : gymMember) 
                {
                    if (member instanceof RegularMember && member.getId() == id) // Downcast: Ensure member is RegularMember
                    {
                        found = true;

                        if (!member.activeStatus) 
                        {
                            JOptionPane.showMessageDialog(frame,
                                "Membership is not active. Cannot upgrade plan.",
                                "Inactive Member", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        String selectedPlan = REGULARPLAN.getSelectedItem().toString();
                        if (selectedPlan.equals("Select Plan") || selectedPlan.isEmpty()) 
                        {
                            JOptionPane.showMessageDialog(frame,
                                "Please select a valid plan.",
                                "Invalid Plan", JOptionPane.WARNING_MESSAGE);
                            return;
                        }

                        String result = ((RegularMember) member).upgradePlan(selectedPlan); // Downcast: Calling RegularMember-specific method
                        JOptionPane.showMessageDialog(frame,
                            result,
                            "Upgrade Result", JOptionPane.INFORMATION_MESSAGE);
                        return; 
                    }
                }

                if (!found) 
                {
                    JOptionPane.showMessageDialog(frame,
                        "No Regular Member found with ID: " + id,
                        "Member Not Found", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException e) 
            {
                JOptionPane.showMessageDialog(frame,
                    "Invalid ID. Please enter a numeric Member ID.",
                    "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }

        //  REGULARMEMBER DISPLAY BUTTON ACTION
        if (ae.getSource() == btnDISPLAY) 
        {
            try {
                // 🧹 Clear the previous content in the display area
                displayArea.setText(""); 

                // Initialize the details string with a heading
                String details = "RegularMembers Details:\n";
                boolean memberFound = false;

                // Loop through the gymMember list to find and display RegularMember objects
                for (GymMember member : gymMember) 
                {
                    if (member instanceof RegularMember) 
                    {
                        //  Downcasting: Converting GymMember reference back to RegularMember
                        // Needed to access RegularMember-specific methods and fields
                        RegularMember regularMember = (RegularMember) member;

                        //  Append the details of this RegularMember to the display string
                        details += "ID: " + regularMember.getId() + "\n" +
                        "Name: " + regularMember.getName() + "\n" +
                        "Location: " + regularMember.getLocation() + "\n" +
                        "Phone: " + regularMember.getPhone() + "\n" +
                        "Email: " + regularMember.getEmail() + "\n" +
                        "Gender: " + regularMember.getGender() + "\n" +
                        "DOB: " + regularMember.getDOB() + "\n" +
                        "Membership Start Date: " + regularMember.getMembershipStartDate() + "\n" +
                        "Removal Reason: " + regularMember.getRemovalReason() + "\n" +
                        "Regular Plan: " + regularMember.getPlan() + "\n" +
                        "Loyalty Points: " + regularMember.getLoyaltyPoints() + "\n" +
                        "Active Status: " + (regularMember.getActiveStatus() ? "Active" : "Inactive") + "\n" +
                        "IsEligibleForUpgrade: " + regularMember.getIsEligibleForUpgrade() + "\n" +
                        "Regular Price: " + regularMember.getPrice() + "\n" +
                        "Referral Source: " + regularMember.getReferralSource() + "\n";

                        memberFound = true;
                    } 
                }

                // ? Display the collected details in the JTextArea if any member was found
                if (memberFound) 
                {
                    displayArea.setText(details);
                } 
                else 
                {
                    displayArea.setText("No members found to display.\n");
                }

                // ?Show the display frame that holds the JTextArea
                displayFrame.setVisible(true);

            } 
            catch (Exception ex) 
            {
                // ?Error handling with a dialog box
                JOptionPane.showMessageDialog(frame, "An error occurred while displaying members. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // REGULAR MMEBER CLEAR BUTTON.
        if (ae.getSource() == btnCLEAR) 
        {
            // Clear the text fields by setting their text to an empty string
            tfMEMBERID.setText(""); // Clear the ID text field
            tfNAME.setText(""); // Clear the Name text field
            tfLOCATION.setText(""); // Clear the Location text field
            tfPHONE.setText(""); // Clear the Phone text field
            tfEMAIL.setText(""); // Clear the Email text field
            tfREFERRALSOURCE.setText(""); // Clear the Referral Source text field
            tfREMOVALREASON.setText(""); // Clear the Removal Reason text field

            // Clear the selection of the radio buttons for gender
            BUTTONGROUP.clearSelection(); // Deselect any selected radio buttons

            // Reset the combo boxes for date of birth to their default (first) option
            DATE.setSelectedIndex(0); // Reset the Date combo box to the first item
            MONTH.setSelectedIndex(0); // Reset the Month combo box to the first item
            YEAR.setSelectedIndex(0); // Reset the Year combo box to the first item

            // Reset the combo boxes for membership start date to their default (first) option
            MEMBERSHIPDATE.setSelectedIndex(0); // Reset the Membership Date combo box to the first item
            MEMBERSHIPMONTH.setSelectedIndex(0); // Reset the Membership Month combo box to the first item
            MEMBERSHIPYEAR.setSelectedIndex(0); // Reset the Membership Year combo box to the first item

            // Reset the combo box for the regular plan to its default (first) option
            REGULARPLAN.setSelectedIndex(0); // Reset the Regular Plan combo box to the first item

            // Clear the JisEligibleForUpgrade checkbox
            JisEligibleForUpgrade.setSelected(false);

        }

        // REGULARMEMBER READFROMFILE BUTTON.
        if (ae.getSource() == btnREADFROMFILE) 
        {
            try {
                // Create a file object to read from the file "RegularMemberDetails.txt"
                file = new File("RegularMemberDetails.txt");

                // Check if the file exists, if not, show a warning message
                if (!file.exists()) 
                {
                    JOptionPane.showMessageDialog(frame, "No saved file found!", "ERROR", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Reading file content using FileReader
                reader = new FileReader(file);
                String content = "";
                int c;

                // Read characters from file until end of file
                while ((c = reader.read()) != -1) 
                {
                    content += (char) c; // Append read character to content string
                }

                reader.close(); // Close the reader after reading

                // Display the read content in the displayArea
                displayArea.setText(content);
                displayFrame.setVisible(true); // Show the displayFrame

            } catch (Exception e) 
            {
                // Error handling if file reading fails
                JOptionPane.showMessageDialog(frame, "Error reading from file.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }


        // SAVE TO FILE REGULARMEMBER
        if (ae.getSource() == btnSAVETOFILE) 
            {
            try {
                // Parse the input from the Member ID text field as an integer
                int id = Integer.parseInt(tfMEMBERID.getText());
                boolean memberFound = false; // Flag to check if a matching member is found

                // Iterate through the list of GymMember objects
                for (GymMember member : gymMember) 
                {
                    // Check if the current member is a RegularMember and if the ID matches the input
                    if (member instanceof RegularMember && member.getId() == id) 
                    {
                        // Downcast the GymMember object to a RegularMember to access its specific methods
                        RegularMember regular = (RegularMember) member;
                        memberFound = true; // Mark that a matching member has been found

                        // Create a FileWriter to overwrite the file "RegularMemberDetails.txt"
                        writer = new FileWriter("RegularMemberDetails.txt");

                        // column headers in formatted table style using String.format
                        writer.write(String.format(
                                "%-6s %-18s %-11s %-13s %-24s %-10s %-14s %-22s %-12s %-16s %-14s %-20s %-10s %-10s %-12s %-16s%n",
                                "ID", "Name", "Location", "Phone", "Email", "Gender", "DOB", "Membership Start Date",
                                "Attendance", "Loyalty Points", "Active Status", "Removal Reason", "Plan", "Upgrade", "Price", "Referral Source"
                            ));

                        // RegularMember's data using aligned formatting
                        writer.write(String.format(
                                "%-6d %-18s %-11s %-13s %-24s %-10s %-14s %-22s %-12d %-16.2f %-14s %-20s %-10s %-10s %-12.2f %-16s%n",
                                regular.getId(),                            // Member ID
                                regular.getName(),                          // Member name
                                regular.getLocation(),                      // Location
                                regular.getPhone(),                         // Phone number
                                regular.getEmail(),                         // Email address
                                regular.getGender(),                        // Gender
                                regular.getDOB(),                           // Date of birth
                                regular.getMembershipStartDate(),           // Start date
                                regular.getAttendance(),                    // Attendance count
                                regular.getLoyaltyPoints(),                 // Loyalty points
                                regular.getActiveStatus() ? "Active" : "Inactive", // Active status
                                regular.getRemovalReason(),                 // Removal reason
                                regular.getPlan(),                          // Membership plan
                                regular.getIsEligibleForUpgrade(),          // Eligibility for upgrade
                                regular.getPrice(),                         // Price
                                regular.getReferralSource()                 // Referral source
                            ));

                        writer.close(); // Close the FileWriter to finalize saving

                        // Show a success message dialog box to the user
                        JOptionPane.showMessageDialog(frame, "Regular member ID " + id + " saved to file successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        break; // Exit the loop once the matching member is found and saved
                    }
                }

                // If no matching RegularMember was found, show a warning message
                if (!memberFound) {
                    JOptionPane.showMessageDialog(frame, "No Regular Member found with ID: " + id, "Not Found", JOptionPane.WARNING_MESSAGE);
                }

            } catch (NumberFormatException e) {
                // Handle invalid input if the Member ID is not a valid integer
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a numeric Member ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                // Handle any general exception that might occur during file operations
                JOptionPane.showMessageDialog(frame, "Error saving to file. Please check permissions or storage.", "File Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        
        // PREMIUM MEMBER BUTTON
        if (ae.getSource() == btnPremiumMember) 
        {
            try {
                // Check if any of the required fields are empty
                if (
                tfMemberID.getText().isEmpty() ||
                tfName.getText().isEmpty() || 
                tfLocation.getText().isEmpty() || 
                tfPhone.getText().isEmpty() ||
                tfEmail.getText().isEmpty() || 
                tfPaidAmount.getText().isEmpty() ||
                tfTrainersName.getText().isEmpty()
                ) 
                {
                    // Show message if any required field is empty
                    JOptionPane.showMessageDialog(frame,"One or more text fields are empty...!!!", "Alert", JOptionPane.ERROR_MESSAGE);
                } else 
                {
                    // Parse data from the input fields
                    int id = Integer.parseInt(tfMemberID.getText()); // Parse the ID from the text field and convert it to an integer
                    String name = tfName.getText();
                    String location = tfLocation.getText(); 
                    String phone = tfPhone.getText();
                    String email = tfEmail.getText();
                    double paidAmount = Double.parseDouble(tfPaidAmount.getText()); // Parse the Paid Amount
                    String personalTrainer = tfTrainersName.getText();

                    // Determine the selected gender from the radio buttons
                    String gender = radiomale.isSelected() ? "Male" : (radiofemale.isSelected() ? "Female" : "");

                    // Construct the date of birth and membership start date
                    String DOB = Date.getSelectedItem() + "-" + Month.getSelectedItem() + "-" + Year.getSelectedItem();
                    String membershipStartDate = Membershipdate.getSelectedItem() + "-" + Membershipmonth.getSelectedItem() + 
                        "-" + Membershipyear.getSelectedItem();

                    // Gender validation (if not selected)
                    if (gender.isEmpty()) 
                    {
                        JOptionPane.showMessageDialog(frame, "Please select gender", "Alert", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Check if ID is valid (greater than 0)
                    if (id <= 0) 
                    {
                        JOptionPane.showMessageDialog(frame, "ID should be greater than zero", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Check for duplicate ID
                    boolean duplicateId = false;
                    for (GymMember member : gymMember) 
                    {
                        if (member.getId() == id) // Check if the ID already exists in the list
                        {
                            duplicateId = true;
                            break;
                        }
                    }

                    // Show message if ID is a duplicate
                    if (duplicateId) 
                    {
                        JOptionPane.showMessageDialog(frame, "ID already exists. Please enter a unique ID.", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Exit the method to prevent adding the member
                    }

                    // Create a new PremiumMember (downcasting occurs here)
                    PremiumMember Member = new PremiumMember(id, name, location, phone, email, gender, DOB,
                            membershipStartDate, personalTrainer); // Downcast is happening in object creation
                    gymMember.add(Member); // Add the new PremiumMember to the gymMember list

                    // Show success message
                    JOptionPane.showMessageDialog(frame, "Premium Member added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException e) 
            {
                // Handle invalid input for ID or PaidAmount
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid numbers for ID & PaidAmount", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // ACTIVATE MEMBERSHIP BUTTON
        if (ae.getSource() == btnActivateMembership) 
        {
            try {
                // Parse the ID from the text field and convert it to an integer
                int id = Integer.parseInt(tfMemberID.getText());
                boolean activateMembershipFound = false;

                // Loop through the list of gym members to find the member with the specified ID
                for (GymMember member : gymMember) 
                {
                    if (member.getId() == id)   // Check if the current member's ID matches the input ID
                    {
                        member.activateMembership();  // Upcasting: Calling method from superclass `GymMember` (upcasting used implicitly here)

                        // Show success message indicating that the membership was activated
                        JOptionPane.showMessageDialog(frame, "Membership activated successfully", "Sucess", JOptionPane.INFORMATION_MESSAGE);

                        activateMembershipFound = true; // Set to true if member is activated

                        break; // Exit the loop as the member has been found and activated
                    }
                }

                // If the membership was not activated (i.e., member ID was not found), show an error message
                if (!activateMembershipFound) 
                {
                    // Show a message dialog indicating that the input ID was not found
                    JOptionPane.showMessageDialog(frame, "Member ID not found", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException e) 
            {
                // Handle invalid ID format input
                JOptionPane.showMessageDialog(frame, "Invalid ID format", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Deactivate Membership Button
        if (ae.getSource() == btnDeactivateMembership) 
        {
            try {
                // Parse the ID from the text field and convert it to an integer
                int id = Integer.parseInt(tfMemberID.getText());
                boolean deactivateMembershipFound = false;
                // Loop through the list of gym members to find the member with the specified ID
                for (GymMember member : gymMember) 
                {
                    if (member.getId() == id) // Check if the current member's ID matches the input ID
                    {
                        member.deactivateMembership(); // Deactivate the membership for the found member

                        // Show a success message indicating that the membership was deactivated
                        JOptionPane.showMessageDialog(frame, "Membership deactivated successfully", "Success", 
                            JOptionPane.INFORMATION_MESSAGE);

                        deactivateMembershipFound = true;
                        break; // Exit the loop as the member has been found
                    }
                }
                // If the membership was not deactivated (i.e., member ID was not found), show an error message
                if (!deactivateMembershipFound) 
                {
                    // Show a message dialog indicating that the member is not found.
                    JOptionPane.showMessageDialog(frame, "Member ID not found", "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) // Catch any NumberFormatException that occurs during parsing
            {
                // Show a message dialog indicating that the input was not a valid number
                JOptionPane.showMessageDialog(frame, "Invalid ID format", "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }

        // MARK ATTENDANCE BUTTON
        if (ae.getSource() == btnMarkAttendance) 
        {
            try {
                // Parse the ID from the text field and convert it to an integer
                int id = Integer.parseInt(tfMemberID.getText());
                boolean markAttendance = false;
                // Loop through the list of gym members to find the member with the specified ID
                for (GymMember member : gymMember) 
                {
                    if (member.getId() == id) // Check if the current member's ID matches the input ID
                    {
                        markAttendance = true;
                        if (member.activeStatus)  // Check if the member's membership is active
                        {
                            member.markAttendance();  // Mark attendance for the member

                            // Show a success message indicating that attendance was marked
                            JOptionPane.showMessageDialog(frame, "Attendance marked for Member ID: " + id, "Success",
                                JOptionPane.INFORMATION_MESSAGE);
                        } else 
                        {
                            // Show an error message if the membership is not active
                            JOptionPane.showMessageDialog(frame, "Cannot mark attendance. Membership is not active.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        }
                        break;  // Exit the loop as the member has been found and processed
                    }
                }
                if (!markAttendance) 
                {
                    // If attendance was not marked (i.e., member ID was not found), show an error message
                    JOptionPane.showMessageDialog(frame, "Member ID not found.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) 
            {  // Catch any NumberFormatException that occurs during parsing
                // Show a message dialog indicating that the input was not a valid number
                JOptionPane.showMessageDialog(frame, "Please enter a valid numeric Member ID.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }

        // REVERT PREMIUM MEMBER BUTTON
        if (ae.getSource() == btnRevertPremiumMember) 
        {
            try 
            {
                // Parse the ID from the text field and convert it to an integer
                int id = Integer.parseInt(tfMemberID.getText());
                GymMember memberToRemove = null;  // Variable to hold the member to be removed

                // Loop through the list of gym members to find the Premium Member with the specified ID
                for (GymMember member : gymMember) 
                {
                    // **Downcasting**: Checking if the member is a PremiumMember and then downcasting it.
                    if (member instanceof PremiumMember && member.getId() == id) // Check if the member is a PremiumMember and matches the ID
                    {
                        memberToRemove = member;   // Set the member to be removed
                        break;   // Exit the loop as the member has been found
                    }
                }

                if (memberToRemove != null) 
                {
                    gymMember.remove(memberToRemove);  // Remove the member from the gymMember list

                    // Show a success message if Premium Member was reverted (removed)
                    JOptionPane.showMessageDialog(frame, "Premium Member reverted (removed).", "Success", 
                        JOptionPane.INFORMATION_MESSAGE);

                } else 
                {
                    // Show an error message if no Premium Member with the specified ID was found
                    JOptionPane.showMessageDialog(frame, "No Premium Member found with ID Not Found", "Error",
                        JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException e)  // Catch any NumberFormatException that occurs during parsing
            {
                // Show a message dialog indicating that the input was not a valid number
                JOptionPane.showMessageDialog(frame, "Invalid ID. Please enter a valid number.", "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }

        // DISPLAY BUTTON
        if (ae.getSource() == btnDisplay) 
        {
            try {
                // Clear the previous content in the displayArea before adding new data
                displayArea.setText(""); 

                // Initialize a string to hold the member details to display
                String details = "PremiumMembers Details:\n";
                boolean memberFound = false;

                // Loop through all gym members to find and display their details
                for (GymMember member : gymMember) 
                {
                    // **Downcasting**: Checking if the member is an instance of PremiumMember
                    // If the member is a PremiumMember, downcast to access its specific details
                    if (member instanceof PremiumMember) 
                    {
                        // Downcast GymMember to PremiumMember to access its specific attributes
                        PremiumMember premiumMember = (PremiumMember) member;  // **Downcasting** from GymMember to PremiumMember

                        // Append the details of the PremiumMember to the 'details' string
                        details += "ID: " + premiumMember.getId() + "\n" +
                        "Name: " + premiumMember.getName() + "\n" +
                        "Location: " + premiumMember.getLocation() + "\n" +
                        "Phone: " + premiumMember.getPhone() + "\n" +
                        "Email: " + premiumMember.getEmail() + "\n" +
                        "Gender: " + premiumMember.getGender() + "\n" +
                        "DOB: " + premiumMember.getDOB() + "\n" +
                        "Membership Start Date: " + premiumMember.getMembershipStartDate() + "\n" +
                        "PaidAmount: " + premiumMember.getPaidAmount() + "\n" +
                        "DiscountAmount: " + premiumMember.getDiscountAmount() + "\n" +  
                        "Loyalty Points: " + premiumMember.getLoyaltyPoints() + "\n" +
                        "Active Status: " + (premiumMember.getActiveStatus() ? "Active" : "Inactive") + "\n" +
                        "IsFullPayment: " + premiumMember.getIsFullPayment() + "\n" +
                        "Premiumcharge: " + premiumMember.getPremiumcharge() + "\n" +
                        "Personal Trainer: " + premiumMember.getPersonalTrainer() + "\n\n";

                        // Mark that at least one member was found
                        memberFound = true;
                    }
                }

                // If any member was found, display the details in the JTextArea
                if (memberFound) 
                {
                    // Set the content of the JTextArea to the collected member details
                    displayArea.setText(details);
                } else 
                {
                    // If no members were found, display a message indicating no data was available
                    displayArea.setText("No members found to display.\n");
                }

                // Set the displayFrame visible so the user can see the member details
                displayFrame.setVisible(true);

            } catch (NumberFormatException e) 
            {
                // Catch any errors that occur during the display process (e.g., invalid data formatting)
                JOptionPane.showMessageDialog(frame, "An error occurred while displaying members. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // CLEAR BUTTON
        if (ae.getSource() == btnClear) 
        {
            // Clear the text fields by setting their text to an empty string
            tfMemberID.setText(""); // Clear the ID text field
            tfName.setText(""); // Clear the Name text field
            tfLocation.setText(""); // Clear the Location text field
            tfPhone.setText(""); // Clear the Phone text field
            tfEmail.setText(""); // Clear the Email text field
            tfPaidAmount.setText(""); // Clear the Paid Amount text field
            tfTrainersName.setText(""); // Clear the Trainer's Name text field

            // Clear the selection of the radio buttons for gender
            Buttongroup.clearSelection(); // Deselect any selected radio buttons

            // Reset the combo boxes for date of birth to their default (first) option
            Date.setSelectedIndex(0); // Reset the Date combo box to the first item
            Month.setSelectedIndex(0); // Reset the Month combo box to the first item
            Year.setSelectedIndex(0); // Reset the Year combo box to the first item

            // Reset the combo boxes for membership start date to their default (first) option
            Membershipdate.setSelectedIndex(0); // Reset the Membership Date combo box to the first item
            Membershipmonth.setSelectedIndex(0); // Reset the Membership Month combo box to the first item
            Membershipyear.setSelectedIndex(0); // Reset the Membership Year combo box to the first item

            // Reset the combo box for the regular plan to its default (first) option
            REGULARPLAN.setSelectedIndex(0); // Reset the Regular Plan combo box to the first item

            // Clear the JisFullPayment checkbox
            JisFullPayment.setSelected(false); // Deselect the checkbox
        }

        // PAY DUE AMOUNT BUTTON
        if (ae.getSource() == btnpayDueAmount) 
        {
            try {
                int id = Integer.parseInt(tfMemberID.getText()); // Get the member ID from the text field

                for (GymMember member : gymMember) 
                {
                    if (member.getId() == id) // Check if the ID matches
                    {
                        // Downcasting: GymMember is being cast to PremiumMember because the method is specific to PremiumMember
                        if (member instanceof PremiumMember) 
                        {
                            PremiumMember premium = (PremiumMember) member; // Downcasting from GymMember to PremiumMember

                            double paidAmount = Double.parseDouble(tfPaidAmount.getText()); // Get the paid amount

                            // Call the payment method and get the result message
                            String resultMessage = premium.payDueAmount(paidAmount);

                            // Display payment status message
                            JOptionPane.showMessageDialog(frame, resultMessage, "Payment Status", JOptionPane.INFORMATION_MESSAGE);
                        } else 
                        {
                            JOptionPane.showMessageDialog(frame, "Member is not a Premium member.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        return; // Exit after processing the payment
                    }
                }
                // If the Member ID was not found
                JOptionPane.showMessageDialog(frame, "Member ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) 
            {
                // Handle errors in parsing Member ID or Due Amount
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter valid numbers for ID and due amount.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // CALCULATE DISCOUNT BUTTON
        if (ae.getSource() == btnCalculateDiscount) 
        {
            try {
                int id = Integer.parseInt(tfMemberID.getText()); // Get the member ID from the text field

                for (GymMember member : gymMember) 
                {
                    if (member.getId() == id) // Check if the ID matches
                    {
                        // Downcasting: GymMember is being cast to PremiumMember because the method is specific to PremiumMember
                        if (member instanceof PremiumMember) 
                        {
                            PremiumMember premium = (PremiumMember) member; // Downcasting from GymMember to PremiumMember

                            premium.calculateDiscount(); // Call the void method

                            // Check discountAmount field after method runs
                            if (premium.getDiscountAmount() > 0) 
                            {
                                JOptionPane.showMessageDialog(frame, "Discount Applied: " + premium.getDiscountAmount(), "Discount", JOptionPane.INFORMATION_MESSAGE);
                            } else 
                            {
                                JOptionPane.showMessageDialog(frame, "No discount applied. Payment is not completed.", "Info", JOptionPane.WARNING_MESSAGE);
                            }
                        } else 
                        {
                            JOptionPane.showMessageDialog(frame, "Member is not a Premium member.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        return;
                    }
                }

                JOptionPane.showMessageDialog(frame, "Member ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid number for Member ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        //SAVE TO FILE button
        if (ae.getSource() == btnsavetofile) 
        {
            try {
                // Parse the input from the Member ID text field as an integer
                int id = Integer.parseInt(tfMemberID.getText());
                boolean memberFound = false;

                // Iterate through the list of GymMember objects
                for (GymMember member : gymMember) 
                {
                    // Check if the member is a PremiumMember and the ID matches
                    if (member instanceof PremiumMember && member.getId() == id) 
                    {
                        PremiumMember premium = (PremiumMember) member;
                        memberFound = true;

                        // Create a FileWriter object to write member data to a file
                        // This will overwrite the file if it already exists
                        writer = new FileWriter("PremiumMemberDetails.txt");

                        // Write the column headers into the file using formatted string for alignment
                        writer.write(String.format(
                                "%-6s %-18s %-11s %-13s %-24s %-14s %-9s %-18s %-15s %-18s %-18s %-15s %-18s%n",
                                "ID", "Name", "Location", "Phone", "Email", "DOB", "Gender", "Member Start Date",
                                "Paid Amount", "Discount Amount", "Loyalty Points", "Active Status", "Full Payment"
                            ));

                        // Write the details of the premium member in the same aligned format
                        writer.write(String.format(
                                "%-6d %-18s %-11s %-13s %-24s %-14s %-10s %-18s %-15.2f %-18.2f %-18.2f %-15s %-18s%n",
                                premium.getId(),                    // Member ID
                                premium.getName(),                  // Name
                                premium.getLocation(),              // Location
                                premium.getPhone(),                 // Phone Number
                                premium.getEmail(),                 // Email Address
                                premium.getDOB(),                   // Date of Birth
                                premium.getGender(),                // Gender
                                premium.getMembershipStartDate(),   // Membership start date
                                premium.getPaidAmount(),            // Paid amount
                                premium.getDiscountAmount(),        // Discount amount
                                premium.getLoyaltyPoints(),         // Loyalty points earned
                                premium.getActiveStatus() ? "Active" : "Inactive", // Active status
                                premium.getIsFullPayment()          // Whether payment is in full
                            ));

                        // Close the file after writing
                        writer.close();

                        // Show success message in a dialog box
                        JOptionPane.showMessageDialog(frame, "Premium member ID " + id + " saved to file successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                }

                // If no matching PremiumMember was found, show warning dialog
                if (!memberFound) {
                    JOptionPane.showMessageDialog(frame, "No Premium Member found with ID: " + id, "Not Found", JOptionPane.WARNING_MESSAGE);
                }

            } catch (NumberFormatException e) {
                // Handle case where the input is not a valid integer
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a numeric Member ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                // Handle any other unexpected errors such as file permission issues
                JOptionPane.showMessageDialog(frame, "Error saving to file. Please check permissions or storage.", "File Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // READ FROM FILE BUTTON
        if (ae.getSource() == btnreadfromfile) 
        {
            try {
                // Retrieve the Member ID from the text field and attempt to parse it to an integer
                int id = Integer.parseInt(tfMemberID.getText());

                // Flag to check if the member is found
                boolean memberFound = false;

                // Create a file object for the PremiumMemberDetails.txt file
                file = new File("PremiumMemberDetails.txt");

                // Check if the file exists; if not, display a warning message and exit
                if (!file.exists()) 
                {
                    JOptionPane.showMessageDialog(frame, "No saved file found!", "ERROR", JOptionPane.WARNING_MESSAGE);
                    return; // Exit if file doesn't exist
                }

                // Create a FileReader to read the contents of the file
                reader = new FileReader(file);

                // Variable to hold the file content as we read it
                String content = "";
                int c;

                // Read each character from the file until end of file is reached
                while ((c = reader.read()) != -1) 
                {
                    content += (char) c;  // Append the character to the content string
                }

                // Close the reader after reading all content
                reader.close();

                // Set the content to be displayed in the JTextArea
                displayArea.setText(content);

                // Make the display frame visible to show the contents to the user
                displayFrame.setVisible(true);

            } catch (NumberFormatException e) 
            {
                // Handle any errors related to parsing the Member ID input
                JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a numeric Member ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) 
            {
                // Handle any general exceptions (e.g., issues with file reading)
                JOptionPane.showMessageDialog(frame, "Error reading from file.", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) 
    {
        // Create a new instance of the Gym class to start the application
        new GymGUI (); 
    }
}
