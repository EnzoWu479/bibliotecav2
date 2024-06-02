package com.umc.library.controllers;

import com.umc.library.views.CadastroLivroFrame;
import com.umc.library.views.DevolverLivroFrame;
import com.umc.library.views.HomeFrame;
import com.umc.library.views.ListaLivrosFrame;
import com.umc.library.views.LoginFrame;
import com.umc.library.views.ReservaLivroFrame;

public class MainController {
    private HomeFrame homeView;
    private ListaLivrosFrame listaLivrosView;
    private CadastroLivroFrame cadastroLivroView;
    private ReservaLivroFrame reservaLivroView;
    private DevolverLivroFrame devolverLivroView;
    private DevolverLivroController devolverLivroController;
    private LoginFrame loginView;
    private HomeController homeController;
    private ListaLivrosController listaLivrosController;
    private CadastroLivroController cadastroLivroController;
    private LoginController loginController;
    private ReservaLivroController reservaLivroController;

    public MainController() {
        homeView = new HomeFrame();
        listaLivrosView = new ListaLivrosFrame();
        cadastroLivroView = new CadastroLivroFrame();
        reservaLivroView = new ReservaLivroFrame();
        loginView = new LoginFrame();
        devolverLivroView = new DevolverLivroFrame();

        homeController = new HomeController(homeView, this);
        listaLivrosController = new ListaLivrosController(listaLivrosView, this);
        cadastroLivroController = new CadastroLivroController(cadastroLivroView, this);
        loginController = new LoginController(loginView, this);
        reservaLivroController = new ReservaLivroController(reservaLivroView, this);
        devolverLivroController = new DevolverLivroController(devolverLivroView, this);

        loginView.setVisible(true);
        // frame.add(homeView);
    }

    public void showHomeView() {
        homeView.setVisible(true);

    }

    public void showListaLivrosView() {
        listaLivrosView.setVisible(true);
    }

    public void showCadastroLivroView() {
        cadastroLivroView.setVisible(true);
    }
    
    public void showReservaLivroView() {
        reservaLivroView.setVisible(true);
    }
    public void showDevolverLivroView() {
        devolverLivroController.carregarDados();
        devolverLivroView.setVisible(true);
    }

    public HomeController getHomeController() {
        return homeController;
    }

    public ListaLivrosController getListaLivrosController() {
        return listaLivrosController;
    }

    public CadastroLivroController getCadastroLivroController() {
        return cadastroLivroController;
    }

    public LoginController getLoginController() {
        return loginController;
    }
}
