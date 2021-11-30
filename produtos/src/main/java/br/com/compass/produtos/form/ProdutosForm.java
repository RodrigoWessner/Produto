package br.com.compass.produtos.form;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProdutosForm {
    @NotEmpty(message = "The name can not be empty")
    private String nome;


    private String description;

    private BigDecimal price;
}
