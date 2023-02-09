package org.acme.resource;
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import org.acme.classes.Empresa;
import org.acme.classes.Fornecedor;
import org.acme.controller.NegociosController;

import com.oracle.svm.core.annotate.Inject;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/negocios")
public class NegociosResource {

@Inject  
private NegociosController negociosController;

@GET  
@Path("/empresas")
public List<Empresa> empresas() {  
    return Empresa.listAll();  
}

@GET  
@Path("/fornecedores")
public List<Fornecedor> fornecedores() {  
    return Fornecedor.listAll();  
}

@POST  
@Transactional
@Path("/inserirempresa")  
public Response create(Empresa empresa) {  
    Empresa.persist(empresa);  
    return Response.ok(empresa).status(201).build();  
}

// @PUT  
// @Path("{id}")  
// @Transactional  
// public Response update(@PathParam("id") Long id, Food food) {

//     if (foodController.isFoodNameIsNotEmpty(food)) {  
//         return Response.ok("Food was not found").type(MediaType.APPLICATION_JSON_TYPE).build();  
//     }

//     Food foodEntity = foodController.update(id, food);

//     return Response.ok(foodEntity).build();  
// }

// @DELETE  
// @Path("{id}")  
// @Transactional  
// public Response delete(@PathParam("id") Long id) {  
//     Food foodEntity = Food.findById(id);

//     if (foodEntity == null) {  
//         throw new WebApplicationException("Food with id " + id + " does not exist.", Response.Status.NOT_FOUND);  
//     }

//     foodEntity.delete();  
//     return Response.status(204).build();  
// }  

}
