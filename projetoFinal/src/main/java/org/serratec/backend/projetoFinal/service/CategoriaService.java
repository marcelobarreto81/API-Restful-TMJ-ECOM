package org.serratec.backend.projetoFinal.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projetoFinal.exception.CategoriaNotFoundException;
import org.serratec.backend.projetoFinal.exception.ParametroObrigatorioException;
import org.serratec.backend.projetoFinal.model.Categoria;
import org.serratec.backend.projetoFinal.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public Categoria inserir(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }
    
    public Categoria listarPorCodigo(Integer codigo) throws CategoriaNotFoundException {
        Optional<Categoria> opCategoria = categoriaRepository.findById(codigo);

 

        if(opCategoria.isPresent()) {
            return opCategoria.get();
        }
        
        throw new CategoriaNotFoundException("Categoria com id " + codigo + " não encontrada");
    }
    
    public Categoria substituir(Integer codigo, Categoria categoria) throws ParametroObrigatorioException, CategoriaNotFoundException {
        if(categoria == null) throw new ParametroObrigatorioException("Campo 'Categoria' é obrigatório");
        
        Categoria categoriaNoBanco = listarPorCodigo(codigo);
        
        if(categoria.getNome() != null) {
            categoriaNoBanco.setNome(categoria.getNome());
        }
        
        if(categoria.getDescricao() != null) {
            categoriaNoBanco.setDescricao(categoria.getDescricao());
        }
        
        return categoriaRepository.save(categoriaNoBanco);
    }
    
    public void deletar(Integer codigo) throws CategoriaNotFoundException{
        Categoria CategoriaNoBanco = listarPorCodigo(codigo);
        categoriaRepository.delete(CategoriaNoBanco);
    }

 

}
