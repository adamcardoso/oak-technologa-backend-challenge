package br.com.technologies.oak.services.interfaces;

import br.com.technologies.oak.dtos.ProdutoDTO;

import java.util.List;

public interface ProdutoService {

    List<ProdutoDTO> listarProdutosPorValorAsc();

    ProdutoDTO cadastrarProduto(ProdutoDTO produto);
}
