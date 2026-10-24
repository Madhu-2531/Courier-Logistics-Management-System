package ui;

import db.DBConnection;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.lang.Exception;

public class AddCustomer extends JFrame {

JTextField nameField;
JTextField phoneField;
JTextField emailField;
JTextField addressField;

JButton saveButton;

public AddCustomer()  {

setTitle("Add Customer");
setSize(400,300);
setLocationRelativeTo(null);

setLayout(new GridLayout(5,2,10,10));

add(new JLabel("Name"));
nameField = new JTextField();
add(nameField);

add(new JLabel("Phone"));
phoneField = new JTextField();
add(phoneField);

add(new JLabel("Email"));
emailField = new JTextField();
add(emailField);

add(new JLabel("Address"));
addressField = new JTextField();
add(addressField);

saveButton = new JButton("Save Customer");
add(saveButton);

saveButton.addActionListener(e -> saveCustomer());
saveButton.addActionListener(e -> {
    System.out.println("Save button clicked");
});

setVisible(true);

}
private void saveCustomer() {
System.out.println("Inside saveCustomer");
try {

Connection con = DBConnection.getConnection();

String sql = "INSERT INTO Customer(name,phone,email,address) VALUES(?,?,?,?)";
String name = nameField.getText().trim();
String phone = phoneField.getText().trim();
String email = emailField.getText().trim();
String address = addressField.getText().trim();

if(name.isEmpty()) {

JOptionPane.showMessageDialog(this,
"Name cannot be empty");

return;

}

if(address.isEmpty()) {

JOptionPane.showMessageDialog(this,
"Address cannot be empty");

return;

}

if(!phone.matches("\\d{10}")) {

JOptionPane.showMessageDialog(this,
"Phone number must contain exactly 10 digits");

return;

}

if(!email.matches("^[A-Za-z0-9+_.-]+@gmail\\.com$")) {

JOptionPane.showMessageDialog(this,
"Enter a valid Gmail address");

return;

}
PreparedStatement ps = con.prepareStatement(sql);

ps.setString(1,nameField.getText());
ps.setString(2,phoneField.getText());
ps.setString(3,emailField.getText());
ps.setString(4,addressField.getText());

ps.executeUpdate();

JOptionPane.showMessageDialog(this,"Customer Added Successfully");
//dispose();

} catch(Exception e) {

    e.printStackTrace();
    JOptionPane.showMessageDialog(this, e.toString());
}

}

}

