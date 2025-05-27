package br.sistemadoacoes.dto;

public class OngDTO {

    public String nome;
    public String email;
    public String telefone;
    public String site;
    public String endereco;
    public String cnpj;

    // Construtores (opcional)
    public OngDTO() {}

    public OngDTO(String nome, String email, String telefone, String site, String endereco, String cnpj) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.site = site;
        this.endereco = endereco;
        this.cnpj = cnpj;
    }
}
