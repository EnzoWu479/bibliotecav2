package com.umc.library.controllers;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import com.umc.library.DAO.UserDAO;
import com.umc.library.models.User;
import com.umc.library.views.LoginFrame;

public class LoginController {
    private LoginFrame loginFrame;
    private MainController mainController;
    private UserDAO userDAO;
    private User user;

    public LoginController(LoginFrame loginFrame, MainController mainController) {
        this.loginFrame = loginFrame;
        this.mainController = mainController;
        this.userDAO = new UserDAO();

        this.loginFrame.getLoginButton().addActionListener((ActionEvent e) -> {
            String username = loginFrame.getUsernameField().getText();
            char[] passwordChars = loginFrame.getPasswordField().getPassword();
            String password = new String(passwordChars);

            User user = userDAO.buscarUserPorUsername(username);

            if (user != null && user.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(loginFrame, "Login OK!");
                this.user = user;
                this.mainController.showHomeView();
                this.loginFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Usuário ou senha inválidos!");
            }
        });

        this.loginFrame.getRegisterButton().addActionListener((ActionEvent e) -> {
            String username = loginFrame.getUsernameField().getText();
            char[] passwordChars = loginFrame.getPasswordField().getPassword();
            String password = new String(passwordChars);

            try {

                User newUser = new User(username, password);
                userDAO.inserirUser(newUser);
                JOptionPane.showMessageDialog(loginFrame, "Usuário registrado com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(loginFrame, ex.getMessage());
            }

        });
    }

    public User getUser() {
        return user;
    }
}
