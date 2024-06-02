package com.umc.library;

import javax.swing.SwingUtilities;

import com.umc.library.controllers.MainController;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainController();
            }
        });
    }
}
