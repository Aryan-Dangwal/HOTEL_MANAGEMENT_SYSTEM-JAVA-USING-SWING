import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelBookingSystemGUI extends JFrame {
    private JLabel nameLabel;
    private JLabel mobileNumberLabel;
    private JLabel emailIdLabel;
    private JLabel roomTypeLabel;
    private JLabel acLabel;
    private JLabel checkInLabel;
    private JLabel checkOutLabel;
    private JLabel roomPreferenceLabel;
    private JLabel addressLabel;
    private JLabel cityLabel;
    private JLabel checkInTimeLabel;
    private JLabel checkOutTimeLabel;
    private JLabel adultsLabel;
    private JLabel childrenLabel;
    private JLabel paymentMethodLabel;

    private JTextField nameTextField;
    private JTextField mobileNumberTextField;
    private JTextField emailIdTextField;
    private JTextField checkInTextField;
    private JTextField checkOutTextField;
    private JTextField addressTextField;
    private JTextField cityTextField;
    private JTextField checkInTimeTextField;
    private JTextField checkOutTimeTextField;
    private JTextField adultsTextField;
    private JTextField childrenTextField;

    private JComboBox<String> roomTypeComboBox;
    private JCheckBox acCheckBox;
    private JComboBox<String> roomPreferenceComboBox;
    private JComboBox<String> paymentMethodComboBox;

    private JButton bookButton;

    private JLabel loginLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public HotelBookingSystemGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("HOTEL RESERVATION SYSTEM");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel loginPanel = new JPanel(new GridBagLayout());
        GridBagConstraints lc = new GridBagConstraints();
        lc.insets = new Insets(5, 5, 5, 5);

        loginLabel = new JLabel("Login");
        lc.gridx = 0;
        lc.gridy = 0;
        lc.gridwidth = 2;
        loginPanel.add(loginLabel, lc);

        lc.gridwidth = 1;
        lc.gridx = 0;
        lc.gridy = 1;
        usernameLabel = new JLabel("Username:");
        loginPanel.add(usernameLabel, lc);
        lc.gridx = 1;
        usernameField = new JTextField(20);
        loginPanel.add(usernameField, lc);

        lc.gridx = 0;
        lc.gridy = 2;
        passwordLabel = new JLabel("Password:");
        loginPanel.add(passwordLabel, lc);
        lc.gridx = 1;
        passwordField = new JPasswordField(20);
        loginPanel.add(passwordField, lc);

        lc.gridx = 0;
        lc.gridy = 3;
        lc.gridwidth = 2;
        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();

                if (username.equals("admin") && String.valueOf(password).equals("password")) {
                    loginPanel.setVisible(false);
                    displayBookingPanel();
                } else {
                    JOptionPane.showMessageDialog(HotelBookingSystemGUI.this, "Invalid login credentials");
                }
                passwordField.setText("");
            }
        });
        loginPanel.add(loginButton, lc);

        add(loginPanel);

        setVisible(true);
    }

    private void displayBookingPanel() {
        getContentPane().removeAll();
        revalidate();
        repaint();

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        nameLabel = new JLabel("Name:");
        mobileNumberLabel = new JLabel("Mobile Number:");
        emailIdLabel = new JLabel("Email ID:");
        roomTypeLabel = new JLabel("Room Type:");
        acLabel = new JLabel("AC:");
        checkInLabel = new JLabel("Check-in Date:");
        checkOutLabel = new JLabel("Check-out Date");
        roomPreferenceLabel = new JLabel("Room Preference:");
        addressLabel = new JLabel("Address:");
        cityLabel = new JLabel("City:");
        checkInTimeLabel = new JLabel("Check-in Time:");
        checkOutTimeLabel = new JLabel("Check-out Time:");
        adultsLabel = new JLabel("Number of Adults:");
        childrenLabel = new JLabel("Number of Children:");
        paymentMethodLabel = new JLabel("Preferred Payment Method:");

        nameTextField = new JTextField(20);
        mobileNumberTextField = new JTextField(20);
        emailIdTextField = new JTextField(20);
        checkInTextField = new JTextField(20);
        checkOutTextField = new JTextField(20);
        addressTextField = new JTextField(20);
        cityTextField = new JTextField(20);
        checkInTimeTextField = new JTextField(20);
        checkOutTimeTextField = new JTextField(20);
        adultsTextField = new JTextField(20);
        childrenTextField = new JTextField(20);

        roomTypeComboBox = new JComboBox<>();
        roomTypeComboBox.addItem("2 Sharing");
        roomTypeComboBox.addItem("3 Sharing");

        acCheckBox = new JCheckBox();

        roomPreferenceComboBox = new JComboBox<>();
        roomPreferenceComboBox.addItem("Standard");
        roomPreferenceComboBox.addItem("Deluxe");
        roomPreferenceComboBox.addItem("Suite");

        paymentMethodComboBox = new JComboBox<>();
        paymentMethodComboBox.addItem("Credit Card");
        paymentMethodComboBox.addItem("Debit Card");
        paymentMethodComboBox.addItem("Cash");
        paymentMethodComboBox.addItem("UPI");

        bookButton = new JButton("Book Now");
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                String mobileNumber = mobileNumberTextField.getText();
                String emailId = emailIdTextField.getText();
                String roomType = (String) roomTypeComboBox.getSelectedItem();
                boolean ac = acCheckBox.isSelected();
                String checkInDate = checkInTextField.getText();
                String checkOutDate = checkOutTextField.getText();
                String roomPreference = (String) roomPreferenceComboBox.getSelectedItem();
                String address = addressTextField.getText();
                String city = cityTextField.getText();
                String checkInTime = checkInTimeTextField.getText();
                String checkOutTime = checkOutTimeTextField.getText();
                String adults = adultsTextField.getText();
                String children = childrenTextField.getText();
                String paymentMethod = (String) paymentMethodComboBox.getSelectedItem();

                // Perform booking logic here

                // For testing, display the collected data in a message dialog
                String bookingInfo = "Name: " + name + "\n" +
                        "Mobile Number: " + mobileNumber + "\n" +
                        "Email ID: " + emailId + "\n" +
                        "Room Type: " + roomType + "\n" +
                        "AC: " + (ac ? "Yes" : "No") + "\n" +
                        "Check-in Date: " + checkInDate + "\n" +
                        "Check-out Date: " + checkOutDate + "\n" +
                        "Room Preference: " + roomPreference + "\n" +
                        "Address: " + address + "\n" +
                        "City: " + city + "\n" +
                        "Check-in Time: " + checkInTime + "\n" +
                        "Check-out Time: " + checkOutTime + "\n" +
                        "Number of Adults: " + adults + "\n" +
                        "Number of Children: " + children + "\n" +
                        "Payment Method: " + paymentMethod;

                JOptionPane.showMessageDialog(HotelBookingSystemGUI.this, bookingInfo, "Booking Information", JOptionPane.INFORMATION_MESSAGE);
            }
        });

 // ...

