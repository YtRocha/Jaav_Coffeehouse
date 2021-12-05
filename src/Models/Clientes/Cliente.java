package Models.Clientes;

public class Cliente {

    private Long id;

    private String nome;

    private String cpf;

    /* ---- Construtor ---- */

    public Cliente() {

    }

    public Cliente(Long id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    /* ---- Getters e Setters ---- */

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
