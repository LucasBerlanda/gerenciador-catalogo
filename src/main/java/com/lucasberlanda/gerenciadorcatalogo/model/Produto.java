package com.lucasberlanda.gerenciadorcatalogo.model;

import com.lucasberlanda.gerenciadorcatalogo.records.ProdutoRecord;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produto")
@Setter
@Getter
@NoArgsConstructor
public class Produto {

    @Id
    private String id;
    private String titulo;
    private String descricao;
    private String proprietarioId;
    private Double valor;
    private Categoria categoria;

    public Produto(ProdutoRecord record) {
        this.titulo = record.titulo();
        this.descricao = record.descricao();
        this.proprietarioId = record.proprietarioId();;
        this.valor = record.valor();
    }
}
