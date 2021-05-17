package com.example.produtos.Model;

import javax.persistence.*;

@Entity
 public class Produtos {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SQ_PRODUTO")
    @SequenceGenerator(name="SQ_PRODUTO", sequenceName="SQ_PRODUTO", allocationSize=1)

    private Integer ID;

    private String NAME;

    private String DESCRIPTION;

    private Long PRICE;


    public Produtos() {

    }

    public Produtos(Integer ID, String NAME, String DESCRIPTION, Long PRICE) {
        this.ID = ID;
        this.NAME = NAME;
        this.DESCRIPTION = DESCRIPTION;
        this.PRICE = PRICE;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public Long getPRICE() {
        return PRICE;
    }

    public void setPRICE(Long PRICE) {
        this.PRICE = PRICE;
    }
}