package org.acme.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.acme.classes.Empresa;

@ApplicationScoped
public class NegociosController {

public Empresa update(Long id, Empresa empresa) {  
    Empresa empresaEntity = Empresa.findById(id);

    if (empresaEntity == null) {  
        throw new WebApplicationException(id + " does not exist.", Response.Status.NOT_FOUND);  
    }

    empresaEntity.setName(empresa.getName());  
    //empresaEntity.setCalories(empresa.getCalories());

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