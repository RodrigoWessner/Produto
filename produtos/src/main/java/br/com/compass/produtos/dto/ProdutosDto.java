package br.com.compass.produtos.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProdutosDto {
    private Long id;
    private String nome;
    private String description;
    private BigDecimal price;
}
