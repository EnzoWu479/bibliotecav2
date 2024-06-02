package com.umc.library.models;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Reserva {
    private String id;
    private String livro_id;
    private Date dataReserva;
    private Date dataDevolucao;
    private Boolean multa;
    private Boolean devolvido;
    private String usuario_id;

    public Reserva(String livro_id, Date dataReserva, Date dataDevolucao, Boolean multa, Boolean devolvido, String usuario_id) {
        this.livro_id = livro_id;
        this.dataReserva = dataReserva;
        this.dataDevolucao = dataDevolucao;
        this.multa = multa;
        this.devolvido = devolvido;
        this.usuario_id = usuario_id;
    }

    public String getId() {
        return id;
    }

    public String getLivro() {
        return livro_id;
    }

    public Date getDataReserva() {
        return dataReserva;
    }
    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public Boolean getMulta() {
        return multa;
    }

    public Boolean getDevolvido() {
        return devolvido;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLivro(String livro) {
        this.livro_id = Objects.requireNonNull(livro, "Livro não pode ser nulo");
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void setMulta(Boolean multa) {
        this.multa = multa;
    }

    public void setDevolvido(Boolean devolvido) {
        this.devolvido = devolvido;
    }

    public String getUsuario() {
        return usuario_id;
    }

    public void setUsuario(String usuario) {
        this.usuario_id = usuario;
    }

}
