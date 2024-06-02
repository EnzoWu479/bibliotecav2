package com.umc.library.converters;

import java.util.function.Function;

import org.bson.Document;

import com.umc.library.models.Livro;
import com.umc.library.models.User;

public class UserConverter extends Converter<Document, User> {

    public UserConverter() {
        super(UserConverter::convertToEntity, UserConverter::convertToDto);
    }

    private static Document convertToDto(User livro) {
        return new Document("username", livro.getUsername())
                .append("password", livro.getPassword());
    }

    private static User convertToEntity(Document dto) {
        User livro = new User(dto.getString("username"), dto.getString("password"));
        if (dto.containsKey("_id")) {
            livro.setId(dto.getObjectId("_id").toString());
        }
        return livro;
    }

}
