package ui;

import db.DBConnection;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewParcels extends JFrame {

JTable table;

public ViewParcels() {

setTitle("View Parcels");
setSize(800,400);
setLocationRelativeTo(null);

String[] columns = {
"Parcel ID",
"Customer ID",
"Source",
"Destination",
"Weight",
"Status",
"Booking Date"
};

DefaultTableModel model =
new DefaultTableModel(columns,0);

table = new JTable(model);

try {

Connection con = DBConnection.getConnection();

Statement st = con.createStatement();

ResultSet rs =
st.executeQuery("SELECT * FROM Parcel");

while(rs.next()) {

model.addRow(new Object[] {

rs.getInt("parcel_id"),
rs.getInt("customer_id"),
rs.getString("source"),
rs.getString("destination"),
rs.getDouble("weight"),
rs.getString("status"),
rs.getDate("booking_date")

});

}

}
catch(Exception e) {

e.printStackTrace();

}

add(new JScrollPane(table));

setVisible(true);

}

}