package com.seuprojeto.resource;

import com.seuprojeto.model.Doacao;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.sql.Date;
import java.util.List;

@Path("/doacoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DoacaoResource {

    // Realiza uma nova doação
    @POST
    @Transactional
    public Doacao realizarDoacao(Doacao doacao) {
        doacao.dataDoacao = new Date(System.currentTimeMillis());
        doacao.persist();
        return doacao;
    }

    // Lista todas as doações do sistema (opcional)
    @GET
    public List<Doacao> listarTodas() {
        return Doacao.listAll();
    }
}
