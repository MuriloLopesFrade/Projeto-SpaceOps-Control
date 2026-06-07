package Entidades.EntidadeEspacial;

public abstract class EntidadeEspacial {

    /*
        Foi criada para aplicar herança e evitar repetição de código nas subclasses

        Todas as entidades possuem:

        - identificação;
        - nome;
        - status;
        - capacidade de gerar relatórios.

        Responsabilidade:
        -Representar qualquer entidade participante da missão espacial e
        centralizar os atributos e comportamentos comuns entre todas as entidades.
     */

    protected int id;
    protected String nome;

    public EntidadeEspacial(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract String gerarRelatorio();
    public abstract String obterStatus();

}
