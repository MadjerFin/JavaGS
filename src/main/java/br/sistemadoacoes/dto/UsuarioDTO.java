package br.sistemadoacoes.dto;

public class UsuarioDTO {

    public String nome;
    public String email;
    public String senha;
    public String tipo;
    public String telefone;

    // Construtores (opcional)
    public UsuarioDTO() {}

    public UsuarioDTO(String nome, String email, String senha, String tipo, String telefone) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
        this.telefone = telefone;
    }
}
