package com.umc.library.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.umc.library.models.Livro;
import com.umc.library.models.Reserva;

public class DevolverLivroFrame extends JFrame {
    private JTextField idLivroField;
    private JFormattedTextField dataDevolucaoField;
    private JButton reservarButton;
    private JTable table;
    private DefaultTableModel tableModel;

    public DevolverLivroFrame() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Reserva de Livro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Define o layout da janela
        setLayout(new BorderLayout());

        // Define a janela como maximizada
        setSize(new Dimension(800, 600));

        JPanel horizontalPanel = new JPanel(new GridLayout(2, 1));

        // Adiciona a lista de livros ao painel de conteúdo
        String[] columnNames = { "Linha","Data de reserva", "Data esperada de devolução", "Devolvido", "Multa" };

        // Cria o modelo da tabela
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Adiciona a tabela ao painel de conteúdo
        horizontalPanel.add(scrollPane);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        idLivroField = new JTextField();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        dataDevolucaoField = new JFormattedTextField(format);

        reservarButton = new JButton("Devolver");

        panel.add(new JLabel("Linha da reserva: "));
        panel.add(idLivroField);
        panel.add(new JLabel("Data de devolução (yyyy-MM-dd): "));
        panel.add(dataDevolucaoField);
        panel.add(reservarButton);

        horizontalPanel.add(panel);

        add(horizontalPanel, BorderLayout.CENTER);

        // add(panel, BorderLayout.CENTER);
    }

    public JTextField getIdLivroField() {
        return idLivroField;
    }

    public JFormattedTextField getDataDevolucaoField() {
        return dataDevolucaoField;
    }

    public JButton getReservarButton() {
        return reservarButton;
    }

    public void renderizarListaReservas(List<Reserva> reservas) {
        // Limpa a tabela
        tableModel.setRowCount(0);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        // Adiciona os livros na tabela
        for (int i = 0; i < reservas.size(); i++) {
            Reserva reserva = reservas.get(i);
            tableModel.addRow(new Object[] { i + 1, 
                format.format(reserva.getDataReserva()),
                format.format(reserva.getDataDevolucao()),
                reserva.getDevolvido() ? "Sim" : "Não",
                reserva.getMulta() ? "Sim" : "Não"
            });
        }

    }
}
