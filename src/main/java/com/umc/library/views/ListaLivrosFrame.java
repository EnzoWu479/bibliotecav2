package com.umc.library.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import com.umc.library.models.Livro;

public class ListaLivrosFrame extends JFrame {

    private JButton reservarButton;
    private JButton devolverButton;
    private JButton cadastrarButton;
    private JTable table;
    private DefaultTableModel tableModel;

    public ListaLivrosFrame() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Lista de Livros");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Define a janela como maximizada
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setMinimumSize(new Dimension(800, 600));

        // Define o layout da janela
        setLayout(new BorderLayout());

        // Nomes das colunas
        String[] columnNames = { "Título", "Autor", "ISBN", "Gênero", "Editora", "Ano de Publicação" };

        // Cria o modelo da tabela
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Adiciona a tabela ao painel de conteúdo
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Adiciona botões de ação
        reservarButton = new JButton("Reservar Livro");
        devolverButton = new JButton("Devolver Livro");
        cadastrarButton = new JButton("Cadastrar Livro");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(reservarButton);
        buttonPanel.add(devolverButton);
        buttonPanel.add(cadastrarButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    public JButton getReservarButton() {
        return reservarButton;
    }

    public JButton getDevolverButton() {
        return devolverButton;
    }

    public JButton getCadastrarButton() {
        return cadastrarButton;
    }

    public JTable getTable() {
        return table;
    }

    public void renderizarTabela(List<Livro> livros) {
        // Limpa os dados existentes na tabela
        tableModel.setRowCount(0);

        // Adiciona os livros na tabela
        for (Livro livro : livros) {
            tableModel.addRow(new Object[] { livro.getTitulo(), livro.getAutor(), livro.getIsbn(), livro.getGenero(),
                    livro.getEditora(), livro.getAnoPublicacao() });
        }
    }
}
