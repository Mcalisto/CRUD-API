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
}