package com.umc.library.views;

import javax.swing.*;
import java.awt.*;

public class CadastroLivroFrame extends JFrame {

    private JTextField tituloField;
    private JTextField autorField;
    private JTextField isbnField;
    private JTextField generoField;
    private JTextField editoraField;
    private JTextField anoPublicacaoField;
    private JButton cadastrarButton;

    public CadastroLivroFrame() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Cadastro de Livro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2));

        // Componentes de entrada para os dados do livro
        JLabel tituloLabel = new JLabel("Título:");
        tituloField = new JTextField();
        JLabel autorLabel = new JLabel("Autor:");
        autorField = new JTextField();
        JLabel isbnLabel = new JLabel("ISBN:");
        isbnField = new JTextField();
        JLabel generoLabel = new JLabel("Gênero:");
        generoField = new JTextField();
        JLabel editoraLabel = new JLabel("Editora:");
        editoraField = new JTextField();
        JLabel anoPublicacaoLabel = new JLabel("Ano de Publicação:");
        anoPublicacaoField = new JTextField();

        panel.add(tituloLabel);
        panel.add(tituloField);
        panel.add(autorLabel);
        panel.add(autorField);
        panel.add(isbnLabel);
        panel.add(isbnField);
        panel.add(generoLabel);
        panel.add(generoField);
        panel.add(editoraLabel);
        panel.add(editoraField);
        panel.add(anoPublicacaoLabel);
        panel.add(anoPublicacaoField);

        cadastrarButton = new JButton("Cadastrar");
        // cadastrarButton.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         cadastrarLivro();
        //     }
        // });

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(cadastrarButton, BorderLayout.SOUTH);
    }

    public JTextField getTituloField() {
        return tituloField;
    }

    public JTextField getAutorField() {
        return autorField;
    }

    public JTextField getIsbnField() {
        return isbnField;
    }

    public JTextField getGeneroField() {
        return generoField;
    }

    public JTextField getEditoraField() {
        return editoraField;
    }

    public JTextField getAnoPublicacaoField() {
        return anoPublicacaoField;
    }

    public JButton getCadastrarButton() {
        return cadastrarButton;
    }
}
