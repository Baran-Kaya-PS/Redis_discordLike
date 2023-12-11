package org.example.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {

    private JTextField userName; // Pseudo
    private JPasswordField password; // Mot de passe avec JPasswordField pour cacher les caractères
    private JButton loginButton;

    public LoginPanel(){
     initialize();
    }

    private void initialize() { // cette fonction initialise la fenêtre
        this.setLayout(new BorderLayout()); // le layout représente la disposition des éléments dans la fenêtre
        JPanel loginPanel = new JPanel(); // le panel est un conteneur qui va contenir les éléments
        loginPanel.setLayout(new GridLayout(2, 2)); // on créer une grille de 2 lignes et 2 colonnes
        loginPanel.add(new JLabel("Pseudo :")); // ajoute le label "pseudo"
        userName = new JTextField(); // Création du champ de texte pour le pseudo
        loginPanel.add(userName); // Ajoute le champ de texte
        loginPanel.add(new JLabel("Mot de passe :"));
        password = new JPasswordField(); // Création du champ de texte
        loginPanel.add(password); // Ajoute le champ de texte
        this.add(loginPanel, BorderLayout.CENTER); // Ajoute le panel au centre de la fenêtre
        loginButton = new JButton("Connexion"); // Création du bouton
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onLogin();
            }
        });
        this.add(loginButton, BorderLayout.SOUTH); // Ajoute le bouton en bas de la fenêtre
    }

    private void onLogin() {
        String username = userName.getText().trim();
        String password = new String(this.password.getPassword()).trim();
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez saisir un pseudo et un mot de passe", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            System.out.println("Vous êtes connecté");
        }
    }
}
