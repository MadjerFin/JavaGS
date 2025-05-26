package com.seuprojeto.resource;

import com.seuprojeto.model.Doacao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/ongs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OngResource {

    // Lista o histórico de doações recebidas por uma ONG
    @GET
    @Path("/{id}/doacoes")
    public List<Doacao> listarDoacoesRecebidas(@PathParam("id") Long id) {
        return Doacao.find("ong.id", id).list();
    }
}
