package com.example.produtos.Controller;

import com.example.produtos.Model.Produtos;
import com.example.produtos.Service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping ("/produtos")
public class ProdutosController {
    @Autowired
    private ProdutosService service;

    @GetMapping()
    public Iterable<Produtos> get() {
        return service.getprodutos();
    }


    @GetMapping("/{id}")
    public Optional<Produtos> get(@PathVariable("id") Long id) {
        return service.getProdutosById(id);
    }

    @PostMapping
    public String post (@RequestBody Produtos produtos){
        Produtos c = service.save(produtos);
        return "Produto salvo com sucesso " + c.getID();

}
    @PutMapping("/{id}")
    public String put(@PathVariable("id") Long id, @RequestBody Produtos produtos) {
        Produtos c = service.update(produtos, id);

        return "Produto atualizado com sucesso " + c.getID();
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.delete((id));
        return "carro deletado com sucesso";
    }






}

