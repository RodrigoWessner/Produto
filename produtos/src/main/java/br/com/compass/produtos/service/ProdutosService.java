package br.com.compass.produtos.service;

import br.com.compass.produtos.dto.ProdutosDto;
import br.com.compass.produtos.entity.ProdutosEntity;
import br.com.compass.produtos.exceptions.NotFound;
import br.com.compass.produtos.form.ProdutosForm;
import br.com.compass.produtos.repository.ProdutosRepository;
import br.com.compass.produtos.utils.specifications.ProdutoSpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specification.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProdutosService {
    private final ProdutosRepository produtosRepository;

    public ProdutosService(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    public ProdutosDto Inserir(ProdutosForm produtosForm) {
        ProdutosEntity produtosEntity = convertProdutToEntity(produtosForm);
        produtosRepository.save(produtosEntity);
        return convertProdutToDto(produtosEntity);
    }

    @Transactional
    public ProdutosDto Atualizar(Long id, ProdutosForm produtosForm) {
        ProdutosEntity produtosEntity = getProdutosEntity(id);
        produtosEntity = convertProdutToEntity(produtosEntity, produtosForm);
        return convertProdutToDto(produtosEntity);
    }

    private ProdutosEntity getProdutosEntity(Long id) {
        return produtosRepository.findById(id)
                .orElseThrow(() -> new NotFound("Não encontrado id = " + id));
    }

    public List<ProdutosDto> Listar() {
        List<ProdutosEntity> produtosEntities = produtosRepository.findAll();
        return produtosEntities
                .stream()
                .map(produto -> convertProdutToDto(produto))
                .collect(Collectors.toList());
    }

    public ProdutosDto Listar(Long id) {
        ProdutosEntity produtosEntity = getProdutosEntity(id);
        return convertProdutToDto(produtosEntity);
    }

    public List<ProdutosDto> Listar(String q, Long minPrice, Long maxPrice) {
        List<ProdutosEntity> produtosEntity = produtosRepository
                .findAll(Specification.where(ProdutoSpecifications.pricesBetween(new BigDecimal(minPrice), new BigDecimal(maxPrice))));
                //.findAll(Specification.where(ProdutoSpecifications.greaterThanOrEqualTo(new BigDecimal(minPrice))
                      //  .and(ProdutoSpecifications.lessThanOrEqualTo(new BigDecimal(maxPrice)))));

        /* .findAll((root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.between(root.get("price"), new BigDecimal(minPrice), new BigDecimal(maxPrice)));*/
        return produtosEntity
                .stream()
                .map(produtos -> convertProdutToDto(produtos))
                .collect(Collectors.toList());
    }

    @Transactional
    public void Deletar(Long id) {
        getProdutosEntity(id);
        produtosRepository.deleteById(id);
    }

    private ProdutosDto convertProdutToDto(ProdutosEntity produtosEntity) {
        ProdutosDto produtosDto = new ProdutosDto();
        produtosDto.setId(produtosEntity.getId());
        produtosDto.setDescription(produtosEntity.getDescription());
        produtosDto.setPrice(produtosEntity.getPrice());
        produtosDto.setNome(produtosEntity.getNome());
        return produtosDto;
    }

    private ProdutosEntity convertProdutToEntity(ProdutosDto produtosDto) {
        ProdutosEntity produtosEntity = new ProdutosEntity();
        produtosEntity.setDescription(produtosDto.getDescription());
        produtosEntity.setPrice(produtosDto.getPrice());
        produtosEntity.setNome(produtosDto.getNome());
        return produtosEntity;
    }

    private ProdutosEntity convertProdutToEntity(ProdutosForm produtosForm) {
        ProdutosEntity produtosEntity = new ProdutosEntity();
        produtosEntity.setDescription(produtosForm.getDescription());
        produtosEntity.setPrice(produtosForm.getPrice());
        produtosEntity.setNome(produtosForm.getNome());
        return produtosEntity;
    }

    private ProdutosEntity convertProdutToEntity(ProdutosEntity produtosEntity, ProdutosForm produtosForm) {
        produtosEntity.setDescription(produtosForm.getDescription());
        produtosEntity.setPrice(produtosForm.getPrice());
        produtosEntity.setNome(produtosForm.getNome());
        return produtosEntity;
    }
}
