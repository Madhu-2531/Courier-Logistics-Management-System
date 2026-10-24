package ui;

import db.DBConnection;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteCustomer extends JFrame {

JTextField customerIdField;
JButton deleteButton;

public DeleteCustomer() {

setTitle("Delete Customer");
setSize(350,150);
setLocationRelativeTo(null);

setLayout(new GridLayout(2,2,10,10));

add(new JLabel("Customer ID"));

customerIdField = new JTextField();
add(customerIdField);

deleteButton = new JButton("Delete Customer");
add(new JLabel());
add(deleteButton);

deleteButton.addActionListener(e -> deleteCustomer());

setVisible(true);

}

private void deleteCustomer() {

try {

Connection con = DBConnection.getConnection();

String sql = "DELETE FROM Customer WHERE customer_id=?";

PreparedStatement ps = con.prepareStatement(sql);

ps.setInt(1,Integer.parseInt(customerIdField.getText()));

int rows = ps.executeUpdate();

if(rows > 0) {

JOptionPane.showMessageDialog(this,
"Customer Deleted Successfully");

dispose();

}
else {

JOptionPane.showMessageDialog(this,
"Customer Not Found");

}

}
catch(Exception e) {

JOptionPane.showMessageDialog(this,
"Unable to Delete Customer");

}

}

}