package ui;

import db.DBConnection;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import ui.Receipt;

public class Payment extends JFrame {

JTextField parcelIdField;
JTextField amountField;
JButton payButton;

public Payment() {

setTitle("Payment");
setSize(400,200);
setLocationRelativeTo(null);

setLayout(new GridLayout(3,2,10,10));

add(new JLabel("Parcel ID"));
parcelIdField = new JTextField();
add(parcelIdField);

add(new JLabel("Amount"));
amountField = new JTextField();
add(amountField);

payButton = new JButton("Make Payment");
add(new JLabel());
add(payButton);

payButton.addActionListener(e -> makePayment());

setVisible(true);

}

private void makePayment() {

try {

double amount = Double.parseDouble(amountField.getText());

if(amount <= 0) {

JOptionPane.showMessageDialog(this,
"Amount must be greater than 0");

return;

}

Connection con = DBConnection.getConnection();

String sql =
"INSERT INTO Payment(parcel_id,amount,payment_date) VALUES(?,?,CURDATE())";

PreparedStatement ps =
con.prepareStatement(sql);

ps.setInt(1,
Integer.parseInt(parcelIdField.getText()));

ps.setDouble(2,amount);

ps.executeUpdate();

JOptionPane.showMessageDialog(this,
"Payment Successful");
new Receipt(Integer.parseInt(parcelIdField.getText()),amount);

dispose();

}
catch(Exception e) {

JOptionPane.showMessageDialog(this,
"Invalid Input");

}

}

}