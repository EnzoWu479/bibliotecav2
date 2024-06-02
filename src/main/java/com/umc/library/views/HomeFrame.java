package com.umc.library.views;

import java.awt.BorderLayout;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeFrame extends JFrame {

    JMenuItem listarLivrosItem;
    JMenuItem reservarLivroItem;
    JMenuItem devolverLivroItem;

    public HomeFrame() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Sistema de Biblioteca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Define a janela como maximizada
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Define o layout da janela
        setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();

        JMenu livroMenu = new JMenu("Livros");
        listarLivrosItem = new JMenuItem("Listar Livros");
        livroMenu.add(listarLivrosItem);

        JMenu reservaMenu = new JMenu("Reservas");
        reservarLivroItem = new JMenuItem("Reservar Livro");
        reservaMenu.add(reservarLivroItem);

        JMenu devolucaoMenu = new JMenu("Devoluções");
        devolverLivroItem = new JMenuItem("Devolver Livro");
        devolucaoMenu.add(devolverLivroItem);

        menuBar.add(livroMenu);
        menuBar.add(reservaMenu);
        menuBar.add(devolucaoMenu);

        setJMenuBar(menuBar);

        pack();
        setLocationRelativeTo(null);
    }

    public JMenuItem getListarLivrosItem() {
        return listarLivrosItem;
    }

    public JMenuItem getReservarLivroItem() {
        return reservarLivroItem;
    }

    public JMenuItem getDevolverLivroItem() {
        return devolverLivroItem;
    }
}
