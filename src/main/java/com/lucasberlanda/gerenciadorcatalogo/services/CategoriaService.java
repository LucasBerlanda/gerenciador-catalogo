package com.lucasberlanda.gerenciadorcatalogo.services;

import com.lucasberlanda.gerenciadorcatalogo.exceptions.CategoriaNotFoundException;
import com.lucasberlanda.gerenciadorcatalogo.model.Categoria;
import com.lucasberlanda.gerenciadorcatalogo.records.CategoriaRecord;
import com.lucasberlanda.gerenciadorcatalogo.repositories.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaService {

    private final CategoriaRepository repository;

    public Categoria salvar(CategoriaRecord record){
        Categoria categoria = new Categoria(record);

        repository.save(categoria);

        return categoria;
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria alterar(Long id, CategoriaRecord record) {
        Categoria categoria = this.repository.findById(id).orElseThrow(CategoriaNotFoundException::new);

        atualizaDados(record, categoria);

        repository.save(categoria);
        return categoria;
    }

    private static void atualizaDados(CategoriaRecord record, Categoria categoria) {
        if(!record.titulo().isEmpty()) categoria.setTitulo(record.titulo());
        if(!record.descricao().isEmpty()) categoria.setDescricao(record.descricao());
        if(record.proprietarioId() != null) categoria.setProprietarioId(record.proprietarioId());
    }

    public void remover(Long id) {
        Categoria categoria = this.repository.findById(id).orElseThrow(CategoriaNotFoundException::new);
        repository.delete(categoria);
    }
}
