package org.example.ui;

import javax.swing.*;

public class ChatScreen extends JFrame {

            private static final long serialVersionUID = 1L; // Pour éviter un warning

            public ChatScreen() {
                super("Chat"); // Titre de la fenêtre
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ferme l'application quand on ferme la fenêtre
                this.setSize(800, 600); // Taille de la fenêtre
                this.setLocationRelativeTo(null); // Centre la fenêtre
                this.setResizable(false); // Empêche le redimensionnement de la fenêtre
                this.setContentPane(new ChatPanel()); // il faut créer la classe ChatPanel
                this.setVisible(true); // Affiche la fenêtre
            }

            public static void main(String[] args) {
                new ChatScreen();
            }
}
