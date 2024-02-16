package com.lucasberlanda.gerenciadorcatalogo.model;

import com.lucasberlanda.gerenciadorcatalogo.records.CategoriaRecord;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "categoria")
@Getter
@Setter
@NoArgsConstructor
public class Categoria {

    @Id
    private Long id;
    private String titulo;
    private String descricao;
    private Long proprietarioId;

    public Categoria(CategoriaRecord record) {
        this.descricao= record.descricao();
        this.titulo = record.titulo();
        this.proprietarioId = record.proprietarioId();;
    }
}
