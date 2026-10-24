package ui;

import db.DBConnection;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateStatus extends JFrame {

JTextField parcelIdField;
JComboBox<String> statusBox;
JButton updateButton;

public UpdateStatus() {

setTitle("Update Parcel Status");
setSize(400,200);
setLocationRelativeTo(null);
setLayout(new GridLayout(3,2,10,10));

add(new JLabel("Parcel ID"));

parcelIdField = new JTextField();
add(parcelIdField);

add(new JLabel("Status"));

statusBox = new JComboBox<>(new String[]{
"Booked",
"In Transit",
"Out For Delivery",
"Delivered"
});

add(statusBox);

updateButton = new JButton("Update");
add(updateButton);

updateButton.addActionListener(e -> updateStatus());

setVisible(true);

}

private void updateStatus() {

try {

Connection con = DBConnection.getConnection();

String sql =
"UPDATE Parcel SET status=? WHERE parcel_id=?";

PreparedStatement ps = con.prepareStatement(sql);

ps.setString(1,statusBox.getSelectedItem().toString());
ps.setInt(2,Integer.parseInt(parcelIdField.getText()));

int rows = ps.executeUpdate();

if(rows > 0) {

JOptionPane.showMessageDialog(this,
"Status Updated Successfully");

dispose();

} else {

JOptionPane.showMessageDialog(this,
"Parcel Not Found");

}

}
catch(Exception e) {

JOptionPane.showMessageDialog(this,
"Invalid Input");

}

}

}