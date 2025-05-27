package br.sistemadoacoes.resource;

import br.sistemadoacoes.bo.OngBO;
import br.sistemadoacoes.dto.OngDTO;
import br.sistemadoacoes.exception.RecursoNaoEncontradoException;
import br.sistemadoacoes.model.Doacao;
import br.sistemadoacoes.model.Ong;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OngResource {

    @Inject
    OngBO ongBO;

    // POST /ongregister
    @POST
    @Path("/ongregister")
    @Transactional
    public Response criarOng(OngDTO dto) {
        Ong ong = ongBO.criar(dto);
        return Response.status(Response.Status.CREATED).entity(ong).build();
    }

    // GET /ongs/{id}/doacoes
    @GET
    @Path("/ongs/{id}/doacoes")
    public Response listarDoacoesRecebidas(@PathParam("id") Long id) {
        Ong ong = ongBO.buscarPorId(id);
        if (ong == null) {
            throw new RecursoNaoEncontradoException("ONG não encontrada");
        }
        List<Doacao> doacoes = Doacao.find("ong.id", ong.id).list();
        return Response.ok(doacoes).build();
    }
}
