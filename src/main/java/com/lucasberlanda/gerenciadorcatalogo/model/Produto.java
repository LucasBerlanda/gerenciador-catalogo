package com.lucasberlanda.gerenciadorcatalogo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "produto")
@Setter
@Getter
@NoArgsConstructor
public class Produto {

    @Id
    private Long id;
    private String titulo;
    private String descricao;
    private Long proprietarioId;
    private Double valor;
    private Categoria categoria;
}
