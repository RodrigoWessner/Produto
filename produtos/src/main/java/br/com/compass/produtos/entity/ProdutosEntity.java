package br.com.compass.produtos.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
public class ProdutosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    public ProdutosEntity(Long id, String nome, String description, BigDecimal price) {
        this.id = id;
        this.nome = nome;
        this.description = description;
        this.price = price;
    }

    public ProdutosEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
