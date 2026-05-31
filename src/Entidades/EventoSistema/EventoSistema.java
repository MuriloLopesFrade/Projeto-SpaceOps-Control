package Entidades.EventoSistema;

public class EventoSistema {
    /*
        Representa eventos críticos ocorridos durante a missão.

        Objetivo:
        -Registrar ocorrências que possam impactar o funcionamento do sistema e o IPO.

        Exemplos de eventos:
        -tempestade solar;
        -falha mecânica;
        -superaquecimento;
        -perda de sinal;
        -bateria crítica;
        -colisão.
     */

    private String descricao;
    private String dataHora;
    private int impacto;

    public EventoSistema(String descricao, String dataHora, int impacto) {
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.impacto = impacto;
    }

    public String getDataHora() {
        return dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getImpacto() {
        return impacto;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setImpacto(int impacto) {
        this.impacto = impacto;
    }

    public String gerarResumoEvento(){

        String aux = "==== Evento do Sistema ====\n";

        aux += "Data/Hora: "+ dataHora+"\n";
        aux += "Impacto: "+ impacto+"\n";
        aux += "Descrição: "+ descricao+"\n";

        return aux;
    }
}
