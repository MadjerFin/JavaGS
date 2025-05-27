package br.sistemadoacoes.bo;

import br.sistemadoacoes.dto.OngDTO;
import br.sistemadoacoes.exception.RecursoNaoEncontradoException;
import br.sistemadoacoes.model.Ong;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OngBO {

    // Busca uma ONG pelo ID
    public Ong buscarPorId(Long id) {
        Ong ong = Ong.findById(id);
        if (ong == null) {
            throw new RecursoNaoEncontradoException("ONG não encontrada com ID: " + id);
        }
        return ong;
    }

    // Cria uma nova ONG com base no DTO
    public Ong criar(OngDTO dto) {
        Ong ong = new Ong();
        ong.nome = dto.nome;
        ong.email = dto.email;
        ong.telefone = dto.telefone;
        ong.site = dto.site;
        ong.endereco = dto.endereco;
        ong.cnpj = dto.cnpj;
        ong.persist();
        return ong;
    }
}
