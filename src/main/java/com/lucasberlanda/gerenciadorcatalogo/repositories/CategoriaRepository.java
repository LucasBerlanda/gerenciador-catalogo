package com.lucasberlanda.gerenciadorcatalogo.repositories;

import com.lucasberlanda.gerenciadorcatalogo.model.Categoria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends MongoRepository<Categoria, String> {
}
