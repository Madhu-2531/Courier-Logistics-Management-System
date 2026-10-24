package ui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import ui.Dashboard;

public class LoginFrame extends JFrame {

JTextField usernameField;
JPasswordField passwordField;
JButton loginButton;

public LoginFrame() {

System.out.println("LoginFrame Opened");

setTitle("Courier Tracking System Login");
setSize(400,250);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);

JPanel panel = new JPanel();
panel.setLayout(new GridLayout(3,2,10,10));

panel.add(new JLabel("Username:"));

usernameField = new JTextField();
panel.add(usernameField);

panel.add(new JLabel("Password:"));

passwordField = new JPasswordField();
panel.add(passwordField);

loginButton = new JButton("Login");

panel.add(new JLabel());
panel.add(loginButton);

add(panel);

loginButton.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent e) {

String username = usernameField.getText();
String password = new String(passwordField.getPassword());

if(username.equals("admin") && password.equals("admin")) {

JOptionPane.showMessageDialog(null,"Login Successful");

new Dashboard();

dispose();

} else {

JOptionPane.showMessageDialog(null,
"Invalid Username or Password");

usernameField.setText("");
passwordField.setText("");

usernameField.requestFocus();

}

}

});

setVisible(true);

}

}
