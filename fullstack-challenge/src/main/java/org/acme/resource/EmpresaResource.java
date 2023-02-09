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

import org.acme.classes.Empresa;
import org.acme.classes.Fornecedor;
import org.acme.controller.NegociosController;

import com.oracle.svm.core.annotate.Inject;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/negocios")
public class EmpresaResource {

@Inject  
private NegociosController negociosController;

@GET  
@Path("/empresas")
public List<Empresa> empresas() {  
    return Empresa.listAll();  
}

@POST  
@Transactional
@Path("/inserirempresa")  
public Response createEmpresa(Empresa empresa) {  
    Empresa.persist(empresa);  
    return Response.ok(empresa).status(201).build();  
}

@PUT  
@Path("empresa/{id}")  
@Transactional  
public Response update(@PathParam("id") Long id, Empresa empresa) {

    Empresa empresaEntity = negociosController.updateEmpresa(id, empresa);

    return Response.ok(empresaEntity).build();  
}

@DELETE  
@Path("{id}")  
@Transactional  
public Response delete(@PathParam("id") Long id) {  
    Empresa empresaEntity = Empresa.findById(id);

    if (empresaEntity == null) {  
        throw new WebApplicationException(id + " does not exist.", Response.Status.NOT_FOUND);  
    }

    empresaEntity.delete();  
    return Response.status(204).build();  
}  

}
