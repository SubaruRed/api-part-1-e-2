package com.exemplo.compras.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double preco;
    private Integer quantidadeEstoque;
    private String descricao;
}