package ui;

import db.DBConnection;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateCustomer extends JFrame {

JTextField idField;
JTextField nameField;
JTextField phoneField;
JTextField emailField;
JTextField addressField;

JButton updateButton;

public UpdateCustomer() {

setTitle("Update Customer");
setSize(400,300);
setLocationRelativeTo(null);

setLayout(new GridLayout(6,2,10,10));

add(new JLabel("Customer ID"));
idField = new JTextField();
add(idField);

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

updateButton = new JButton("Update Customer");
add(new JLabel());
add(updateButton);

updateButton.addActionListener(e -> updateCustomer());

setVisible(true);

}

private void updateCustomer() {

try {

String phone = phoneField.getText().trim();
String email = emailField.getText().trim();

if(!phone.matches("\\d{10}")) {

JOptionPane.showMessageDialog(this,
"Phone number must be 10 digits");

return;

}

if(!email.matches("^[A-Za-z0-9+_.-]+@gmail\\.com$")) {

JOptionPane.showMessageDialog(this,
"Enter valid Gmail");

return;

}
if(nameField.getText().trim().isEmpty()) {

JOptionPane.showMessageDialog(this,
"Name cannot be empty");

return;

}

if(addressField.getText().trim().isEmpty()) {

JOptionPane.showMessageDialog(this,
"Address cannot be empty");

return;

}

Connection con = DBConnection.getConnection();

String sql =
"UPDATE Customer SET name=?,phone=?,email=?,address=? WHERE customer_id=?";

PreparedStatement ps =
con.prepareStatement(sql);

ps.setString(1,nameField.getText());
ps.setString(2,phone);
ps.setString(3,email);
ps.setString(4,addressField.getText());
ps.setInt(5,Integer.parseInt(idField.getText()));

int rows = ps.executeUpdate();

if(rows > 0) {

JOptionPane.showMessageDialog(
this,
"Customer Updated Successfully"
);

dispose();

}
else {

JOptionPane.showMessageDialog(
this,
"Customer Not Found"
);

}

}
catch(Exception e) {

JOptionPane.showMessageDialog(
this,
"Invalid Input"
);

}

}

}