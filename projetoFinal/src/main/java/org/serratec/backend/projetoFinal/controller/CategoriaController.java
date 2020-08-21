package org.serratec.backend.projetoFinal.controller;

import java.util.List;

import org.serratec.backend.projetoFinal.exception.CategoriaNotFoundException;
import org.serratec.backend.projetoFinal.exception.ParametroObrigatorioException;
import org.serratec.backend.projetoFinal.model.Categoria;
import org.serratec.backend.projetoFinal.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/categoria")
public class CategoriaController {

     @Autowired
    private CategoriaService categoriaService;
    
    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody Categoria categoria) {
        categoriaService.inserir(categoria);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    @GetMapping
    public List<Categoria> listar() {
        return categoriaService.listar();
    }
    
    @GetMapping("/{codigo}")
    public Categoria listarPorCodigo(@PathVariable Integer codigo) throws CategoriaNotFoundException {
        return categoriaService.listarPorCodigo(codigo);
    }
    
    @PutMapping("/{codigo}")
    public ResponseEntity<Void> substituir(@PathVariable Integer codigo, @RequestBody(required = true) Categoria categoria)
            throws CategoriaNotFoundException, ParametroObrigatorioException {
            categoriaService.substituir(codigo, categoria);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    @DeleteMapping("/{codigo}")
    public void deletar(@PathVariable Integer codigo) throws CategoriaNotFoundException {
        categoriaService.deletar(codigo);
    }
}
