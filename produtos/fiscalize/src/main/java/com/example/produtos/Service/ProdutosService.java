package com.example.produtos.Service;

import com.example.produtos.Model.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

@Service
public class ProdutosService {
    @Autowired
    private produtosRepository rep;

    public Iterable<Produtos> getprodutos() {
        return rep.findAll();
    }

    public Optional<Produtos> getProdutosById(Long id) {
        return rep.findById(id);
    }

    public Produtos save(Produtos produtos) {
        return rep.save(produtos);
    }

    public Produtos update(Produtos produtos, Long id){
        Assert.notNull(id,"Não foi possível atualizar o registro!");

        Optional<Produtos> optional = getProdutosById(id);
        if (optional.isPresent()){
            Produtos db = optional.get();
            db.setNAME(produtos.getNAME());
            db.setDESCRIPTION(produtos.getDESCRIPTION());
            db.setPRICE(produtos.getPRICE());
            System.out.println("Produto od"+db.getID());

            rep.save(db);
            return db;

        } else {
            throw new RuntimeException("não foi possivel atualizar o registro");
        }
    }

    public void delete(Long id){
        Optional<Produtos> produto = getProdutosById(id);
        if (produto.isPresent()){
            rep.deleteById(id);
        }
    }
}
