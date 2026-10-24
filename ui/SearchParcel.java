package ui;

import db.DBConnection;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class SearchParcel extends JFrame {

JTextField parcelIdField;
JTextArea resultArea;
JButton searchButton;

public SearchParcel() {

setTitle("Search Parcel");
setSize(500,300);
setLocationRelativeTo(null);

setLayout(new BorderLayout());

JPanel panel = new JPanel();

panel.add(new JLabel("Parcel ID"));

parcelIdField = new JTextField(10);
panel.add(parcelIdField);

searchButton = new JButton("Search");
panel.add(searchButton);

add(panel, BorderLayout.NORTH);

resultArea = new JTextArea();
resultArea.setEditable(false);

add(new JScrollPane(resultArea), BorderLayout.CENTER);

searchButton.addActionListener(e -> searchParcel());

setVisible(true);

}

private void searchParcel() {

try {

Connection con = DBConnection.getConnection();

String sql = "SELECT * FROM Parcel WHERE parcel_id=?";

PreparedStatement ps = con.prepareStatement(sql);

ps.setInt(1, Integer.parseInt(parcelIdField.getText()));

ResultSet rs = ps.executeQuery();

if(rs.next()) {

resultArea.setText(
"Parcel ID : " + rs.getInt("parcel_id") +
"\nCustomer ID : " + rs.getInt("customer_id") +
"\nSource : " + rs.getString("source") +
"\nDestination : " + rs.getString("destination") +
"\nWeight : " + rs.getDouble("weight") +
"\nStatus : " + rs.getString("status") +
"\nBooking Date : " + rs.getDate("booking_date")
);

}
else {

resultArea.setText("Parcel Not Found");

}

rs.close();
ps.close();
con.close();

}
catch(Exception e) {

JOptionPane.showMessageDialog(
this,
"Invalid Parcel ID"
);

}

}

}