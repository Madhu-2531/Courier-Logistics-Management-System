package ui;

import db.DBConnection;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookParcel extends JFrame {

JTextField customerIdField;
JTextField sourceField;
JTextField destinationField;
JTextField weightField;

JButton bookButton;

public BookParcel() {

setTitle("Book Parcel");
setSize(400,300);
setLocationRelativeTo(null);

setLayout(new GridLayout(5,2,10,10));

add(new JLabel("Customer ID"));
customerIdField = new JTextField();
add(customerIdField);

add(new JLabel("Source"));
sourceField = new JTextField();
add(sourceField);

add(new JLabel("Destination"));
destinationField = new JTextField();
add(destinationField);

add(new JLabel("Weight in (kgs)"));
weightField = new JTextField();
add(weightField);

bookButton = new JButton("Book Parcel");
add(bookButton);

bookButton.addActionListener(e -> bookParcel());

setVisible(true);

}

private void bookParcel() {

try {

String source = sourceField.getText().trim();
String destination = destinationField.getText().trim();
String weight = weightField.getText().trim();

if(source.isEmpty()) {
JOptionPane.showMessageDialog(this,"Source cannot be empty");
return;
}

if(destination.isEmpty()) {
JOptionPane.showMessageDialog(this,"Destination cannot be empty");
return;
}

if(Double.parseDouble(weight) <= 0) {
JOptionPane.showMessageDialog(this,"Weight must be greater than 0");
return;
}

Connection con = DBConnection.getConnection();

String sql = "INSERT INTO Parcel(customer_id,source,destination,weight,status,booking_date) VALUES(?,?,?,?,?,CURDATE())";

PreparedStatement ps = con.prepareStatement(sql);

ps.setInt(1,Integer.parseInt(customerIdField.getText()));
ps.setString(2,source);
ps.setString(3,destination);
ps.setDouble(4,Double.parseDouble(weight));
ps.setString(5,"Booked");

ps.executeUpdate();

JOptionPane.showMessageDialog(this,"Parcel Booked Successfully");

dispose();

} catch(Exception e) {

JOptionPane.showMessageDialog(this,"Invalid Details");

}

}

}