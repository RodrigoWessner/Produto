package br.com.compass.produtos;

import br.com.compass.produtos.controller.ProdutoController;
import br.com.compass.produtos.dto.ProdutosDto;
import br.com.compass.produtos.entity.ProdutosEntity;
import br.com.compass.produtos.form.ProdutosForm;
import br.com.compass.produtos.repository.ProdutosRepository;
import br.com.compass.produtos.service.ProdutosService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {

    @Mock
    private ProdutosRepository produtosRepository;

    @Mock
    private ProdutoController produtoController;

    @Mock
    private ProdutosForm produtosForm;

    @Mock
    private ProdutosService produtosService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testReturnFindById() {
        when(produtosRepository.findById(any()))
                .thenReturn(Optional.of(completeProductEntity()));

        when(produtoController.ListarId(any()))
                .thenReturn(completeProductDto());

        assertEquals(1L, produtosRepository.findById(any()).get().getId());
        assertEquals(1L,produtoController.ListarId(any()).getId());
    }

    @Test
    public void testReturnInsert() {
        when(produtosService.Inserir(any()))
                .thenReturn(completeProductDto());
        assertEquals(completeProductDto(), produtosService.Inserir(any()));
    }

    private ProdutosEntity completeProductEntity() {
        return new ProdutosEntity(1L, "TV", "14 pole", new BigDecimal(25));
    }

    private ProdutosDto completeProductDto() {
        ProdutosDto produtosDto = new ProdutosDto();
        produtosDto.setId(1l);
        produtosDto.setPrice(new BigDecimal(25));
        produtosDto.setDescription("14 pole");
        produtosDto.setNome("TV");
        return produtosDto;
    }

    private ProdutosForm completeProductForm() {
        ProdutosForm produtosForm = new ProdutosForm();
        produtosForm.setPrice(new BigDecimal(25));
        produtosForm.setDescription("14 pole");
        produtosForm.setNome("TV");
        return produtosForm;
    }
}
