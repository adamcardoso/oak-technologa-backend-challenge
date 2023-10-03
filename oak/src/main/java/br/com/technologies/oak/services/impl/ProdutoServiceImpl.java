package br.com.technologies.oak.services.impl;

import br.com.technologies.oak.dtos.ProdutoDTO;
import br.com.technologies.oak.entities.Produto;
import br.com.technologies.oak.repositories.ProdutoRepository;
import br.com.technologies.oak.services.interfaces.ProdutoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<ProdutoDTO> listarProdutosPorValorAsc() {
        List<Produto> produtos = produtoRepository.findAllByOrderByValorAsc();

        List<ProdutoDTO> produtoDTOs = produtos.stream()
                .map(produto -> new ProdutoDTO(
                        produto.getId(),
                        produto.getNome(),
                        produto.getDescricao(),
                        produto.getValor(),
                        produto.getDisponivel()))
                .toList();

        return produtoDTOs;
    }

    @Override
    public ProdutoDTO cadastrarProduto(ProdutoDTO produto) {
        Produto produtoEntity = new Produto(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getValor(),
                produto.getDisponivel());
        produtoRepository.save(produtoEntity);

        return produto;
    }
}
