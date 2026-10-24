package ui;

import db.DBConnection;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class ViewCustomers extends JFrame {

JTable table;

public ViewCustomers() {

setTitle("View Customers");
setSize(700,400);
setLocationRelativeTo(null);

String[] columns = {
"Customer ID",
"Name",
"Phone",
"Email",
"Address"
};

DefaultTableModel model =
new DefaultTableModel(columns,0);

table = new JTable(model);

try {

Connection con =
DBConnection.getConnection();

Statement st =
con.createStatement();

ResultSet rs =
st.executeQuery("SELECT * FROM Customer");

while(rs.next()) {

model.addRow(new Object[] {

rs.getInt("customer_id"),
rs.getString("name"),
rs.getString("phone"),
rs.getString("email"),
rs.getString("address")

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