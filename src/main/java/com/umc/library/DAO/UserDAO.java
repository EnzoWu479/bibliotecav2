package com.umc.library.DAO;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.umc.library.config.DBConnection;
import com.umc.library.converters.UserConverter;
import com.umc.library.models.User;

public class UserDAO {
    private final MongoCollection<Document> userCollection;
    private final UserConverter userConverter = new UserConverter();

    public UserDAO() {
        this.userCollection = DBConnection.getMongoDatabase().getCollection("users");
    }

    public void inserirUser(User user) {
        userCollection.insertOne(userConverter.convertFromEntity(user));
    }

    public List<User> listarUsers() {
        return userConverter.createFromDtos(userCollection.find().into(new ArrayList<>()));
    }

    public User buscarUserPorId(String userId) {
        return userConverter.convertFromDto(userCollection.find(eq("_id", new ObjectId(userId))).first());
    }

    public User buscarUserPorUsername(String username) {
        return userConverter.convertFromDto(userCollection.find(eq("username", username)).first());
    }

    public long atualizarUser(String userId, User userAtualizado) {
        // UpdateResult result = userCollection.replaceOne(eq("_id", devolucaoId),
        // devolucaoAtualizada);
        // return result.getModifiedCount();
        UpdateResult result = userCollection.updateOne(eq("_id", new ObjectId(userId)),
                userConverter.convertFromEntity(userAtualizado));
        return result.getModifiedCount();
    }

    public long excluirUser(String devolucaoId) {
        DeleteResult result = userCollection.deleteOne(eq("_id", new ObjectId(devolucaoId)));
        return result.getDeletedCount();
    }
}
