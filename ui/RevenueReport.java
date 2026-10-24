package ui;

import db.DBConnection;
import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class RevenueReport extends JFrame {

public RevenueReport() {

setTitle("Revenue Report");
setSize(400,200);
setLocationRelativeTo(null);

JTextArea area = new JTextArea();

area.setEditable(false);
area.setFocusable(false);
try {

Connection con = DBConnection.getConnection();

Statement st = con.createStatement();

ResultSet rs = st.executeQuery(
"SELECT SUM(amount) AS total FROM Payment"
);

if(rs.next()) {

area.setText(
"Total Revenue : ₹ " +
rs.getDouble("total")
);

}

}
catch(Exception e) {

area.setText("Unable to Generate Report");

}

add(area);

setVisible(true);

}

}