package com.umc.library.controllers;

import java.util.List;

import javax.swing.JOptionPane;

import com.umc.library.DAO.LivroDAO;
import com.umc.library.models.Livro;
import com.umc.library.views.ListaLivrosFrame;

public class ListaLivrosController {
    private ListaLivrosFrame listaLivrosFrame;
    private MainController mainController;
    private LivroDAO livroDAO;

    public ListaLivrosController(ListaLivrosFrame listaLivrosFrame, MainController mainController) {
        this.listaLivrosFrame = listaLivrosFrame;
        this.mainController = mainController;
        this.livroDAO = new LivroDAO();
        carregarDados();

        this.listaLivrosFrame.getReservarButton().addActionListener(e -> {
            reservarLivro();
        });

        this.listaLivrosFrame.getDevolverButton().addActionListener(e -> {
            devolverLivro();
        });

        this.listaLivrosFrame.getCadastrarButton().addActionListener(e -> {
            this.mainController.showCadastroLivroView();
        });
        // this.listaLivrosFrame.getTable().add
    }

    public void carregarDados() {
        List<Livro> livros = livroDAO.listarLivros();

        listaLivrosFrame.renderizarTabela(livros);
    }
    private void reservarLivro() {
        // Implemente a lógica de reserva
        JOptionPane.showMessageDialog(listaLivrosFrame, "A funcionalidade de reservar livro está em desenvolvimento.",
                "Em Desenvolvimento", JOptionPane.INFORMATION_MESSAGE);
    }

    private void devolverLivro() {
        // Implemente a lógica de devolução
        JOptionPane.showMessageDialog(listaLivrosFrame, "A funcionalidade de devolver livro está em desenvolvimento.",
                "Em Desenvolvimento", JOptionPane.INFORMATION_MESSAGE);

    }
}
