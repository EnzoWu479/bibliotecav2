package com.umc.library.DAO;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.umc.library.config.DBConnection;
import com.umc.library.converters.LivroConverter;
import com.umc.library.models.Livro;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

public class LivroDAO {
    private final MongoCollection<Document> livroCollection;
    private final LivroConverter livroConverter = new LivroConverter();

    public LivroDAO() {
        this.livroCollection = DBConnection.getMongoDatabase().getCollection("livros");
    }

    public void inserirLivro(Livro livro) {
        livroCollection.insertOne(livroConverter.convertFromEntity(livro));
    }

    public List<Livro> listarLivros() {
        ArrayList<Document> documents = livroCollection.find().into(new ArrayList<>());
        return livroConverter.createFromDtos(documents);
    }
    public List<Livro> listarLivrosLivres() {
        ArrayList<Document> documents = livroCollection.find(eq("reservado", false)).into(new ArrayList<>());
        return livroConverter.createFromDtos(documents);
    }

    public Livro buscarLivroPorId(String livroId) {
        return livroConverter.convertFromDto(livroCollection.find(eq("_id",
                new ObjectId(livroId))).first());
    }
    public List<Livro> buscarLivroPorAutor(String autor) {
        ArrayList<Document> documents = livroCollection.find(eq("autor", autor)).into(new ArrayList<>());
        return livroConverter.createFromDtos(documents);
    }

    public long atualizarLivro(String livroId, Livro livroAtualizado) {
        UpdateResult result = livroCollection.replaceOne(eq("_id",
                new ObjectId(livroId)),
                livroConverter.convertFromEntity(livroAtualizado));
        return result.getModifiedCount();
    }

    public long excluirLivro(String livroId) {
        DeleteResult result = livroCollection.deleteOne(eq("_id", new ObjectId(livroId)));
        return result.getDeletedCount();
    }
}
