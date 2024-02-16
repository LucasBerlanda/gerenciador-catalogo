package com.lucasberlanda.gerenciadorcatalogo.controllers;

import com.lucasberlanda.gerenciadorcatalogo.model.Categoria;
import com.lucasberlanda.gerenciadorcatalogo.records.CategoriaRecord;
import com.lucasberlanda.gerenciadorcatalogo.services.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@AllArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping("/salvar")
    public ResponseEntity<Categoria> salvar(@RequestBody CategoriaRecord record){
       var categoria = categoriaService.salvar(record);

       return ResponseEntity.ok().body(categoria);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Categoria>> lista(){
        List<Categoria> list = categoriaService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<Categoria> alterar(@RequestParam Long id, @RequestBody CategoriaRecord record){
        var categoria = categoriaService.alterar(id, record);

        return ResponseEntity.ok().body(categoria);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Categoria> remover(@RequestParam Long id){
        categoriaService.remover(id);

        return ResponseEntity.noContent().build();
    }
}

