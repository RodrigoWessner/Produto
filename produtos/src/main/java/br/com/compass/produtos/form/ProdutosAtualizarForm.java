package br.com.compass.produtos.form;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProdutosAtualizarForm {
    private Long id;
    private String nome;
    private String description;
    private BigDecimal price;
}
