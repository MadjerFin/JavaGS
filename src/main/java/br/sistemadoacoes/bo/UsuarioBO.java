package br.sistemadoacoes.bo;

import br.sistemadoacoes.dto.UsuarioDTO;
import br.sistemadoacoes.exception.RecursoNaoEncontradoException;
import br.sistemadoacoes.model.Usuario;

import jakarta.enterprise.context.ApplicationScoped;

import java.sql.Date;

@ApplicationScoped
public class UsuarioBO {

    public Usuario autenticar(String email, String senha) {
        Usuario usuario = Usuario.find("email = ?1 AND senha = ?2", email, senha).firstResult();

        if (usuario == null) {
            throw new RecursoNaoEncontradoException("Email ou senha inválidos");
        }

        return usuario;
    }

    public Usuario buscarPorId(Long id) {
        Usuario usuario = Usuario.findById(id);
        if (usuario == null) {
            throw new RecursoNaoEncontradoException("Usuário não encontrado com ID: " + id);
        }
        return usuario;
    }

    public Usuario criar(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.nome = dto.nome;
        usuario.email = dto.email;
        usuario.senha = dto.senha;
        usuario.tipo = dto.tipo;
        usuario.telefone = dto.telefone;
        usuario.dataCadastro = new Date(System.currentTimeMillis());
        usuario.persist();
        return usuario;
    }
}
