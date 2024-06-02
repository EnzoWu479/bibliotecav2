package com.umc.library.controllers;

import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.umc.library.DAO.LivroDAO;
import com.umc.library.DAO.ReservaDAO;
import com.umc.library.models.Livro;
import com.umc.library.models.Reserva;
import com.umc.library.views.DevolverLivroFrame;
import com.umc.library.views.ReservaLivroFrame;

public class DevolverLivroController {
    private DevolverLivroFrame devolverLivroFrame;
    private MainController mainController;
    private LivroDAO livroDAO;
    private ReservaDAO reservaDAO;
    private List<Reserva> reservas;

    public DevolverLivroController(DevolverLivroFrame devolverLivroFrame, MainController mainController) {
        this.devolverLivroFrame = devolverLivroFrame;
        this.mainController = mainController;
        this.livroDAO = new LivroDAO();
        this.reservaDAO = new ReservaDAO();

        this.devolverLivroFrame.getReservarButton().addActionListener((e) -> {
            salvar();
        });
    }

    private void salvar() {
        String linhaReserva = devolverLivroFrame.getIdLivroField().getText();
        Date dataDevolucao = (Date) devolverLivroFrame.getDataDevolucaoField().getValue();

        Reserva reserva = reservas.get(Integer.parseInt(linhaReserva) - 1);

        if (reserva == null) {
            throw new IllegalArgumentException("Reserva não encontrada");
        }

        if (reserva.getDevolvido()) {
            throw new IllegalArgumentException("Reserva já devolvida");
        }

        reserva.setDevolvido(true);
        if (reserva.getDataDevolucao().before(dataDevolucao)) {
            reserva.setMulta(true);
        }
        reservaDAO.atualizarReserva(reserva.getId(), reserva);

        JOptionPane.showMessageDialog(devolverLivroFrame, "Devolução realizada com sucesso!");

        carregarDados();
    }

    public void carregarDados() {
        reservas = reservaDAO.buscarReservasPorUsuario(mainController.getLoginController().getUser().getId());

        devolverLivroFrame.renderizarListaReservas(reservas);
    }
}
