package com.lucasberlanda.gerenciadorcatalogo.repositories;

import com.lucasberlanda.gerenciadorcatalogo.model.Categoria;
import com.lucasberlanda.gerenciadorcatalogo.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, Long> {
}
