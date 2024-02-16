package com.lucasberlanda.gerenciadorcatalogo.controllers;

import com.lucasberlanda.gerenciadorcatalogo.model.Categoria;
import com.lucasberlanda.gerenciadorcatalogo.model.Produto;
import com.lucasberlanda.gerenciadorcatalogo.records.CategoriaRecord;
import com.lucasberlanda.gerenciadorcatalogo.records.ProdutoRecord;
import com.lucasberlanda.gerenciadorcatalogo.services.CategoriaService;
import com.lucasberlanda.gerenciadorcatalogo.services.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produto")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping("/salvar")
    public ResponseEntity<Produto> salvar(@RequestBody ProdutoRecord record){
       var produto = produtoService.salvar(record);

       return ResponseEntity.ok().body(produto);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Produto>> lista(){
        List<Produto> list = produtoService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<Produto> alterar(@PathVariable("id") String id, @RequestBody ProdutoRecord record){
        var produto = produtoService.alterar(id, record);

        return ResponseEntity.ok().body(produto);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Produto> remover(@PathVariable("id") String id){
        produtoService.remover(id);

        return ResponseEntity.noContent().build();
    }
}

