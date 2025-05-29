package com.exemplo.compras.controller;

import com.exemplo.compras.model.ProdutoModel;
import com.exemplo.compras.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ProdutoModel adicionar(@RequestBody ProdutoModel produto) {
        return produtoService.adicionar(produto);
    }

    @GetMapping
    public List<ProdutoModel> listarTodos() {
        return produtoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ProdutoModel buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ProdutoModel atualizar(@PathVariable Long id, @RequestBody ProdutoModel produto) {
        return produtoService.atualizar(id, produto);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        produtoService.remover(id);
    }
}