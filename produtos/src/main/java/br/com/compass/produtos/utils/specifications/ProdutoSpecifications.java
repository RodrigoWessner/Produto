package br.com.compass.produtos.utils.specifications;

import br.com.compass.produtos.entity.ProdutosEntity;
import br.com.compass.produtos.entity.ProdutosEntity;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProdutoSpecifications {

    public static Specification<ProdutosEntity> pricesBetween(BigDecimal minPrice, BigDecimal maxPrice){
        return ((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.between(root.get("price"), minPrice, maxPrice));
    }

    public static Specification<ProdutosEntity> greaterThanOrEqualTo(BigDecimal minPrice){
        return ((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice));
    }

    public static Specification<ProdutosEntity> lessThanOrEqualTo(BigDecimal maxPrice){
        return ((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice));
    }
}
