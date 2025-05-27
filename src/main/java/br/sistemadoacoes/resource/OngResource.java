package br.sistemadoacoes.resource;

import br.sistemadoacoes.bo.OngBO;
import br.sistemadoacoes.dto.OngDTO;
import br.sistemadoacoes.model.Doacao;
import br.sistemadoacoes.model.Ong;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/ongs")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OngResource {

    @Inject
    OngBO ongBO;

    @POST
    @Transactional
    public Response criarOng(OngDTO dto) {
        Ong ong = ongBO.criar(dto);
        return Response.status(Response.Status.CREATED).entity(ong).build();
    }

    @GET
    @Path("/{id}/doacoes")
    public List<Doacao> listarDoacoesRecebidas(@PathParam("id") Long id) {
        Ong ong = ongBO.buscarPorId(id);
        return Doacao.find("ong.id", ong.id).list();
    }
}
