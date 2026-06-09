package Entidades.EntidadeEspacial;

public abstract class EntidadeEspacial {

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

    @Override
    public String toString() {

        String aux="";

        aux +="id: " + id +"\n";
        aux +="Nome:" + nome + "\n";

        return aux;
    }

    public abstract String gerarRelatorio();
    public abstract String obterStatus();

}
