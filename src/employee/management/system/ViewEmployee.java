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
import net.proteanit.sql.DbUtils; // Import DbUtils for converting ResultSet to TableModel
import java.awt.event.*; // Import AWT event classes for handling actions

public class ViewEmployee extends JFrame implements ActionListener {

    // Declare GUI components
    JTable table;
    Choice cemployeeId;
    JButton search, print, update, back;

    // Constructor to initialize the ViewEmployee frame
    ViewEmployee() {
        getContentPane().setBackground(Color.WHITE); // Set background color of the content pane
        setLayout(null); // Disable default layout manager for absolute positioning

        // Create and configure 'Search by Employee Id' label and choice box
        JLabel searchlbl = new JLabel("Search by Employee Id");
        searchlbl.setBounds(20, 20, 150, 20); // Set position and size
        add(searchlbl); // Add label to the frame

        cemployeeId = new Choice(); // Choice box for employee IDs
        cemployeeId.setBounds(180, 20, 150, 20); // Set position and size
        add(cemployeeId); // Add choice box to the frame

        // Populate choice box with employee IDs from the database
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            while (rs.next()) {
                cemployeeId.add(rs.getString("empId")); // Add employee IDs to the choice box
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print exception details
        }

        table = new JTable(); // Create table to display employee data

        // Populate table with employee data from the database
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs)); // Convert ResultSet to TableModel and set to table
        } catch (Exception e) {
            e.printStackTrace(); // Print exception details
        }

        JScrollPane jsp = new JScrollPane(table); // Add table to JScrollPane for scrolling capability
        jsp.setBounds(0, 100, 900, 600); // Set position and size
        add(jsp); // Add JScrollPane to the frame

        // Create and configure 'Search' button
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20); // Set position and size
        search.addActionListener(this); // Add action listener
        add(search); // Add button to the frame

        // Create and configure 'Print' button
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20); // Set position and size
        print.addActionListener(this); // Add action listener
        add(print); // Add button to the frame

        // Create and configure 'Update' button
        update = new JButton("Update");
        update.setBounds(220, 70, 80, 20); // Set position and size
        update.addActionListener(this); // Add action listener
        add(update); // Add button to the frame

        // Create and configure 'Back' button
        back = new JButton("Back");
        back.setBounds(320, 70, 80, 20); // Set position and size
        back.addActionListener(this); // Add action listener
        add(back); // Add button to the frame

        setSize(900, 700); // Set frame size
        setLocation(300, 100); // Set frame location
        setVisible(true); // Make frame visible
    }

    // Handle button click events
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) { // If 'Search' button is clicked
            String query = "select * from employee where empId = '" + cemployeeId.getSelectedItem() + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs)); // Update table with search results
            } catch (Exception e) {
                e.printStackTrace(); // Print exception details
            }
        } else if (ae.getSource() == print) { // If 'Print' button is clicked
            try {
                table.print(); // Print the table contents
            } catch (Exception e) {
                e.printStackTrace(); // Print exception details
            }
        } else if (ae.getSource() == update) { // If 'Update' button is clicked
            setVisible(false); // Hide current frame
            new UpdateEmployee(cemployeeId.getSelectedItem()); // Open UpdateEmployee frame with selected employee ID
        } else { // If 'Back' button is clicked
            setVisible(false); // Hide current frame
            new Home(); // Open Home frame
        }
    }

    public static void main(String[] args) {
        new ViewEmployee(); // Create and display ViewEmployee frame
    }
}
