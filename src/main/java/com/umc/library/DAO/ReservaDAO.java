package com.umc.library.DAO;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.umc.library.config.DBConnection;
import com.umc.library.converters.ReservaConverter;
import com.umc.library.models.Reserva;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

public class ReservaDAO {
    private final MongoCollection<Document> reservaCollection;
    private final ReservaConverter converter = new ReservaConverter();

    public ReservaDAO() {
        this.reservaCollection = DBConnection.getMongoDatabase().getCollection("reservas");
    }

    public void inserirReserva(Reserva reserva) {
        // checa se o usuario já reservou o livro
        if (reservaCollection.find(Filters.and(eq("usuario_id", reserva.getUsuario()), eq("livro_id", reserva.getLivro()))).first() != null) {
            throw new IllegalArgumentException("Usuário já reservou este livro");
        }
        // checa se o livro já foi reservado
        if (reservaCollection.find(Filters.and(eq("livro_id", reserva.getLivro()), eq("devolvido", false))).first() != null) {
            throw new IllegalArgumentException("Livro já reservado");
        }
        // checa se o usuario já reservou 5 livros
        if (reservaCollection.find(eq("usuario_id", reserva.getUsuario())).into(new ArrayList<>()).size() > 5) {
            throw new IllegalArgumentException("Usuário já reservou 5 livros");
        }
        reservaCollection.insertOne(converter.convertFromEntity(reserva));
    }

    public List<Reserva> buscarReservasPorUsuario(String usuarioId) {
        return converter.createFromDtos(
                reservaCollection.find(eq("usuario_id", usuarioId)).into(new ArrayList<>()));
    }

    public long atualizarReserva(String reservaId, Reserva reservaAtualizada) {
        UpdateResult result = reservaCollection.replaceOne(eq("_id", new ObjectId(reservaId)),
                converter.convertFromEntity(reservaAtualizada));
        return result.getModifiedCount();
    }

    public long excluirReserva(String reservaId) {
        DeleteResult result = reservaCollection.deleteOne(eq("_id", new ObjectId(reservaId)));
        return result.getDeletedCount();
    }
}
