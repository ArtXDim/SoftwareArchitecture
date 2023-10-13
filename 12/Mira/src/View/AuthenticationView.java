package View;

import javax.swing.*;

import Model.MessengerModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthenticationView extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public AuthenticationView() {
        setTitle("Authentication");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Sign up");

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Создание объекта класса для проверки данных аутентификации
                MessengerModel messengerModel = new MessengerModel();

                // Вызов метода проверки данных аутентификации
                if (messengerModel.checkCredentials(username, password)) {
                    openMessengerPage();
                } else {
                    JOptionPane.showMessageDialog(null, " Login or password incorrect!");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openRegistrationPage();
            }
        });

        add(panel);
        pack();
        setVisible(true);
    }

    private void openRegistrationPage() {
        // Закрыть текущее окно аутентификации и открыть окно регистрации
        dispose();
        RegistrationView registrationView = new RegistrationView();
        registrationView.setVisible(true);
    }

    private void openMessengerPage() {
        // Закрыть текущее окно аутентификации и открыть страницу мессенджера
        dispose();
        MessengerView messengerView = new MessengerView();
        messengerView.setVisible(true);
    }

}