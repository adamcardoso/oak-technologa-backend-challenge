package br.com.technologies.oak.repositories;

import br.com.technologies.oak.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findAllByOrderByValorAsc();
}
