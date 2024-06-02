package com.umc.library.controllers;

import com.umc.library.views.HomeFrame;

public class HomeController {
    private HomeFrame homeFrame;
    private MainController mainController;

    public HomeController(HomeFrame homeFrame, MainController mainController) {
        this.homeFrame = homeFrame;
        this.mainController = mainController;
        this.homeFrame.getListarLivrosItem().addActionListener(e -> {
            this.mainController.showListaLivrosView();
        });
        this.homeFrame.getReservarLivroItem().addActionListener(e -> {
            this.mainController.showReservaLivroView();
        });

        this.homeFrame.getDevolverLivroItem().addActionListener(e -> {
            this.mainController.showDevolverLivroView();
        });
    }
}
