package org.example.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatPanel extends JPanel {

    private JTextArea chatArea; // Zone de texte pour l'affichage des messages
    private JTextField messageField; // Champ de texte pour écrire un message
    private JButton sendButton; // Bouton pour envoyer le message
    private JList<String> userList; // Liste des utilisateurs connectés
    private JButton refreshButton; // Bouton pour rafraîchir la liste des utilisateurs

    public ChatPanel() {
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());

        // Zone de chat
        chatArea = new JTextArea();
        chatArea.setEditable(false); // La zone de texte ne doit pas être éditable
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        // Panneau pour le champ de saisie et le bouton d'envoi
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BorderLayout());
        messageField = new JTextField();
        sendButton = new JButton("Envoyer");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        messagePanel.add(messageField, BorderLayout.CENTER);
        messagePanel.add(sendButton, BorderLayout.EAST);
        add(messagePanel, BorderLayout.SOUTH);

        // Liste des utilisateurs
        userList = new JList<>();
        add(new JScrollPane(userList), BorderLayout.EAST);

        // Bouton de rafraîchissement de la liste des utilisateurs
        refreshButton = new JButton("Rafraîchir");
        // Ajoutez ici l'actionListener pour le refreshButton
        add(refreshButton, BorderLayout.NORTH);
    }

    private void sendMessage() {
        String message = messageField.getText().trim();
        if (!message.isEmpty()) {
            // TODO: Implémentez la logique d'envoi de message ici
            chatArea.append(message + "\n"); // Ajoute le message à la zone de chat
            messageField.setText(""); // Réinitialise le champ de saisie de texte
        }
    }

    // TODO: Implémentez la méthode pour rafraîchir la liste des utilisateurs
}
