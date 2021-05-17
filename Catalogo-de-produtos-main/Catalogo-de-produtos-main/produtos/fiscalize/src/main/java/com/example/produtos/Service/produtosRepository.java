package com.example.produtos.Service;

import com.example.produtos.Model.Produtos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface produtosRepository extends CrudRepository<Produtos, Integer> {

    @Query("select p from Produtos p where p.PRICE <= :max_price and p.PRICE >= :min_price and (p.NAME like :q or p.DESCRIPTION like :q)")
    List<Produtos> findAllBetweenPrices(@Param("min_price") Long min_price, @Param("max_price") Long max_price, @Param("q") String q);
}



