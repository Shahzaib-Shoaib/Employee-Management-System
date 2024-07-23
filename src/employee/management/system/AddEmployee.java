/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

/**
 *
 * @author shahz
 */
import java.awt.*; // Import AWT package for GUI components
import javax.swing.*; // Import Swing package for GUI components
import com.toedter.calendar.JDateChooser; // Import JDateChooser for date selection
import java.util.*; // Import util package for Random class
import java.awt.event.*; // Import event package for ActionListener

public class AddEmployee extends JFrame implements ActionListener {

    Random ran = new Random(); // Create Random object
    int number = ran.nextInt(999999); // Generate a random employee ID

    JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfsalary, tfdesignation; // Declare text fields
    JDateChooser dcdob; // Declare date chooser
    JComboBox cbeducation; // Declare combo box for education
    JLabel lblempId; // Declare label for employee ID
    JButton add, back; // Declare buttons

    AddEmployee() {
        getContentPane().setBackground(Color.WHITE); // Set background color
        setLayout(null); // Disable default layout

        JLabel heading = new JLabel("Add Employee Detail"); // Create heading label
        heading.setBounds(320, 30, 500, 50); // Set position and size
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25)); // Set font
        add(heading); // Add heading to the frame

        JLabel labelname = new JLabel("Name"); // Create label for name
        labelname.setBounds(50, 150, 150, 30); // Set position and size
        labelname.setFont(new Font("serif", Font.PLAIN, 20)); // Set font
        add(labelname); // Add label to the frame

        tfname = new JTextField(); // Create text field for name
        tfname.setBounds(200, 150, 150, 30); // Set position and size
        add(tfname); // Add text field to the frame

        JLabel labelfname = new JLabel("Father's Name"); // Create label for father's name
        labelfname.setBounds(400, 150, 150, 30); // Set position and size
        labelfname.setFont(new Font("serif", Font.PLAIN, 20)); // Set font
        add(labelfname); // Add label to the frame

        tffname = new JTextField(); // Create text field for father's name
        tffname.setBounds(600, 150, 150, 30); // Set position and size
        add(tffname); // Add text field to the frame

        JLabel labeldob = new JLabel("Date of Birth"); // Create label for date of birth
        labeldob.setBounds(50, 200, 150, 30); // Set position and size
        labeldob.setFont(new Font("serif", Font.PLAIN, 20)); // Set font
        add(labeldob); // Add label to the frame

        dcdob = new JDateChooser(); // Create date chooser for date of birth
        dcdob.setBounds(200, 200, 150, 30); // Set position and size
        add(dcdob); // Add date chooser to the frame

        JLabel labelsalary = new JLabel("Salary"); // Create label for salary
        labelsalary.setBounds(400, 200, 150, 30); // Set position and size
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20)); // Set font
        add(labelsalary); // Add label to the frame

        tfsalary = new JTextField(); // Create text field for salary
        tfsalary.setBounds(600, 200, 150, 30); // Set position and size
        add(tfsalary); // Add text field to the frame

        JLabel labeladdress = new JLabel("Address"); // Create label for address
        labeladdress.setBounds(50, 250, 150, 30); // Set position and size
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20)); // Set font
        add(labeladdress); // Add label to the frame

        tfaddress = new JTextField(); // Create text field for address
        tfaddress.setBounds(200, 250, 150, 30); // Set position and size
        add(tfaddress); // Add text field to the frame

        JLabel labelphone = new JLabel("Phone"); // Create label for phone
        labelphone.setBounds(400, 250, 150, 30); // Set position and size
        labelphone.setFont(new Font("serif", Font.PLAIN, 20)); // Set font
        add(labelphone); // Add label to the frame

        tfphone = new JTextField(); // Create text field for phone
        tfphone.setBounds(600, 250, 150, 30); // Set position and size
        add(tfphone); // Add text field to the frame

        JLabel labelemail = new JLabel("Email"); // Create label for email
        labelemail.setBounds(50, 300, 150, 30); // Set position and size
        labelemail.setFont(new Font("serif", Font.PLAIN, 20)); // Set font
        add(labelemail); // Add label to the frame

        tfemail = new JTextField(); // Create text field for email
        tfemail.setBounds(200, 300, 150, 30); // Set position and size
        add(tfemail); // Add text field to the frame

        JLabel labeleducation = new JLabel("Higest Education"); // Create label for highest education
        labeleducation.setBounds(400, 300, 150, 30); // Set position and size
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20)); // Set font
        add(labeleducation); // Add label to the frame

        String courses[] = {"BBA", "BCA", "BA", "BSC", "B.COM", "BTech", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"}; // Array of education options
        cbeducation = new JComboBox(courses); // Create combo box for education
        cbeducation.setBackground(Color.WHITE); // Set background color
        cbeducation.setBounds(600, 300, 150, 30); // Set position and size
        add(cbeducation); // Add combo box to the frame

        JLabel labeldesignation = new JLabel("Designation"); // Create label for designation
        labeldesignation.setBounds(50, 350, 150, 30); // Set position and size
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20)); // Set font
        add(labeldesignation); // Add label to the frame

        tfdesignation = new JTextField(); // Create text field for designation
        tfdesignation.setBounds(200, 350, 150, 30); // Set position and size
        add(tfdesignation); // Add text field to the frame

        JLabel labelempId = new JLabel("Employee id"); // Create label for employee ID
        labelempId.setBounds(50, 400, 150, 30); // Set position and size
        labelempId.setFont(new Font("serif", Font.PLAIN, 20)); // Set font
        add(labelempId); // Add label to the frame

        lblempId = new JLabel("" + number); // Display generated employee ID
        lblempId.setBounds(200, 400, 150, 30); // Set position and size
        lblempId.setFont(new Font("serif", Font.PLAIN, 20)); // Set font
        add(lblempId); // Add label to the frame

        add = new JButton("Add Details"); // Create 'Add Details' button
        add.setBounds(250, 550, 150, 40); // Set position and size
        add.addActionListener(this); // Add action listener for button
        add.setBackground(Color.BLACK); // Set background color
        add.setForeground(Color.WHITE); // Set foreground color
        add(add); // Add button to the frame

        back = new JButton("Back"); // Create 'Back' button
        back.setBounds(450, 550, 150, 40); // Set position and size
        back.addActionListener(this); // Add action listener for button
        back.setBackground(Color.BLACK); // Set background color
        back.setForeground(Color.WHITE); // Set foreground color
        add(back); // Add button to the frame

        setSize(900, 700); // Set frame size
        setLocation(300, 50); // Set frame location
        setVisible(true); // Make frame visible
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) { // Check if 'Add Details' button is clicked
            String name = tfname.getText(); // Get text from name field
            String fname = tffname.getText(); // Get text from father's name field
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText(); // Get text from date of birth field
            String salary = tfsalary.getText(); // Get text from salary field
            String address = tfaddress.getText(); // Get text from address field
            String phone = tfphone.getText(); // Get text from phone field
            String email = tfemail.getText(); // Get text from email field
            String education = (String) cbeducation.getSelectedItem(); // Get selected item from education combo box
            String designation = tfdesignation.getText(); // Get text from designation field
            String empId = lblempId.getText(); // Get text from employee ID label

            try {
                Conn conn = new Conn(); // Create connection object
                String query = "insert into employee values('" + name + "', '" + fname + "', '" + dob + "', '" + salary + "', '" + address + "', '" + phone + "', '" + email + "', '" + education + "', '" + designation + "',  '" + empId + "')"; // Prepare insert query
                conn.s.executeUpdate(query); // Execute insert query
                JOptionPane.showMessageDialog(null, "Details added successfully"); // Show success message
                setVisible(false); // Hide current frame
                new Home(); // Open Home frame
            } catch (Exception e) {
                e.printStackTrace(); // Print exception details
            }
        } else {
            setVisible(false); // Hide current frame
            new Home(); // Open Home frame
        }
    }

    public static void main(String[] args) {
        new AddEmployee(); // Create and display AddEmployee frame
    }
}
