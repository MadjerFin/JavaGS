package com.seuprojeto.resource;

import com.seuprojeto.model.Usuario;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.Date;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @POST
    @Transactional
    public Usuario criarUsuario(Usuario usuario) {
        usuario.dataCadastro = new Date(System.currentTimeMillis());
        usuario.persist();
        return usuario;
    }

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return "API doações online!";
    }

    @POST
    @Path("/login")
    public Response login(Usuario credenciais) {
        Usuario usuario = Usuario.find("email = ?1 AND senha = ?2",
                credenciais.email, credenciais.senha).firstResult();

        if (usuario == null) {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Email ou senha inválidos").build();
        }

        return Response.ok(usuario).build();
    }
}