c.gridx = 0;
c.gridy = 0;
panel.add(nameLabel, c);
c.gridx = 1;
panel.add(nameTextField, c);

c.gridx = 0;
c.gridy = 1;
panel.add(mobileNumberLabel, c);
c.gridx = 1;
panel.add(mobileNumberTextField, c);

c.gridx = 0;
c.gridy = 2;
panel.add(emailIdLabel, c);
c.gridx = 1;
panel.add(emailIdTextField, c);

c.gridx = 0;
c.gridy = 3;
panel.add(addressLabel, c);
c.gridx = 1;
panel.add(addressTextField, c);

c.gridx = 0;
c.gridy = 4;
panel.add(cityLabel, c);
c.gridx = 1;
panel.add(cityTextField, c);

c.gridx = 0;
c.gridy = 5;
panel.add(roomTypeLabel, c);
c.gridx = 1;
panel.add(roomTypeComboBox, c);

c.gridx = 0;
c.gridy = 6;
panel.add(acLabel, c);
c.gridx = 1;
panel.add(acCheckBox, c);

c.gridx = 0;
c.gridy = 7;
panel.add(roomPreferenceLabel, c);
c.gridx = 1;
panel.add(roomPreferenceComboBox, c);

c.gridx = 0;
c.gridy = 8;
panel.add(adultsLabel, c);
c.gridx = 1;
panel.add(adultsTextField, c);

c.gridx = 0;
c.gridy = 9;
panel.add(childrenLabel, c);
c.gridx = 1;
panel.add(childrenTextField, c);

c.gridx = 0;
c.gridy = 10;
panel.add(checkInLabel, c);
c.gridx = 1;
panel.add(checkInTextField, c);

c.gridx = 0;
c.gridy = 11;
panel.add(checkOutLabel, c);
c.gridx = 1;
panel.add(checkOutTextField, c);

c.gridx = 0;
c.gridy = 12;
panel.add(checkInTimeLabel, c);
c.gridx = 1;
panel.add(checkInTimeTextField, c);

c.gridx = 0;
c.gridy = 13;
panel.add(checkOutTimeLabel, c);
c.gridx = 1;
panel.add(checkOutTimeTextField, c);

c.gridx = 0;
c.gridy = 14;
panel.add(paymentMethodLabel, c);
c.gridx = 1;
panel.add(paymentMethodComboBox, c);

c.gridx = 0;
c.gridy = 15;
c.gridwidth = 2;
panel.add(bookButton, c);

// ...


        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HotelBookingSystemGUI();
            }
        });
    }
}
