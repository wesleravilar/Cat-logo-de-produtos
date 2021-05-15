package com.example.produtos.Model;

import javax.persistence.*;

@Entity
 public class Produtos {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SQ_PRODUTO")
    @SequenceGenerator(name="SQ_PRODUTO", sequenceName="SQ_PRODUTO", allocationSize=1)

    private Long ID;

    private String NAME;

    private String DESCRIPTION;

    private String PRICE;


    public Produtos() {

    }

    public Produtos(Long ID, String NAME, String DESCRIPTION, String PRICE) {
        this.ID = ID;
        this.NAME = NAME;
        this.DESCRIPTION = DESCRIPTION;
        this.PRICE = PRICE;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
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

    public String getPRICE() {
        return PRICE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }
}