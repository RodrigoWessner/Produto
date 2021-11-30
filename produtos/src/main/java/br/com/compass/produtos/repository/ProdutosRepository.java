package br.com.compass.produtos.repository;

import br.com.compass.produtos.entity.ProdutosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProdutosRepository extends JpaRepository<ProdutosEntity, Long>,
        JpaSpecificationExecutor<ProdutosEntity> {
}
