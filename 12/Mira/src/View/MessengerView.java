package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MessengerView extends JFrame {

    private JTextField messageField;
    private JTextArea chatArea;
    private JButton logoutButton;
    private JButton sendButton;
    private JList<String> chatList;

    
    public MessengerView() {
        setTitle("Messenger");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      

        JPanel panel = new JPanel(new BorderLayout());

        // Создание компонентов
        JPanel leftPanel = new JPanel(new BorderLayout());
        JPanel leftSouthPanel = new JPanel(new BorderLayout());
        JLabel chatListLabel = new JLabel("Chat list:");
        chatList = new JList<>();
        JButton addNewChatButton = new JButton("New chat");
        logoutButton = new JButton("Exit");
        JScrollPane chatListScrollPane = new JScrollPane(chatList);
        leftPanel.add(chatListLabel, BorderLayout.NORTH);
        leftPanel.add(chatListScrollPane, BorderLayout.CENTER);
        leftSouthPanel.add(addNewChatButton, BorderLayout.NORTH);
        leftSouthPanel.add(logoutButton, BorderLayout.SOUTH);
        leftPanel.add(leftSouthPanel, BorderLayout.SOUTH);

        JPanel centerPanel = new JPanel(new BorderLayout());
        chatArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(chatArea);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        JLabel messageLabel = new JLabel("Message:");
        messageField = new JTextField();
        bottomPanel.add(messageLabel, BorderLayout.WEST);
        bottomPanel.add(messageField, BorderLayout.CENTER);
        sendButton = new JButton("Send");
        bottomPanel.add(sendButton, BorderLayout.EAST);

        // Добавление компонентов на панель
        panel.add(leftPanel, BorderLayout.WEST);
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAuthenticationPage();
            }
        });


        // Добавление панели на окно
        getContentPane().add(panel);

        // Установка размеров окна
        setSize(500, 500);
        // Расположение окна по центру экрана
        setLocationRelativeTo(null);
        // Отображение окна
        setVisible(true);
    }

    private void openAuthenticationPage() {
        // Закрыть текущее окно мессенджера и открыть окно аутентификации
        dispose();
        AuthenticationView authenticationView = new AuthenticationView();
        authenticationView.setVisible(true);
    }

    // Метод для получения кнопки отправки сообщения
    public JButton getSendButton() {
        return sendButton;
    }

    // Метод для получения поля для отображения сообщений
    public JTextArea getMessageArea() {
        return chatArea;
    }

    // Метод для получения поля для ввода сообщения
    public JTextField getMessageField() {
        return messageField;
    }

    // Метод для получения кнопки выхода из чата
    public JButton getExitButton() {
        return logoutButton;
    }

    // Метод для обновления списка контактов
    public void updateContactList(List<String> contacts) {
        DefaultListModel<String> model = new DefaultListModel<>(); // Создаем модель для списка контактов
        for (String contact : contacts) {
            model.addElement(contact); // Добавляем каждый контакт в модель
        }
        chatList.setModel(model); // Устанавливаем модель для списка контактов
    }

    // Метод для отображения нового сообщения
    public void displayMessage(String message) {
        chatArea.append(message + "\n"); // Добавляем сообщение в текстовое поле
    }
    

}