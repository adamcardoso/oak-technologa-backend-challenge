package br.com.technologies.oak.controllers;

import br.com.technologies.oak.dtos.ProdutoDTO;
import br.com.technologies.oak.services.interfaces.ProdutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class ProdutoControllerImpl {
    private final ProdutoService produtoService;

    public ProdutoControllerImpl(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ProdutoDTO>> listarProdutos() {
        List<ProdutoDTO> produtos = produtoService.listarProdutosPorValorAsc();

        log.info("Listando todos os produtos!");

        return ResponseEntity.ok().body(produtos);
    }

    @PostMapping("/produtos")
    public ResponseEntity<ProdutoDTO> cadastrarProduto(@RequestBody ProdutoDTO produto) {
        ProdutoDTO produtoCadastrado = produtoService.cadastrarProduto(produto);


        if (produtoCadastrado != null) {
            log.info("Criando novo produto: " + produtoCadastrado.getId());
            return ResponseEntity.ok().body(produtoCadastrado);
        } else {
            log.error("Falha ao criar novo produto.");
            return ResponseEntity.badRequest().build();
        }
    }
}
