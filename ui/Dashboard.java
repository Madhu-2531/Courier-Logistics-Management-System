package ui;

import javax.swing.*;
import java.awt.*;
import ui.UpdateCustomer;
import ui.SearchParcel;
public class Dashboard extends JFrame {

public Dashboard() {

setTitle("Courier Tracking System Dashboard");
setSize(800,500);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setSize(900,600);
setLayout(new BorderLayout());

JLabel title = new JLabel(
"Courier Tracking System",
SwingConstants.CENTER
);
title.setForeground(new Color(25,25,112));
title.setFont(
new Font("Arial", Font.BOLD, 24)
);

add(title, BorderLayout.NORTH);

JPanel panel = new JPanel();

panel.setLayout(new GridLayout(0,2,10,10));

JButton addCustomer = new JButton("Add Customer");
JButton bookParcel = new JButton("Book Parcel");
JButton trackParcel = new JButton("Track Parcel");
JButton updateStatus = new JButton("Update Status");
JButton viewCustomers = new JButton("View Customers");
JButton payment = new JButton("Payment");
JButton viewParcels = new JButton("View Parcels");
JButton searchCustomer = new JButton("Search Customer");
JButton deleteCustomer = new JButton("Delete Customer");
JButton revenueReport = new JButton("Revenue Report");
JButton viewPayments = new JButton("View Payments");
JButton updateCustomer = new JButton("Update Customer");
JButton searchParcel = new JButton("Search Parcel");
JButton logout = new JButton("Logout");
JButton exit = new JButton("Exit");

addCustomer.addActionListener(e -> new AddCustomer());
bookParcel.addActionListener(e -> new BookParcel());
trackParcel.addActionListener(e -> new TrackParcel());
updateStatus.addActionListener(e -> new UpdateStatus());
viewCustomers.addActionListener(e -> new ViewCustomers());
payment.addActionListener(e -> new Payment());
viewParcels.addActionListener(e -> new ViewParcels());
searchCustomer.addActionListener(e -> new SearchCustomer());
deleteCustomer.addActionListener(e -> new DeleteCustomer());
revenueReport.addActionListener(e -> new RevenueReport());
viewPayments.addActionListener(e -> new ViewPayments());
updateCustomer.addActionListener(e -> new UpdateCustomer());
searchParcel.addActionListener(e -> new SearchParcel());
addCustomer.setBackground(Color.CYAN);
bookParcel.setBackground(Color.GREEN);
trackParcel.setBackground(new Color(255,182,193));
updateStatus.setBackground(new Color(173,216,230));
viewCustomers.setBackground(new Color(221,160,221));
payment.setBackground(Color.YELLOW);
viewParcels.setBackground(new Color(255,228,181));
searchCustomer.setBackground(new Color(144,238,144));
deleteCustomer.setBackground(new Color(255,99,71));
revenueReport.setBackground(new Color(255,215,0));
viewPayments.setBackground(new Color(240,230,140));
updateCustomer.setBackground(new Color(186,85,211));
searchParcel.setBackground(new Color(135,206,250));
logout.setBackground(Color.ORANGE);
exit.setBackground(Color.RED);
exit.setForeground(Color.WHITE);

deleteCustomer.setForeground(Color.WHITE);
logout.addActionListener(e -> {
new LoginFrame();
dispose();});

exit.addActionListener(e -> System.exit(0));

panel.add(addCustomer);
panel.add(bookParcel);
panel.add(trackParcel);
panel.add(updateStatus);
panel.add(viewCustomers);
panel.add(payment);
panel.add(viewParcels);
panel.add(searchCustomer);
panel.add(deleteCustomer);
panel.add(revenueReport);
panel.add(viewPayments);
panel.add(updateCustomer);
panel.add(searchParcel);
panel.add(logout);
panel.add(exit);
panel.setBackground(new Color(245,245,245));
add(panel, BorderLayout.CENTER);
getContentPane().setBackground(
new Color(230,240,250)
);
setVisible(true);

}

}