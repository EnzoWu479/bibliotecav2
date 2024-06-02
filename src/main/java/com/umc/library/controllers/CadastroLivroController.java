package com.umc.library.controllers;

import javax.swing.JOptionPane;

import com.umc.library.DAO.LivroDAO;
import com.umc.library.models.Livro;
import com.umc.library.views.CadastroLivroFrame;

public class CadastroLivroController {
    private CadastroLivroFrame cadastroLivroFrame;
    private MainController mainController;
    private LivroDAO livroDAO;

    public CadastroLivroController(CadastroLivroFrame cadastroLivroFrame, MainController mainController) {
        this.cadastroLivroFrame = cadastroLivroFrame;
        this.mainController = mainController;
        this.livroDAO = new LivroDAO();

        this.cadastroLivroFrame.getCadastrarButton().addActionListener(e -> {
            cadastrarLivro();
        });
    }

    private void cadastrarLivro() {
        // Obtém os dados do livro dos campos de entrada
        String titulo = cadastroLivroFrame.getTituloField().getText();
        String autor = cadastroLivroFrame.getAutorField().getText();
        String isbn = cadastroLivroFrame.getIsbnField().getText();
        String genero = cadastroLivroFrame.getGeneroField().getText();
        String editora = cadastroLivroFrame.getEditoraField().getText();
        int anoPublicacao = Integer.parseInt(cadastroLivroFrame.getAnoPublicacaoField().getText());

        livroDAO.inserirLivro(new Livro(titulo, autor, isbn, genero, editora, anoPublicacao));

        JOptionPane.showMessageDialog(cadastroLivroFrame, "Livro cadastrado com sucesso!");
        
        cadastroLivroFrame.getTituloField().setText("");
        cadastroLivroFrame.getAutorField().setText("");
        cadastroLivroFrame.getIsbnField().setText("");
        cadastroLivroFrame.getGeneroField().setText("");
        cadastroLivroFrame.getEditoraField().setText("");

        mainController.getListaLivrosController().carregarDados();
    }
}
