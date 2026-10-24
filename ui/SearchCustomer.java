package ui;

import db.DBConnection;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class SearchCustomer extends JFrame {

JTextField customerIdField;
JTextArea resultArea;
JButton searchButton;

public SearchCustomer() {

setTitle("Search Customer");
setSize(500,300);
setLocationRelativeTo(null);

setLayout(new BorderLayout());

JPanel panel = new JPanel();

panel.add(new JLabel("Customer ID"));

customerIdField = new JTextField(10);
panel.add(customerIdField);

searchButton = new JButton("Search");
panel.add(searchButton);

add(panel, BorderLayout.NORTH);

resultArea = new JTextArea();
resultArea.setEditable(false);

add(new JScrollPane(resultArea), BorderLayout.CENTER);

searchButton.addActionListener(e -> searchCustomer());

setVisible(true);

}

private void searchCustomer() {

try {

Connection con = DBConnection.getConnection();

String sql = "SELECT * FROM Customer WHERE customer_id=?";

PreparedStatement ps = con.prepareStatement(sql);

ps.setInt(1, Integer.parseInt(customerIdField.getText()));

ResultSet rs = ps.executeQuery();

if(rs.next()) {

resultArea.setText(
"Customer ID : " + rs.getInt("customer_id") +
"\nName : " + rs.getString("name") +
"\nPhone : " + rs.getString("phone") +
"\nEmail : " + rs.getString("email") +
"\nAddress : " + rs.getString("address")
);

}
else {

resultArea.setText("Customer Not Found");

}

rs.close();
ps.close();
con.close();

}
catch(Exception e) {

JOptionPane.showMessageDialog(
this,
"Invalid Customer ID"
);

}

}

}