package ui;

import db.DBConnection;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewPayments extends JFrame {

JTable table;

public ViewPayments() {

setTitle("View Payments");
setSize(700,400);
setLocationRelativeTo(null);

String[] columns = {
"Payment ID",
"Parcel ID",
"Amount",
"Payment Date"
};

DefaultTableModel model =
new DefaultTableModel(columns,0);

table = new JTable(model);

try {

Connection con = DBConnection.getConnection();

Statement st = con.createStatement();

ResultSet rs =
st.executeQuery("SELECT * FROM Payment");

while(rs.next()) {

model.addRow(new Object[] {

rs.getInt("payment_id"),
rs.getInt("parcel_id"),
rs.getDouble("amount"),
rs.getDate("payment_date")

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