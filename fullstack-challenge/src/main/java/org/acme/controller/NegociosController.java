package org.acme.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.acme.classes.Empresa;
import org.acme.classes.Fornecedor;

@ApplicationScoped
public class NegociosController {

public Empresa updateEmpresa(Long id, Empresa empresa) {  
    Empresa empresaEntity = Empresa.findById(id);

    if (empresaEntity == null) {  
        throw new WebApplicationException(id + " does not exist.", Response.Status.NOT_FOUND);  
    }

     empresaEntity.setNome(empresa.getNome());  
     empresaEntity.setCep(empresa.getCep()); 
     empresaEntity.setCnpj(empresa.getCnpj()); 

    return empresaEntity;  
}

public Fornecedor updateFornecedor(Long id, Fornecedor fornecedor) {  
    Fornecedor empresaEntity = Fornecedor.findById(id);

    if (empresaEntity == null) {  
        throw new WebApplicationException(id + " does not exist.", Response.Status.NOT_FOUND);  
    }

     empresaEntity.setNome(fornecedor.getNome());  
     empresaEntity.setCep(fornecedor.getCep()); 
     empresaEntity.setCnpj(fornecedor.getCnpj()); 

    return empresaEntity;  
}

/**  
 * This method is main purpose to show simple "Business" example  
 * @param food  
 * @return  
 */  
// public boolean isFoodNameIsNotEmpty(Food food) {
//     return food.getName().isEmpty();  
// }

}