package br.com.compass.produtos.controller;

import br.com.compass.produtos.dto.ProdutosDto;
import br.com.compass.produtos.form.ProdutosForm;
import br.com.compass.produtos.service.ProdutosService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProdutoController {

    private final ProdutosService produtosService;

    public ProdutoController(ProdutosService produtoService) {
        this.produtosService = produtoService;
    }

    @PostMapping
    public ProdutosDto Inserir(@Valid @RequestBody ProdutosForm produtosForm) {
        return produtosService.Inserir(produtosForm);
    }

    @PutMapping("/{id}")
    public ProdutosDto Atualizar(@PathVariable Long id, @RequestBody ProdutosForm produtosForm) {
        return produtosService.Atualizar(id, produtosForm);
    }

    @GetMapping()
    public List<ProdutosDto> ListarTodos() {
        return produtosService.Listar();
    }

    @GetMapping("/{id}")
    public ProdutosDto ListarId(@PathVariable Long id) {
        return produtosService.Listar(id);
    }

    @GetMapping("/search")
    public List<ProdutosDto> ListarFiltro(@RequestParam(required = false) String q,
                                          @RequestParam(required = false) Long minPrice,
                                          @RequestParam(required = false) Long maxPrice) {
        return produtosService.Listar(q, minPrice, maxPrice);
    }

    @DeleteMapping("/{id}")
    public void Deletar(@PathVariable Long id) {
        produtosService.Deletar(id);
    }
}
