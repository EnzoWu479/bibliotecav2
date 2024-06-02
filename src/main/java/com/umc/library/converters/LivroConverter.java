package com.umc.library.converters;

import org.bson.Document;

import com.umc.library.models.Livro;

public class LivroConverter extends Converter<Document, Livro> {

    public LivroConverter() {
        super(LivroConverter::convertToEntity, LivroConverter::convertToDto);
    }

    private static Document convertToDto(Livro livro) {
        return new Document("titulo", livro.getTitulo())
                .append("autor", livro.getAutor())
                .append("isbn", livro.getIsbn())
                .append("genero", livro.getGenero())
                .append("editora", livro.getEditora())
                .append("anoPublicacao", livro.getAnoPublicacao());
    }

    private static Livro convertToEntity(Document dto) {
        Livro livro = new Livro(dto.getString("titulo"), dto.getString("autor"), dto.getString("isbn"),
                dto.getString("genero"),
                dto.getString("editora"), dto.getInteger("anoPublicacao"));
        livro.setId(dto.getObjectId("_id").toHexString());
        return livro;
    }

}
