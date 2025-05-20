import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel messageLabel;

    public LoginForm() {
        setTitle("Login Form");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        var panel = new JPanel();
        var layout = new GridBagLayout();
        var c = new GridBagConstraints();

        c.insets = new Insets(3, 3, 3, 3);
        c.weightx = 0.25;
        c.weighty = 0.25;
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.setLayout(layout);

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        messageLabel = new JLabel("");

        c.weightx = 0.25;
        c.weighty = 0.25;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(usernameLabel, c);

        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 0;
        panel.add(usernameField, c);

        c.weightx = 0.25;
        c.weighty = 0.25;
        c.gridx = 0;
        c.gridy = 1;
        panel.add(passwordLabel, c);

        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 1;
        panel.add(passwordField, c);

        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 2;
        panel.add(loginButton, c);

        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 1;
        c.gridy = 3;
        panel.add(messageLabel, c);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals("admin") && password.equals("password")) {
                messageLabel.setText("Login successful!");
            } else {
                messageLabel.setText("Invalid username or password.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginForm();
            }
        });
    }
}