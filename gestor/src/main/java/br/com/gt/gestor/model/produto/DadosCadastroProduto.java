package br.com.gt.gestor.model.produto;

import java.math.BigDecimal;

public record DadosCadastroProduto(
        String nome,
        String cor,
        BigDecimal valor
) {
}
