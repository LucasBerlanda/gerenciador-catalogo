package com.lucasberlanda.gerenciadorcatalogo.services;

import com.lucasberlanda.gerenciadorcatalogo.exceptions.CategoriaNotFoundException;
import com.lucasberlanda.gerenciadorcatalogo.exceptions.ProdutoNotFoundException;
import com.lucasberlanda.gerenciadorcatalogo.model.Categoria;
import com.lucasberlanda.gerenciadorcatalogo.model.Produto;
import com.lucasberlanda.gerenciadorcatalogo.records.CategoriaRecord;
import com.lucasberlanda.gerenciadorcatalogo.records.ProdutoRecord;
import com.lucasberlanda.gerenciadorcatalogo.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;
    private final CategoriaService categoriaService;

    public Produto salvar(ProdutoRecord record){

        var catergoria = categoriaService.getById(record.categoriaId()).orElseThrow(CategoriaNotFoundException::new);

        Produto produto = new Produto(record);
        produto.setCategoria(catergoria);

        repository.save(produto);

        return produto;
    }

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Produto alterar(String id, ProdutoRecord record) {
        Produto produto = this.repository.findById(id).orElseThrow(ProdutoNotFoundException::new);

        atualizaDados(record, produto);

        repository.save(produto);
        return produto;
    }

    private void atualizaDados(ProdutoRecord record, Produto produto) {
        if(record.titulo() != null) produto.setTitulo(record.titulo());
        if(record.descricao() != null) produto.setDescricao(record.descricao());
        if(record.proprietarioId() != null) produto.setProprietarioId(record.proprietarioId());
        if(record.valor() != null) produto.setValor(record.valor());
        if(record.categoriaId() != null) categoriaService.getById(record.categoriaId()).ifPresent(produto::setCategoria);
    }

    public void remover(String id) {
        Produto produto = this.repository.findById(id).orElseThrow(ProdutoNotFoundException::new);
        repository.delete(produto);
    }
}
