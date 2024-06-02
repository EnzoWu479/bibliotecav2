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

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

public class DevolucaoDAO {
    private final MongoCollection<Document> devolucaoCollection;

    public DevolucaoDAO() {
        this.devolucaoCollection = DBConnection.getMongoDatabase().getCollection("devolucoes");
    }

    public void inserirDevolucao(Document devolucao) {
        devolucaoCollection.insertOne(devolucao);
    }

    public List<Document> listarDevolucoes() {
        return devolucaoCollection.find().into(new ArrayList<>());
    }

    public Document buscarDevolucaoPorId(ObjectId devolucaoId) {
        return devolucaoCollection.find(eq("_id", devolucaoId)).first();
    }

    public long atualizarDevolucao(ObjectId devolucaoId, Document devolucaoAtualizada) {
        UpdateResult result = devolucaoCollection.replaceOne(eq("_id", devolucaoId), devolucaoAtualizada);
        return result.getModifiedCount();
    }

    public long excluirDevolucao(ObjectId devolucaoId) {
        DeleteResult result = devolucaoCollection.deleteOne(eq("_id", devolucaoId));
        return result.getDeletedCount();
    }
}
