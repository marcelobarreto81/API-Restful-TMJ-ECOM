package org.serratec.backend.projetoFinal.repository;

import org.serratec.backend.projetoFinal.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
