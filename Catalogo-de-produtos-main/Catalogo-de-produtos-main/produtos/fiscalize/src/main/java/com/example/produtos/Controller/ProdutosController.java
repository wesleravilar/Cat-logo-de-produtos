package com.example.produtos.Controller;

import com.example.produtos.Model.Produtos;
import com.example.produtos.Service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
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
    public ResponseEntity get(@PathVariable("id") Integer id) {
        Optional<Produtos> produtos = service.getProdutosById(id);
        return produtos
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity post (@RequestBody Produtos produtos) {

        try {
            Produtos c = service.insert(produtos);

            URI location  = getUri(c.getID());
            return ResponseEntity.created(location).build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

private URI getUri (Integer id){
     return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
             .buildAndExpand(id).toUri();
}

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Integer id, @RequestBody Produtos produtos) {
        produtos.setID(id);
        Produtos c = service.update(produtos, id);

        return c != null ?
                ResponseEntity.ok(c) :
                ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
       boolean ok = service.delete((id));

        return ok ?
               ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }


    @GetMapping("/search")
    public  Iterable<Produtos> search(@RequestParam(required = false) Long min_price, @RequestParam(required = false) Long max_price, @RequestParam(required = false) String q) {

        Iterable<Produtos> produtos = service.search(min_price,max_price,q);
        return produtos;



    }



}

