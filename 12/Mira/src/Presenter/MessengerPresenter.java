package Presenter;

import javax.swing.*;

import Listener.ContactChangeListener;
import Listener.MessageReceivedListener;
import Model.MessengerModel;
import View.MessengerView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MessengerPresenter {

    private MessengerView view;
    private MessengerModel model;

    public MessengerPresenter(MessengerView view, MessengerModel model) {
        this.view = view;
        this.model = model;

        // Добавляем обработчик для кнопки отправки сообщения
        view.getSendButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = view.getMessageField().getText();
                model.sendMessage(message); // Вызываем метод модели для отправки сообщения
                view.getMessageField().setText(""); // Очищаем поле ввода сообщения
            }
        });

        // Добавляем обработчик для кнопки выхода из чата
        view.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.exitChat(); // Вызываем метод модели для выхода из чата
                view.dispose(); // Закрываем окно чата
            }
        });

        // Добавляем обработчик для изменения списка контактов
        model.addContactChangeListener(new ContactChangeListener() {
            @Override
            public void onContactChange(List<String> contacts) {
                view.updateContactList(contacts); // Вызываем метод представления для обновления списка контактов
            }
        });

        // Добавляем обработчик для получения нового сообщения
        model.addMessageReceivedListener(new MessageReceivedListener() {
            @Override
            public void onMessageReceived(String message) {
                view.displayMessage(message); // Вызываем метод представления для отображения нового сообщения
            }
        });
    }

}