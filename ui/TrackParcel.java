package ui;

import db.DBConnection;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class TrackParcel extends JFrame {

JTextField parcelIdField;
JTextArea resultArea;
JButton searchButton;

public TrackParcel() {

setTitle("Track Parcel");
setSize(500,300);
setLocationRelativeTo(null);

setLayout(new BorderLayout());

JPanel topPanel = new JPanel();

topPanel.add(new JLabel("Parcel ID:"));

parcelIdField = new JTextField(10);
topPanel.add(parcelIdField);

searchButton = new JButton("Search");
topPanel.add(searchButton);

add(topPanel, BorderLayout.NORTH);

resultArea = new JTextArea();
add(new JScrollPane(resultArea), BorderLayout.CENTER);

searchButton.addActionListener(e -> trackParcel());

setVisible(true);

}

private void trackParcel() {

try {

Connection con = DBConnection.getConnection();

String sql =
"SELECT parcel_id, source, destination, weight, status FROM Parcel WHERE parcel_id=?";

PreparedStatement ps = con.prepareStatement(sql);

ps.setInt(1, Integer.parseInt(parcelIdField.getText()));

ResultSet rs = ps.executeQuery();

if(rs.next()) {

resultArea.setText(
"Parcel ID: " + rs.getInt("parcel_id") +
"\nSource: " + rs.getString("source") +
"\nDestination: " + rs.getString("destination") +
"\nWeight: " + rs.getDouble("weight") +
"\nStatus: " + rs.getString("status")
);

}
else {

resultArea.setText("Parcel Not Found");

}

}
catch(Exception e) {

JOptionPane.showMessageDialog(this,"Invalid Parcel ID");

}

}

}