package br.com.gt.gestor.model.produto;

import java.math.BigDecimal;

public record DadosEditarProduto(Long id, String nome, String cor, BigDecimal valor) {
}
