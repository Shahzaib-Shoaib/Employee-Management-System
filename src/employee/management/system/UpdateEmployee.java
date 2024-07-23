/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

/**
 *
 * @author shahz
 */

import java.awt.*; // Import AWT components for GUI
import javax.swing.*; // Import Swing components for GUI
import java.awt.event.*; // Import AWT event classes for handling actions
import java.sql.*; // Import SQL components for database operations

public class UpdateEmployee extends JFrame implements ActionListener {

    // Declare GUI components
    JTextField tfeducation, tffname, tfaddress, tfphone, tfemail, tfsalary, tfdesignation;
    JLabel lblempId;
    JButton add, back;
    String empId; // Store employee ID

    // Constructor to initialize the UpdateEmployee frame
    UpdateEmployee(String empId) {
        this.empId = empId; // Initialize employee ID
        getContentPane().setBackground(Color.WHITE); // Set background color of the content pane
        setLayout(null); // Disable default layout manager for absolute positioning

        // Create and configure heading label
        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320, 30, 500, 50); // Set position and size
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25)); // Set font
        add(heading); // Add label to the frame

        // Create and configure 'Name' label and display field
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30); // Set position and size
        labelname.setFont(new Font("serif", Font.PLAIN, 20)); // Set font
        add(labelname); // Add label to the frame

        JLabel lblname = new JLabel(); // Label to display employee name
        lblname.setBounds(200, 150, 150, 30); // Set position and size
        add(lblname); // Add label to the frame

        // Create and configure 'Father's Name' label and text field
        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400, 150, 150, 30); // Set position and size
        labelfname.setFont(new Font("serif", Font.PLAIN, 20)); // Set font
        add(labelfname); // Add label to the frame

        tffname = new JTextField(); // Text field for father's name
        tffname.setBounds(600, 150, 150, 30); // Set position and size
        add(tffname); // Add text field to the frame

        // Create and configure 'Date of Birth' label and display field
        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30); // Set position and size
        labeldob.setFont(new Font("serif", Font.PLAIN, 20)); // Set font
        add(labeldob); // Add label to the frame

        JLabel lbldob = new JLabel(); // Label to display date of birth
        lbldob.setBounds(200, 200, 150, 30); // Set position and size
        add(lbldob); // Add label to the frame

        // Create and configure 'Salary' label and text field
        JLabel labelsalary = new JLabel("Salary");
        labelsalary.setBounds(400, 200, 150, 30); // Set position and size
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20)); // Set font
        add(labelsalary); // Add label to the frame

        tfsalary = new JTextField(); // Text field for salary
        tfsalary.setBounds(600, 200, 150, 30); // Set position and size
        add(tfsalary); // Add text field to the frame

        // Create and configure 'Address' label and text field
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30); // Set position and size
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20)); // Set font
        add(labeladdress); // Add label to the frame

        tfaddress = new JTextField(); // Text field for address
        tfaddress.setBounds(200, 250, 150, 30); // Set position and size
        add(tfaddress); // Add text field to the frame

        // Create and configure 'Phone' label and text field
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30); // Set position and size
        labelphone.setFont(new Font("serif", Font.PLAIN, 20)); // Set font
        add(labelphone); // Add label to the frame

        tfphone = new JTextField(); // Text field for phone
        tfphone.setBounds(600, 250, 150, 30); // Set position and size
        add(tfphone); // Add text field to the frame

        // Create and configure 'Email' label and text field
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30); // Set position and size
        labelemail.setFont(new Font("serif", Font.PLAIN, 20)); // Set font
        add(labelemail); // Add label to the frame

        tfemail = new JTextField(); // Text field for email
        tfemail.setBounds(200, 300, 150, 30); // Set position and size
        add(tfemail); // Add text field to the frame

        // Create and configure 'Highest Education' label and text field
        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(400, 300, 150, 30); // Set position and size
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20)); // Set font
        add(labeleducation); // Add label to the frame

        tfeducation = new JTextField(); // Text field for highest education
        tfeducation.setBounds(600, 300, 150, 30); // Set position and size
        add(tfeducation); // Add text field to the frame

        // Create and configure 'Designation' label and text field
        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50, 350, 150, 30); // Set position and size
        labeldesignation.setFont(new Font("serif", Font.PLAIN, 20)); // Set font
        add(labeldesignation); // Add label to the frame

        tfdesignation = new JTextField(); // Text field for designation
        tfdesignation.setBounds(200, 350, 150, 30); // Set position and size
        add(tfdesignation); // Add text field to the frame

        // Create and configure 'Employee ID' label and display field
        JLabel labelempId = new JLabel("Employee ID");
        labelempId.setBounds(50, 400, 150, 30); // Set position and size
        labelempId.setFont(new Font("serif", Font.PLAIN, 20)); // Set font
        add(labelempId); // Add label to the frame

        lblempId = new JLabel(); // Label to display employee ID
        lblempId.setBounds(200, 400, 150, 30); // Set position and size
        lblempId.setFont(new Font("serif", Font.PLAIN, 20)); // Set font
        add(lblempId); // Add label to the frame

        // Fetch and display employee details from the database
        try {
            Conn c = new Conn();
            String query = "select * from employee where empId = '" + empId + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                lblempId.setText(rs.getString("empId"));
                tfdesignation.setText(rs.getString("designation"));
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print exception details
        }

        // Create and configure 'Update Details' button
        add = new JButton("Update Details");
        add.setBounds(250, 550, 150, 40); // Set position and size
        add.addActionListener(this); // Add action listener
        add.setBackground(Color.BLACK); // Set background color
        add.setForeground(Color.WHITE); // Set text color
        add(add); // Add button to the frame

        // Create and configure 'Back' button
        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40); // Set position and size
        back.addActionListener(this); // Add action listener
        back.setBackground(Color.BLACK); // Set background color
        back.setForeground(Color.WHITE); // Set text color
        add(back); // Add button to the frame

        setSize(900, 700); // Set frame size
        setLocation(300, 50); // Set frame location
        setVisible(true); // Make frame visible
    }

    // Handle button click events
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) { // If 'Update Details' button is clicked
            // Get text field values
            String fname = tffname.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String education = tfeducation.getText();
            String designation = tfdesignation.getText();

            // Update employee details in the database
            try {
                Conn conn = new Conn();
                String query = "update employee set fname = '" + fname + "', salary = '" + salary + "', address = '" + address + "', phone = '" + phone + "', email =  '" + email + "', education = '" + education + "', designation = '" + designation + "' where empId = '" + empId + "'";
                conn.s.executeUpdate(query); // Execute update query
                JOptionPane.showMessageDialog(null, "Details updated successfully"); // Show success message
                setVisible(false); // Hide current frame
                new Home(); // Open Home frame
            } catch (Exception e) {
                e.printStackTrace(); // Print exception details
            }
        } else { // If 'Back' button is clicked
            setVisible(false); // Hide current frame
            new Home(); // Open Home frame
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee(""); // Create and display UpdateEmployee frame
    }
}
