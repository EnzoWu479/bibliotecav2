package com.umc.library.converters;

import java.util.function.Function;

import org.bson.Document;

import com.umc.library.models.Livro;
import com.umc.library.models.Reserva;

public class ReservaConverter extends Converter<Document, Reserva> {

    public ReservaConverter() {
        super(ReservaConverter::convertToEntity, ReservaConverter::convertToDto);

    }

    private static Document convertToDto(Reserva reserva) {
        return new Document("id", reserva.getId())
                .append("livro", reserva.getLivro())
                .append("dataReserva", reserva.getDataReserva())
                .append("dataDevolucao", reserva.getDataDevolucao())
                .append("multa", reserva.getMulta())
                .append("devolvido", reserva.getDevolvido())
                .append("usuario_id", reserva.getUsuario());
    }

    private static Reserva convertToEntity(Document dto) {
        Reserva reserva = new Reserva(dto.getString("livro"), dto.getDate("dataReserva"),
                dto.getDate("dataDevolucao"), dto.getBoolean("multa"), dto.getBoolean("devolvido"),
                dto.getString("usuario_id"));
        if (dto.containsKey("_id")) {
            reserva.setId(dto.getObjectId("_id").toString());
        }
        return reserva;
    }
}
