package org.example.ui;

import javax.swing.*;

// Page de connexion en utilisant swing
public class LoginScreen extends JFrame {

        private static final long serialVersionUID = 1L; // Pour éviter un warning

        public LoginScreen() {
            super("Login"); // Titre de la fenêtre
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ferme l'application quand on ferme la fenêtre
            this.setSize(300, 300); // Taille de la fenêtre
            this.setLocationRelativeTo(null); // Centre la fenêtre
            this.setResizable(false); // Empêche le redimensionnement de la fenêtre
            this.setContentPane(new LoginPanel()); // il faut créer la classe LoginPanel
            this.setVisible(true); // Affiche la fenêtre
        }

        public static void main(String[] args) {
            new LoginScreen();
        }
}
