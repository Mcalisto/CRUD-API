package org.acme.resource;
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import org.acme.classes.Fornecedor;
import org.acme.controller.NegociosController;

import com.oracle.svm.core.annotate.Inject;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/negocios")
public class FornecedorReseource {

@Inject  
private NegociosController negociosController;


@GET  
@Path("/fornecedores")
public List<Fornecedor> fornecedores() {  
    return Fornecedor.listAll();  
}

@POST  
@Transactional
@Path("/inserirfornecedor")  
public Response createFornecedor(Fornecedor fornecedor) {  
    Fornecedor.persist(fornecedor);  
    return Response.ok(fornecedor).status(201).build();  
}


@PUT  
@Path("fornecedore/{id}")  
@Transactional  
public Response update(@PathParam("id") Long id, Fornecedor fornecedor) {

    Fornecedor fornecedorEntity = negociosController.updateFornecedor(id, fornecedor);

    return Response.ok(fornecedorEntity).build();  
}

@DELETE  
@Path("{id}")  
@Transactional  
public Response delete(@PathParam("id") Long id) {  
    Fornecedor fornecedorEntity = Fornecedor.findById(id);

    if (fornecedorEntity == null) {  
        throw new WebApplicationException(id + " does not exist.", Response.Status.NOT_FOUND);  
    }

    fornecedorEntity.delete();  
    return Response.status(204).build();  
}  

}
