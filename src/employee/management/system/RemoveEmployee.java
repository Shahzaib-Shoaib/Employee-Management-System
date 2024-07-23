/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

/**
 *
 * @author shahz
 */
import javax.swing.*; // Import Swing components for GUI
import java.awt.*; // Import AWT components for GUI
import java.sql.*; // Import SQL components for database operations
import java.awt.event.*; // Import AWT event classes for handling actions

public class RemoveEmployee extends JFrame implements ActionListener {

    Choice cEmpId; // Choice component for employee IDs
    JButton delete, back; // Buttons for delete and back actions

    RemoveEmployee() {
        getContentPane().setBackground(Color.WHITE); // Set background color of the content pane
        setLayout(null); // Disable default layout manager for absolute positioning

        // Create and configure 'Employee Id' label
        JLabel labelempId = new JLabel("Employee Id");
        labelempId.setBounds(50, 50, 100, 30); // Set position and size
        add(labelempId); // Add label to the frame

        // Create and configure choice component for employee IDs
        cEmpId = new Choice();
        cEmpId.setBounds(200, 50, 150, 30); // Set position and size
        add(cEmpId); // Add choice component to the frame

        // Populate employee IDs in the choice component from the database
        try {
            Conn c = new Conn();
            String query = "select * from employee"; // SQL query to select all employees
            ResultSet rs = c.s.executeQuery(query); // Execute query
            while (rs.next()) {
                cEmpId.add(rs.getString("empId")); // Add employee IDs to choice component
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print exception details
        }

        // Create and configure 'Name' label
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 100, 100, 30); // Set position and size
        add(labelname); // Add label to the frame

        // Create and configure label to display employee name
        JLabel lblname = new JLabel();
        lblname.setBounds(200, 100, 100, 30); // Set position and size
        add(lblname); // Add label to the frame

        // Create and configure 'Phone' label
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50, 150, 100, 30); // Set position and size
        add(labelphone); // Add label to the frame

        // Create and configure label to display employee phone
        JLabel lblphone = new JLabel();
        lblphone.setBounds(200, 150, 100, 30); // Set position and size
        add(lblphone); // Add label to the frame

        // Create and configure 'Email' label
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 200, 100, 30); // Set position and size
        add(labelemail); // Add label to the frame

        // Create and configure label to display employee email
        JLabel lblemail = new JLabel();
        lblemail.setBounds(200, 200, 100, 30); // Set position and size
        add(lblemail); // Add label to the frame

        // Update employee details when a different ID is selected
        cEmpId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from employee where empId = '" + cEmpId.getSelectedItem() + "'"; // SQL query to select employee by ID
                    ResultSet rs = c.s.executeQuery(query); // Execute query
                    while (rs.next()) {
                        lblname.setText(rs.getString("name")); // Set name label text
                        lblphone.setText(rs.getString("phone")); // Set phone label text
                        lblemail.setText(rs.getString("email")); // Set email label text
                    }
                } catch (Exception e) {
                    e.printStackTrace(); // Print exception details
                }
            }
        });

        // Create and configure 'Delete' button
        delete = new JButton("Delete");
        delete.setBounds(80, 300, 100, 30); // Set position and size
        delete.setBackground(Color.BLACK); // Set background color
        delete.setForeground(Color.WHITE); // Set text color
        delete.addActionListener(this); // Add action listener
        add(delete); // Add button to the frame

        // Create and configure 'Back' button
        back = new JButton("Back");
        back.setBounds(220, 300, 100, 30); // Set position and size
        back.setBackground(Color.BLACK); // Set background color
        back.setForeground(Color.WHITE); // Set text color
        back.addActionListener(this); // Add action listener
        add(back); // Add button to the frame

        // Load and scale background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); // Create label with background image
        image.setBounds(350, 0, 600, 400); // Set position and size
        add(image); // Add image label to the frame

        setSize(1000, 400); // Set frame size
        setLocation(300, 150); // Set frame location
        setVisible(true); // Make frame visible
    }

    // Handle button click events
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) { // If 'Delete' button is clicked
            try {
                Conn c = new Conn();
                String query = "delete from employee where empId = '" + cEmpId.getSelectedItem() + "'"; // SQL query to delete employee by ID
                c.s.executeUpdate(query); // Execute delete query
                JOptionPane.showMessageDialog(null, "Employee Information Deleted Successfully"); // Show success message
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
        new RemoveEmployee(); // Create and display RemoveEmployee frame
    }
}
