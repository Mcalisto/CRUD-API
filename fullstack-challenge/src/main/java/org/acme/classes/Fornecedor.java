package org.acme.classes;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.persistence.*;

@Entity
public class Fornecedor extends PanacheEntityBase{

    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long cnpj;

    @Column
    private long cpf;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private long cep;

    public String getNome() {
        return null;
    }

    public Long getCep() {
        return null;
    }

    public Long getCnpj() {
        return null;
    }

    public Long getCpf() {
        return null;
    }

    public String getEmail() {
        return null;
    }


    public void setCep(Long cep) {
        this.cep = cep;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}