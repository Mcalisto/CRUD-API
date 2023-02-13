package org.acme.classes;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.persistence.*;

@Entity
public class Empresa extends PanacheEntityBase{

    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long cnpj;

    @Column
    private String nome;

    @Column
    private long cep;

    public long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public Long getCep() {
        return this.cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }
}