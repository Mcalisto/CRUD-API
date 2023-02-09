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

    public Object getName() {
        return null;
    }

    public void setName(Object name) {
    }
}