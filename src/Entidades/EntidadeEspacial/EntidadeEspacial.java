package Entidades.EntidadeEspacial;

public abstract class EntidadeEspacial {

    /*
        Foi criada para aplicar herança e reutilização de código.

        Todas as entidades possuem:

        - identificação;
        - nome;
        - status;
        - capacidade de gerar relatórios.

        Isso evita repetição de código nas subclasses.

        Responsabilidade:
        -Representar qualquer entidade participante da missão espacial e
        centralizar os atributos e comportamentos comuns entre todas as entidades.
     */

    private int id;
    private String nome;
    private String status;

    public EntidadeEspacial(int id, String nome, String status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public abstract double calcularDesempenho();
    public abstract String gerarRelatorio();

}
