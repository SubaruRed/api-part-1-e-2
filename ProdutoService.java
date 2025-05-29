package com.exemplo.compras.service;

import com.exemplo.compras.model.ProdutoModel;
import com.exemplo.compras.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoModel adicionar(ProdutoModel produto) {
        return produtoRepository.save(produto);
    }

    public List<ProdutoModel> listarTodos() {
        return produtoRepository.findAll();
    }

    public ProdutoModel buscarPorId(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public ProdutoModel atualizar(Long id, ProdutoModel produtoAtualizado) {
        ProdutoModel produto = buscarPorId(id);
        if (produto != null) {
            produto.setNome(produtoAtualizado.getNome());
            produto.setPreco(produtoAtualizado.getPreco());
            produto.setQuantidadeEstoque(produtoAtualizado.getQuantidadeEstoque());
            produto.setDescricao(produtoAtualizado.getDescricao());
            return produtoRepository.save(produto);
        }
        return null;
    }

    public void remover(Long id) {
        produtoRepository.deleteById(id);
    }
}