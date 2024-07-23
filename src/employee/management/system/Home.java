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
import java.awt.event.*; // Import AWT event classes for handling actions

public class Home extends JFrame implements ActionListener {

    JButton view, add, update, remove; // Declare buttons

    Home() {
        setLayout(null); // Disable default layout manager for absolute positioning

        // Load and scale background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3); // Create label with background image
        image.setBounds(0, 0, 1120, 630); // Set position and size
        add(image); // Add image label to the frame

        // Create and configure heading label
        JLabel heading = new JLabel("Employee Management System");
        heading.setBounds(620, 20, 400, 40); // Set position and size
        heading.setFont(new Font("Raleway", Font.BOLD, 25)); // Set font
        image.add(heading); // Add heading to image label

        // Create and configure 'Add Employee' button
        add = new JButton("Add Employee");
        add.setBounds(650, 80, 150, 40); // Set position and size
        add.addActionListener(this); // Add action listener
        image.add(add); // Add button to image label

        // Create and configure 'View Employees' button
        view = new JButton("View Employees");
        view.setBounds(820, 80, 150, 40); // Set position and size
        view.addActionListener(this); // Add action listener
        image.add(view); // Add button to image label

        // Create and configure 'Update Employee' button
        update = new JButton("Update Employee");
        update.setBounds(650, 140, 150, 40); // Set position and size
        update.addActionListener(this); // Add action listener
        image.add(update); // Add button to image label

        // Create and configure 'Remove Employee' button
        remove = new JButton("Remove Employee");
        remove.setBounds(820, 140, 150, 40); // Set position and size
        remove.addActionListener(this); // Add action listener
        image.add(remove); // Add button to image label

        setSize(1120, 630); // Set frame size
        setLocation(250, 100); // Set frame location
        setVisible(true); // Make frame visible
    }

    // Handle button click events
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) { // If 'Add Employee' button is clicked
            setVisible(false); // Hide current frame
            new AddEmployee(); // Open AddEmployee frame
        } else if (ae.getSource() == view) { // If 'View Employees' button is clicked
            setVisible(false); // Hide current frame
            new ViewEmployee(); // Open ViewEmployee frame
        } else if (ae.getSource() == update) { // If 'Update Employee' button is clicked
            setVisible(false); // Hide current frame
            new ViewEmployee(); // Open ViewEmployee frame
        } else { // If 'Remove Employee' button is clicked
            setVisible(false); // Hide current frame
            new RemoveEmployee(); // Open RemoveEmployee frame
        }
    }

    public static void main(String[] args) {
        new Home(); // Create and display Home frame
    }
}
