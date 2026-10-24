package ui;

import javax.swing.*;

public class Receipt extends JFrame {

public Receipt(int parcelId, double amount) {

setTitle("Payment Receipt");
setSize(400,300);
setLocationRelativeTo(null);

JTextArea area = new JTextArea();

area.setText(
"COURIER TRACKING SYSTEM\n\n" +
"Payment Receipt\n\n" +
"Parcel ID : " + parcelId +
"\nAmount : ₹" + amount +
"\nStatus : Paid" +
"\n\nThank You"
);

area.setEditable(false);
area.setFocusable(false);

add(area);

setVisible(true);

}

}