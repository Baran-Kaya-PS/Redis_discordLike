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
    private JMenuBar menuBar; // Barre de menu

    public ChatPanel() {
        initializeUI();
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
    }

    private void initializeUI() {
        // Configurez le layout principal avec des espaces entre les composants
        setLayout(new BorderLayout(10, 10)); // L'espacement horizontal et vertical entre les composants

        // Ajoutez ici la barre de menu
        menuBar = createMenuBar();

        // Panneau pour la zone de chat
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        add(chatScrollPane, BorderLayout.CENTER);

        // Panneau pour la liste des utilisateurs
        userList = new JList<>();
        JScrollPane userScrollPane = new JScrollPane(userList);
        userScrollPane.setPreferredSize(new Dimension(150, 0)); // Fixez la largeur de la liste des utilisateurs
        add(userScrollPane, BorderLayout.EAST);

        // Panneau pour le champ de saisie et le bouton d'envoi
        JPanel messagePanel = new JPanel(new BorderLayout(5, 5)); // Espacement entre les composants du messagePanel
        messageField = new JTextField();
        messageField.setPreferredSize(new Dimension(0, 30)); // Fixez la hauteur du champ de saisie
        sendButton = new JButton("Envoyez");
        sendButton.setPreferredSize(new Dimension(100,40));
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(sendButton,BorderLayout.LINE_END);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        messagePanel.add(messageField, BorderLayout.CENTER);
        messagePanel.add(sendButton, BorderLayout.EAST);
        add(messagePanel, BorderLayout.SOUTH);

        // Bouton de rafraîchissement de la liste des utilisateurs
        refreshButton = new JButton("Rafraîchir");
        JPanel refreshPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Alignez le bouton à droite
        refreshPanel.add(refreshButton);
        add(refreshPanel, BorderLayout.NORTH);

        // TODO: Ajoutez les actionListeners nécessaires pour les boutons
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem newItem = new JMenuItem("Ouvrir une nouvelle fenêtre");
        JMenuItem quitItem = new JMenuItem("Tout quitter");
        // Ajoutez des écouteurs d'événements pour les éléments de menu
        menu.add(newItem);
        menu.add(quitItem);
        menuBar.add(menu);
        return menuBar;
    }

    private void sendMessage() {
        String message = messageField.getText().trim();
        if (!message.isEmpty()) {
            // Afficher le message dans la zone de texte du chat
            chatArea.append(message + "\n");

            // TODO: Implémentez ici la logique d'envoi de message à Redis
            // Supposons que vous avez une méthode sendToRedis(String channel, String message) :
            //sendToRedis("nom_du_salon", message);

            // Réinitialise le champ de saisie de texte après envoi
            messageField.setText("");
        }
    }
    public void sendToRedis(String channel, String message) {

    }
    // TODO: Implémentez la méthode pour rafraîchir la liste des utilisateurs
}
