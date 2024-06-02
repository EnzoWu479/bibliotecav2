package com.umc.library.controllers;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.umc.library.DAO.LivroDAO;
import com.umc.library.DAO.ReservaDAO;
import com.umc.library.models.Livro;
import com.umc.library.models.Reserva;
import com.umc.library.views.ReservaLivroFrame;

public class ReservaLivroController {
    private ReservaLivroFrame reservaLivroView;
    private MainController mainController;
    private LivroDAO livroDAO;
    private ReservaDAO reservaDAO;
    private List<Livro> livros;

    public ReservaLivroController(ReservaLivroFrame reservaLivroView, MainController mainController) {
        this.reservaLivroView = reservaLivroView;
        this.mainController = mainController;
        this.livroDAO = new LivroDAO();
        this.reservaDAO = new ReservaDAO();

        reservaLivroView.getReservarButton().addActionListener((e) -> {
            salvar();
        });

        carregarDados();
    }

    private void salvar() {
        String linhaLivro = reservaLivroView.getIdLivroField().getText();

        try {
            Livro livro = livros.get(Integer.parseInt(linhaLivro) - 1);

            if (livro == null) {
                throw new IllegalArgumentException("Livro não encontrado");
            }

            Date dataReserva = (Date) reservaLivroView.getDataReservaField().getValue();
            Date dataDevolucao = (Date) reservaLivroView.getDataDevolucaoField().getValue();

            Reserva reserva = new Reserva(livro.getId(),
                    dataReserva,
                    dataDevolucao, false, false, mainController.getLoginController().getUser().getId());
            reservaDAO.inserirReserva(reserva);

            JOptionPane.showMessageDialog(reservaLivroView, "Reserva realizada com sucesso!");

            reservaLivroView.getIdLivroField().setText("");
            reservaLivroView.getDataReservaField().setValue(null);
            reservaLivroView.getDataDevolucaoField().setValue(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(reservaLivroView, e.getMessage());
        }

    }

    public void carregarDados() {
        livros = livroDAO.listarLivros();

        reservaLivroView.renderizarListaLivros(livros);
    }
}
